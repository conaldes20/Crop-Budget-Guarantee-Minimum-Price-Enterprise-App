/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.util;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class CUserId implements Serializable{
    private Long cusrid;

    public CUserId() {
    }
    
    public Long getCusrid() {
        return cusrid;
    }

    public void setCusrid(Long cusrid) {
        this.cusrid = cusrid;
    } 
}
