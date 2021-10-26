/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CBVARRATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbvarrate.findAll", query = "SELECT c FROM Cbvarrate c"),
    @NamedQuery(name = "Cbvarrate.findByVarrateid", query = "SELECT c FROM Cbvarrate c WHERE c.varrateid = :varrateid"),
    @NamedQuery(name = "Cbvarrate.findByVarrate1", query = "SELECT c FROM Cbvarrate c WHERE c.varrate1 = :varrate1"),
    @NamedQuery(name = "Cbvarrate.findByVarrate2", query = "SELECT c FROM Cbvarrate c WHERE c.varrate2 = :varrate2"),
    @NamedQuery(name = "Cbvarrate.findByVarrate3", query = "SELECT c FROM Cbvarrate c WHERE c.varrate3 = :varrate3"),
    @NamedQuery(name = "Cbvarrate.findByVarrate4", query = "SELECT c FROM Cbvarrate c WHERE c.varrate4 = :varrate4"),
    @NamedQuery(name = "Cbvarrate.findByVarrate5", query = "SELECT c FROM Cbvarrate c WHERE c.varrate5 = :varrate5"),
    @NamedQuery(name = "Cbvarrate.findByVarrate6", query = "SELECT c FROM Cbvarrate c WHERE c.varrate6 = :varrate6"),
    @NamedQuery(name = "Cbvarrate.findByVarrate7", query = "SELECT c FROM Cbvarrate c WHERE c.varrate7 = :varrate7"),
    @NamedQuery(name = "Cbvarrate.findByVarrate8", query = "SELECT c FROM Cbvarrate c WHERE c.varrate8 = :varrate8"),
    @NamedQuery(name = "Cbvarrate.findByVarrate9", query = "SELECT c FROM Cbvarrate c WHERE c.varrate9 = :varrate9"),
    @NamedQuery(name = "Cbvarrate.findByVarrate10", query = "SELECT c FROM Cbvarrate c WHERE c.varrate10 = :varrate10"),
    @NamedQuery(name = "Cbvarrate.findByVarrate11", query = "SELECT c FROM Cbvarrate c WHERE c.varrate11 = :varrate11"),
    @NamedQuery(name = "Cbvarrate.findByVarrate12", query = "SELECT c FROM Cbvarrate c WHERE c.varrate12 = :varrate12"),
    @NamedQuery(name = "Cbvarrate.findByVarrate13", query = "SELECT c FROM Cbvarrate c WHERE c.varrate13 = :varrate13"),
    @NamedQuery(name = "Cbvarrate.findByVarrate14", query = "SELECT c FROM Cbvarrate c WHERE c.varrate14 = :varrate14"),
    @NamedQuery(name = "Cbvarrate.findByVarrate15", query = "SELECT c FROM Cbvarrate c WHERE c.varrate15 = :varrate15"),
    @NamedQuery(name = "Cbvarrate.findByVarrate16", query = "SELECT c FROM Cbvarrate c WHERE c.varrate16 = :varrate16"),
    @NamedQuery(name = "Cbvarrate.findByVarrate17", query = "SELECT c FROM Cbvarrate c WHERE c.varrate17 = :varrate17"),
    @NamedQuery(name = "Cbvarrate.findByVarrate18", query = "SELECT c FROM Cbvarrate c WHERE c.varrate18 = :varrate18"),
    @NamedQuery(name = "Cbvarrate.findByVarrate19", query = "SELECT c FROM Cbvarrate c WHERE c.varrate19 = :varrate19")})
