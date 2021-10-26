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
@Table(name = "CBPLANTINGTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbplantingtype.findAll", query = "SELECT c FROM Cbplantingtype c"),
    @NamedQuery(name = "Cbplantingtype.findByPltypeid", query = "SELECT c FROM Cbplantingtype c WHERE c.pltypeid = :pltypeid"),
    @NamedQuery(name = "Cbplantingtype.findByPltype", query = "SELECT c FROM Cbplantingtype c WHERE c.pltype LIKE :pltype")})
public class Cbplantingtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLTYPEID")
    private Integer pltypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "PLTYPE")
    private String pltype;

    public Cbplantingtype() {
    }

    public Cbplantingtype(Integer pltypeid) {
        this.pltypeid = pltypeid;
    }

    public Cbplantingtype(Integer pltypeid, String pltype) {
        this.pltypeid = pltypeid;
        this.pltype = pltype;
    }

    public Integer getPltypeid() {
        return pltypeid;
    }

    public void setPltypeid(Integer pltypeid) {
        this.pltypeid = pltypeid;
    }

    public String getPltype() {
        return pltype;
    }

    public void setPltype(String pltype) {
        this.pltype = pltype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pltypeid != null ? pltypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbplantingtype)) {
            return false;
        }
        Cbplantingtype other = (Cbplantingtype) object;
        if ((this.pltypeid == null && other.pltypeid != null) || (this.pltypeid != null && !this.pltypeid.equals(other.pltypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop.gmp.ejb.Cbplantingtype[ pltypeid=" + pltypeid + " ]";
    }
    
}
