/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlstp.projektteam.muhm.testdaten_maven.app.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gabriel Kremsner
 */
@Entity
public class UmfrageDaten {

    /*"ud_id": 1522,
"regionID": "1",
"region": "ÖSTERREICH",
"ud_institut": "Unique Research",
"ud_medium": "Heute",
"ud_befragtenanzahl": 2402,
"ud_schwankungsbreite": 2.00,
"ud_datum": "2019-09-14",
"ud_befragungsmethode": "Telefon und Online",
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
    @Id
    @Column(name = "ud_id")
    private int ud_id;
    @Column(name = "ud_institut")
    private String ud_institut;
    @Column(name = "ud_medium")
    private String ud_medium;
    @Column(name = "ud_befragtenanzahl")
    private int ud_befragtenanzahl;
    @Column(name = "ud_schwankungsbreite")
    private double ud_schwankungsbreite;
    @Column(name = "ud_datum")
    @Temporal(TemporalType.DATE)
    private Date ud_datum;
    @Column(name = "ud_befragungsmethode")
    private String ud_befragungsmethode;
    @ManyToOne
    private Region region;
    public UmfrageDaten() {
    }

    public UmfrageDaten(int id, String institut, String medium, int n, double f, Date datum, String methode,Region r) {
        this.ud_id = id;
        this.ud_institut = institut;
        this.ud_medium = medium;
        this.ud_befragtenanzahl = n;
        this.ud_schwankungsbreite = f;
        this.ud_datum = datum;
        this.ud_befragungsmethode = methode;
        this.region = r;
    }

    public int getId() {
        return ud_id;
    }

    public String getInstitut() {
        return ud_institut;
    }

    public void setInstitut(String institut) {
        this.ud_institut = institut;
    }

    public String getMedium() {
        return ud_medium;
    }

    public void setMedium(String medium) {
        this.ud_medium = medium;
    }

    public int getN() {
        return ud_befragtenanzahl;
    }

    public void setN(int n) {
        this.ud_befragtenanzahl = n;
    }

    public double getF() {
        return ud_schwankungsbreite;
    }

    public void setF(double f) {
        this.ud_schwankungsbreite = f;
    }

    public Date getDatum() {
        return ud_datum;
    }

    public void setDatum(Date datum) {
        this.ud_datum = datum;
    }

    public String getMethode() {
        return ud_befragungsmethode;
    }

    public void setMethode(String methode) {
        this.ud_befragungsmethode = methode;
    }

    @Override
    public String toString() {
        return "UmfrageDaten{" + "ud_id=" + ud_id + ", ud_institut=" + ud_institut + ", ud_medium=" + ud_medium + ", ud_befragtenanzahl=" + ud_befragtenanzahl + ", ud_schwankungsbreite=" + ud_schwankungsbreite + ", ud_datum=" + ud_datum + ", ud_befragungsmethode=" + ud_befragungsmethode + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.ud_id;
        hash = 37 * hash + Objects.hashCode(this.ud_institut);
        hash = 37 * hash + Objects.hashCode(this.ud_medium);
        hash = 37 * hash + this.ud_befragtenanzahl;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ud_schwankungsbreite) ^ (Double.doubleToLongBits(this.ud_schwankungsbreite) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.ud_datum);
        hash = 37 * hash + Objects.hashCode(this.ud_befragungsmethode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UmfrageDaten other = (UmfrageDaten) obj;
        if (this.ud_id != other.ud_id) {
            return false;
        }
        if (this.ud_befragtenanzahl != other.ud_befragtenanzahl) {
            return false;
        }
        if (Double.doubleToLongBits(this.ud_schwankungsbreite) != Double.doubleToLongBits(other.ud_schwankungsbreite)) {
            return false;
        }
        if (!Objects.equals(this.ud_institut, other.ud_institut)) {
            return false;
        }
        if (!Objects.equals(this.ud_medium, other.ud_medium)) {
            return false;
        }
        if (!Objects.equals(this.ud_befragungsmethode, other.ud_befragungsmethode)) {
            return false;
        }
        if (!Objects.equals(this.ud_datum, other.ud_datum)) {
            return false;
        }
        return true;
    }
   
    
    
}
