/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlstp.projektteam.muhm.testdaten_maven.app.model;

import java.util.Date;

/**
 *
 * @author Gabriel Kremsner
 */
public class Help {

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

    private int ud_id;
    private int rg_id;
    private String rg_name;
    private String ud_institut;
    private String ud_medium;
    private int ud_befragtenanzahl;
    private double ud_schwankungsbreite;
    private Date ud_datum;
    private String ud_befragungsmethode;
    private String pt_party1;
    private int up_value1;
    private String pt_party2;
    private int up_value2;
    private String pt_party3;
    private int up_value3;
    private String pt_party4;
    private int up_value4;
    private String pt_party5;
    private int up_value5;
    private String pt_party6;
    private int up_value6;

    public Help() {
    }

    public Help(int ud_id, int rg_id, String rg_name, String ud_institut, String ud_medium, int ud_befragtenanzahl, double ud_schwankungsbreite, Date ud_datum, String ud_befragungsmethode, String pt_party1, int up_value1, String pt_party2, int up_value2, String pt_party3, int up_value3, String pt_party4, int up_value4, String pt_party5, int up_value5, String pt_party6, int up_value6) {
        this.ud_id = ud_id;
        this.rg_id = rg_id;
        this.rg_name = rg_name;
        this.ud_institut = ud_institut;
        this.ud_medium = ud_medium;
        this.ud_befragtenanzahl = ud_befragtenanzahl;
        this.ud_schwankungsbreite = ud_schwankungsbreite;
        this.ud_datum = ud_datum;
        this.ud_befragungsmethode = ud_befragungsmethode;
        this.pt_party1 = pt_party1;
        this.up_value1 = up_value1;
        this.pt_party2 = pt_party2;
        this.up_value2 = up_value2;
        this.pt_party3 = pt_party3;
        this.up_value3 = up_value3;
        this.pt_party4 = pt_party4;
        this.up_value4 = up_value4;
        this.pt_party5 = pt_party5;
        this.up_value5 = up_value5;
        this.pt_party6 = pt_party6;
        this.up_value6 = up_value6;
    }

    public int getUd_id() {
        return ud_id;
    }

    public void setUd_id(int ud_id) {
        this.ud_id = ud_id;
    }

    public int getRg_id() {
        return rg_id;
    }

    public void setRg_id(int rg_id) {
        this.rg_id = rg_id;
    }

    public String getRg_name() {
        return rg_name;
    }

    public void setRg_name(String rg_name) {
        this.rg_name = rg_name;
    }

    public String getUd_institut() {
        return ud_institut;
    }

    public void setUd_institut(String ud_institut) {
        this.ud_institut = ud_institut;
    }

    public String getUd_medium() {
        return ud_medium;
    }

    public void setUd_medium(String ud_medium) {
        this.ud_medium = ud_medium;
    }

    public int getUd_befragtenanzahl() {
        return ud_befragtenanzahl;
    }

    public void setUd_befragtenanzahl(int ud_befragtenanzahl) {
        this.ud_befragtenanzahl = ud_befragtenanzahl;
    }

    public double getUd_schwankungsbreite() {
        return ud_schwankungsbreite;
    }

    public void setUd_schwankungsbreite(double ud_schwankungsbreite) {
        this.ud_schwankungsbreite = ud_schwankungsbreite;
    }

    public Date getUd_datum() {
        return ud_datum;
    }

    public void setUd_datum(Date ud_datum) {
        this.ud_datum = ud_datum;
    }

    public String getUd_befragungsmethode() {
        return ud_befragungsmethode;
    }

    public void setUd_befragungsmethode(String ud_befragungsmethode) {
        this.ud_befragungsmethode = ud_befragungsmethode;
    }

    public String getPt_party1() {
        return pt_party1;
    }

    public void setPt_party1(String pt_party1) {
        this.pt_party1 = pt_party1;
    }

    public int getUp_value1() {
        return up_value1;
    }

    public void setUp_value1(int up_value1) {
        this.up_value1 = up_value1;
    }

    public String getPt_party2() {
        return pt_party2;
    }

    public void setPt_party2(String pt_party2) {
        this.pt_party2 = pt_party2;
    }

    public int getUp_value2() {
        return up_value2;
    }

    public void setUp_value2(int up_value2) {
        this.up_value2 = up_value2;
    }

    public String getPt_party3() {
        return pt_party3;
    }

    public void setPt_party3(String pt_party3) {
        this.pt_party3 = pt_party3;
    }

    public int getUp_value3() {
        return up_value3;
    }

    public void setUp_value3(int up_value3) {
        this.up_value3 = up_value3;
    }

    public String getPt_party4() {
        return pt_party4;
    }

    public void setPt_party4(String pt_party4) {
        this.pt_party4 = pt_party4;
    }

    public int getUp_value4() {
        return up_value4;
    }

    public void setUp_value4(int up_value4) {
        this.up_value4 = up_value4;
    }

    public String getPt_party5() {
        return pt_party5;
    }

    public void setPt_party5(String pt_party5) {
        this.pt_party5 = pt_party5;
    }

    public int getUp_value5() {
        return up_value5;
    }

    public void setUp_value5(int up_value5) {
        this.up_value5 = up_value5;
    }

    public String getPt_party6() {
        return pt_party6;
    }

    public void setPt_party6(String pt_party6) {
        this.pt_party6 = pt_party6;
    }

    public int getUp_value6() {
        return up_value6;
    }

    public void setUp_value6(int up_value6) {
        this.up_value6 = up_value6;
    }

    @Override
    public String toString() {
        return "Help{" + "ud_id=" + ud_id + ", rg_id=" + rg_id + ", rg_name=" + rg_name + ", ud_institut=" + ud_institut + ", ud_medium=" + ud_medium + ", ud_befragtenanzahl=" + ud_befragtenanzahl + ", ud_schwankungsbreite=" + ud_schwankungsbreite + ", ud_datum=" + ud_datum + ", ud_befragungsmethode=" + ud_befragungsmethode + ", pt_party1=" + pt_party1 + ", up_value1=" + up_value1 + ", pt_party2=" + pt_party2 + ", up_value2=" + up_value2 + ", pt_party3=" + pt_party3 + ", up_value3=" + up_value3 + ", pt_party4=" + pt_party4 + ", up_value4=" + up_value4 + ", pt_party5=" + pt_party5 + ", up_value5=" + up_value5 + ", pt_party6=" + pt_party6 + ", up_value6=" + up_value6 + '}';
    }
    
    
    
}
