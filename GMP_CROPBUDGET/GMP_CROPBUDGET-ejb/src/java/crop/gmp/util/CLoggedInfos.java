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
public class CLoggedInfos implements Serializable{
    private String loggeddetails;

    public CLoggedInfos() {
    }
    
    public String getLoggeddetails() {
        return loggeddetails;
    }

    public void setLoggeddetails(String loggeddetails) {
        this.loggeddetails = loggeddetails;
    }
}
