/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.locator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.servlet.ServletContext;

/**
 *
 * @author user
 */
public class BusinessInterface {
    //private CropBDGTRemoteBusiness JNDI_NAME_CBDGT; 
    
    private final String JNDI_NAME_CBDGTGMP_REMOTE_BUSINESS = "java:global/GMP_CROPBUDGET/GMP_CROPBUDGET-ejb/CropBDGTBeanRemote!crop.gmp.intface.CropBDGTRemoteBusiness";
    private final String JNDI_NAME_USER_REMOTE_BUSINESS = "java:global/GMP_CROPBUDGET/GMP_CROPBUDGET-ejb/UserBeanRemote!crop.gmp.intface.UserRemoteBusiness";
    private final String JNDI_NAME_USERTRAIL_REMOTE_BUSINESS = "java:global/GMP_CROPBUDGET/GMP_CROPBUDGET-ejb/UserTrailBeanRemote!crop.gmp.intface.UserTrailRemoteBusiness";
    
    public BusinessInterface(){
    }
    
    public Object getRemoteBusiness(Context namingContext, String jndiName){ 
        try {
            if(jndiName.equals("USERTRAIL_REMOTE")){
                System .out.println("Looking up and get UserTrailRemoteBusiness");
                return namingContext.lookup(JNDI_NAME_USERTRAIL_REMOTE_BUSINESS);            
            } else if (jndiName.equals("USER_REMOTE")){
                System .out.println("Looking up and get UserRemoteBusiness");
                return namingContext.lookup(JNDI_NAME_USER_REMOTE_BUSINESS);
            }  else if (jndiName.equals("CBDGTGMP_REMOTE")){
                System .out.println("Looking up and get CropBDGTRemoteBusiness");
                return namingContext.lookup(JNDI_NAME_CBDGTGMP_REMOTE_BUSINESS);
            }  
        } catch (NamingException ex) {
            Logger.getLogger(BusinessInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    public Object getRemoteBusiness(ServletContext context, String jndiName){        
        if(jndiName.equals("USERTRAIL_REMOTE")){
            System .out.println("Looking up and get UserTrailRemoteBusiness");
            return context.getAttribute("JNDI_NAME_USERTRAIL");
        } else if (jndiName.equals("USER_REMOTE")){
            System .out.println("Looking up and get UserRemoteBusiness");
            return context.getAttribute("JNDI_NAME_USER");
        }  else if (jndiName.equalsIgnoreCase("CBDGTGMP_REMOTE")){
            System .out.println("Looking up and get CropBDGTRemoteBusiness");
            return context.getAttribute("JNDI_NAME_CBDGT");
        } else {
            return null;
        }        
    }
    */
}
