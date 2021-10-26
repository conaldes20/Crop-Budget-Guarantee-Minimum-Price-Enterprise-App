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
public class LOGGEDUserid implements Serializable{
    private String loogeduserid;

    public LOGGEDUserid() {
    }
    
    public String getLoogeduserid() {
        return loogeduserid;
    }

    public void setLoogeduserid(String loogeduserid) {
        this.loogeduserid = loogeduserid;
    }
}