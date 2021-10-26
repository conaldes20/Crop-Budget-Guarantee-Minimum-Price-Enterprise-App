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
@Table(name = "CBQUANTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbquantity.findAll", query = "SELECT c FROM Cbquantity c"),
    @NamedQuery(name = "Cbquantity.findByQuantityid", query = "SELECT c FROM Cbquantity c WHERE c.quantityid = :quantityid"),
    @NamedQuery(name = "Cbquantity.findByQuantity1", query = "SELECT c FROM Cbquantity c WHERE c.quantity1 = :quantity1"),
    @NamedQuery(name = "Cbquantity.findByQuantity2", query = "SELECT c FROM Cbquantity c WHERE c.quantity2 = :quantity2"),
    @NamedQuery(name = "Cbquantity.findByQuantity3", query = "SELECT c FROM Cbquantity c WHERE c.quantity3 = :quantity3"),
    @NamedQuery(name = "Cbquantity.findByQuantity4", query = "SELECT c FROM Cbquantity c WHERE c.quantity4 = :quantity4"),
    @NamedQuery(name = "Cbquantity.findByQuantity5", query = "SELECT c FROM Cbquantity c WHERE c.quantity5 = :quantity5"),
    @NamedQuery(name = "Cbquantity.findByQuantity6", query = "SELECT c FROM Cbquantity c WHERE c.quantity6 = :quantity6"),
    @NamedQuery(name = "Cbquantity.findByQuantity7", query = "SELECT c FROM Cbquantity c WHERE c.quantity7 = :quantity7"),
    @NamedQuery(name = "Cbquantity.findByQuantity8", query = "SELECT c FROM Cbquantity c WHERE c.quantity8 = :quantity8"),
    @NamedQuery(name = "Cbquantity.findByQuantity9", query = "SELECT c FROM Cbquantity c WHERE c.quantity9 = :quantity9"),
    @NamedQuery(name = "Cbquantity.findByQuantity10", query = "SELECT c FROM Cbquantity c WHERE c.quantity10 = :quantity10"),
    @NamedQuery(name = "Cbquantity.findByQuantity11", query = "SELECT c FROM Cbquantity c WHERE c.quantity11 = :quantity11"),
    @NamedQuery(name = "Cbquantity.findByQuantity12", query = "SELECT c FROM Cbquantity c WHERE c.quantity12 = :quantity12"),
    @NamedQuery(name = "Cbquantity.findByQuantity13", query = "SELECT c FROM Cbquantity c WHERE c.quantity13 = :quantity13"),
    @NamedQuery(name = "Cbquantity.findByQuantity14", query = "SELECT c FROM Cbquantity c WHERE c.quantity14 = :quantity14"),
    @NamedQuery(name = "Cbquantity.findByQuantity15", query = "SELECT c FROM Cbquantity c WHERE c.quantity15 = :quantity15"),
    @NamedQuery(name = "Cbquantity.findByQuantity16", query = "SELECT c FROM Cbquantity c WHERE c.quantity16 = :quantity16"),
    @NamedQuery(name = "Cbquantity.findByQuantity17", query = "SELECT c FROM Cbquantity c WHERE c.quantity17 = :quantity17"),
    @NamedQuery(name = "Cbquantity.findByQuantity18", query = "SELECT c FROM Cbquantity c WHERE c.quantity18 = :quantity18"),
    @NamedQuery(name = "Cbquantity.findByQuantity19", query = "SELECT c FROM Cbquantity c WHERE c.quantity19 = :quantity19")})
