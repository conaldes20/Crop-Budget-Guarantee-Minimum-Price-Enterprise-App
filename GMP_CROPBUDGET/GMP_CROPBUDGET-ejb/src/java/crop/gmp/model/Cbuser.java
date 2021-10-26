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
import javax.persistence.Id;
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
@Table(name = "cbuser")
@NamedQueries({
    @NamedQuery(name = "Cbuser.findAll", query = "SELECT c FROM Cbuser c"),
    @NamedQuery(name = "Cbuser.findByUsernamePasswd", query = "SELECT c FROM Cbuser c WHERE c.username LIKE :username AND c.passwd LIKE :passwd"),
    @NamedQuery(name = "Cbuser.findByUserId", query = "SELECT c FROM Cbuser c WHERE c.userId = :userId"),
    @NamedQuery(name = "Cbuser.findByUsername", query = "SELECT c FROM Cbuser c WHERE c.username = :username"),
    @NamedQuery(name = "Cbuser.findByPasswd", query = "SELECT c FROM Cbuser c WHERE c.passwd = :passwd"),
    @NamedQuery(name = "Cbuser.findByRole", query = "SELECT c FROM Cbuser c WHERE c.role = :role")})
public class Cbuser implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private Long userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "passwd")
    private String passwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "role")
    private String role;

    public Cbuser() {
    }

    public Cbuser(Long userId) {
        this.userId = userId;
    }

    public Cbuser(Long userId, String username, String passwd, String role) {
        this.userId = userId;
        this.username = username;
        this.passwd = passwd;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbuser)) {
            return false;
        }
        Cbuser other = (Cbuser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crop_budget.gmp.model.Cbuser[ userId=" + userId + " ]";
    }
    
}
