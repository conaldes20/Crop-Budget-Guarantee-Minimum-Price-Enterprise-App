/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "cbloguser")
@NamedQueries({
    @NamedQuery(name = "Cbloguser.findAll", query = "SELECT c FROM Cbloguser c"),
    @NamedQuery(name = "Cbloguser.findByLoguserId", query = "SELECT c FROM Cbloguser c WHERE c.loguserId = :loguserId"),
    @NamedQuery(name = "Cbloguser.findByUserId", query = "SELECT c FROM Cbloguser c WHERE c.userId = :userId"),
    @NamedQuery(name = "Cbloguser.findByLogsummary", query = "SELECT c FROM Cbloguser c WHERE c.logsummary = :logsummary")})
public class Cbloguser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "loguserId")
    private String loguserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private Long userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "logsummary")
    private String logsummary;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "logdetails")
    private String logdetails;

    public Cbloguser() {
    }

    public Cbloguser(String loguserId) {
        this.loguserId = loguserId;
    }

    public Cbloguser(String loguserId, Long userId, String logsummary, String logdetails) {
        this.loguserId = loguserId;
        this.userId = userId;
        this.logsummary = logsummary;
        this.logdetails = logdetails;
    }

    public String getLoguserId() {
        return loguserId;
    }

    public void setLoguserId(String loguserId) {
        this.loguserId = loguserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogsummary() {
        return logsummary;
    }

    public void setLogsummary(String logsummary) {
        this.logsummary = logsummary;
    }

    public String getLogdetails() {
        return logdetails;
    }

    public void setLogdetails(String logdetails) {
        this.logdetails = logdetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loguserId != null ? loguserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbloguser)) {
            return false;
        }
        Cbloguser other = (Cbloguser) object;
        if ((this.loguserId == null && other.loguserId != null) || (this.loguserId != null && !this.loguserId.equals(other.loguserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop_budget.gmp.model.Cbloguser[ loguserId=" + loguserId + " ]";
    }
    
}