public class Cbvarrate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VARRATEID")
    private Integer varrateid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPID")
    private Integer cropid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATIONID")
    private Integer locationid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEARID")
    private Integer yearid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLTYPEID")
    private Integer pltypeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE1")
    private BigDecimal varrate1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE2")
    private BigDecimal varrate2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE3")
    private BigDecimal varrate3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE4")
    private BigDecimal varrate4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE5")
    private BigDecimal varrate5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE6")
    private BigDecimal varrate6;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE7")
    private BigDecimal varrate7;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE8")
    private BigDecimal varrate8;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE9")
    private BigDecimal varrate9;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE10")
    private BigDecimal varrate10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE11")
    private BigDecimal varrate11;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE12")
    private BigDecimal varrate12;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE13")
    private BigDecimal varrate13;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE14")
    private BigDecimal varrate14;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE15")
    private BigDecimal varrate15;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE16")
    private BigDecimal varrate16;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE17")
    private BigDecimal varrate17;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE18")
    private BigDecimal varrate18;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARRATE19")
    private BigDecimal varrate19;

    public Cbvarrate() {
    }

    public Cbvarrate(Integer varrateid) {
        this.varrateid = varrateid;
    }

    public Cbvarrate(Integer varrateid, BigDecimal varrate1, BigDecimal varrate2, BigDecimal varrate3, BigDecimal varrate4, BigDecimal varrate5, BigDecimal varrate6, BigDecimal varrate7, BigDecimal varrate8, BigDecimal varrate9, BigDecimal varrate10, BigDecimal varrate11, BigDecimal varrate12, BigDecimal varrate13, BigDecimal varrate14, BigDecimal varrate15, BigDecimal varrate16, BigDecimal varrate17, BigDecimal varrate18, BigDecimal varrate19) {
        this.varrateid = varrateid;
        this.varrate1 = varrate1;
        this.varrate2 = varrate2;
        this.varrate3 = varrate3;
        this.varrate4 = varrate4;
        this.varrate5 = varrate5;
        this.varrate6 = varrate6;
        this.varrate7 = varrate7;
        this.varrate8 = varrate8;
        this.varrate9 = varrate9;
        this.varrate10 = varrate10;
        this.varrate11 = varrate11;
        this.varrate12 = varrate12;
        this.varrate13 = varrate13;
        this.varrate14 = varrate14;
        this.varrate15 = varrate15;
        this.varrate16 = varrate16;
        this.varrate17 = varrate17;
        this.varrate18 = varrate18;
        this.varrate19 = varrate19;
    }

    public Integer getVarrateid() {
        return varrateid;
    }

    public void setVarrateid(Integer varrateid) {
        this.varrateid = varrateid;
    }
    
    public Integer getCropid() {
        return cropid;
    }

    public void setCropid(Integer cropid) {
        this.cropid = cropid;
    }
    
    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }
    
    public Integer getYearid() {
        return yearid;
    }

    public void setYearid(Integer yearid) {
        this.yearid = yearid;
    }
    
    public Integer getPltypeid() {
        return pltypeid;
    }

    public void setPltypeid(Integer pltypeid) {
        this.pltypeid = pltypeid;
    }
    
    public BigDecimal getVarrate1() {
        return varrate1;
    }

    public void setVarrate1(BigDecimal varrate1) {
        this.varrate1 = varrate1;
    }

    public BigDecimal getVarrate2() {
        return varrate2;
    }

    public void setVarrate2(BigDecimal varrate2) {
        this.varrate2 = varrate2;
    }

    public BigDecimal getVarrate3() {
        return varrate3;
    }

    public void setVarrate3(BigDecimal varrate3) {
        this.varrate3 = varrate3;
    }

    public BigDecimal getVarrate4() {
        return varrate4;
    }

    public void setVarrate4(BigDecimal varrate4) {
        this.varrate4 = varrate4;
    }

    public BigDecimal getVarrate5() {
        return varrate5;
    }

    public void setVarrate5(BigDecimal varrate5) {
        this.varrate5 = varrate5;
    }

    public BigDecimal getVarrate6() {
        return varrate6;
    }

    public void setVarrate6(BigDecimal varrate6) {
        this.varrate6 = varrate6;
    }

    public BigDecimal getVarrate7() {
        return varrate7;
    }

    public void setVarrate7(BigDecimal varrate7) {
        this.varrate7 = varrate7;
    }

    public BigDecimal getVarrate8() {
        return varrate8;
    }

    public void setVarrate8(BigDecimal varrate8) {
        this.varrate8 = varrate8;
    }

    public BigDecimal getVarrate9() {
        return varrate9;
    }

    public void setVarrate9(BigDecimal varrate9) {
        this.varrate9 = varrate9;
    }

    public BigDecimal getVarrate10() {
        return varrate10;
    }

    public void setVarrate10(BigDecimal varrate10) {
        this.varrate10 = varrate10;
    }

    public BigDecimal getVarrate11() {
        return varrate11;
    }

    public void setVarrate11(BigDecimal varrate11) {
        this.varrate11 = varrate11;
    }

    public BigDecimal getVarrate12() {
        return varrate12;
    }

    public void setVarrate12(BigDecimal varrate12) {
        this.varrate12 = varrate12;
    }

    public BigDecimal getVarrate13() {
        return varrate13;
    }

    public void setVarrate13(BigDecimal varrate13) {
        this.varrate13 = varrate13;
    }

    public BigDecimal getVarrate14() {
        return varrate14;
    }

    public void setVarrate14(BigDecimal varrate14) {
        this.varrate14 = varrate14;
    }

    public BigDecimal getVarrate15() {
        return varrate15;
    }

    public void setVarrate15(BigDecimal varrate15) {
        this.varrate15 = varrate15;
    }

    public BigDecimal getVarrate16() {
        return varrate16;
    }

    public void setVarrate16(BigDecimal varrate16) {
        this.varrate16 = varrate16;
    }

    public BigDecimal getVarrate17() {
        return varrate17;
    }

    public void setVarrate17(BigDecimal varrate17) {
        this.varrate17 = varrate17;
    }

    public BigDecimal getVarrate18() {
        return varrate18;
    }

    public void setVarrate18(BigDecimal varrate18) {
        this.varrate18 = varrate18;
    }

    public BigDecimal getVarrate19() {
        return varrate19;
    }

    public void setVarrate19(BigDecimal varrate19) {
        this.varrate19 = varrate19;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (varrateid != null ? varrateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbvarrate)) {
            return false;
        }
        Cbvarrate other = (Cbvarrate) object;
        if ((this.varrateid == null && other.varrateid != null) || (this.varrateid != null && !this.varrateid.equals(other.varrateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop.gmp.ejb.Cbvarrate[ varrateid=" + varrateid + " ]";
    }
    
}
