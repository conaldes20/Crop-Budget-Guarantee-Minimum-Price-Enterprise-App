/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CONALDES
 */
@Entity
@Table(name = "CBCROP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbcrop.findAll", query = "SELECT c FROM Cbcrop c"),
    @NamedQuery(name = "Cbcrop.findByCropid", query = "SELECT c FROM Cbcrop c WHERE c.cropid = :cropid"),
    @NamedQuery(name = "Cbcrop.findByCrop", query = "SELECT c FROM Cbcrop c WHERE c.crop LIKE :crop")})
public class Cbcrop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPID")
    private Integer cropid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CROP")
    private String crop;

    public Cbcrop() {
    }

    public Cbcrop(Integer cropid) {
        this.cropid = cropid;
    }

    public Cbcrop(Integer cropid, String crop) {
        this.cropid = cropid;
        this.crop = crop;
    }

    public Integer getCropid() {
        return cropid;
    }

    public void setCropid(Integer cropid) {
        this.cropid = cropid;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cropid != null ? cropid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbcrop)) {
            return false;
        }
        Cbcrop other = (Cbcrop) object;
        if ((this.cropid == null && other.cropid != null) || (this.cropid != null && !this.cropid.equals(other.cropid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop.gmp.ejb.Cbcrop[ cropid=" + cropid + " ]";
    }
    
}
