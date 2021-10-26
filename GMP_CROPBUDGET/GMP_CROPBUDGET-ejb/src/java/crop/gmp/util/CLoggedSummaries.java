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
public class CLoggedSummaries implements Serializable{
    private List<String> loggedSummaries;

   public CLoggedSummaries() {
   }
   
   public List<String> getLoggedSummaries() { 
        return loggedSummaries; 
   }

   public void setLoggedSummaries(List<String> loggedSummaries) {
        this.loggedSummaries = loggedSummaries;
   }
}
