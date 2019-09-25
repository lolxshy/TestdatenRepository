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
import javax.persistence.OneToOne;

public class ud_pt {
    @OneToOne
    private UmfrageDaten up_ud;
    @OneToOne
    private Partei up_pt_kürzel;
    private int up_value;

  

    public int getUp_value() {
        return up_value;
    }

    public void setUp_value(int up_value) {
        this.up_value = up_value;
    }

    public ud_pt() {
    }

    public ud_pt(UmfrageDaten up_ud_id, Partei up_pt_id, int up_value) {
        this.up_ud = up_ud_id;
        this.up_pt_kürzel = up_pt_id;
        this.up_value = up_value;
    }

    @Override
    public String toString() {
        return "ud_pt{" + "up_ud_id=" + up_ud + ", up_pt_name=" + up_pt_kürzel + ", up_value=" + up_value + '}';
    }
    
    
}
