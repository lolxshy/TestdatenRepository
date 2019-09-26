/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlstp.projektteam.muhm.testdaten_maven.app;

import at.htlstp.projektteam.muhm.testdaten_maven.app.model.UmfrageDaten;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.Region;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.ud_pt;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.Partei;
import at.htlstp.projektteam.muhm.testdaten_maven.app.model.Help;
import at.htlstp.projektteam.muhm.testdaten_maven.db.DAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Gabriel Kremsner
 */
public class TestdatenVerschönerung {

    /**
     * @param args the command line arguments
     */
    /*
    Aufbau des Json Objekts:
"id": 1522,
"regionID": "1",
"region": "ÖSTERREICH",
"institut": "Unique Research",
"medium": "Heute",
"befragtenanzahl": 2402,
"schwankungsbreite": 2.00,
"datum": "2019-09-14",
"befragungsmethode": "Telefon und Online",
"p1Party": "ÖVP",
"p1Value": "33",
"p1Css": "ovp",
"p2Party": "SPÖ",
"p2Value": "22",
"p2Css": "spo",
"p3Party": "FPÖ",
"p3Value": "20",
"p3Css": "fpo",
"p4Party": "GRÜNE",
"p4Value": "13",
"p4Css": "gru",
"p5Party": "NEOS",
"p5Value": "8",
"p5Css": "neo",
"p6Party": "JETZT",
"p6Value": "2",
"p6Css": "pilz"
     */
    static List<String> ls = new ArrayList<>();         // Liste der gesamten Zeilen des Files
    static List<Help> lh = new ArrayList<>();           // Liste von Help
    // (Help ist eine Hilfsklasse in der zuerst die ganzen Zeilen in die Entsprechenden Datentypen verwandelt werde)
    static List<List<String>> lls = new ArrayList<>();  // Hier werden Listen von Strings in einer Liste gespeichert, 
    // dies hat den Vorteil das die Speicherung der Zeilen in die Helpklasse leichter ist
    static List<Region> lr = new ArrayList<>();         // Liste von Regionen in dieser Liste werden Regionen aber mehrmals gespeichert
    static Map<Integer, String> lrh;                    // Map die dazu dient die Regionen einzigartig zu machen
    static List<Region> lrh2 = new ArrayList<>();       // unique Liste von Regionen
    static List<UmfrageDaten> lud = new ArrayList();    // Liste der Umfragedaten
    static List<Partei> lp = new ArrayList<>();         // Liste der Parteien
    static Set<String> lph;                             // Set zum unikate erstellen
    static List<Partei> lpu = new ArrayList<>();        // unique Partei List
    static List<ud_pt> lup = new ArrayList();           // Liste der Beziehungsentitys
    static int helpingvar1;                             // Variable zur Hilfe falls Party 6 keine Value hat
    static int helpingvar2;                             // Variable zur Hilfe falls Party 5 keine Value hat
    static String helpingvars1 = "";                    // Variable zur Hilfe falls Party 6 keine Bezeichnung hat
    static String helpingvars2 = "";                    // Variable zur Hilfe falls Party 5 keine Bezeichnung hat
    static int i = 0;                                   // Variable, die beim Speichern der Zeilen in eine Liste, zur Verwendung kommt
    private static DAO dao = DAO.getINSTANCE();         // DAO objekt für Datenbankmethoden

    public static void main(String[] args) throws IOException {

        erzeugeDaten();
        /*
        Persistierung der Testdaten mit Hilfe von DAO Methoden
         */
        lpu.forEach(x -> dao.persist(x));
        lrh2.forEach(x -> dao.persist(x));
        lud.forEach(x -> dao.persist(x));
        lup.forEach(x -> dao.persist(x));
    }

