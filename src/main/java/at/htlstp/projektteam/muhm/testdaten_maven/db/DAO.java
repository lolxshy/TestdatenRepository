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

    public boolean persist(Partei partei) {
        Boolean b = true;
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(partei);
            tx.commit();
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
    
    @Override
    public void close() throws Exception {
        JPAUtil.close();
    }
}
