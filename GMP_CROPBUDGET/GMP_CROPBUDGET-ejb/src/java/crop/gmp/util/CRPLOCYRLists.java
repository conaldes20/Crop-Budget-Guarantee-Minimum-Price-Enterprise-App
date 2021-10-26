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
public class CRPLOCYRLists implements Serializable {
    private List<String> crops;
    private List<String> locations;
    private List<String> years;
    private List<String> farmingtypes;

    public CRPLOCYRLists() {
    }

    public List<String> getCrops() { 
         return crops; 
    }
    public void setCrops(List<String> crops) {
         this.crops = crops;
    }
    
    public List<String> getLocations() { 
         return locations; 
    }
    
    public void setLocations(List<String> locations) {
         this.locations = locations;
    }
    
    public List<String> getYears() { 
         return years; 
    }
    public void setYears(List<String> years) {
         this.years = years;
    }
    
    public List<String> getFarmingtypes() { 
         return farmingtypes; 
    }
    public void setFarmingtypes(List<String> farmingtypes) {
         this.farmingtypes = farmingtypes;
    }
}
