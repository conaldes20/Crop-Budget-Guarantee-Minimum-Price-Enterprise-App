/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.listener;

import crop.gmp.intface.CropBDGTRemoteBusiness;
import crop.gmp.intface.UserRemoteBusiness;
import crop.gmp.intface.UserTrailRemoteBusiness;
import crop.gmp.util.CLoggedInfos;
import crop.gmp.util.CUNRDaytime;
import crop.gmp.util.CUPDetails;
import crop.gmp.util.LOGGEDUserid;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author user
 */
public class CBDGTServletListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {

    private ServletContext context = null;
        
    private Context namingContext;
    private CropBDGTRemoteBusiness JNDI_NAME_CBDGT; 
    private final String JNDI_NAME_CBDGTGMP_REMOTE_BUSINESS = "java:global/GMP_CROPBUDGET/GMP_CROPBUDGET-ejb/CropBDGTBeanRemote!crop.gmp.intface.CropBDGTRemoteBusiness";
    private UserRemoteBusiness JNDI_NAME_USER; 
    private final String JNDI_NAME_USER_REMOTE_BUSINESS = "java:global/GMP_CROPBUDGET/GMP_CROPBUDGET-ejb/UserBeanRemote!crop.gmp.intface.UserRemoteBusiness";
    private UserTrailRemoteBusiness JNDI_NAME_USERTRAIL;
    private final String JNDI_NAME_USERTRAIL_REMOTE_BUSINESS = "java:global/GMP_CROPBUDGET/GMP_CROPBUDGET-ejb/UserTrailBeanRemote!crop.gmp.intface.UserTrailRemoteBusiness";
    
    //ServletContext ctx=null;
    static int total=0,current=0;
            
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*
        context = sce.getServletContext();
        try { 
            namingContext = new InitialContext();
            JNDI_NAME_USER = (UserRemoteBusiness)namingContext.lookup(JNDI_NAME_USER_REMOTE_BUSINESS);
            JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)namingContext.lookup(JNDI_NAME_USERTRAIL_REMOTE_BUSINESS);
            JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)namingContext.lookup(JNDI_NAME_CBDGTGMP_REMOTE_BUSINESS);         
        } catch (NamingException ne) {
            System.out.println(ne.getMessage());
        }finally {

        }
        context.setAttribute("JNDI_NAME_CBDGT", JNDI_NAME_CBDGT);
        context.setAttribute("JNDI_NAME_USER", JNDI_NAME_USER);
        context.setAttribute("JNDI_NAME_USERTRAIL", JNDI_NAME_USERTRAIL);
        //context.setAttribute("userServices", userServices);       
        */
        System.out.println("Context attributes initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //context = sce.getServletContext(); 
        //context.removeAttribute("JNDI_NAME_CBDGT");
        System.out.println("Context attributes destroyed");
    }
    
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Context attributes added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Context attributes removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Context attributes replaced");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        total++;
	current++;
	//context.setAttribute("totalusers", total);
	//context.setAttribute("currentusers", current);
        
	HttpSession sess = se.getSession();
        String sessId = se.getSession().getId();
        sess.setAttribute("sessId", sessId);
        System.out.println("HttpSessionEvent sessionCreated");
        CUNRDaytime cunrDaytime = new CUNRDaytime();
        cunrDaytime.setUNRDaytime(" ");
        sess.setAttribute("cunrDaytime", cunrDaytime);
        CUPDetails cupdetails = new CUPDetails();
        cupdetails.setUsername(" ");
        cupdetails.setPasswd(" ");
        cupdetails.setRole(" ");
        sess.setAttribute("cupdetails", cupdetails);                                                    
        String loggeduserid = " ";
        String loggedtrail = " ";
        LOGGEDUserid loggedUserid = new LOGGEDUserid();
        loggedUserid.setLoogeduserid(loggeduserid);
        sess.setAttribute("loggedUserid", loggedUserid);
        CLoggedInfos cloggedInfos = new CLoggedInfos();
        cloggedInfos.setLoggeddetails("");
        sess.setAttribute("cloggedInfos", cloggedInfos);
        sess.setAttribute("loggedtrail", loggedtrail);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        current--;
	//context.setAttribute("currentusers",current);
    }
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBinding attributeAdded");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBinding attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        //event.getSession()
        System.out.println("HttpSessionBinding attributeReplaced");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequest requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequest requestInitialized");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequestAttribute attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequestAttribute attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequestAttribute attributeReplaced");
    }
}
