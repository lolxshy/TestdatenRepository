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
public class Partei {
/*"p5Party": "NEOS",*/
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

    
}
