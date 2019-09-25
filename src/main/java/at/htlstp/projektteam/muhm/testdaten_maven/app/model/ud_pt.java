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
public class ud_pt {
    private int up_ud_id;
    private String up_pt_kürzel;
    private int up_value;

    public int getUp_ud_id() {
        return up_ud_id;
    }

    public void setUp_ud_id(int up_ud_id) {
        this.up_ud_id = up_ud_id;
    }

    public String getUp_pt_kürzel() {
        return up_pt_kürzel;
    }

    public void setUp_pt_kürzel(String up_pt_kürzel) {
        this.up_pt_kürzel = up_pt_kürzel;
    }

    public int getUp_value() {
        return up_value;
    }

    public void setUp_value(int up_value) {
        this.up_value = up_value;
    }

    public ud_pt() {
    }

    public ud_pt(int up_ud_id, String up_pt_id, int up_value) {
        this.up_ud_id = up_ud_id;
        this.up_pt_kürzel = up_pt_id;
        this.up_value = up_value;
    }

    @Override
    public String toString() {
        return "ud_pt{" + "up_ud_id=" + up_ud_id + ", up_pt_name=" + up_pt_kürzel + ", up_value=" + up_value + '}';
    }
    
    
}
