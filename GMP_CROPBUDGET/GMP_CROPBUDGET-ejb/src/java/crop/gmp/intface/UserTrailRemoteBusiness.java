/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.intface;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface UserTrailRemoteBusiness {
    
    public List<String> getLoggedSummaries(final String username, final String logDate1, final String logDate2);
    
    public String getLoggedDetails(final String UNROLTAUTH);
    
    public String saveUserTrails(final Long userId, final String loggedsummary, final String loggeddetails);
    //public CBDGTAmounts getVarsAmounts(CLYPIDnums clypidnums);
    //public void updateUserTrails(final String loggedusrId, final BigInteger userId, final String logsummary, final String loggeddetails);
    public void updateUserTrails(final String loggedusrId, final String loggeddetails);
    public String getMSG();
}
