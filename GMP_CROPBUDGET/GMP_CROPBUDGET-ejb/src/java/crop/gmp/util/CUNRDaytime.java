/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.util;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class CUNRDaytime implements Serializable{
    private String unrDaytime;

    public CUNRDaytime() {
    }
    
    public String getUNRDaytime() {
        return unrDaytime;
    }

    public void setUNRDaytime(String unrDaytime) {
        this.unrDaytime = unrDaytime;
    }
}
