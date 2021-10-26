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
@Table(name = "CBLOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cblocation.findAll", query = "SELECT c FROM Cblocation c"),
    @NamedQuery(name = "Cblocation.findByLocationid", query = "SELECT c FROM Cblocation c WHERE c.locationid = :locationid"),
    @NamedQuery(name = "Cblocation.findByLocation", query = "SELECT c FROM Cblocation c WHERE c.location LIKE :location")})
public class Cblocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATIONID")
    private Integer locationid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "LOCATION")
    private String location;

    public Cblocation() {
    }

    public Cblocation(Integer locationid) {
        this.locationid = locationid;
    }

    public Cblocation(Integer locationid, String location) {
        this.locationid = locationid;
        this.location = location;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationid != null ? locationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cblocation)) {
            return false;
        }
        Cblocation other = (Cblocation) object;
        if ((this.locationid == null && other.locationid != null) || (this.locationid != null && !this.locationid.equals(other.locationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop.gmp.ejb.Cblocation[ locationid=" + locationid + " ]";
    }
    
}
