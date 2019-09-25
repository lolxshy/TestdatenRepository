/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlstp.projektteam.muhm.testdaten_maven.db;

/**
 *
 * @author Gabriel Kremsner
 * @author Mateo Palac
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory EMF;

    static {
        try {
            EMF = Persistence.createEntityManagerFactory("at.htlstp.projektteam.muhm_Testdaten_maven_jar_1.0-SNAPSHOTPU");
        } catch (Exception ex) {
            System.err.println("EntityManagerFactory creation faild: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEMF() {

        return EMF;
    }

    public static void close() {
        EMF.close();
    }
}
