/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlstp.projektteam.muhm.testdaten_maven.app.model;
import java.util.Objects;
/**
 *
 * @author Gabriel Kremsner
 */
@Entity
Table(name = "Partei")
public class Partei {
/*"p5Party": "NEOS",*/
    @Id
    @Column(name = "pt_kuerzel")
    private String pt_kürzel;


    public Partei() {
    }
    
    public Partei(String party) {
        this.pt_kürzel = party;
    }

    public String getParty() {
        return pt_kürzel;
    }

    public void setParty(String party) {
        this.pt_kürzel = party;
    }

    @Override
    public String toString() {
        return "Partei{" + "pt_party=" + pt_kürzel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.pt_kürzel);
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
        if (!Objects.equals(this.pt_kürzel, other.pt_kürzel)) {
            return false;
        }
        return true;
    }
    

    
}
