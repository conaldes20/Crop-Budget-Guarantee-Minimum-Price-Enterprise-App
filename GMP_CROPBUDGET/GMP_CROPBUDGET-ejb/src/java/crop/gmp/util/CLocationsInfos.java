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
public class CLocationsInfos implements Serializable {
   private List<String> locationsInfos;

   public CLocationsInfos() {
   }
   
   public List<String> getLocationsInfos() { 
        return locationsInfos; 
   }

   public void setLocationsInfos(List<String> locationsInfos) {
        this.locationsInfos = locationsInfos;
   } 
}
