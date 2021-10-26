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
public class CLYPTVars implements Serializable {
    
    private String crop;
    private String location;
    private int yeear;
    private String pltype;
    
    public CLYPTVars() {
    }

    public CLYPTVars(String crop, String location, int year, String pltype) {
        this.crop = crop;
        this.location = location;
        this.yeear = year;
        this.pltype = pltype;
    }
    
    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getYeear() {
        return yeear;
    }

    public void setYeear(int yeear) {
        this.yeear = yeear;
    }
    
    public String getPltype() {
        return pltype;
    }

    public void setPltype(String pltype) {
        this.pltype = pltype;
    }    
}
