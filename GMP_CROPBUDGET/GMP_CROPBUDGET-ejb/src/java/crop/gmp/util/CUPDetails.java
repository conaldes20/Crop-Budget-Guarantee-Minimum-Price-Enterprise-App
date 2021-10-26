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
public class CUPDetails implements Serializable {
    private String username;
    private String passwd;
    private String role;

    public CUPDetails() {
    }

    public CUPDetails(String username, String passwd, String role) {
        this.username = username;
        this.passwd = passwd;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
