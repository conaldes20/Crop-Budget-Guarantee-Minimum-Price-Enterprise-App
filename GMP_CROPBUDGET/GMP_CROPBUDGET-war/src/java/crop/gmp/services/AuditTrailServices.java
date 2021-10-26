/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.services;

import crop.gmp.intface.UserTrailRemoteBusiness;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AuditTrailServices {
        private static final Logger log = Logger.getLogger(UsersServices.class.getName());
        
	//private static final String JNDI_NAME_EJB = "SecureSchoolBeanLocal";

	//private final CropBudgetRemoteBusiness cropBudget;
        
        //public UserServices(SecureSchoolLocalBusiness unauthenticatedSchool, SecureSchoolLocalBusiness authenticatedSchool, FireDepartmentLocalBusiness fireDepartment) {
        public AuditTrailServices() {
            System.out.println("UsersServices created: ");
            //this.fireDepartment = fireDepartment;
        }
        

	/**
	* Ensures that an cropBudget user cannot open the front door
     * @param userTrail
     * @return 
	*/
	        
        public String serviceMSG(final UserTrailRemoteBusiness userTrail)
        {
            return userTrail.getMSG();
        } 
            
        public String logUserDetails(final UserTrailRemoteBusiness userTrail, final Long userId, final String loggedsummary, final String loggeddetails)
        {
            return userTrail.saveUserTrails(userId, loggedsummary, loggeddetails);
        }
        
        //public void updateUserDetails(final UserTrailRemoteBusiness userTrail, final String loggedusrId, final BigInteger userId, final String logsummary, final String loggeddetails)
        //{
        //    userTrail.updateUserTrails(loggedusrId, userId, logsummary, loggeddetails);
        //}
        
        public void updateUserDetails(final UserTrailRemoteBusiness userTrail, final String loggedusrId, final String loggeddetails)
        {
            userTrail.updateUserTrails(loggedusrId, loggeddetails);
        }
                
        public List<String> loggedSummaries(final UserTrailRemoteBusiness userTrail, final String username, final String logDate1, final String logDate2)
        {
            return userTrail.getLoggedSummaries(username, logDate1, logDate2);
        }
        
        public String loggedDetails(final UserTrailRemoteBusiness userTrail, final String UNROLTAUTH)
        {
            return userTrail.getLoggedDetails(UNROLTAUTH);
        }
}