    /*
    Methode zur Verarbeitung der Testdaten.
    In dieser Methode wird das JSON Objekt in Java Klassen umgemappt.
     */
    public static void erzeugeDaten() throws IOException {
        ls = Files.lines(Paths.get("neuwal-wahlumfragen-user.json")).skip(2) // hier werden die Ersten 2 Objekte übersprungen, da in der File hier der Objektname steht
                .filter(s -> !(s.contains("}") || s.contains("{") || s.equals(",")))
                .collect(Collectors.toList());
//        System.out.println(ls.size() / 27);
        for (i = 0; i < ls.size(); i += 27) {
            lls.add(ls.subList(i, i + 27));
        }
        for (List<String> ls1 : lls) {
            //System.out.println(ls1.get(25));
            //Hier wird überprüft ob Party6 und Party5 eine Value und oder eine Bezeichnung besitzen ansonsten wird 0 und unbekannt als Wert eingetragen
            if (ls1.get(25).split(":")[1].equals(" \"\",") || ls1.get(25).split(":")[1].equals("\"\",")) {
                helpingvar1 = 0;
            } else {
                helpingvar1 = Integer.parseInt(ls1.get(25).split(":")[1].replace(",", " ").replace("\"", " ").trim());
            }
            if (ls1.get(24).split(":")[1].contains("?")) {
                helpingvars1 = "Unbekannt";
            } else {
                helpingvars1 = ls1.get(24).split(":")[1].replace(",", " ").trim();
            }
            if (ls1.get(22).split(":")[1].equals(" \"\",") || ls1.get(22).split(":")[1].equals("\"\",")) {
                helpingvar2 = 0;
            } else {
                helpingvar2 = Integer.parseInt(ls1.get(22).split(":")[1].replace(",", " ").replace("\"", " ").trim());
            }
            if (ls1.get(21).split(":")[1].contains("?")) {
                helpingvars1 = "Unbekannt";
            } else {
                helpingvars2 = ls1.get(21).split(":")[1].replace(",", " ").trim();
            }
            //Hier wird die Liste lh mit Help Objekten gefüllt
            lh.add(new Help(
                    Integer.parseInt(ls1.get(0).split(":")[1].replace(",", " ").trim()),
                    Integer.parseInt(ls1.get(1).split(":")[1].replace(",", " ").replace("\"", " ").trim()),
                    ls1.get(2).split(":")[1].replace(",", " ").trim(),
                    ls1.get(3).split(":")[1].replace(",", " ").trim(),
                    ls1.get(4).split(":")[1].replace(",", " ").trim(),
                    Integer.parseInt(ls1.get(5).split(":")[1].replace(",", " ").trim()),
                    Double.parseDouble(ls1.get(6).split(":")[1].replace(",", " ").trim()),
                    Date.valueOf(ls1.get(7).split(":")[1].replace(",", " ").replace("\"", " ").trim()),
                    ls1.get(8).split(":")[1].replace(",", " ").trim(),
                    ls1.get(9).split(":")[1].replace(",", " ").trim(),
                    Integer.parseInt(ls1.get(10).split(":")[1].replace(",", " ").replace("\"", " ").trim()),
                    ls1.get(12).split(":")[1].replace(",", " ").trim(),
                    Integer.parseInt(ls1.get(13).split(":")[1].replace(",", " ").replace("\"", " ").trim()),
                    ls1.get(15).split(":")[1].replace(",", " ").trim(),
                    Integer.parseInt(ls1.get(16).split(":")[1].replace(",", " ").replace("\"", " ").trim()),
                    ls1.get(18).split(":")[1].replace(",", " ").trim(),
                    Integer.parseInt(ls1.get(19).split(":")[1].replace(",", " ").replace("\"", " ").trim()),
                    helpingvars2,
                    helpingvar2,
                    helpingvars1,
                    helpingvar1
            )
            );
        }
        //  System.err.println(lh.size());
        i = 0;
//        System.out.println(lh);

// Hier werden die Helpobjekte in die Entsprechenden Klassen gespeichert      
        for (Help h : lh) {

//            System.out.println(h);
            lp.add(new Partei(h.getPt_party1()));
            lp.add(new Partei(h.getPt_party2()));
            lp.add(new Partei(h.getPt_party3()));
            lp.add(new Partei(h.getPt_party4()));
            lp.add(new Partei(h.getPt_party5()));
            lp.add(new Partei(h.getPt_party6()));
            lr.add(new Region(h.getRg_id(), h.getRg_name()));
//            if (!(p.getParty().equals(h.getPt_party1()) || p.getParty().equals(h.getPt_party2()) || p.getParty().equals(h.getPt_party3()) || p.getParty().equals(h.getPt_party4()) || p.getParty().equals(h.getPt_party5()) || p.getParty().equals(h.getPt_party6()))) {
            lud.add(new UmfrageDaten(h.getUd_id(), h.getUd_institut(), h.getUd_medium(), h.getUd_befragtenanzahl(), h.getUd_schwankungsbreite(), h.getUd_datum(), h.getUd_befragungsmethode(), lr.get(i)));
            lup.add(new ud_pt(lud.get(i), lp.get(i * 6), h.getUp_value1()));
            lup.add(new ud_pt(lud.get(i), lp.get((i * 6) + 1), h.getUp_value2()));
            lup.add(new ud_pt(lud.get(i), lp.get((i * 6) + 2), h.getUp_value3()));
            lup.add(new ud_pt(lud.get(i), lp.get((i * 6) + 3), h.getUp_value4()));
            lup.add(new ud_pt(lud.get(i), lp.get((i * 6) + 4), h.getUp_value5()));
            lup.add(new ud_pt(lud.get(i), lp.get((i * 6) + 5), h.getUp_value6()));
            i++;
        }
        //System.out.println(i);
        lph = new TreeSet<String>(lp.stream().map(lap -> lap.getParty()).collect(Collectors.toList()));
        for (String s : lph) {
            lpu.add(new Partei(s));
        }

//        System.out.println("Parteien:\n\n---------------------------------------------------------------------------------------------------------");
//        for (Partei p : lpu) {
//            System.out.println(p);
//        }
//        System.out.println(lpu.size());
//        System.out.println("Regionen:\n\n---------------------------------------------------------------------------------------------------------");
        lrh = new TreeMap<>();
        lr.forEach(x -> lrh.put(x.getRg_id(), x.getRg_name()));
        for (int j = 0; j < 88; j++) {
            if (lrh.containsKey(j)) {
                lrh2.add(new Region(j, lrh.get(j)));
            }
        }

//        for (Region r : lrh2) {
//            System.out.println(r);
//        }
//        System.out.println(lrh2.size());
//        System.out.println("UmfrageDaten:\n\n---------------------------------------------------------------------------------------------------------");
//        for (UmfrageDaten ud : lud) {
//            System.out.println(ud);
//       }
//        System.out.println(lud.size());
//        System.out.println("Beziehungstabelle:\n\n---------------------------------------------------------------------------------------------------------");
//        for (ud_pt ud : lup) {
//            System.out.println(ud);
//        }
//        System.out.println(lup.size());
    }
}
