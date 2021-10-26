/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.intface;

import crop.gmp.model.Cbquantity;
//import crop.gmp.model.Cbvarrate;
import crop.gmp.util.CBDGTAmounts;
import crop.gmp.util.CBDGTParams;
import crop.gmp.util.CBDGTQties;
import crop.gmp.util.CLYPIDnums;
import crop.gmp.util.CLYPTVars;
import crop.gmp.util.CropbudgetVars;
//import crop.gmp.util.UsernameRole;
//import java.math.BigDecimal;
//import java.math.BigInteger;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface CropBDGTRemoteBusiness {
    
    public String enterData(CropbudgetVars cropbdgtvars, final CLYPTVars clyptvars);  //, final String username, final String role);
    
    public String modifyData(CropbudgetVars cropbdgtvars, final CLYPTVars clyptvars);  //, final String username, final String role);
    
    public String modifyQties(final CBDGTQties cbdgtqties);
    //public CBDGTAmounts getVarsAmounts(final CLYPIDnums clypidnums, String rptType);  //,  final String role);
    public CBDGTAmounts getVarsAmounts(final CLYPIDnums clypidnums, String cyield, String cmktp, String rptType);
    
    public CBDGTParams getVarsRates(final CLYPIDnums clypidnums);  //,  final String role);
    
    public CLYPIDnums namesToIds(String crop, String location, int year, String pltype);
    //public void saveUserParameeters(final String username, final String password, final String role);
    public List<String> yearList();
    
    public List<String> cropList();
    
    public List<String> locationList();
    
    public List<String> plantingtypeList();
    
    public String updatingLists(final String  crop,  final String  location, final String  farmtype);
        
    public String enterQTYData(final CBDGTQties cbdgtqties);
    //public CBDGTParams getVarsRates(CLYPIDnums clypidnums);
    //public Cbquantity getCbquantity(int quantityId);
    public Cbquantity getCbquantity();
    
    public List<String> locationInfos(String crop, String state, String year1, String year2);
    
    public String getMSG();  
}
