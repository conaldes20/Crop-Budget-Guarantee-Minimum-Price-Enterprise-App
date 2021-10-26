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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CONALDES
 */
@Entity
@Table(name = "CBYEAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbyear.findAll", query = "SELECT c FROM Cbyear c"),
    @NamedQuery(name = "Cbyear.findByYearid", query = "SELECT c FROM Cbyear c WHERE c.yearid = :yearid"),
    @NamedQuery(name = "Cbyear.findByYeear", query = "SELECT c FROM Cbyear c WHERE c.yeear = :yeear")})
public class Cbyear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEARID")
    private Integer yearid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEEAR")
    private int yeear;

    public Cbyear() {
    }

    public Cbyear(Integer yearid) {
        this.yearid = yearid;
    }

    public Cbyear(Integer yearid, int yeear) {
        this.yearid = yearid;
        this.yeear = yeear;
    }

    public Integer getYearid() {
        return yearid;
    }

    public void setYearid(Integer yearid) {
        this.yearid = yearid;
    }

    public int getYeear() {
        return yeear;
    }

    public void setYeear(int yeear) {
        this.yeear = yeear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yearid != null ? yearid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbyear)) {
            return false;
        }
        Cbyear other = (Cbyear) object;
        if ((this.yearid == null && other.yearid != null) || (this.yearid != null && !this.yearid.equals(other.yearid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop.gmp.ejb.Cbyear[ yearid=" + yearid + " ]";
    }
    
}
