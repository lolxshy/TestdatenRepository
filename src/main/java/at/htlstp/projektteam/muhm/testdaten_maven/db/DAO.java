/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlstp.projektteam.muhm.testdaten_maven.db;

import at.htlstp.projektteam.muhm.testdaten_maven.app.model.Partei;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.Region;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.UmfrageDaten;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.ud_pt;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 20140416
 */
public class DAO implements AutoCloseable {

    private static final DAO INSTANCE = new DAO();

    private DAO() {
    }

    
    public boolean persist(Partei partei) {
        Boolean b = true;
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(partei);
            tx.commit();
            System.out.println("partei:::"+partei.getParty() + " wurde persistiert!");
        } catch (Exception e) {
            b = false;
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        return b;
    }

    public boolean persist(Region region) {
        Boolean b = true;
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(region);
            tx.commit();
            System.out.println("Region:::::"+region.getRg_name() + "wurde persistiert");
        } catch (Exception e) {
            b = false;
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        return b;
    }

    public boolean persist(UmfrageDaten daten) {
        Boolean b = true;
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(daten);
            tx.commit();
            System.out.println("Umfrage:::::"+daten.getDatum() + "wurde persistiert");
        } catch (Exception e) {
            b = false;
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        return b;
    }

    public boolean persist(ud_pt entity) {
        Boolean b = true;
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            System.out.println("beziehungstabelle:::::"+entity+ "wurde persistiert");
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        return b;
    }

    public static DAO getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void close() throws Exception {
        JPAUtil.close();
    }


}
