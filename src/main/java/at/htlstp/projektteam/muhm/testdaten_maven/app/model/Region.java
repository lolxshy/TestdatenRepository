/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlstp.projektteam.muhm.testdaten_maven.app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Kremsner
 */
@Entity
@Table(name = "Region")
public class Region implements Serializable {
//"regionID": "1",
//"region": "ÖSTERREICH",

    @Id
    @Column(name = "rg_id")
    private int rg_id;
    @Column(name = "rg_name")
    private String rg_name;

//    @OneToMany(mappedBy = "region")
//    private List<UmfrageDaten> umfrageDatensatz;

    public Region() {
    }

    public Region(int rg_id, String rg_name, UmfrageDaten daten) {
        this.rg_id = rg_id;
        this.rg_name = rg_name;
//        this.addUmfrageDatensatz(daten);
    }

    public String getRg_name() {
        return rg_name;
    }

    public void setRg_name(String rg_name) {
        this.rg_name = rg_name;
    }

    public int getRg_id() {
        return rg_id;
    }

    @Override
    public String toString() {
        return "Region{" + "rg_id=" + rg_id + ", rg_name=" + rg_name + '}';
    }

//    public List<UmfrageDaten> getUmfrageDatensatz() {
//        return umfrageDatensatz;
//    }
//
//    public void setUmfrageDatensatz(List<UmfrageDaten> umfrageDatensatz) {
//        this.umfrageDatensatz = umfrageDatensatz;
//    }
//
//    public void addUmfrageDatensatz(UmfrageDaten daten) {
//        this.umfrageDatensatz.add(daten);
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.rg_id;
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
        final Region other = (Region) obj;
        if (this.rg_id != other.rg_id) {
            return false;
        }
        return true;
    }

}
