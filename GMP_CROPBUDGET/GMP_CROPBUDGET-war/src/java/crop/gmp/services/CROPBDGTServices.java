/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.services;

import crop.gmp.intface.CropBDGTRemoteBusiness;
import crop.gmp.model.Cbquantity;
import crop.gmp.util.CBDGTAmounts;
import crop.gmp.util.CBDGTParams;
import crop.gmp.util.CBDGTQties;
import crop.gmp.util.CLYPIDnums;
import crop.gmp.util.CLYPTVars;
import crop.gmp.util.CropbudgetVars;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CROPBDGTServices {
        private static final Logger log = Logger.getLogger(UsersServices.class.getName());
        
	//private static final String JNDI_NAME_EJB = "SecureSchoolBeanLocal";

	//private final CropBudgetRemoteBusiness cropBudget;
        
        //public UserServices(SecureSchoolLocalBusiness unauthenticatedSchool, SecureSchoolLocalBusiness authenticatedSchool, FireDepartmentLocalBusiness fireDepartment) {
        public CROPBDGTServices() {
            System.out.println("CROPBDGTServices created: ");
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
	
	/**
	* Ensures that the "student" user can open the front door
        * @param cropBudget
        * @param cropbdgtvars
        * @param clyptvars
        * @return 
	*/
	public String enterCBDGTVars(CropBDGTRemoteBusiness cropBudget, final CropbudgetVars cropbdgtvars, final CLYPTVars clyptvars)
	{
		return cropBudget.enterData(cropbdgtvars, clyptvars);
	}
        
        public String modifyCBDGTVars(CropBDGTRemoteBusiness cropBudget, final CropbudgetVars  cropbdgtvars, final CLYPTVars clyptvars)  //, final String username, final String role)
	{
		return cropBudget.modifyData(cropbdgtvars, clyptvars);   //, username, role);
	}

        public String modifyCBDGTQties(CropBDGTRemoteBusiness cropBudget, final CBDGTQties cbdgtqties)  //, final String username, final String role)
	{
		return cropBudget.modifyQties(cbdgtqties);   //, username, role);
	}
        
        public String enterCBDGTQtyies(CropBDGTRemoteBusiness cropBudget, final CBDGTQties cbdgtqties)
	{
		return cropBudget.enterQTYData(cbdgtqties);
	}
        
	public CBDGTParams retreiveVarsRates(CropBDGTRemoteBusiness cropBudget, final CLYPIDnums clypidnums)
	{
		//return cropBudget.accessVarsRates(clyptvars, role);
                return cropBudget.getVarsRates(clypidnums);
	}
        
        public CBDGTAmounts retreiveVarsAmounts(CropBDGTRemoteBusiness cropBudget, final CLYPIDnums clypidnums, String yield, String mktp, String rptType)  //,  final String role)
	{
		
                return cropBudget.getVarsAmounts(clypidnums, yield, mktp, rptType);  //, role);
	}
        
        public CLYPIDnums converNamesToIds(CropBDGTRemoteBusiness cropBudget, String crop, String location, int year, String plttype)
	{
		
                return cropBudget.namesToIds(crop, location, year, plttype);
	}
	
        public String listUpdate(CropBDGTRemoteBusiness cropBudget,final String  crop, final String  location, final String  farmtype)
        {
            return cropBudget.updatingLists(crop, location, farmtype);
        }
               
        public List<String> reportsLinks(final CropBDGTRemoteBusiness cropBudget, String crop, String state, String year1, String year2)   
	{	
            return cropBudget.locationInfos(crop, state, year1, year2);
	}        
                
        public List<String> crops(final CropBDGTRemoteBusiness cropBudget)   
	{	
            return cropBudget.cropList();
	}
        
        public List<String> years(final CropBDGTRemoteBusiness cropBudget)   
	{	
            return cropBudget.yearList();
	}
        public Cbquantity getQuantities(final CropBDGTRemoteBusiness cropBudget)   //, int quantityId)   
	{	
            return cropBudget.getCbquantity();  //quantityId);
	}
        public List<String> locations(final CropBDGTRemoteBusiness cropBudget)   
	{	
            return cropBudget.locationList();
	}
        
        public List<String> farmingtypes(final CropBDGTRemoteBusiness cropBudget)   
	{	
            return cropBudget.plantingtypeList();
	}
        
        public String serviceMSG(final CropBDGTRemoteBusiness cropBudget)
        {
            return cropBudget.getMSG();
        }        
}
