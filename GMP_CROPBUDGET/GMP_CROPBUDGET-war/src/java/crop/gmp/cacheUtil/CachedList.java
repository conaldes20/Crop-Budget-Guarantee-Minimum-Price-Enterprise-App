/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.cacheUtil;

/**
 *
 * @author user
 */
import crop.gmp.util.UsernameRole;
import java.util.ArrayList;
import java.util.List;

public class CachedList {
    private List<UsernameRole> usernamesRoles;
    
    public CachedList(){
        usernamesRoles = new ArrayList<>();
    }
        
    public void copyObjlist(List<UsernameRole> usernsroles){
        this.usernamesRoles = usernsroles;
    }
    
    public List<UsernameRole> getObjlist(){        
        return usernamesRoles;
    }

    public void cachedNewObj(UsernameRole usernameRole){
        try{
            if(usernameRole != null)
                System.out.println("usernameRole.getUsername(), usernameRole.getRole(): " + usernameRole.getUsername() + ", " + usernameRole.getRole());
            
            usernamesRoles.add(usernameRole);
        } catch (UnsupportedOperationException ueexp){
            System.out.println("usernameRole == null: " + (usernameRole == null));
        }
    }
}