public class Cbquantity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "QUANTITYID")
    private Integer quantityid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY1")
    private BigDecimal quantity1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY2")
    private BigDecimal quantity2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY3")
    private BigDecimal quantity3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY4")
    private BigDecimal quantity4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY5")
    private BigDecimal quantity5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY6")
    private BigDecimal quantity6;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY7")
    private BigDecimal quantity7;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY8")
    private BigDecimal quantity8;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY9")
    private BigDecimal quantity9;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY10")
    private BigDecimal quantity10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY11")
    private BigDecimal quantity11;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY12")
    private BigDecimal quantity12;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY13")
    private BigDecimal quantity13;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY14")
    private BigDecimal quantity14;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY15")
    private BigDecimal quantity15;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY16")
    private BigDecimal quantity16;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY17")
    private BigDecimal quantity17;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY18")
    private BigDecimal quantity18;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY19")
    private BigDecimal quantity19;

    public Cbquantity() {
    }

    public Cbquantity(Integer quantityid) {
        this.quantityid = quantityid;
    }

    public Cbquantity(Integer quantityid, BigDecimal quantity1, BigDecimal quantity2, BigDecimal quantity3, BigDecimal quantity4, BigDecimal quantity5, BigDecimal quantity6, BigDecimal quantity7, BigDecimal quantity8, BigDecimal quantity9, BigDecimal quantity10, BigDecimal quantity11, BigDecimal quantity12, BigDecimal quantity13, BigDecimal quantity14, BigDecimal quantity15, BigDecimal quantity16, BigDecimal quantity17, BigDecimal quantity18, BigDecimal quantity19) {
        this.quantityid = quantityid;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
        this.quantity3 = quantity3;
        this.quantity4 = quantity4;
        this.quantity5 = quantity5;
        this.quantity6 = quantity6;
        this.quantity7 = quantity7;
        this.quantity8 = quantity8;
        this.quantity9 = quantity9;
        this.quantity10 = quantity10;
        this.quantity11 = quantity11;
        this.quantity12 = quantity12;
        this.quantity13 = quantity13;
        this.quantity14 = quantity14;
        this.quantity15 = quantity15;
        this.quantity16 = quantity16;
        this.quantity17 = quantity17;
        this.quantity18 = quantity18;
        this.quantity19 = quantity19;
    }

    public Integer getQuantityid() {
        return quantityid;
    }

    public void setQuantityid(Integer quantityid) {
        this.quantityid = quantityid;
    }

    public BigDecimal getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(BigDecimal quantity1) {
        this.quantity1 = quantity1;
    }

    public BigDecimal getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(BigDecimal quantity2) {
        this.quantity2 = quantity2;
    }

    public BigDecimal getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(BigDecimal quantity3) {
        this.quantity3 = quantity3;
    }

    public BigDecimal getQuantity4() {
        return quantity4;
    }

    public void setQuantity4(BigDecimal quantity4) {
        this.quantity4 = quantity4;
    }

    public BigDecimal getQuantity5() {
        return quantity5;
    }

    public void setQuantity5(BigDecimal quantity5) {
        this.quantity5 = quantity5;
    }

    public BigDecimal getQuantity6() {
        return quantity6;
    }

    public void setQuantity6(BigDecimal quantity6) {
        this.quantity6 = quantity6;
    }

    public BigDecimal getQuantity7() {
        return quantity7;
    }

    public void setQuantity7(BigDecimal quantity7) {
        this.quantity7 = quantity7;
    }

    public BigDecimal getQuantity8() {
        return quantity8;
    }

    public void setQuantity8(BigDecimal quantity8) {
        this.quantity8 = quantity8;
    }

    public BigDecimal getQuantity9() {
        return quantity9;
    }

    public void setQuantity9(BigDecimal quantity9) {
        this.quantity9 = quantity9;
    }

    public BigDecimal getQuantity10() {
        return quantity10;
    }

    public void setQuantity10(BigDecimal quantity10) {
        this.quantity10 = quantity10;
    }

    public BigDecimal getQuantity11() {
        return quantity11;
    }

    public void setQuantity11(BigDecimal quantity11) {
        this.quantity11 = quantity11;
    }

    public BigDecimal getQuantity12() {
        return quantity12;
    }

    public void setQuantity12(BigDecimal quantity12) {
        this.quantity12 = quantity12;
    }

    public BigDecimal getQuantity13() {
        return quantity13;
    }

    public void setQuantity13(BigDecimal quantity13) {
        this.quantity13 = quantity13;
    }

    public BigDecimal getQuantity14() {
        return quantity14;
    }

    public void setQuantity14(BigDecimal quantity14) {
        this.quantity14 = quantity14;
    }

    public BigDecimal getQuantity15() {
        return quantity15;
    }

    public void setQuantity15(BigDecimal quantity15) {
        this.quantity15 = quantity15;
    }

    public BigDecimal getQuantity16() {
        return quantity16;
    }

    public void setQuantity16(BigDecimal quantity16) {
        this.quantity16 = quantity16;
    }

    public BigDecimal getQuantity17() {
        return quantity17;
    }

    public void setQuantity17(BigDecimal quantity17) {
        this.quantity17 = quantity17;
    }

    public BigDecimal getQuantity18() {
        return quantity18;
    }

    public void setQuantity18(BigDecimal quantity18) {
        this.quantity18 = quantity18;
    }

    public BigDecimal getQuantity19() {
        return quantity19;
    }

    public void setQuantity19(BigDecimal quantity19) {
        this.quantity19 = quantity19;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quantityid != null ? quantityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbquantity)) {
            return false;
        }
        Cbquantity other = (Cbquantity) object;
        if ((this.quantityid == null && other.quantityid != null) || (this.quantityid != null && !this.quantityid.equals(other.quantityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop.gmp.ejb.Cbquantity[ quantityid=" + quantityid + " ]";
    }
    
}
