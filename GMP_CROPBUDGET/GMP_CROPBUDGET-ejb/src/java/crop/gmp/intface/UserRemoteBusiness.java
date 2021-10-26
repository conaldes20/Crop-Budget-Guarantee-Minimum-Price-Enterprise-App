/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.intface;

import crop.gmp.model.Cbquantity;
import crop.gmp.util.CBDGTAmounts;
import crop.gmp.util.CBDGTParams;
import crop.gmp.util.CBDGTQties;
import crop.gmp.util.CLYPIDnums;
import crop.gmp.util.CLYPTVars;
import crop.gmp.util.CropbudgetVars;
import crop.gmp.util.UsernameRole;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface UserRemoteBusiness {
    
    public String addUserParameeters(final String usern, final String pswd, final String role);
    
    public String logon(final String username, final String password);
    
    public Long getUserId(final String username, final String password);
    
    public List<UsernameRole> usernameRoleList();
    
    public String getRole();
    
    public boolean authenticationStatus();
    
    public String getMSG();
}
