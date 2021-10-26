/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.services;

//import java.util.HashMap;
//import java.util.Map;
import crop.gmp.intface.UserRemoteBusiness;
import crop.gmp.util.UsernameRole;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UsersServices {
    
        private String role;
        private String serviceMSG;
        private static final Logger log = Logger.getLogger(UsersServices.class.getName());
        
	//private static final String JNDI_NAME_EJB = "SecureSchoolBeanLocal";

	//private final CropBudgetRemoteBusiness cropBudget;
        
        //public UserServices(SecureSchoolLocalBusiness unauthenticatedSchool, SecureSchoolLocalBusiness authenticatedSchool, FireDepartmentLocalBusiness fireDepartment) {
        public UsersServices() {
            System.out.println("UsersServices created: ");
            //this.fireDepartment = fireDepartment;
        }
        

	/**
	* Ensures that an cropBudget user cannot open the front door
     * @param userBusiness
     * @param usern
     * @param pswd
        * @param role
     * @return 
	*/
	public String addApplicationUser(UserRemoteBusiness userBusiness, final String usern, final String pswd, final String role)
	{
		// Try to open the front door before we've authenticated; should fail
		return userBusiness.addUserParameeters(usern, pswd, role);
	}
	
	public void authenticateUser(UserRemoteBusiness userBusiness, final String username, final String password)   //throws NamingException
	{
		userBusiness.logon(username, password);
	}
        
        public List<UsernameRole> userParticulars(final UserRemoteBusiness userBusiness)   
	{	
            return userBusiness.usernameRoleList();
	}        
        
        public String serviceMSG(final UserRemoteBusiness userBusiness)
        {
            return userBusiness.getMSG();
        } 
        
        public String getUserRole(final UserRemoteBusiness userBusiness)
        {
            return userBusiness.getRole();
        }
        
        public boolean getAuthenticationStatus(final UserRemoteBusiness userBusiness)
        {
            return userBusiness.authenticationStatus();
        }
        
        public Long getUserIdentity(final UserRemoteBusiness userBusiness, final String username, final String password)
        {
            return userBusiness.getUserId(username, password);
        }
}
