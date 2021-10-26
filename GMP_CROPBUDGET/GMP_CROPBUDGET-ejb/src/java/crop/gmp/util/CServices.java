/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.util;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
public class CServices implements Serializable{
    private List<String> servies;

    public CServices() {
    }

    public List<String> getServies() { 
         return servies; 
    }

    public void setServies(List<String> servies) {
         this.servies = servies;
    }
}
