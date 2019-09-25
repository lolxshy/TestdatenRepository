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
    public static void main(String[] args) throws IOException {
        List<String> ls = new ArrayList<>();
        List<Help> lh = new ArrayList<>();
        List<List<String>> lls = new ArrayList<>();
        List<Region> lr = new ArrayList<>();
        Map<Integer, String> lrh;
        List<Region> lrh2 = new ArrayList<>();
        List<UmfrageDaten> lud = new ArrayList();
        List<Partei> lp = new ArrayList<>();//Liste der Parteien
        Set<String> lph;//Set zum unikate erstellen
        List<Partei> lpu = new ArrayList<>();//unique Partei List
        List<ud_pt> lup = new ArrayList();
        int helpingvar1;
        int helpingvar2;
        String helpingvars1 = "";
        String helpingvars2 = "";
        int i = 0;
        boolean hb = false;

        ls = Files.lines(Paths.get("neuwal-wahlumfragen-user.json")).skip(2)
                .filter(s -> !(s.contains("}") || s.contains("{") || s.equals(",")))
                .collect(Collectors.toList());
//        System.out.println(ls.size() / 27);
        for (i = 0; i < ls.size(); i += 27) {
            lls.add(ls.subList(i, i + 27));
        }
        for (List<String> ls1 : lls) {
            //System.out.println(ls1.get(25));

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
        System.err.println(lh.size());
        i = 0;
//        System.out.println(lh);
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
            lud.add(new UmfrageDaten(h.getUd_id(), h.getUd_institut(), h.getUd_medium(), h.getUd_befragtenanzahl(), h.getUd_schwankungsbreite(), h.getUd_datum(), h.getUd_befragungsmethode()));
            lup.add(new ud_pt(lud.get(i), lp.get(i*6), h.getUp_value1()));
            lup.add(new ud_pt(lud.get(i), lp.get((i+1)*6), h.getUp_value2()));
            lup.add(new ud_pt(lud.get(i), lp.get((i+2)*6), h.getUp_value3()));
            lup.add(new ud_pt(lud.get(i), lp.get((i+3)*6), h.getUp_value4()));
            lup.add(new ud_pt(lud.get(i), lp.get((i+4)*6), h.getUp_value5()));
            lup.add(new ud_pt(lud.get(i), lp.get((i+5)*6), h.getUp_value6())); 
            i++;
        }
        System.out.println(i);
        lph = new TreeSet<String>(lp.stream().map(lap -> lap.getParty()).collect(Collectors.toList()));
        lph.remove(lph.toArray()[0]);
        for (String s : lph) {
            lpu.add(new Partei(s));
        }
        System.out.println("Parteien:\n\n---------------------------------------------------------------------------------------------------------");
        for (Partei p : lpu) {
            System.out.println(p);
        }
        System.out.println(lpu.size());
        System.out.println("Regionen:\n\n---------------------------------------------------------------------------------------------------------");
        lrh = new TreeMap<>();
        for (Region r : lr) {
            lrh.put(r.getRg_id(), r.getRg_name());
        }
        for (int j = 0; j < lrh.size(); j++) {
            if (lrh.containsKey(j)) {
                lrh2.add(new Region(j, lrh.get(j)));
            }
        }

        for (Region r : lrh2) {
            System.out.println(r);
        }
        System.out.println(lrh2.size());
        System.out.println("UmfrageDaten:\n\n---------------------------------------------------------------------------------------------------------");
        for (UmfrageDaten ud : lud) {
            System.out.println(ud);
        }
        System.out.println(lud.size());
        System.out.println("Beziehungstabelle:\n\n---------------------------------------------------------------------------------------------------------");
        for (ud_pt ud : lup) {
            System.out.println(ud);
        }
        System.out.println(lup.size());

    }

}
