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
public class CLYPIDnums implements Serializable {
    private int cropId;
    private int locationId;
    private int yearId;
    private int pltypeId;

    public CLYPIDnums() {
    }

    public CLYPIDnums(int cropId, int locationId, int yearId, int pltypeId) {
        this.cropId = cropId;
        this.locationId = locationId;
        this.yearId = yearId;
        this.pltypeId = pltypeId;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getPltypeId() {
        return pltypeId;
    }

    public void setPltypeId(int pltypeId) {
        this.pltypeId = pltypeId;
    }
}