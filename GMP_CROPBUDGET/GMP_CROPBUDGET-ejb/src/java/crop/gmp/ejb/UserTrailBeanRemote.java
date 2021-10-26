/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.ejb;

import crop.gmp.intface.UserTrailRemoteBusiness;
import crop.gmp.model.Cbloguser;
import crop.gmp.util.Functions;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class UserTrailBeanRemote implements UserTrailRemoteBusiness{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final Logger log = Logger.getLogger(CropBDGTBeanRemote.class.getName());	
        private String msg = " ";
        
        @PersistenceContext(unitName="GMP_CROPBUDGET-ejbPU", type=PersistenceContextType.TRANSACTION)
        private EntityManager entityManager;
        
        @Override
        public List<String> getLoggedSummaries(final String username, final String logDate1, final String logDate2)
	{   
            List<String> loggedSummaries = new ArrayList<>();
            //final String SQL_LOGGED = "SELECT logsummary FROM Cbloguser WHERE loguserId like '" + dateASYYYYMMDD(logDate.trim()) + "%' and logsummary like '" + username.trim() + "%'";
            final String SQL_LOGGED = "SELECT loguserId, logsummary FROM Cbloguser WHERE logsummary like '" + username.trim() + "%'";

            System.out.println("username.trim(): " + username.trim()); 
            try{
                Query query = entityManager.createNativeQuery(SQL_LOGGED);                
                // Query and get result
                System.out.println("getLoggedSummaries 111");
                msg = "Action performed successfully.";                
                List<Object[]> objects = query.getResultList();
                System.out.println("objects.size(): " + objects.size());
                for ( Object obj[] : objects ) {
                    System.out.println("lgsummary: " + obj[1].toString());
                    Calendar lgdate = Functions.extractDate(obj[0].toString());
                    Calendar lgdate1 = Functions.createDate(logDate1);
                    Calendar lgdate2 = Functions.createDate(logDate2);
                    if((lgdate.before(lgdate2) && lgdate.after(lgdate1)) || (lgdate.equals(lgdate1) || lgdate.equals(lgdate2)))
                        loggedSummaries.add(obj[1].toString());
                    
                    if((lgdate.equals(lgdate2) || lgdate.before(lgdate2)) || (lgdate.equals(lgdate1) || lgdate.after(lgdate1)))
                        loggedSummaries.add(obj[1].toString());
                }
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("IllegalArgumentException ilagex: " + nniex.getMessage());
                msg = "Action not performed successfully.";
                loggedSummaries = Collections.EMPTY_LIST;
            }
            return loggedSummaries;
	}
        @Override
        public String getLoggedDetails(final String UNROLTAUTH)
	{    
            final String SQL_LOGGED = "SELECT logdetails FROM Cbloguser WHERE logsummary like '" + UNROLTAUTH.trim() + "'";
            System.out.println("UNROLTAUTH: " + UNROLTAUTH);
            try{
                Query query = entityManager.createNativeQuery(SQL_LOGGED);                
                // Query and get result
                msg = "User operations retrieved successfully.";
                Object obj = query.getSingleResult();
                System.out.println("(String)query.getSingleResult(): " + (String)query.getSingleResult());
                return obj.toString();                  
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("NoResultException noresltex: " + nniex.getMessage());
                msg = "User operations not successfully retrieved.";
                return " ";
            }            
	}

        @Override
        public String saveUserTrails(final Long userId, final String loggedsummary, final String loggeddetails)
	{   
            String loguserId = dateTimeID();
            System.out.println("loguserId = dateTimeID(): " + loguserId);
            //BigInteger userNo = userId.toBigInteger();
            System.out.println("String saveUserTrails. Point 11 " + loguserId);
            Cbloguser cbloguser = new Cbloguser(loguserId,userId,loggedsummary,loggeddetails);
            System.out.println("cbloguser.getLoguserId(): " + cbloguser.getLoguserId());
            System.out.println("cbloguser.getUserId(): " + cbloguser.getUserId());
            System.out.println("cbloguser.getLogsummary(): " + cbloguser.getLogsummary());
            System.out.println("cbloguser.getLogdetails(): " + cbloguser.getLogdetails());
            try{
                //sql = "insert into Cbloguser (loguserId,userId,logsummary,logdetails) values (" + loguserId + "," + userId + "," + loggedsummary + "," + loggeddetails + ")";
                System.out.println("Before entityManager.persist(cbloguser)");
                entityManager.persist(cbloguser);
                msg = "User's trails logged successfully.";
                System.out.println("After entityManager.persist(cbloguser)");
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                System.out.println("User's trails not logged.");
                msg = "User's trails not logged.";
            }
            return loguserId;
	}
        
        
        //public void updateUserTrails(final String loggedusrId, final BigInteger userId, final String logsummary, final String loggeddetails)
        @Override
        public void updateUserTrails(final String loggedusrId, final String loggeddetails)
	{   
            Query query; 
            String SQL = "UPDATE cbloguser SET logdetails = '" + loggeddetails.trim() + "' WHERE trim(loguserId) like '" + loggedusrId.trim() + "'";
            System.out.println("updateUserTrails 0000 User's trails to be logged.");
            try{
                query = entityManager.createNativeQuery(SQL);
                int done = query.executeUpdate();    
                System.out.println("updateUserTrails 111 User's trails logged.");
                msg = "User's trails updated successfully.";
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("User's trails not logged.");
                msg = "User's trails not updated.";
            }
            System.out.println("updateUserTrails 222 User's trails logged.");
	}
        
        @Override
        public String getMSG() {
            if(msg == null) 
                msg = "No service.\n";
            return msg;
        }
        
        private String dateTimeID(){
            String ldtStr, hdchar;  // = localDateTime.toString();
            int ldtStrln;  // =  ldtStr.length();
            Instant timestamp = Instant.now();
            ldtStr = (timestamp.toString()).trim();
            ldtStrln =  ldtStr.length();
            ldtStr = ldtStr.substring(0, ldtStrln - 1); //This statement removes the last Z character.
            ldtStrln = ldtStrln - 1;   //This takes care of the last Z character removed.
            StringBuilder result = new StringBuilder();
            System.out.println("Inside hexEncode() 1");        
            for (int idx = 0; idx < ldtStrln; idx++) {
                hdchar = ldtStr.substring(idx, idx + 1);
                switch (hdchar) {
                    case "-": case "T": case ":": case ".":
                    case "Z":
                        break;
                    case "0": case "1": case "2": case "3":
                    case "4": case "5": case "6": case "7":
                    case "8": case "9":
                        result.append(hdchar);
                        break;
                    default:
                        System.out.println("Invalid char.");
                        break;
                }
            }                
            return result.toString();
        }
        
        private String dateASYYYYMMDD(String stDate){
            String ldtStr, hdchar;  
            int ldtStrln;  
            ldtStr = stDate.trim();
            ldtStrln =  ldtStr.length();
            StringBuilder result = new StringBuilder();
            System.out.println("dateASYYYYMMDD(String stDate) 1");
            //"hamburger".substring(4, 8) returns "urge"
            //"smiles".substring(1, 5) returns "mile"
            //for (int idx = 0; idx < ldtStrln; idx++) {
            for (int idx = ldtStrln - 1; idx > 0; idx--) {  //taking character from back
                hdchar = ldtStr.substring(idx, (idx + 1));
                switch (hdchar) {
                    case "-": case ".": case "/":
                        break;
                    case "0": case "1": case "2": case "3":
                    case "4": case "5": case "6": case "7":
                    case "8": case "9":
                        result.append(hdchar);
                        break;
                    default:
                        System.out.println("Invalid char.");
                        break;
                }
            }                
            return result.toString();
        }
}
