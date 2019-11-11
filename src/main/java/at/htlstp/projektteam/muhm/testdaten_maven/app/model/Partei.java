/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlstp.projektteam.muhm.testdaten_maven.app.model;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Gabriel Kremsner
 */
@Entity
@Table(name = "Partei")
public class Partei {
/*"p5Party": "NEOS",*/
    @Id
    @Column(name = "pt_kuerzel")
    private String pt_kuerzel;


    public Partei() {
    }
    
    public Partei(String party) {
        this.pt_kuerzel = party;
    }

    public String getParty() {
        return pt_kuerzel;
    }

    public void setParty(String party) {
        this.pt_kuerzel = party.replaceAll("\"","");
    }

    @Override
    public String toString() {
        return "Partei{" + "pt_party=" + pt_kuerzel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.pt_kuerzel);
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
        final Partei other = (Partei) obj;
        if (!Objects.equals(this.pt_kuerzel, other.pt_kuerzel)) {
            return false;
        }
        return true;
    }
    

    
}
