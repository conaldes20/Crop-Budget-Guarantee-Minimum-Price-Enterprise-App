/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.ejb;

import crop.gmp.intface.UserRemoteBusiness;
import crop.gmp.model.Cbuser;
import crop.gmp.util.UsernameRole;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class UserBeanRemote implements UserRemoteBusiness{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final Logger log = Logger.getLogger(CropBDGTBeanRemote.class.getName());	
        private String userRole = "REPORT";
        private boolean userAuthenticated = false;
        //private boolean recordSaved = false;
        private String msg = " ";
        
        @PersistenceContext(unitName="GMP_CROPBUDGET-ejbPU", type=PersistenceContextType.TRANSACTION)
        private EntityManager entityManager;
		
        @Override
	public String addUserParameeters(final String usern, final String pswd, final String role)
	{             
            saveUserParameeters(usern, pswd, role);            
            return msg;
	}
        
        @Override
        public String logon(final String username, final String passwd)
	{   
            String SQL;
            try{
                Query query;  // = entityManager.createNamedQuery("Cbuser.findByUsernamePasswd");
                //System.out.println("(public void logon) username, password: " + username + ", " + password);
                // Set parameter            
                //query.setParameter("username", username).setParameter("passwd", password);
                System.out.println("(public void logon 11) username, password: " + username + ", " + passwd);
                
                SQL = "SELECT * FROM Cbuser WHERE username like '" + username.trim()+ "%' AND passwd like '" + passwd.trim() + "%'";
                System.out.println("(public void logon 22) username, password: " + username + ", " + passwd);
                query = entityManager.createNativeQuery(SQL);
                // Query and get result
                //Object obj = query.getSingleResult();  //If a column is returned.
                //List<Object> objs = query.getResultList();
                List<Object[]> valueArray = query.getResultList();
               
                Cbuser cbuser = null; 
                //Further usage
                for ( Object[] values : valueArray ) {
                    final Long userid = (Long) values[0];
                    System.out.println("(Long) values[0]: " + (Long) values[0]);
                    final String usrname = (String) values[1];
                    System.out.println("(String) values[1]: " + (String) values[1]);
                    final String usrpwd = (String) values[2];
                    System.out.println("(String) values[2]: " + (String) values[2]);
                    final String role = (String) values[3];
                    System.out.println("(String) values[3]: " + (String) values[3]);
                    cbuser = new Cbuser(userid, usrname, usrpwd, role);
                    System.out.println("(Before testing cbuser for null");
                    System.out.println("(cbuser == null): " + (cbuser == null));
                    System.out.println("cbuser.getUsername(), cbuser.getRole(): " + cbuser.getUsername() + ", " + cbuser.getRole());
                }
                /*
                Object[] objs = query.getResultList().toArray();
                System.out.println("objs.length: " + objs.length);
                System.out.println("(String)objs[1]: " + objs[0].toString());
                System.out.println("(String)objs[2]: " + objs[2].toString());
                System.out.println("(String)objs[3]: " + objs[3].toString());
                */                
                userRole = cbuser.getRole();
                userAuthenticated = true;
                msg = "User successfully authenticated.";  
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(Username and (or) password not entered.");
                System.out.println("ERROR MESSAGE: " + nniex.getMessage());
                userRole = "REPORT";
                userAuthenticated = false;
                msg = "User not successfully authenticated.";
            }
            return msg;
	} 
        
        @Override
        public List<UsernameRole> usernameRoleList()
	{    
            List<UsernameRole> usernamesRoles = new ArrayList();
            System.out.println("usernameRoleList() => 0");
            try{
                Query query;  
                String SQL = "SELECT * FROM cbuser";
                query = entityManager.createNativeQuery(SQL);
                // Query and get result
                System.out.println("usernameRoleList() => 1");
                List<Object[]> valueArray = query.getResultList();
                //Cbuser cbuser = null; 
                //Further usage
                UsernameRole usernameRole;
                for ( Object[] values : valueArray ) {
                    usernameRole = new UsernameRole();
                    //final Long userid = (Long) values[0];
                    //System.out.println("(Long) values[0]: " + (Long) values[0]);
                    usernameRole.setUsername((String)values[1]);
                    System.out.println("(String) values[1]: " + (String) values[1]);
                    usernameRole.setRole((String) values[3]);
                    System.out.println("(String) values[3]: " + (String) values[3]);
                    usernamesRoles.add(usernameRole);
                }
                System.out.println("(usernamesRoles.size())): " + Integer.toString(usernamesRoles.size()));  //info(Integer.toString(usernamesRoles.size()));
                System.out.println("(usernamesRoles.isEmpty()): " + Boolean.toString(usernamesRoles.isEmpty()));
                System.out.println("usernameRoleList() => 2");
                if(usernamesRoles.isEmpty()){
                    //System.out.println("(usernamesRoles == null) " + (usernamesRoles == null));
                    usernameRole = new UsernameRole("NA", "NA");
                    System.out.println("usernameRole.getUsername(), usernameRole.getRole(): " + usernameRole.getUsername() + ", " + usernameRole.getRole());                
                    usernamesRoles.add(usernameRole);
                    //System.out.println("(usernamesRoles == null) " + (usernamesRoles == null));
                }
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(cbuser == null). No entity returned.");
                if(usernamesRoles == null)
                    usernamesRoles = Collections.EMPTY_LIST;
            }
            log.info("usernameRoleList() => 3");
            System.out.println("usernameRoleList() => 3");
            return usernamesRoles;
	}
        
        @Override
        public Long getUserId(final String username, final String password)
	{   
            Cbuser cbuser = null;
            String SQL;
            try{
                Query query;  // = entityManager.createNamedQuery("Cbuser.findByUsernamePasswd");
                //System.out.println("(public void logon) username, password: " + username + ", " + password);
                // Set parameter            
                //query.setParameter("username", username).setParameter("passwd", password);
                System.out.println("(public void logon 11) username, password: " + username + ", " + password);
                
                SQL = "SELECT * FROM Cbuser WHERE username like '" + username.trim()+ "%' AND passwd like '" + password.trim() + "%'";
                System.out.println("(public void logon 22) username, password: " + username + ", " + password);
                query = entityManager.createNativeQuery(SQL);    
                // Query and get result
                //Object obj = query.getSingleResult();  //If a column is returned.
                //List<Object> objs = query.getResultList();
                List<Object[]> valueArray = query.getResultList();
                //Further usage
                for ( Object[] values : valueArray ) {
                    final Long userid = (Long) values[0];
                    System.out.println("(Long) values[0]: " + (Long) values[0]);
                    final String usrname = (String) values[1];
                    System.out.println("(String) values[1]: " + (String) values[1]);
                    final String usrpwd = (String) values[2];
                    System.out.println("(String) values[2]: " + (String) values[2]);
                    final String usrrole = (String) values[3];
                    System.out.println("(String) values[3]: " + (String) values[3]);
                    cbuser = new Cbuser(userid, usrname, usrpwd, usrrole);
                    System.out.println("(Before testing cbuser for null");
                    System.out.println("(cbuser == null): " + (cbuser == null));
                    System.out.println("cbuser.getUsername(), cbuser.getRole(): " + cbuser.getUsername() + ", " + cbuser.getRole());
                }
                
                System.out.println("cbuser.getUsername(), cbuser.getRole(): " + cbuser.getUsername() + ", " + cbuser.getRole());
                msg = "Action performed successfully.";                
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(Username and (or) password not entered.");
                msg = "Username and (or) password not entered.";
                return new Long(0);
            }
            return cbuser.getUserId();
	} 
        
        private void saveUserParameeters(final String username, final String password, final String role)
	{   
            long userId = uniqueID();
            //String sql = "insert into Cbuser (userId,username,passwd) values (?,?,?,?)";
            //Query query;
            boolean inserted;
            try{
                final Cbuser cbuser = new Cbuser(Long.valueOf(userId), username.trim(), password.trim(), role.trim().toUpperCase());
                System.out.println("cbuser.getUserId(): " + cbuser.getUserId());
                System.out.println("cbuser.getUsername(): " + cbuser.getUsername());
                System.out.println("cbuser.getPasswd(): " + cbuser.getPasswd());
                System.out.println("cbuser.getRole(): " + cbuser.getRole());
                entityManager.persist(cbuser);
                inserted = true;   
                msg = "User successfully created.\n";
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
            //}catch(Exception ex){
                System.out.println("Cbuser not created." + nniex.getMessage());
                msg = "User not successfully created." + nniex.getMessage();
            }
	}
                        
        @Override
        public String getRole() {
            return userRole;
        }
        
        @Override
        public boolean authenticationStatus() {
            return userAuthenticated;
        }        
        
        @Override
        public String getMSG() {
            if(msg == null) 
                msg = "No service.\n";
            return msg;
        }
        
        private long uniqueID(){
            //LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Africa/Lagos"));
            String ldtStr;  // = localDateTime.toString();
            int ldtStrln;  // =  ldtStr.length();
            Instant timestamp = Instant.now();
            ldtStr = (timestamp.toString()).trim();
            ldtStrln =  ldtStr.length();
            ldtStr = ldtStr.substring(0, ldtStrln - 1); //This statement removes the last Z character.
            ldtStrln = ldtStrln - 1;   //This takes care of the last Z character removed.
            StringBuilder result = new StringBuilder();
            String hdchar, hdstr;
            long lgstr, uidVal = 0L;
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
            try{
                System.out.println("Inside hexEncode() 2");
                hdstr = result.toString();
                lgstr = Long.parseLong(hdstr);
                System.out.println("Inside hexEncode() 3");                 
                uidVal = lgstr/2L + 11101001011001011L;
                System.out.println(uidVal);            
                System.out.println("Inside hexEncode() 4");
            }catch (NumberFormatException ex) {
                System.err.println(ex);
            }        
            return uidVal;
        }
        
        
}
