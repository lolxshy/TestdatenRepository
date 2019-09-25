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
public class Region {
//"regionID": "1",
//"region": "ÖSTERREICH",
    private int rg_id;
    private String rg_name;

    public Region() {
    }

    public Region(int rg_id, String rg_name) {
        this.rg_id = rg_id;
        this.rg_name = rg_name;
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
    
    
}
