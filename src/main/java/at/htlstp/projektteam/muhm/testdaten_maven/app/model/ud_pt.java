/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlstp.projektteam.muhm.testdaten_maven.app.model;

/**
 *
 * @author Gabriel Kremsner
 */
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ud_pt")
public class ud_pt implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @ManyToOne
    private UmfrageDaten up_ud;
    @ManyToOne
    private Partei up_pt_kürzel;
    @Column(name = "ud_pt_value")
    private int ud_pt_value;

    public UmfrageDaten getUp_ud() {
        return up_ud;
    }

    public void setUp_ud(UmfrageDaten up_ud) {
        this.up_ud = up_ud;
    }

    public Partei getUp_pt_kürzel() {
        return up_pt_kürzel;
    }

    public void setUp_pt_kürzel(Partei up_pt_kürzel) {
        this.up_pt_kürzel = up_pt_kürzel;
    }

  

    public int getUd_pt_value() {
        return ud_pt_value;
    }

    public void setUd_pt_value(int ud_pt_value) {
        this.ud_pt_value = ud_pt_value;
    }

    public ud_pt() {
    }

    public ud_pt(UmfrageDaten up_ud_id, Partei up_pt_id, int up_value) {
        this.up_ud = up_ud_id;
        this.up_pt_kürzel = up_pt_id;
        this.ud_pt_value = up_value;
    }

    @Override
    public String toString() {
        return "ud_pt{" + "up_ud_id=" + up_ud + ", up_pt_name=" + up_pt_kürzel + ", up_value=" + ud_pt_value + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.up_ud);
        hash = 71 * hash + Objects.hashCode(this.up_pt_kürzel);
        hash = 71 * hash + this.ud_pt_value;
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
        final ud_pt other = (ud_pt) obj;
        if (this.ud_pt_value != other.ud_pt_value) {
            return false;
        }
        if (!Objects.equals(this.up_ud, other.up_ud)) {
            return false;
        }
        if (!Objects.equals(this.up_pt_kürzel, other.up_pt_kürzel)) {
            return false;
        }
        return true;
    }
    
    
}
