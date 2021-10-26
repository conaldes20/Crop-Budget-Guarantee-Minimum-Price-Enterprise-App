/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.servlet;

import crop.gmp.cacheUtil.CachedListObject;
import crop.gmp.intface.CropBDGTRemoteBusiness;
import crop.gmp.intface.UserRemoteBusiness;
import crop.gmp.intface.UserTrailRemoteBusiness;
import crop.gmp.model.Cbquantity;
import crop.gmp.services.AuditTrailServices;
import crop.gmp.services.CROPBDGTServices;
import crop.gmp.services.Roles;
import crop.gmp.locator.ServiceLocator;
import crop.gmp.services.UsersServices;
import crop.gmp.util.CBDGTAmounts;
import crop.gmp.util.CBDGTParams;
import crop.gmp.util.CBDGTQties;
import crop.gmp.util.CLYPIDnums;
import crop.gmp.util.CLYPTVars;
import crop.gmp.util.CLocationsInfos;
import crop.gmp.util.CLoggedInfos;
import crop.gmp.util.CLoggedSummaries;
import crop.gmp.util.CRPLOCYRLists;
import crop.gmp.util.CServices;
import crop.gmp.util.CUNRDaytime;
import crop.gmp.util.CUPDetails;
import crop.gmp.util.CUserId;
import crop.gmp.util.CropbudgetVars;
import crop.gmp.util.Functions;
import crop.gmp.util.LOGGEDUserid;
import crop.gmp.util.UsernameRole;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.servlet.RequestDispatcher;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/cropbdgtgmp"})
public class ControllerServlet extends HttpServlet {

       /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //final ReentrantReadWriteLock rrindecntrl = new ReentrantReadWriteLock();
    //volatile boolean indexdataValid = false;
    //final Lock lindecntrl = new ReentrantLock();
    //final Lock lrptVarContl = new ReentrantLock();
    //final Lock lviewTAContl = new ReentrantLock();
    //final Lock lviewTBContl = new ReentrantLock();
    //final Lock lupdateRContl = new ReentrantLock();
    //final Lock lupdateQContl = new ReentrantLock();
    //final Lock llogincntrl = new ReentrantLock();
    //final Lock laddusrparams = new ReentrantLock();
    //final Lock laddcpbdgtrate = new ReentrantLock();
    //final Lock laddcpbdgtqty = new ReentrantLock();
    //final Lock lupdaterate = new ReentrantLock();
    //final Lock lupdatecpbdgtqty = new ReentrantLock();
    //final Lock lloggedcntrl = new ReentrantLock();
    //final Lock lusrncntrl = new ReentrantLock();
    
    //private CropBDGTRemoteBusiness JNDI_NAME_CBDGT;
    //private UserRemoteBusiness JNDI_NAME_USER;
    //private UserTrailRemoteBusiness JNDI_NAME_USERTRAIL;
    
    //private final UsersServices userServices = new UsersServices();
    //private final CROPBDGTServices cbdgtServices = new CROPBDGTServices();
    //private final AuditTrailServices audtrailServices = new AuditTrailServices();
    
    //private final static ServiceLocator serviceLocator = new ServiceLocator();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        //ServletContext context = request.getServletContext();
                        
        //JNDI_NAME_USER = (UserRemoteBusiness)context.getAttribute("JNDI_NAME_USER");
        //JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)context.getAttribute("JNDI_NAME_USERTRAIL");
        //JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)context.getAttribute("JNDI_NAME_CBDGT");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //ServletContext context = request.getServletContext();
        Context context = null;
        try { 
            context = new InitialContext();       
        } catch (NamingException ne) {
            System.out.println(ne.getMessage());
        }finally {

        }
        RequestDispatcher rd;
        String userPath = request.getServletPath();
        System.out.println("userPath: " + userPath);
        List<String> ctrlNames = new ArrayList<>();
        //List<String> ctrlNamesCopy = new ArrayList<>();
        Map<String, String> ctrlNamesVals = new HashMap<>();
        //List<String> ctrlValues = new ArrayList<>();
        //CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject("CBDGTGMP_REMOTE");
        //final UsersServices userServices = new UsersServices();
        final CROPBDGTServices cbdgtServices = new CROPBDGTServices();
        //final AuditTrailServices audtrailServices = new AuditTrailServices();
        final Lock lindecntrl = new ReentrantLock();
        final Lock lrptVarContl = new ReentrantLock();
        final Lock lviewTAContl = new ReentrantLock();
        final Lock lviewTBContl = new ReentrantLock();
        final Lock lupdateRContl = new ReentrantLock();
        final Lock lupdateQContl = new ReentrantLock();
    
        HttpSession sess = request.getSession();
        
        //sess.setAttribute("JNDI_NAME_CBDGT", JNDI_NAME_CBDGT);
        Enumeration nameCode = request.getParameterNames();        
        while(nameCode.hasMoreElements()){
            String ctrlStr = (String)nameCode.nextElement();
            String valStr = request.getParameter(ctrlStr);
            ctrlNames.add(ctrlStr);
            ctrlNamesVals.put(ctrlStr, valStr);
            //ctrlValues.add(valStr);
            System.out.println("doPost: request.getParameter(paramStr) => " + request.getParameter(ctrlStr));
        }        
        String locdetails = " ", respmsg = " ";
        String reqservice;  // = "";
        List<String> errors; 
        //CustomerBean custBean = new CustomerBean();
        //String[] acctnos = null;
        //String[] acctbals = null; 
        CBDGTParams cbdgtparams;  // = new CBDGTParams();
        CBDGTQties cbdgtqties = new CBDGTQties();
        Cbquantity cbquantity;  // = new Cbquantity();
        
        //String reqservice = "";
        for(String ctrlName: ctrlNames){
            switch(ctrlName){
                case "indecntrl":                   
                    if(lindecntrl.tryLock()){
                        try {
                            reqservice = request.getParameter("reqservice");         
                            System.out.println("reqservice => " + reqservice);
                            errors = (List) request.getAttribute("errors");
                            if(errors == null)
                                errors = Collections.EMPTY_LIST;
                            if (!isBlank(reqservice) && ((reqservice.trim().equals("UserAccessControl")) 
                                || (reqservice.trim().equals("RatesEntry")) || reqservice.trim().equals("QtiesEntry"))
                                || (reqservice.trim().equals("AuditTrail"))){
                                if((reqservice.trim().equals("RatesUpdate")) || (reqservice.trim().equals("QtiesUpdate"))){
                                    locdetails = request.getParameter("locdetails");
                                }
                                if ((reqservice.trim().equals("RatesEntry"))){
                                    CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                    List<String> crops = cbdgtServices.crops(JNDI_NAME_CBDGT);
                                    List<String> locations = cbdgtServices.locations(JNDI_NAME_CBDGT);
                                    List<String> years = cbdgtServices.years(JNDI_NAME_CBDGT);
                                    List<String> farmingtypes = cbdgtServices.farmingtypes(JNDI_NAME_CBDGT);
                                    CRPLOCYRLists crplocyrLists = new CRPLOCYRLists();
                                    crplocyrLists.setCrops(crops);
                                    crplocyrLists.setLocations(locations);
                                    crplocyrLists.setYears(years);
                                    crplocyrLists.setFarmingtypes(farmingtypes);
                                    System.out.println("crplocyrLists.equals(null)" + crplocyrLists.equals(null)); 
                                    sess.setAttribute("crplocyrLists", crplocyrLists);
                                }
                                System.out.println("(doGet) reqservice => " + reqservice);
                                //System.out.println("ssn error!");
                                request.setAttribute("reqservice", reqservice);                                
                                request.setAttribute("locdetails", locdetails);
                                request.setAttribute("respmsg", respmsg);
                                request.setAttribute("errors", errors);
                                rd = request.getRequestDispatcher("/login.jsp");
                                rd.forward(request, response);
                            }else if(!isBlank(reqservice) && (reqservice.trim().equals("ViewReport"))){
                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                List<String> crops = cbdgtServices.crops(JNDI_NAME_CBDGT);
                                List<String> locations = cbdgtServices.locations(JNDI_NAME_CBDGT);
                                List<String> years = cbdgtServices.years(JNDI_NAME_CBDGT);
                                //sess.setAttribute("crops", crops);
                                //sess.setAttribute("locations", locations);
                                //sess.setAttribute("years", years);
                                request.setAttribute("crops", crops);
                                request.setAttribute("locations", locations);
                                request.setAttribute("years", years);
                                request.setAttribute("reqservice", reqservice);
                                request.setAttribute("errors", errors);
                                rd = request.getRequestDispatcher("/reportVars.jsp");
                                rd.forward(request, response);
                            }
                        } finally {
                              lindecntrl.unlock();
                        }
                      } else {
                        //List<String> servicesA = new ArrayList();
                        //ServletContext context = request.getServletContext();
                        CServices cservices = (CServices)sess.getAttribute("cservices");
                        List<String> servicesA = cservices.getServies();
                        request.setAttribute("servicesA", servicesA);
                        rd = request.getRequestDispatcher("/serviceslist.jsp");
                        rd.forward(request, response);
                      }
                    break;
                case "rptVarContl":
                    String crop, state, startyr, endyr;
                    if(lrptVarContl.tryLock()){
                        try {
                            crop = request.getParameter("CROP");
                            state = request.getParameter("LOCATION");
                            startyr = request.getParameter("STARTYEAR");
                            endyr = request.getParameter("ENDYEAR");
                            errors = new ArrayList();
                            List<String> locationsInfos;  // = new ArrayList();
                            if (isBlank(crop)) {
                                errors.add("You must select crop.");
                            }
                            if (isBlank(state)) {
                                errors.add("You must select location.");
                            }
                            if (isBlank(startyr)) {
                                errors.add("You must select year1.");
                            }
                            if (isBlank(endyr)) {
                                errors.add("You must select year2.");
                            }
                            System.out.println("crop, state, year1, year2: " + crop + ", " + state  + ", " + startyr + ", " + endyr);
                            // Was the sent data was correct?
                            if (errors.isEmpty()) {
                            //if(!isBlank(crop) && !isBlank(state) && !isBlank(startyr) && !isBlank(endyr)){ 
                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                locationsInfos = cbdgtServices.reportsLinks(JNDI_NAME_CBDGT, crop, state, startyr, endyr);
                                if(locationsInfos.isEmpty())
                                   locationsInfos = Collections.EMPTY_LIST;
                                CLocationsInfos clocationsInfos = new CLocationsInfos();
                                clocationsInfos.setLocationsInfos(locationsInfos);
                                sess.setAttribute("clocationsInfos", clocationsInfos);
                                request.setAttribute("locationsInfos", locationsInfos);
                                rd = request.getRequestDispatcher("/reportList.jsp");
                                rd.forward(request, response);
                            }else{
                                List<String> crops, locations, years, farmingtypes;
                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                crops = cbdgtServices.crops(JNDI_NAME_CBDGT);
                                locations = cbdgtServices.locations(JNDI_NAME_CBDGT);
                                years = cbdgtServices.years(JNDI_NAME_CBDGT);
                                farmingtypes = cbdgtServices.farmingtypes(JNDI_NAME_CBDGT);
                                CRPLOCYRLists crplocyrLists = new CRPLOCYRLists();
                                crplocyrLists.setCrops(crops);
                                crplocyrLists.setLocations(locations);
                                crplocyrLists.setYears(years);
                                crplocyrLists.setFarmingtypes(farmingtypes);
                                System.out.println("crplocyrLists.equals(null)" + crplocyrLists.equals(null)); 
                                sess.setAttribute("crplocyrLists", crplocyrLists);
                                request.setAttribute("crops", crops);
                                request.setAttribute("locations", locations);
                                request.setAttribute("years", years);
                                request.setAttribute("errors", errors);
                                rd = request.getRequestDispatcher("/reportVars.jsp");
                                rd.include(request, response);
                            } 
                        } finally {
                            lrptVarContl.unlock();
                        }
                    } else {
                        //List<String> servicesA = new ArrayList();
                        //ServletContext context = request.getServletContext();
                        CServices cservices = (CServices)sess.getAttribute("cservices");
                        List<String> servicesA = cservices.getServies();
                        request.setAttribute("servicesA", servicesA);
                        rd = request.getRequestDispatcher("/serviceslist.jsp");
                        rd.forward(request, response);
                    }
                    break; 
                case "viewTAContl":
                    String yield, mktp, locationInfos, rptType;
                    if(lviewTAContl.tryLock()){
                        try {
                            yield = request.getParameter("yield");
                            mktp = request.getParameter("mktp");

                            if(isBlank(yield) || (yield.trim()).equals("0"))
                                yield = "2.00";
                            else{
                                try{
                                    Double hdyld = Double.parseDouble(yield);
                                }catch (NumberFormatException nfex){
                                    yield = "2.00";
                                }
                            }

                            if(isBlank(mktp) || (mktp.trim()).equals("0"))
                                mktp = "70000.00";
                            else{
                                try{
                                    Double hdmkt = Double.parseDouble(mktp);
                                }catch (NumberFormatException nfex){
                                    mktp = "70000.00";
                                }
                            }

                            locationInfos = request.getParameter("locdetails");
                            rptType = "A";
                            CLYPIDnums clypidnums = getPKS(locationInfos); 
                            CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                            CBDGTAmounts cbdgtamunts = cbdgtServices.retreiveVarsAmounts(JNDI_NAME_CBDGT, clypidnums, yield, mktp, rptType);  //, "REPORT");
                            //CLYPTVars clyptvars = getCLPTNames(locationInfos);
                            System.out.println("clypidnums values: " + clypidnums.getCropId() + ", " + clypidnums.getLocationId() + ", " + clypidnums.getYearId() + ", " + clypidnums.getPltypeId());
                            cbdgtparams = cbdgtServices.retreiveVarsRates(JNDI_NAME_CBDGT, clypidnums);  //, "REPORT");
                            cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //, 1);

                            cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                            cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                            cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                            cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                            cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                            cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                            cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                            cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                            cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                            cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                            cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                            cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                            cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                            cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                            cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                            cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                            cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                            cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                            cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                            errors = (List) request.getAttribute("errors");
                            if(errors == null)
                                errors = Collections.EMPTY_LIST;
                            //System.out.println("Display form and list => flag: " + flag);
                            request.setAttribute("cbdgtqties", cbdgtqties);
                            request.setAttribute("cbdgtparams", cbdgtparams);
                            request.setAttribute("cbdgtamunts", cbdgtamunts);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/cropBDGTRPT.jsp");
                            rd.forward(request, response);
                        } finally {
                            lviewTAContl.unlock();
                        }
                    } else {
                        //List<String> servicesA = new ArrayList();                        
                        //ServletContext context = request.getServletContext();
                        CLocationsInfos clocationsInfos = (CLocationsInfos)sess.getAttribute("clocationsInfos");
                        List<String> locationsInfos = clocationsInfos.getLocationsInfos();
                        request.setAttribute("locationsInfos", locationsInfos);
                        rd = request.getRequestDispatcher("/reportList.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "viewTBContl":
                    if(lviewTBContl.tryLock()){
                        try {
                            yield = request.getParameter("yield");
                            mktp = request.getParameter("mktp");
                            if(isBlank(yield) || (yield.trim()).equals("0"))
                                yield = "2.00";
                            else{
                                try{
                                    Double hdyld = Double.parseDouble(yield);
                                }catch (NumberFormatException nfex){
                                    yield = "2.00";
                                }
                            }

                            if(isBlank(mktp) || (mktp.trim()).equals("0"))
                                mktp = "70000.00";
                            else{
                                try{
                                    Double hdmkt = Double.parseDouble(mktp);
                                }catch (NumberFormatException nfex){
                                    mktp = "70000.00";
                                }
                            }
                            locationInfos = request.getParameter("locdetails");
                            CLYPIDnums clypidnums = getPKS(locationInfos);
                            rptType = "B";
                            CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                            CBDGTAmounts cbdgtamunts = cbdgtServices.retreiveVarsAmounts(JNDI_NAME_CBDGT, clypidnums, yield, mktp, rptType);  //, "REPORT");
                            //CLYPTVars clyptvars = getCLPTNames(locationInfos);
                            System.out.println("clypidnums values: " + clypidnums.getCropId() + ", " + clypidnums.getLocationId() + ", " + clypidnums.getYearId() + ", " + clypidnums.getPltypeId());
                            cbdgtparams = cbdgtServices.retreiveVarsRates(JNDI_NAME_CBDGT, clypidnums);  //, "REPORT");
                            cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //, 1);
                            cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                            cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                            cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                            cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                            cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                            cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                            cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                            cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                            cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                            cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                            cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                            cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                            cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                            cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                            cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                            cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                            cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                            cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                            cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                            errors = (List) request.getAttribute("errors");
                            if(errors == null)
                                errors = Collections.EMPTY_LIST;
                            //System.out.println("Display form and list => flag: " + flag);
                            request.setAttribute("cbdgtqties", cbdgtqties);
                            request.setAttribute("cbdgtparams", cbdgtparams);
                            request.setAttribute("cbdgtamunts", cbdgtamunts);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/cropBDGTRPTB.jsp");
                            rd.forward(request, response);
                        } finally {
                            lviewTBContl.unlock();
                        }
                    } else {
                        //List<String> servicesA = new ArrayList();                        
                        //ServletContext context = request.getServletContext();
                        CLocationsInfos clocationsInfos = (CLocationsInfos)sess.getAttribute("clocationsInfos");
                        List<String> locationsInfos = clocationsInfos.getLocationsInfos();
                        request.setAttribute("locationsInfos", locationsInfos);
                        rd = request.getRequestDispatcher("/reportList.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "updateRContl":
                    if(lupdateRContl.tryLock()){
                        try {
                            locationInfos = request.getParameter("locdetails");
                            //clypidnums = getPKS(locationInfos);
                            reqservice = "RatesUpdate"; 
                            errors = (List) request.getAttribute("errors");
                            if(errors == null)
                                errors = Collections.EMPTY_LIST;
                            //System.out.println("Display form and list => flag: " + flag);
                            request.setAttribute("rspmsg", respmsg);
                            request.setAttribute("locdetails", locationInfos);
                            request.setAttribute("reqservice", reqservice);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);
                        } finally {
                            lupdateRContl.unlock();
                        }
                    } else {
                        //List<String> servicesA = new ArrayList();                        
                        //ServletContext context = request.getServletContext();
                        CLocationsInfos clocationsInfos = (CLocationsInfos)sess.getAttribute("clocationsInfos");
                        List<String> locationsInfos = clocationsInfos.getLocationsInfos();
                        request.setAttribute("locationsInfos", locationsInfos);
                        rd = request.getRequestDispatcher("/reportList.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "updateQContl":
                    if(lupdateQContl.tryLock()){
                        try {
                            locationInfos = request.getParameter("locdetails");
                            //clypidnums = getPKS(locationInfos);
                            reqservice = "QtiesUpdate";  
                            errors = (List) request.getAttribute("errors");
                            if(errors == null)
                                errors = Collections.EMPTY_LIST;
                            request.setAttribute("rspmsg", respmsg);
                            request.setAttribute("locdetails", locationInfos);
                            request.setAttribute("reqservice", reqservice);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);
                        } finally {
                            lupdateQContl.unlock();
                        }
                    } else {
                        //List<String> servicesA = new ArrayList();                        
                        //ServletContext context = request.getServletContext();
                        CLocationsInfos clocationsInfos = (CLocationsInfos)sess.getAttribute("clocationsInfos");
                        List<String> locationsInfos = clocationsInfos.getLocationsInfos();
                        request.setAttribute("locationsInfos", locationsInfos);
                        rd = request.getRequestDispatcher("/reportList.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "logout":
                    rd = request.getRequestDispatcher("/redbank.jsp");
                    rd.forward(request, response);  
                    break;
                default:                   
                    
                    break;
            }    
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //ServletContext context = request.getServletContext();
        Context context = null;
        try { 
            context = new InitialContext();       
        } catch (NamingException ne) {
            System.out.println(ne.getMessage());
        }finally {

        }
        //UsersServices userServices = new UsersServices();
        List<UsernameRole> usernamesRoles = new ArrayList();
        //ServletContext context = request.getServletContext();
                
        //CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject("CBDGTGMP_REMOTE");
        //UserRemoteBusiness JNDI_NAME_USER = (UserRemoteBusiness)ServiceLocator.getRemoteObject("USER_REMOTE");
        //UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject("USERTRAIL_REMOTE");
        
        RequestDispatcher rd;
        List<String> ctrlNames = new ArrayList<>();
        //List<String> ctrlNamesCopy = new ArrayList<>();
        Map<String, String> ctrlNamesVals = new HashMap<>();
        //List<String> ctrlValues = new ArrayList<>();
        //HttpSession sess = request.getSession(true);
        
        final UsersServices userServices = new UsersServices();
        final CROPBDGTServices cbdgtServices = new CROPBDGTServices();
        final AuditTrailServices audtrailServices = new AuditTrailServices();        
        
        final Lock llogincntrl = new ReentrantLock();
        final Lock laddusrparams = new ReentrantLock();
        final Lock laddcpbdgtrate = new ReentrantLock();
        final Lock laddcpbdgtqty = new ReentrantLock();
        final Lock lupdaterate = new ReentrantLock();
        final Lock lupdatecpbdgtqty = new ReentrantLock();
        final Lock lloggedcntrl = new ReentrantLock();
        final Lock lusrncntrl = new ReentrantLock();
        
        HttpSession sess = request.getSession();
        String loggedtrail = (String)sess.getAttribute("loggedtrail");
        //sess.setAttribute("JNDI_NAME_CBDGT", JNDI_NAME_CBDGT);
        Enumeration nameCode = request.getParameterNames();        
        while(nameCode.hasMoreElements()){
            String ctrlStr = (String)nameCode.nextElement();
            String valStr = request.getParameter(ctrlStr);
            ctrlNames.add(ctrlStr);
            ctrlNamesVals.put(ctrlStr, valStr);
            //ctrlValues.add(valStr);
            System.out.println("doPost: request.getParameter(paramStr) => " + request.getParameter(ctrlStr));
        } 
        String locdetails = "", respmsg = "";
        Cbquantity cbquantity;
        CBDGTParams cbdgtparams = new CBDGTParams();
        CBDGTQties cbdgtqties = new CBDGTQties();
        CropbudgetVars cropbdgtvars = new CropbudgetVars();
        CLYPTVars clyptvars = new CLYPTVars();
        CLoggedInfos cloggedInfos = new CLoggedInfos();
        //List<UsernameRole> usernamesRoles = new ArrayList();
        List<String> crops;  // = new ArrayList();
        List<String> locations; // = new ArrayList();
        List<String> years;  // = new ArrayList();
        List<String> farmingtypes;  // = new ArrayList();
        String crop, location, year, plttype, rate1, rate2, rate3,
               rate4, rate5, rate6, rate7, rate8, rate9, rate10, rate11,
               rate12, rate13, rate14, rate15, rate16, rate17, rate18,
               rate19, qty1, qty2, qty3, qty4, qty5, qty6, qty7, qty8, qty9, 
               qty10, qty11, qty12, qty13, qty14, qty15, qty16, qty17, 
               qty18, qty19;
        String msg = " ";        
        for(String ctrlName: ctrlNames){
            //String hdObj;  // = null;
            System.out.println("ctrlName: " + ctrlName);
            switch(ctrlName){
                case "logincntrl":
                    String userRole = " ", reqservice = " ", userlogin = " ", psswdlogin = " ";  // = " ";
                    String loginParams = " ";   //, reqservice = " ";
                    boolean isAuthenticated;  // = false;
                    
                    if(llogincntrl.tryLock()){
                        try {
                            reqservice = (String)request.getParameter("reqservice");
                            userlogin = (String)request.getParameter("userlogin");
                            psswdlogin = (String)request.getParameter("psswdlogin");
                            locdetails = (String)request.getParameter("locdetails");
                            request.setAttribute("reqservice", reqservice.trim());
                            //List errors = (List) request.getAttribute("errors");
                            //if(errors == null)                    
                            //    errors = Collections.EMPTY_LIST; 
                            List errors = new ArrayList();
                            if (isBlank(userlogin)) {
                                errors.add("You must enter your username.");
                            }
                            if (isBlank(psswdlogin)) {
                                errors.add("You must enter your password.");
                            }

                            if(errors.isEmpty()){
                            System.out.println("Point 000");
                            System.out.println("reqservice: " + reqservice);
                            if (!isBlank(reqservice)){
                                System.out.println("(!isBlank(reqservice)): " + (!isBlank(reqservice)));
                                if(((reqservice.trim().equals("UserAccessControl")) || (reqservice.trim().equals("RatesEntry")) 
                                    || reqservice.trim().equals("QtiesEntry")) || (reqservice.trim().equals("RatesUpdate")) 
                                    || (reqservice.trim().equals("QtiesUpdate")) || (reqservice.trim().equals("AuditTrail"))){
                                        String usrlogin, pwdlogin;
                                        CUPDetails cupdetails;  // = new CUPDetails();
                                        if(sess == null){
                                            usrlogin = "";
                                            pwdlogin = "";
                                        }else{
                                            cupdetails = (CUPDetails)sess.getAttribute("cupdetails");
                                            usrlogin = cupdetails.getUsername();
                                            pwdlogin = cupdetails.getPasswd();
                                        }
                                        

                                        System.out.println("Point 001");
                                        //CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject("CBDGTGMP_REMOTE");
                                        UserRemoteBusiness JNDI_NAME_USER = (UserRemoteBusiness)ServiceLocator.getRemoteObject(context, "USER_REMOTE");
                                        //UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject("USERTRAIL_REMOTE");
                                        System.out.println("userlogin, psswdlogin: " + userlogin + ", " +  psswdlogin);
                                        userServices.authenticateUser(JNDI_NAME_USER, userlogin.trim(), psswdlogin.trim());
                                        userRole = userServices.getUserRole(JNDI_NAME_USER);
                                        isAuthenticated = userServices.getAuthenticationStatus(JNDI_NAME_USER);
                                        
                                        sess.setAttribute("userRole", userRole);
                                        System.out.println("userlogin, psswdlogin: " + userlogin + ", " +  psswdlogin);
                                        System.out.println("Point 002");

                                        System.out.println("userRole, isAuthenticated: " + userRole + ", " +  isAuthenticated);
                                        if(isAuthenticated){
                                            respmsg = "User authenticated";
                                            System.out.println("(!usrlogin.equals(userlogin.trim()) && !pwdlogin.equals(psswdlogin.trim())): " + (!usrlogin.equals(userlogin.trim()) && !pwdlogin.equals(psswdlogin.trim())));
                                            if(!usrlogin.equals(userlogin.trim()) && !pwdlogin.equals(psswdlogin.trim())){
                                                String usrRole;  // = " ";
                                                System.out.println("(!isBlank(usrlogin) && !isBlank(pwdlogin)): " + (!isBlank(usrlogin) && !isBlank(pwdlogin)));
                                                if(!isBlank(usrlogin) && !isBlank(pwdlogin)){                                            

                                                    usrRole = (String)sess.getAttribute("userRole");
                                                    //BigDecimal userId = userServices.getUserIdentity(JNDI_NAME_CBDGT, usrlogin, pwdlogin);
                                                    //String loggedsummary = (String)sess.getAttribute("UNROLTAUTH");
                                                    loggedtrail = loggedtrail.trim() + "User Name/Role (" + usrlogin.trim() + "/" + usrRole.toUpperCase() + ") Conflict: " + getCurrentDateTime() + "#" ;
                                                    //userServices.logUserDetails(JNDI_NAME_CBDGT, userId, loggedsummary, loggedtrail); 
                                                    
                                                    //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                                    CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                                    String loggedsummary = cunrDaytime.getUNRDaytime();
                                                    //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                                    LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                                    String loggeduserid = loggedUserid.getLoogeduserid();
                                                    System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                                    CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                                    Long userId = cuserId.getCusrid();
                                                    //CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject("CBDGTGMP_REMOTE");
                                                    //UserRemoteBusiness JNDI_NAME_USER = (UserRemoteBusiness)ServiceLocator.getRemoteObject("USER_REMOTE");
                                                    UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                                    //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                                    audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                                    System.out.println("(loggedtrail != null)7 : " + (loggedtrail != null));
                                                    //sess.setAttribute("loggedtrail", "");
                                                    //sess.setAttribute("UNROLTAUTH", "");
                                                    //sess.setAttribute("userlogin", "");
                                                    //sess.setAttribute("psswdlogin", "");
                                                    //sess.setAttribute("userRole", "");
                                                }else if(isBlank(usrlogin) && isBlank(pwdlogin)){
                                                    //###########################################################
                                                    if (isBlank(loggedtrail)){
                                                    String ldtStr;  // = localDateTime.toString();
                                                    Instant timestamp = Instant.now();
                                                    ldtStr = (timestamp.toString()).trim();
                                                    //loggedtrail = "";
                                                    loggedtrail = (String)sess.getAttribute("loggedtrail");
                                                    loggedtrail = loggedtrail + userlogin + "/" + userRole.toUpperCase() + " Authenticated: " + ldtStr + "#" ;
                                                    //String UNROLTAUTH = loggedtrail;
                                                    //sess.setAttribute("UNROLTAUTH", UNROLTAUTH);
                                                    //System.out.println("loggedtrail.trim(): " + loggedtrail.trim());
                                                    String usrRoleDayTime = userlogin + "/" + userRole.toUpperCase() + "/" + ldtStr;
                                                    CUNRDaytime cunrDaytime = new CUNRDaytime();
                                                    cunrDaytime.setUNRDaytime(usrRoleDayTime);
                                                    sess.setAttribute("cunrDaytime", cunrDaytime);
                                                    cupdetails = new CUPDetails(userlogin,psswdlogin.trim(),userRole.trim());
                                                    sess.setAttribute("cupdetails", cupdetails);
                                                    //CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject("CBDGTGMP_REMOTE");
                                                    JNDI_NAME_USER = (UserRemoteBusiness)ServiceLocator.getRemoteObject(context, "USER_REMOTE");
                                                    UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                                    Long userID = userServices.getUserIdentity(JNDI_NAME_USER, userlogin.trim(), psswdlogin.trim());
                                                    String loggeduserid = audtrailServices.logUserDetails(JNDI_NAME_USERTRAIL, userID, usrRoleDayTime, loggedtrail);
                                                    System.out.println("loggeduserid from server: " + loggeduserid);
                                                    System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                                    CUserId cuserId = new CUserId();
                                                    cuserId.setCusrid(userID);
                                                    sess.setAttribute("cuserId", cuserId);
                                                    LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                                    loggedUserid.setLoogeduserid(loggeduserid);
                                                    sess.setAttribute("loggedUserid", loggedUserid);
                                                    }
                                                    //###########################################################
                                                }
                                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                                cloggedInfos.setLoggeddetails(loggedtrail);
                                                sess.setAttribute("cloggedInfos", cloggedInfos);
                                                sess.setAttribute("loggedtrail", loggedtrail);
                                            }

                                            System.out.println("Point 003");
                                            //String ldtStr;  // = localDateTime.toString();
                                            //Instant timestamp = Instant.now();
                                            //ldtStr = (timestamp.toString()).trim();
                                            //loggedtrail = loggedtrail + userlogin + "/" + userRole.toUpperCase() + " Authenticated: " + ldtStr + "#" ;
                                            //String UNROLTAUTH = userlogin + "/" + userRole.toUpperCase() + "/" + ldtStr;
                                            //sess.setAttribute("userlogin", userlogin);
                                            //sess.setAttribute("psswdlogin", psswdlogin.trim());
                                            //sess.setAttribute("userRole", userRole.trim());
                                            //sess.setAttribute("UNROLTAUTH", loggedtrail);
                                            //sess.setAttribute("loggedtrail", loggedtrail);
                                            switch (reqservice.trim()) {
                                                case "UserAccessControl":
                                                    System.out.println("switch (reqservice.trim()): " + reqservice.trim());
                                                    //sess.setAttribute("userlogin", userlogin);
                                                    //sess.setAttribute("userRole", userRole.toUpperCase());
                                                    if(!hasAddingUserRoles(userRole)){
                                                        msg = "YOU DO NOT HAVE THE ROLE TO PERFORM THIS TASK.";
                                                        errors.add(msg);
                                                        request.setAttribute("respmsg", respmsg);
                                                        request.setAttribute("errors", errors);
                                                        rd = request.getRequestDispatcher("/login.jsp");
                                                        rd.include(request, response);                                                        
                                                    }else{
                                                        System.out.println("About logging into user's form");
                                                        usernamesRoles = userServices.userParticulars(JNDI_NAME_USER);
                                                        System.out.println("usernamesRoles.size()): " + usernamesRoles.size());
                                                        CachedListObject.cacheObjlist(usernamesRoles);
                                                        request.setAttribute("usernamesRoles", usernamesRoles);
                                                        request.setAttribute("loginParams", loginParams);
                                                        request.setAttribute("respmsg", respmsg);
                                                        request.setAttribute("errors", errors);
                                                        rd = request.getRequestDispatcher("/userFormList.jsp");
                                                        rd.forward(request, response);
                                                    }
                                                    //try{
                                                    //}finally {
                                                    //    llogincntrl.unlock();
                                                    //}
                                                    break;                                        
                                                case "RatesEntry": case "QtiesEntry": case "RatesUpdate": case "QtiesUpdate": case "AuditTrail":
                                                    if(!hasDataEntryRoles(userRole)){
                                                        msg = "YOU DO NOT HAVE THE ROLE TO PERFORM THIS TASK.";
                                                        errors.add(msg);
                                                        request.setAttribute("errors", errors);
                                                        rd = request.getRequestDispatcher("/login.jsp");
                                                        rd.include(request, response);
                                                    }else{
                                                        request.setAttribute("loginParams", loginParams);
                                                        request.setAttribute("respmsg", respmsg);
                                                        request.setAttribute("errors", errors);
                                                        switch (reqservice.trim()) {
                                                            case "RatesEntry":
                                                                //crops = userServices.crops(JNDI_NAME_CBDGT);
                                                                //locations = userServices.locations(JNDI_NAME_CBDGT);
                                                                //years = userServices.years(JNDI_NAME_CBDGT);
                                                                //farmingtypes = userServices.farmingtypes(JNDI_NAME_CBDGT);
                                                                //List<String> crops, locations, years, farmingtypes;                                
                                                                //CRPLOCYRLists crplocyrLists = new CRPLOCYRLists();
                                                                CRPLOCYRLists crplocyrLists = (CRPLOCYRLists)sess.getAttribute("crplocyrLists");
                                                                System.out.println("crplocyrLists.equals(null): " + crplocyrLists.equals(null));
                                                                crops = crplocyrLists.getCrops();
                                                                locations = crplocyrLists.getLocations();
                                                                years = crplocyrLists.getYears();
                                                                farmingtypes = crplocyrLists.getFarmingtypes();
                                                                
                                                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                                                cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //,1);
                                                                if(cbquantity == null){
                                                                    cbdgtqties.setQuantity1(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity2(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity3(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity4(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity5(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity6(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity7(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity8(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity9(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity10(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity11(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity12(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity13(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity14(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity15(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity16(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity17(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity18(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity19(format("#,###.00", (0.00))); 
                                                                    //request.setAttribute("cbdgtqties", cbdgtqties);
                                                                    //rd = request.getRequestDispatcher("/cropBDGTVarsForm.jsp");
                                                                    //rd.forward(request, response);
                                                                }else{
                                                                    cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                                                                    cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                                                                    cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                                                                    cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                                                                    cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                                                                    cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                                                                    cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                                                                    cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                                                                    cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                                                                    cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                                                                    cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                                                                    cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                                                                    cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                                                                    cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                                                                    cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                                                                    cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                                                                    cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                                                                    cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                                                                    cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                                                                }
                                                                //ServletContext context = request.getServletContext();
                                                                sess.setAttribute("cbdgtqties", cbdgtqties);
                                                                request.setAttribute("cbdgtqties", cbdgtqties);
                                                                request.setAttribute("crops", crops);
                                                                request.setAttribute("locations", locations);
                                                                request.setAttribute("years", years);
                                                                request.setAttribute("farmingtypes", farmingtypes);
                                                                rd = request.getRequestDispatcher("/cropBDGTForm.jsp");
                                                                rd.forward(request, response);
                                                                break;
                                                            case "QtiesEntry":
                                                                //CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject("CBDGTGMP_REMOTE");
                                                                JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                                                //cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT,1);
                                                                cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);
                                                                System.out.println("(cbquantity == null): " + (cbquantity == null));
                                                                if(cbquantity == null){
                                                                    cbdgtqties.setQuantity1(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity2(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity3(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity4(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity5(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity6(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity7(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity8(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity9(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity10(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity11(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity12(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity13(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity14(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity15(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity16(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity17(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity18(format("#,###.00", (0.00)));
                                                                    cbdgtqties.setQuantity19(format("#,###.00", (0.00)));                                                            
                                                                    //request.setAttribute("cbdgtqties", cbdgtqties);
                                                                    //rd = request.getRequestDispatcher("/cropBDGTVarsForm.jsp");
                                                                    //rd.forward(request, response);
                                                                }else{
                                                                    System.out.println("(cbquantity == null): " + (cbquantity == null));
                                                                    System.out.println("(cbquantity.getQuantity1(): " + cbquantity.getQuantity1());
                                                                    cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                                                                    cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                                                                    cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                                                                    cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                                                                    cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                                                                    cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                                                                    cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                                                                    cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                                                                    cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                                                                    cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                                                                    cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                                                                    cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                                                                    cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                                                                    cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                                                                    cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                                                                    cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                                                                    cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                                                                    cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                                                                    cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));

                                                                    //request.setAttribute("cbdgtqties", cbdgtqties);
                                                                    //rd = request.getRequestDispatcher("/updateBDGTVarsForm.jsp");
                                                                    //rd.forward(request, response);
                                                                }
                                                                //context = request.getServletContext();
                                                                sess.setAttribute("cbdgtqties", cbdgtqties);
                                                                request.setAttribute("cbdgtqties", cbdgtqties);
                                                                rd = request.getRequestDispatcher("/cropBDGTVarsForm.jsp");
                                                                rd.forward(request, response);
                                                                break;  
                                                            case "RatesUpdate":
                                                                //locdetails = (String)request.getParameter("locdetails");
                                                                //CLYPTVars clyptvars = new CLYPTVars();  //getCLPTNames(locdetails);
                                                                CLYPIDnums clypidnums;  // = new CLYPIDnums();  //userServices.converNamesToIds(getCropBudget(), clyptvars.getCrop(), clyptvars.getLocation(), clyptvars.getYeear(), clyptvars.getPltype());
                                                                //CBDGTParams cbdgtparams = new CBDGTParams();
                                                                JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                                                cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //,1);
                                                                cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                                                                cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                                                                cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                                                                cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                                                                cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                                                                cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                                                                cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                                                                cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                                                                cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                                                                cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                                                                cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                                                                cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                                                                cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                                                                cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                                                                cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                                                                cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                                                                cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                                                                cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                                                                cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                                                                clyptvars = getCLPTNames(locdetails);
                                                                clypidnums = cbdgtServices.converNamesToIds(JNDI_NAME_CBDGT, clyptvars.getCrop(), clyptvars.getLocation(), clyptvars.getYeear(), clyptvars.getPltype());
                                                                cbdgtparams = cbdgtServices.retreiveVarsRates(JNDI_NAME_CBDGT, clypidnums);
                                                                //context = request.getServletContext();
                                                                sess.setAttribute("cbdgtparams", cbdgtparams);
                                                                sess.setAttribute("cbdgtqties", cbdgtqties);
                                                                request.setAttribute("locdetails", locdetails);
                                                                request.setAttribute("cbdgtparams", cbdgtparams);
                                                                request.setAttribute("cbdgtqties", cbdgtqties);
                                                                rd = request.getRequestDispatcher("/cropBdgtUpdateForm.jsp");
                                                                rd.forward(request, response);
                                                                break;
                                                            case "QtiesUpdate":
                                                                cbdgtqties = new CBDGTQties();  //)request.getAttribute("qtiesupdate");
                                                                JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                                                cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //,1);
                                                                cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                                                                cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                                                                cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                                                                cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                                                                cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                                                                cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                                                                cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                                                                cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                                                                cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                                                                cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                                                                cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                                                                cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                                                                cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                                                                cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                                                                cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                                                                cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                                                                cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                                                                cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                                                                cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                                                                //context = request.getServletContext();
                                                                sess.setAttribute("cbdgtqties", cbdgtqties);
                                                                request.setAttribute("cbdgtqties", cbdgtqties);
                                                                rd = request.getRequestDispatcher("/updateBDGTVarsForm.jsp");
                                                                rd.forward(request, response);
                                                                break;
                                                            case "AuditTrail":
                                                                List<String> loggedsummaries = null;  // = new ArrayList<>();  //userServices.loggedSummaries(JNDI_NAME_CBDGT, userlogin.trim());
                                                                if(loggedsummaries == null)
                                                                    loggedsummaries = Collections.EMPTY_LIST;                                                                
                                                                request.setAttribute("loggedsummaries", loggedsummaries);
                                                                request.setAttribute("respmsg", respmsg);
                                                                request.setAttribute("errors", errors);                                                        
                                                                rd = request.getRequestDispatcher("/auditTrail.jsp");
                                                                rd.include(request, response);
                                                                break;
                                                            default:                    

                                                            break;
                                                        }
                                                    }
                                                    default:                    

                                                    break;
                                                }
                                         }else if(!isAuthenticated){
                                            respmsg = "YOU ARE NOT AUTHENTICATED.";
                                            //request.setAttribute("reqservice", reqservice.trim());
                                            request.setAttribute("respmsg", respmsg);
                                            request.setAttribute("errors", errors);
                                            rd = request.getRequestDispatcher("/login.jsp");
                                            rd.include(request, response);
                                         }                        
                                }
                            }
                            }else{
                                respmsg = "USERNAME AND/OR PASSWORD INVALID.";
                                //errors.add("Username and/or password fields not filled.");
                                request.setAttribute("userlogin", validStr(userlogin));
                                request.setAttribute("psswdlogin", validStr(psswdlogin));
                                request.setAttribute("locdetails", locdetails);
                                //request.setAttribute("reqservice", reqservice.trim());
                                request.setAttribute("respmsg", respmsg);
                                request.setAttribute("errors", errors);
                                rd = request.getRequestDispatcher("/login.jsp");
                                rd.include(request, response);
                            }
                        } finally {
                            llogincntrl.unlock();
                            System.out.println("finally {llogincntrl.unlock()} executed");
                        }
                    } else {
                        List errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";                        
                        request.setAttribute("userlogin", validStr(userlogin));
                        request.setAttribute("psswdlogin", validStr(psswdlogin));
                        request.setAttribute("locdetails", locdetails);
                        request.setAttribute("reqservice", reqservice.trim());
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/login.jsp");
                        rd.include(request, response);
                    }
                    break;
                case "addusrparams":
                    List<String> errors = new ArrayList();
                    String username = " ", password = " ", role = " ";  
                    if(laddusrparams.tryLock()){
                        try {
                            username = noNull(request.getParameter("username"));
                            password = noNull(request.getParameter("password"));
                            role = noNull(request.getParameter("role"));
                            System.out.println("username, password, role (Blank if not entered): " + username + ", " + password + ", " + role);

                            if (isBlank(username)) {
                                errors.add("You must enter user username.");
                            }
                            if (isBlank(password)) {
                                errors.add("You must enter user password.");
                            }
                            if (isBlank(role)) {
                                errors.add("You must enter user role.");
                            }

                            // Was the data sent correct?
                            System.out.println("(errors.isEmpty() => " + (errors.isEmpty()));
                            if (errors.isEmpty()) {
                                //msg = userServices.addApplicationUser(getCropBudget(), userlogin.trim(), userRole.trim(),username.toUpperCase().trim(), password.trim(), role.toUpperCase().trim());
                                System.out.println("New User (" + username.toUpperCase() + "/" + role.toUpperCase() + ") added. Time: " + getCurrentDateTime() + "#");
                                loggedtrail = (String)sess.getAttribute("loggedtrail");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                UserRemoteBusiness JNDI_NAME_USER = (UserRemoteBusiness)ServiceLocator.getRemoteObject(context, "USER_REMOTE");
                                //UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject("USERTRAIL_REMOTE");
                                respmsg = userServices.addApplicationUser(JNDI_NAME_USER, username.trim(), password.trim(), role.toUpperCase().trim());
                                loggedtrail = loggedtrail + "New User (" + username.trim() + "/" + role.toUpperCase() + ") added. Time: " + getCurrentDateTime() + "#";
                                //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                String loggeduserid = loggedUserid.getLoogeduserid();
                                //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                String loggedsummary = cunrDaytime.getUNRDaytime();
                                System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                Long userId = cuserId.getCusrid();
                                UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                cloggedInfos.setLoggeddetails(loggedtrail);
                                sess.setAttribute("cloggedInfos", cloggedInfos);
                                sess.setAttribute("loggedtrail", loggedtrail);
                                //msg = "New user added successfully.";
                                //synchronized (usernamesRoles) {
                                //    usernamesRoles.add(new UsernameRole(username.trim(), role.trim()));
                                //}
                                CachedListObject.cachedNewObject(new UsernameRole(username.trim(), role.trim()));
                                //usernamesRoles.add(new UsernameRole(username.trim(), role.trim()));
                                
                            }                
                            request.setAttribute("username", validStr(username));
                            request.setAttribute("password", validStr(password));
                            request.setAttribute("role", validStr(role));
                            request.setAttribute("respmsg", respmsg);
                            request.setAttribute("errors", errors);
                            request.setAttribute("usernamesRoles", CachedListObject.getObjectList());
                            //request.setAttribute("usernamesRoles", usernamesRoles);
                            rd = request.getRequestDispatcher("/userFormList.jsp");
                            rd.include(request, response);  
                        } finally {
                            laddusrparams.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        if(usernamesRoles == null)
                                usernamesRoles = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";                        
                        request.setAttribute("username", validStr(username));
                        request.setAttribute("password", validStr(password));
                        request.setAttribute("role", validStr(role));
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        request.setAttribute("usernamesRoles", CachedListObject.getObjectList());
                            //request.setAttribute("usernamesRoles", usernamesRoles);
                        rd = request.getRequestDispatcher("/userFormList.jsp");
                        rd.include(request, response);
                    }
                    break;
                case "addcpbdgtrate":
                    errors = new ArrayList();
                    if(laddcpbdgtrate.tryLock()){
                        try {
                            int insertable = 0;
                            crop = noNull(request.getParameter("crop"));
                            location = noNull(request.getParameter("location"));
                            year = noNull(request.getParameter("year"));
                            plttype = noNull(request.getParameter("farmingtype"));
                            rate1 = noNull(request.getParameter("rate1"));
                            rate2 = noNull(request.getParameter("rate2"));
                            rate3 = noNull(request.getParameter("rate3"));
                            rate4 = noNull(request.getParameter("rate4"));
                            rate5 = noNull(request.getParameter("rate5"));
                            rate6 = noNull(request.getParameter("rate6"));
                            rate7 = noNull(request.getParameter("rate7"));
                            rate8 = noNull(request.getParameter("rate8"));
                            rate9 = noNull(request.getParameter("rate9"));
                            rate10 = noNull(request.getParameter("rate10"));
                            rate11 = noNull(request.getParameter("rate11"));
                            rate12 = noNull(request.getParameter("rate12"));
                            rate13 = noNull(request.getParameter("rate13"));
                            rate14 = noNull(request.getParameter("rate14"));
                            rate15 = noNull(request.getParameter("rate15"));
                            rate16 = noNull(request.getParameter("rate16"));
                            rate17 = noNull(request.getParameter("rate17"));
                            rate18 = noNull(request.getParameter("rate18"));
                            rate19 = noNull(request.getParameter("rate19"));

                            if(isBlank(rate16) || (rate16.trim()).equals("0"))
                                rate16 = "0.00";
                            else{
                                try{
                                    Double hdr16 = Double.parseDouble(rate16);
                                }catch (NumberFormatException nfex){
                                    rate16 = "0.00";
                                }
                            }
                            System.out.println("About to test for empty rates");
                            System.out.println("Testing rates for emptiness:" + ((!isBlank(crop) && !isBlank(location) && !isBlank(year) && !isBlank(plttype) && !isBlank(rate1) 
                                && !isBlank(rate2) && !isBlank(rate3) && !isBlank(rate4) 
                                && !isBlank(rate5) && !isBlank(rate6) && !isBlank(rate7) && !isBlank(rate8)
                                && !isBlank(rate9) && !isBlank(rate10) && !isBlank(rate11) && !isBlank(rate12)
                                && !isBlank(rate13) && !isBlank(rate14) && !isBlank(rate15) && !isBlank(rate16)
                                && !isBlank(rate17) && !isBlank(rate18) && !isBlank(rate19))));
                            System.out.println("crop: " + crop);
                            System.out.println("location: " + location);
                            System.out.println("year: " + year);
                            System.out.println("rate1: " + rate1);
                            System.out.println("rate5: " + rate5);
                            System.out.println("rate8: " + rate8);
                            System.out.println("rate12: " + rate12);
                            System.out.println("rate16: " + rate16);
                            System.out.println("rate17: " + rate17);
                            System.out.println("rate18: " + rate18);
                            System.out.println("rate19: " + rate19);

                            if((!isBlank(crop) && !isBlank(location) && !isBlank(year) && !isBlank(plttype) && !isBlank(rate1) 
                                && !isBlank(rate2) && !isBlank(rate3) && !isBlank(rate4) 
                                && !isBlank(rate5) && !isBlank(rate6) && !isBlank(rate7) && !isBlank(rate8)
                                && !isBlank(rate9) && !isBlank(rate10) && !isBlank(rate11) && !isBlank(rate12)
                                && !isBlank(rate13) && !isBlank(rate14) && !isBlank(rate15) && !isBlank(rate16)
                                && !isBlank(rate17) && !isBlank(rate18) && !isBlank(rate19))) {
                                System.out.println("Point 00000000000000000000000000000");
                                cropbdgtvars = new CropbudgetVars();
                                clyptvars = new CLYPTVars();
                                clyptvars.setCrop(crop);                    
                                clyptvars.setLocation(location);
                                try{
                                    clyptvars.setYeear(Integer.parseInt(year));
                                    clyptvars.setPltype(plttype);
                                    cropbdgtvars.setVarrate1(BigDecimal.valueOf(Double.parseDouble(refmt(rate1))));
                                    cropbdgtvars.setVarrate2(BigDecimal.valueOf(Double.parseDouble(refmt(rate2))));
                                    cropbdgtvars.setVarrate3(BigDecimal.valueOf(Double.parseDouble(refmt(rate3))));
                                    cropbdgtvars.setVarrate4(BigDecimal.valueOf(Double.parseDouble(refmt(rate4))));
                                    cropbdgtvars.setVarrate5(BigDecimal.valueOf(Double.parseDouble(refmt(rate5))));
                                    cropbdgtvars.setVarrate6(BigDecimal.valueOf(Double.parseDouble(refmt(rate6))));
                                    cropbdgtvars.setVarrate7(BigDecimal.valueOf(Double.parseDouble(refmt(rate7))));
                                    cropbdgtvars.setVarrate8(BigDecimal.valueOf(Double.parseDouble(refmt(rate8))));
                                    cropbdgtvars.setVarrate9(BigDecimal.valueOf(Double.parseDouble(refmt(rate9))));
                                    cropbdgtvars.setVarrate10(BigDecimal.valueOf(Double.parseDouble(refmt(rate10))));
                                    cropbdgtvars.setVarrate11(BigDecimal.valueOf(Double.parseDouble(refmt(rate11))));
                                    cropbdgtvars.setVarrate12(BigDecimal.valueOf(Double.parseDouble(refmt(rate12))));
                                    cropbdgtvars.setVarrate13(BigDecimal.valueOf(Double.parseDouble(refmt(rate13))));
                                    cropbdgtvars.setVarrate14(BigDecimal.valueOf(Double.parseDouble(refmt(rate14))));
                                    cropbdgtvars.setVarrate15(BigDecimal.valueOf(Double.parseDouble(refmt(rate15))));
                                    cropbdgtvars.setVarrate16(BigDecimal.valueOf(Double.parseDouble(refmt(rate16))));
                                    cropbdgtvars.setVarrate17(BigDecimal.valueOf(Double.parseDouble(refmt(rate17))));
                                    cropbdgtvars.setVarrate18(BigDecimal.valueOf(Double.parseDouble(refmt(rate18))));
                                    cropbdgtvars.setVarrate19(BigDecimal.valueOf(Double.parseDouble(refmt(rate19))));
                                }catch (NumberFormatException nfex){
                                    msg = "Some rates are not entered.";
                                    errors.add(msg);
                                }
                                System.out.println("clyptvars.getCrop(): " + clyptvars.getCrop());
                                System.out.println("clyptvars.getLocation(): " + clyptvars.getLocation());
                                System.out.println("clyptvars.getYeear(): " + clyptvars.getYeear());
                                System.out.println("clyptvars.getPltype(): " + clyptvars.getPltype());
                                System.out.println("cropbdgtvars.getVarrate1(): " + cropbdgtvars.getVarrate1());
                                System.out.println("cropbdgtvars.getVarrate2(): " + cropbdgtvars.getVarrate2());
                                System.out.println("cropbdgtvars.getVarrate3(): " + cropbdgtvars.getVarrate3());
                                System.out.println("cropbdgtvars.getVarrate4(): " + cropbdgtvars.getVarrate4());
                                System.out.println("cropbdgtvars.getVarrate5(): " + cropbdgtvars.getVarrate5());
                                System.out.println("cropbdgtvars.getVarrate6(): " + cropbdgtvars.getVarrate6());
                                System.out.println("cropbdgtvars.getVarrate7(): " + cropbdgtvars.getVarrate7());
                                System.out.println("cropbdgtvars.getVarrate8(): " + cropbdgtvars.getVarrate8());
                                System.out.println("cropbdgtvars.getVarrate9(): " + cropbdgtvars.getVarrate9());
                                System.out.println("cropbdgtvars.getVarrate10(): " + cropbdgtvars.getVarrate10());
                                System.out.println("cropbdgtvars.getVarrate11(): " + cropbdgtvars.getVarrate11());
                                System.out.println("cropbdgtvars.getVarrate12(): " + cropbdgtvars.getVarrate12());
                                System.out.println("cropbdgtvars.getVarrate13(): " + cropbdgtvars.getVarrate13());
                                System.out.println("cropbdgtvars.getVarrate14(): " + cropbdgtvars.getVarrate14());
                                System.out.println("cropbdgtvars.getVarrate15(): " + cropbdgtvars.getVarrate15());
                                System.out.println("cropbdgtvars.getVarrate16(): " + cropbdgtvars.getVarrate16());
                                System.out.println("cropbdgtvars.getVarrate17(): " + cropbdgtvars.getVarrate17());
                                System.out.println("cropbdgtvars.getVarrate18(): " + cropbdgtvars.getVarrate18());
                                System.out.println("cropbdgtvars.getVarrate19(): " + cropbdgtvars.getVarrate19());

                                ////System.out.println("Record inserted => udfflag :" + udfflag);
                                //System.out.println("hasDataEntryRoles(userRole), userRole: " + hasDataEntryRoles(userRole) + ", " + userRole);
                                //msg = "Record updated successfully.";
                                cbdgtparams.setCrop(clyptvars.getCrop());
                                cbdgtparams.setLocation(clyptvars.getLocation());
                                cbdgtparams.setYeear(Integer.toString(clyptvars.getYeear()));
                                cbdgtparams.setPltype(clyptvars.getPltype());
                                cbdgtparams.setVarrate1(format("#,###.00", cropbdgtvars.getVarrate1().doubleValue()));
                                cbdgtparams.setVarrate2(format("#,###.00", cropbdgtvars.getVarrate2().doubleValue()));
                                cbdgtparams.setVarrate3(format("#,###.00", cropbdgtvars.getVarrate3().doubleValue()));
                                cbdgtparams.setVarrate4(format("#,###.00", cropbdgtvars.getVarrate4().doubleValue()));
                                cbdgtparams.setVarrate5(format("#,###.00", cropbdgtvars.getVarrate5().doubleValue()));
                                cbdgtparams.setVarrate6(format("#,###.00", cropbdgtvars.getVarrate6().doubleValue()));
                                cbdgtparams.setVarrate7(format("#,###.00", cropbdgtvars.getVarrate7().doubleValue()));
                                cbdgtparams.setVarrate8(format("#,###.00", cropbdgtvars.getVarrate8().doubleValue()));
                                cbdgtparams.setVarrate9(format("#,###.00", cropbdgtvars.getVarrate9().doubleValue()));
                                cbdgtparams.setVarrate10(format("#,###.00", cropbdgtvars.getVarrate10().doubleValue()));
                                cbdgtparams.setVarrate11(format("#,###.00", cropbdgtvars.getVarrate11().doubleValue()));
                                cbdgtparams.setVarrate12(format("#,###.00", cropbdgtvars.getVarrate12().doubleValue()));
                                cbdgtparams.setVarrate13(format("#,###.00", cropbdgtvars.getVarrate13().doubleValue()));
                                cbdgtparams.setVarrate14(format("#,###.00", cropbdgtvars.getVarrate14().doubleValue()));
                                cbdgtparams.setVarrate15(format("#,###.00", cropbdgtvars.getVarrate15().doubleValue()));
                                cbdgtparams.setVarrate16(format("#,###.00", cropbdgtvars.getVarrate16().doubleValue()));
                                cbdgtparams.setVarrate17(format("#,###.00", cropbdgtvars.getVarrate17().doubleValue()));
                                cbdgtparams.setVarrate18(format("#,###.00", cropbdgtvars.getVarrate18().doubleValue()));
                                cbdgtparams.setVarrate19(format("#,###.00", cropbdgtvars.getVarrate19().doubleValue()));
                                insertable = insertable + 1;
                            }else{
                                msg = "Some list items are not selected or rates not entered. ";
                                errors.add(msg);
                            }

                            if(insertable == 1){
                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                respmsg = cbdgtServices.enterCBDGTVars(JNDI_NAME_CBDGT, cropbdgtvars, clyptvars);  //, username.trim(), userRole.trim());
                                loggedtrail = (String)sess.getAttribute("loggedtrail");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                loggedtrail = loggedtrail + "New record(rates) added. Time: " + getCurrentDateTime() + "#";
                                //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                String loggeduserid = loggedUserid.getLoogeduserid();
                                //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                String loggedsummary = cunrDaytime.getUNRDaytime();
                                System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                Long userId = cuserId.getCusrid();
                                UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                System.out.println("New record(rates) added. Time: " + getCurrentDateTime() + "#");
                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                cloggedInfos.setLoggeddetails(loggedtrail);
                                sess.setAttribute("cloggedInfos", cloggedInfos); 
                                sess.setAttribute("loggedtrail", loggedtrail);
                            }
                            //List<String> crops, locations, years, farmingtypes;                                
                            //CRPLOCYRLists crplocyrLists = new CRPLOCYRLists();
                            CRPLOCYRLists crplocyrLists = (CRPLOCYRLists)sess.getAttribute("crplocyrLists");
                            crops = crplocyrLists.getCrops();
                            locations = crplocyrLists.getLocations();
                            years = crplocyrLists.getYears();
                            farmingtypes = crplocyrLists.getFarmingtypes(); 
                            //crops = userServices.crops(JNDI_NAME_CBDGT);
                            //locations = userServices.locations(JNDI_NAME_CBDGT);
                            //years = userServices.years(JNDI_NAME_CBDGT);
                            //farmingtypes = userServices.farmingtypes(JNDI_NAME_CBDGT);
                            CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                            cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //,1);
                            System.out.println("(cbquantity == null): " + (cbquantity == null));
                            if(cbquantity == null){
                                cbdgtqties.setQuantity1(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity2(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity3(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity4(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity5(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity6(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity7(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity8(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity9(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity10(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity11(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity12(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity13(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity14(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity15(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity16(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity17(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity18(format("#,###.00", (0.00)));
                                cbdgtqties.setQuantity19(format("#,###.00", (0.00))); 
                                request.setAttribute("cbdgtqties", cbdgtqties);
                                rd = request.getRequestDispatcher("/cropBDGTVarsForm.jsp");
                                rd.forward(request, response);
                             }else{
                                cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                                cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                                cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                                cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                                cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                                cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                                cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                                cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                                cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                                cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                                cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                                cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                                cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                                cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                                cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                                cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                                cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                                cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                                cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                            }
                            request.setAttribute("crops", crops);
                            request.setAttribute("locations", locations);
                            request.setAttribute("years", years);
                            request.setAttribute("farmingtypes", farmingtypes);
                            request.setAttribute("cbdgtqties", cbdgtqties);
                            request.setAttribute("cbdgtparams", cbdgtparams);
                            request.setAttribute("respmsg", respmsg);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/cropBDGTForm.jsp");
                            rd.include(request, response);
                        } finally {
                            laddcpbdgtrate.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";
                        //ServletContext context = request.getServletContext();
                        cbdgtqties = (CBDGTQties)sess.getAttribute("cbdgtqties");
                        //List<String> crops, locations, years, farmingtypes;                                
                        //CRPLOCYRLists crplocyrLists = new CRPLOCYRLists();
                        CRPLOCYRLists crplocyrLists = (CRPLOCYRLists)sess.getAttribute("crplocyrLists");
                        crops = crplocyrLists.getCrops();
                        locations = crplocyrLists.getLocations();
                        years = crplocyrLists.getYears();
                        farmingtypes = crplocyrLists.getFarmingtypes();
                        //crops = userServices.crops(JNDI_NAME_CBDGT);
                        //locations = userServices.locations(JNDI_NAME_CBDGT);
                        //years = userServices.years(JNDI_NAME_CBDGT);
                        //farmingtypes = userServices.farmingtypes(JNDI_NAME_CBDGT);
                        request.setAttribute("cbdgtqties", cbdgtqties);
                        request.setAttribute("crops", crops);
                        request.setAttribute("locations", locations);
                        request.setAttribute("years", years);
                        request.setAttribute("farmingtypes", farmingtypes);
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/cropBDGTForm.jsp");
                        rd.include(request, response);
                    }
                    break;
                case "addcpbdgtqty":
                    System.out.println("ctrlName: " + ctrlName);
                    errors = new ArrayList();
                    if(laddcpbdgtqty.tryLock()){
                        try {
                            int insertable = 0;
                            CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                            cbquantity = cbdgtServices.getQuantities(JNDI_NAME_CBDGT);  //,1);
                            if(cbquantity == null){
                                qty1 = noNull(request.getParameter("qty1"));
                                qty2 = noNull(request.getParameter("qty2"));
                                qty3 = noNull(request.getParameter("qty3"));
                                qty4 = noNull(request.getParameter("qty4"));
                                qty5 = noNull(request.getParameter("qty5"));
                                qty6 = noNull(request.getParameter("qty6"));
                                qty7 = noNull(request.getParameter("qty7"));
                                qty8 = noNull(request.getParameter("qty8"));
                                qty9 = noNull(request.getParameter("qty9"));
                                qty10 = noNull(request.getParameter("qty10"));
                                qty11 = noNull(request.getParameter("qty11"));
                                qty12 = noNull(request.getParameter("qty12"));
                                qty13 = noNull(request.getParameter("qty13"));
                                qty14 = noNull(request.getParameter("qty14"));
                                qty15 = noNull(request.getParameter("qty15"));
                                qty16 = noNull(request.getParameter("qty16"));
                                qty17 = noNull(request.getParameter("qty17"));
                                qty18 = noNull(request.getParameter("qty18"));
                                qty19 = noNull(request.getParameter("qty19"));                    

                                //if(isBlank(qty16))
                                //    qty16 = "0.00";
                                //if(isBlank(qty16) || (qty16.trim()).equals("0"))
                                //    rate16 = "0.00";
                                //else{
                                try{
                                    Double hdq16 = Double.parseDouble(qty16);
                                }catch (NumberFormatException nfex){
                                    qty16 = "0.00";
                                }
                                //}
                                System.out.println("About to test for empty qtys");
                                System.out.println("Testing qtys for emptiness:" + ((!isBlank(qty1) 
                                    && !isBlank(qty2) && !isBlank(qty3) && !isBlank(qty4) 
                                    && !isBlank(qty5) && !isBlank(qty6) && !isBlank(qty7) && !isBlank(qty8)
                                    && !isBlank(qty9) && !isBlank(qty10) && !isBlank(qty11) && !isBlank(qty12)
                                    && !isBlank(qty13) && !isBlank(qty14) && !isBlank(qty15) && !isBlank(qty16)
                                    && !isBlank(qty17) && !isBlank(qty18) && !isBlank(qty19))));
                                System.out.println("qty1: " + qty1);
                                System.out.println("qty5: " + qty5);
                                System.out.println("qty8: " + qty8);
                                System.out.println("qty12: " + qty12);
                                System.out.println("qty16: " + qty16);
                                System.out.println("qty17: " + qty17);
                                System.out.println("qty18: " + qty18);
                                System.out.println("qty19: " + qty19);

                                if((!isBlank(qty1) && !isBlank(qty2) && !isBlank(qty3) && !isBlank(qty4)  
                                    && !isBlank(qty5) && !isBlank(qty6) && !isBlank(qty7) && !isBlank(qty8)
                                    && !isBlank(qty9) && !isBlank(qty10) && !isBlank(qty11) && !isBlank(qty12)
                                    && !isBlank(qty13) && !isBlank(qty14) && !isBlank(qty15) && !isBlank(qty16)
                                    && !isBlank(qty17) && !isBlank(qty18) && !isBlank(qty19))) {
                                    System.out.println("Point 00000000000000000000000000000");

                                    cbdgtqties = new CBDGTQties();
                                    try{
                                        cbdgtqties.setQuantity1(format("#,###.00", (Double.parseDouble(refmt(qty1)))));
                                        cbdgtqties.setQuantity2(format("#,###.00", (Double.parseDouble(refmt(qty2)))));
                                        cbdgtqties.setQuantity3(format("#,###.00", (Double.parseDouble(refmt(qty3)))));
                                        cbdgtqties.setQuantity4(format("#,###.00", (Double.parseDouble(refmt(qty4)))));
                                        cbdgtqties.setQuantity5(format("#,###.00", (Double.parseDouble(refmt(qty5)))));
                                        cbdgtqties.setQuantity6(format("#,###.00", (Double.parseDouble(refmt(qty6)))));
                                        cbdgtqties.setQuantity7(format("#,###.00", (Double.parseDouble(refmt(qty7)))));
                                        cbdgtqties.setQuantity8(format("#,###.00", (Double.parseDouble(refmt(qty8)))));
                                        cbdgtqties.setQuantity9(format("#,###.00", (Double.parseDouble(refmt(qty9)))));
                                        cbdgtqties.setQuantity10(format("#,###.00", (Double.parseDouble(refmt(qty10)))));
                                        cbdgtqties.setQuantity11(format("#,###.00", (Double.parseDouble(refmt(qty11)))));
                                        cbdgtqties.setQuantity12(format("#,###.00", (Double.parseDouble(refmt(qty12)))));
                                        cbdgtqties.setQuantity13(format("#,###.00", (Double.parseDouble(refmt(qty13)))));
                                        cbdgtqties.setQuantity14(format("#,###.00", (Double.parseDouble(refmt(qty14)))));
                                        cbdgtqties.setQuantity15(format("#,###.00", (Double.parseDouble(refmt(qty15)))));
                                        cbdgtqties.setQuantity16(format("#,###.00", (Double.parseDouble(refmt(qty16)))));
                                        cbdgtqties.setQuantity17(format("#,###.00", (Double.parseDouble(refmt(qty17)))));
                                        cbdgtqties.setQuantity18(format("#,###.00", (Double.parseDouble(refmt(qty18)))));
                                        cbdgtqties.setQuantity19(format("#,###.00", (Double.parseDouble(refmt(qty19)))));
                                    }catch (NumberFormatException nfex){
                                        msg = "Some quantities are not entered.";
                                        errors.add(msg);
                                    }
                                    System.out.println("cbdgtqties.getQuantity1(): " + cbdgtqties.getQuantity1());
                                    System.out.println("cbdgtqties.getQuantity2(): " + cbdgtqties.getQuantity2());
                                    System.out.println("cbdgtqties.getQuantity3(): " + cbdgtqties.getQuantity3());
                                    System.out.println("cbdgtqties.getQuantity4(): " + cbdgtqties.getQuantity4());
                                    System.out.println("cbdgtqties.getQuantity5(): " + cbdgtqties.getQuantity5());
                                    System.out.println("cbdgtqties.getQuantity6(): " + cbdgtqties.getQuantity6());
                                    System.out.println("cbdgtqties.getQuantity7(): " + cbdgtqties.getQuantity7());
                                    System.out.println("cbdgtqties.getQuantity8(): " + cbdgtqties.getQuantity8());
                                    System.out.println("cbdgtqties.getQuantity9(): " + cbdgtqties.getQuantity9());
                                    System.out.println("cbdgtqties.getQuantity10(): " + cbdgtqties.getQuantity10());
                                    System.out.println("cbdgtqties.getQuantity11(): " + cbdgtqties.getQuantity11());
                                    System.out.println("cbdgtqties.getQuantity12(): " + cbdgtqties.getQuantity12());
                                    System.out.println("cbdgtqties.getQuantity13(): " + cbdgtqties.getQuantity13());
                                    System.out.println("cbdgtqties.getQuantity14(): " + cbdgtqties.getQuantity14());
                                    System.out.println("cbdgtqties.getQuantity15(): " + cbdgtqties.getQuantity15());
                                    System.out.println("cbdgtqties.getQuantity16(): " + cbdgtqties.getQuantity16());
                                    System.out.println("cbdgtqties.getQuantity17(): " + cbdgtqties.getQuantity17());
                                    System.out.println("cbdgtqties.getQuantity18(): " + cbdgtqties.getQuantity18());
                                    System.out.println("cbdgtqties.getQuantity19(): " + cbdgtqties.getQuantity19());
                                    cbdgtqties.setQuantity1(cbdgtqties.getQuantity1());
                                    cbdgtqties.setQuantity2(cbdgtqties.getQuantity2());
                                    cbdgtqties.setQuantity3(cbdgtqties.getQuantity3());
                                    cbdgtqties.setQuantity4(cbdgtqties.getQuantity4());
                                    cbdgtqties.setQuantity5(cbdgtqties.getQuantity5());
                                    cbdgtqties.setQuantity6(cbdgtqties.getQuantity6());
                                    cbdgtqties.setQuantity7(cbdgtqties.getQuantity7());
                                    cbdgtqties.setQuantity8(cbdgtqties.getQuantity8());
                                    cbdgtqties.setQuantity9(cbdgtqties.getQuantity9());
                                    cbdgtqties.setQuantity10(cbdgtqties.getQuantity10());
                                    cbdgtqties.setQuantity11(cbdgtqties.getQuantity11());
                                    cbdgtqties.setQuantity12(cbdgtqties.getQuantity12());
                                    cbdgtqties.setQuantity13(cbdgtqties.getQuantity13());
                                    cbdgtqties.setQuantity14(cbdgtqties.getQuantity14());
                                    cbdgtqties.setQuantity15(cbdgtqties.getQuantity15());
                                    cbdgtqties.setQuantity16(cbdgtqties.getQuantity16());
                                    cbdgtqties.setQuantity17(cbdgtqties.getQuantity17());
                                    cbdgtqties.setQuantity18(cbdgtqties.getQuantity18());
                                    cbdgtqties.setQuantity19(cbdgtqties.getQuantity19());
                                    insertable = insertable + 1;
                                }else{
                                    msg = msg + "Some quantities are not entered.";
                                    errors.add(msg);
                                }
                                System.out.println("(insertable == 1): " + (insertable == 1));
                                if(insertable == 1){
                                    System.out.println("cbdgtServices.enterCBDGTQtyies executed: " );
                                    respmsg = cbdgtServices.enterCBDGTQtyies(JNDI_NAME_CBDGT, cbdgtqties);  //, username.trim(), userRole.trim());
                                    loggedtrail = (String)sess.getAttribute("loggedtrail");
                                    //sess.setAttribute("loggedtrail", loggedtrail);
                                    loggedtrail = loggedtrail + "New record(quantities) added. Time: " + getCurrentDateTime() + "#";
                                    //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                    LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                    String loggeduserid = loggedUserid.getLoogeduserid();
                                    //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                    CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                    String loggedsummary = cunrDaytime.getUNRDaytime();
                                    System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                    CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                    Long userId = cuserId.getCusrid();
                                    UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                    //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                    audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                    //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                    cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                    cloggedInfos.setLoggeddetails(loggedtrail);
                                    sess.setAttribute("cloggedInfos", cloggedInfos);
                                    sess.setAttribute("loggedtrail", loggedtrail);
                                }
                            }else{
                                cbdgtqties.setQuantity1(format("#,###.00", cbquantity.getQuantity1().doubleValue()));
                                cbdgtqties.setQuantity2(format("#,###.00", cbquantity.getQuantity2().doubleValue()));
                                cbdgtqties.setQuantity3(format("#,###.00", cbquantity.getQuantity3().doubleValue()));
                                cbdgtqties.setQuantity4(format("#,###.00", cbquantity.getQuantity4().doubleValue()));
                                cbdgtqties.setQuantity5(format("#,###.00", cbquantity.getQuantity5().doubleValue()));
                                cbdgtqties.setQuantity6(format("#,###.00", cbquantity.getQuantity6().doubleValue()));
                                cbdgtqties.setQuantity7(format("#,###.00", cbquantity.getQuantity7().doubleValue()));
                                cbdgtqties.setQuantity8(format("#,###.00", cbquantity.getQuantity8().doubleValue()));
                                cbdgtqties.setQuantity9(format("#,###.00", cbquantity.getQuantity9().doubleValue()));
                                cbdgtqties.setQuantity10(format("#,###.00", cbquantity.getQuantity10().doubleValue()));
                                cbdgtqties.setQuantity11(format("#,###.00", cbquantity.getQuantity11().doubleValue()));
                                cbdgtqties.setQuantity12(format("#,###.00", cbquantity.getQuantity12().doubleValue()));
                                cbdgtqties.setQuantity13(format("#,###.00", cbquantity.getQuantity13().doubleValue()));
                                cbdgtqties.setQuantity14(format("#,###.00", cbquantity.getQuantity14().doubleValue()));
                                cbdgtqties.setQuantity15(format("#,###.00", cbquantity.getQuantity15().doubleValue()));
                                cbdgtqties.setQuantity16(format("#,###.00", cbquantity.getQuantity16().doubleValue()));
                                cbdgtqties.setQuantity17(format("#,###.00", cbquantity.getQuantity17().doubleValue()));
                                cbdgtqties.setQuantity18(format("#,###.00", cbquantity.getQuantity18().doubleValue()));
                                cbdgtqties.setQuantity19(format("#,###.00", cbquantity.getQuantity19().doubleValue()));
                            }
                            request.setAttribute("cbdgtqties", cbdgtqties);
                            request.setAttribute("respmsg", respmsg);
                            //request.setAttribute("locdetails", locdetails);
                            request.setAttribute("errors", errors);
                            System.out.println(" to request.getRequestDispatcher(\"/cropBDGTVarsForm.jsp: " );
                            rd = request.getRequestDispatcher("/cropBDGTVarsForm.jsp");
                            System.out.println(" doneupdatecpbdgtqty request.getRequestDispatcher(\"/cropBDGTVarsForm.jsp: " );
                            rd.include(request, response);
                        } finally {
                            laddcpbdgtqty.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";
                        //ServletContext context = request.getServletContext();
                        cbdgtqties = (CBDGTQties)sess.getAttribute("cbdgtqties");
                        request.setAttribute("cbdgtqties", cbdgtqties);
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/cropBDGTVarsForm.jsp");
                        rd.include(request, response);
                    }
                    break;
                case "updaterate": 
                    errors = new ArrayList();
                    if(lupdaterate.tryLock()){
                        try {
                            int updatable = 0;
                            crop = noNull(request.getParameter("crop"));
                            location = noNull(request.getParameter("location"));
                            year = noNull(request.getParameter("year"));
                            plttype = noNull(request.getParameter("farmingtype"));
                            rate1 = noNull(request.getParameter("rate1"));
                            rate2 = noNull(request.getParameter("rate2"));
                            rate3 = noNull(request.getParameter("rate3"));
                            rate4 = noNull(request.getParameter("rate4"));
                            rate5 = noNull(request.getParameter("rate5"));
                            rate6 = noNull(request.getParameter("rate6"));
                            rate7 = noNull(request.getParameter("rate7"));
                            rate8 = noNull(request.getParameter("rate8"));
                            rate9 = noNull(request.getParameter("rate9"));
                            rate10 = noNull(request.getParameter("rate10"));
                            rate11 = noNull(request.getParameter("rate11"));
                            rate12 = noNull(request.getParameter("rate12"));
                            rate13 = noNull(request.getParameter("rate13"));
                            rate14 = noNull(request.getParameter("rate14"));
                            rate15 = noNull(request.getParameter("rate15"));
                            rate16 = noNull(request.getParameter("rate16"));
                            rate17 = noNull(request.getParameter("rate17"));
                            rate18 = noNull(request.getParameter("rate18"));
                            rate19 = noNull(request.getParameter("rate19"));

                            if(isBlank(rate16) || (rate16.trim()).equals("0"))
                                rate16 = "0.00";
                            else{
                                try{
                                    Double hdr16 = Double.parseDouble(rate16);
                                }catch (NumberFormatException nfex){
                                    rate16 = "0.00";
                                }
                            }    
                            System.out.println("About to test for empty rates");
                            System.out.println("Testing rates for emptiness:" + ((!isBlank(crop) && !isBlank(location) && !isBlank(year) && !isBlank(plttype) && !isBlank(rate1) 
                                && !isBlank(rate2) && !isBlank(rate3) && !isBlank(rate4) 
                                && !isBlank(rate5) && !isBlank(rate6) && !isBlank(rate7) && !isBlank(rate8)
                                && !isBlank(rate9) && !isBlank(rate10) && !isBlank(rate11) && !isBlank(rate12)
                                && !isBlank(rate13) && !isBlank(rate14) && !isBlank(rate15) && !isBlank(rate16)
                                && !isBlank(rate17) && !isBlank(rate18) && !isBlank(rate19))));
                            System.out.println("crop: " + crop);
                            System.out.println("location: " + location);
                            System.out.println("year: " + year);
                            System.out.println("rate1: " + rate1);
                            System.out.println("rate5: " + rate5);
                            System.out.println("rate8: " + rate8);
                            System.out.println("rate12: " + rate12);
                            System.out.println("rate16: " + rate16);
                            System.out.println("rate17: " + rate17);
                            System.out.println("rate18: " + rate18);
                            System.out.println("rate19: " + rate19);

                            if((!isBlank(crop) && !isBlank(location) && !isBlank(year) && !isBlank(plttype) && !isBlank(rate1) 
                                && !isBlank(rate2) && !isBlank(rate3) && !isBlank(rate4) 
                                && !isBlank(rate5) && !isBlank(rate6) && !isBlank(rate7) && !isBlank(rate8)
                                && !isBlank(rate9) && !isBlank(rate10) && !isBlank(rate11) && !isBlank(rate12)
                                && !isBlank(rate13) && !isBlank(rate14) && !isBlank(rate15) && !isBlank(rate16)
                                && !isBlank(rate17) && !isBlank(rate18) && !isBlank(rate19))) {
                                System.out.println("Point 00000000000000000000000000000");
                                cropbdgtvars = new CropbudgetVars();
                                clyptvars = new CLYPTVars();
                                clyptvars.setCrop(crop);                    
                                clyptvars.setLocation(location);
                                try{
                                    clyptvars.setYeear(Integer.parseInt(year));
                                    clyptvars.setPltype(plttype);
                                    cropbdgtvars.setVarrate1(BigDecimal.valueOf(Double.parseDouble(refmt(rate1))));
                                    cropbdgtvars.setVarrate2(BigDecimal.valueOf(Double.parseDouble(refmt(rate2))));
                                    cropbdgtvars.setVarrate3(BigDecimal.valueOf(Double.parseDouble(refmt(rate3))));
                                    cropbdgtvars.setVarrate4(BigDecimal.valueOf(Double.parseDouble(refmt(rate4))));
                                    cropbdgtvars.setVarrate5(BigDecimal.valueOf(Double.parseDouble(refmt(rate5))));
                                    cropbdgtvars.setVarrate6(BigDecimal.valueOf(Double.parseDouble(refmt(rate6))));
                                    cropbdgtvars.setVarrate7(BigDecimal.valueOf(Double.parseDouble(refmt(rate7))));
                                    cropbdgtvars.setVarrate8(BigDecimal.valueOf(Double.parseDouble(refmt(rate8))));
                                    cropbdgtvars.setVarrate9(BigDecimal.valueOf(Double.parseDouble(refmt(rate9))));
                                    cropbdgtvars.setVarrate10(BigDecimal.valueOf(Double.parseDouble(refmt(rate10))));
                                    cropbdgtvars.setVarrate11(BigDecimal.valueOf(Double.parseDouble(refmt(rate11))));
                                    cropbdgtvars.setVarrate12(BigDecimal.valueOf(Double.parseDouble(refmt(rate12))));
                                    cropbdgtvars.setVarrate13(BigDecimal.valueOf(Double.parseDouble(refmt(rate13))));
                                    cropbdgtvars.setVarrate14(BigDecimal.valueOf(Double.parseDouble(refmt(rate14))));
                                    cropbdgtvars.setVarrate15(BigDecimal.valueOf(Double.parseDouble(refmt(rate15))));
                                    cropbdgtvars.setVarrate16(BigDecimal.valueOf(Double.parseDouble(refmt(rate16))));
                                    cropbdgtvars.setVarrate17(BigDecimal.valueOf(Double.parseDouble(refmt(rate17))));
                                    cropbdgtvars.setVarrate18(BigDecimal.valueOf(Double.parseDouble(refmt(rate18))));
                                    cropbdgtvars.setVarrate19(BigDecimal.valueOf(Double.parseDouble(refmt(rate19))));
                                }catch (NumberFormatException nfex){
                                    msg = "Some rates are not entered.";
                                    errors.add(msg);
                                }
                                System.out.println("clyptvars.getCrop(): " + clyptvars.getCrop());
                                System.out.println("clyptvars.getLocation(): " + clyptvars.getLocation());
                                System.out.println("clyptvars.getYeear(): " + clyptvars.getYeear());
                                System.out.println("clyptvars.getPltype(): " + clyptvars.getPltype());
                                System.out.println("cropbdgtvars.getVarrate1(): " + cropbdgtvars.getVarrate1());
                                System.out.println("cropbdgtvars.getVarrate2(): " + cropbdgtvars.getVarrate2());
                                System.out.println("cropbdgtvars.getVarrate3(): " + cropbdgtvars.getVarrate3());
                                System.out.println("cropbdgtvars.getVarrate4(): " + cropbdgtvars.getVarrate4());
                                System.out.println("cropbdgtvars.getVarrate5(): " + cropbdgtvars.getVarrate5());
                                System.out.println("cropbdgtvars.getVarrate6(): " + cropbdgtvars.getVarrate6());
                                System.out.println("cropbdgtvars.getVarrate7(): " + cropbdgtvars.getVarrate7());
                                System.out.println("cropbdgtvars.getVarrate8(): " + cropbdgtvars.getVarrate8());
                                System.out.println("cropbdgtvars.getVarrate9(): " + cropbdgtvars.getVarrate9());
                                System.out.println("cropbdgtvars.getVarrate10(): " + cropbdgtvars.getVarrate10());
                                System.out.println("cropbdgtvars.getVarrate11(): " + cropbdgtvars.getVarrate11());
                                System.out.println("cropbdgtvars.getVarrate12(): " + cropbdgtvars.getVarrate12());
                                System.out.println("cropbdgtvars.getVarrate13(): " + cropbdgtvars.getVarrate13());
                                System.out.println("cropbdgtvars.getVarrate14(): " + cropbdgtvars.getVarrate14());
                                System.out.println("cropbdgtvars.getVarrate15(): " + cropbdgtvars.getVarrate15());
                                System.out.println("cropbdgtvars.getVarrate16(): " + cropbdgtvars.getVarrate16());
                                System.out.println("cropbdgtvars.getVarrate17(): " + cropbdgtvars.getVarrate17());
                                System.out.println("cropbdgtvars.getVarrate18(): " + cropbdgtvars.getVarrate18());
                                System.out.println("cropbdgtvars.getVarrate19(): " + cropbdgtvars.getVarrate19());

                                ////System.out.println("Record inserted => udfflag :" + udfflag);
                                //System.out.println("hasDataEntryRoles(userRole), userRole: " + hasDataEntryRoles(userRole) + ", " + userRole);
                                //msg = "Record updated successfully.";
                                cbdgtparams.setCrop(clyptvars.getCrop());
                                cbdgtparams.setLocation(clyptvars.getLocation());
                                cbdgtparams.setYeear(Integer.toString(clyptvars.getYeear()));
                                cbdgtparams.setPltype(clyptvars.getPltype());
                                cbdgtparams.setVarrate1(format("#,###.00", cropbdgtvars.getVarrate1().doubleValue()));
                                cbdgtparams.setVarrate2(format("#,###.00", cropbdgtvars.getVarrate2().doubleValue()));
                                cbdgtparams.setVarrate3(format("#,###.00", cropbdgtvars.getVarrate3().doubleValue()));
                                cbdgtparams.setVarrate4(format("#,###.00", cropbdgtvars.getVarrate4().doubleValue()));
                                cbdgtparams.setVarrate5(format("#,###.00", cropbdgtvars.getVarrate5().doubleValue()));
                                cbdgtparams.setVarrate6(format("#,###.00", cropbdgtvars.getVarrate6().doubleValue()));
                                cbdgtparams.setVarrate7(format("#,###.00", cropbdgtvars.getVarrate7().doubleValue()));
                                cbdgtparams.setVarrate8(format("#,###.00", cropbdgtvars.getVarrate8().doubleValue()));
                                cbdgtparams.setVarrate9(format("#,###.00", cropbdgtvars.getVarrate9().doubleValue()));
                                cbdgtparams.setVarrate10(format("#,###.00", cropbdgtvars.getVarrate10().doubleValue()));
                                cbdgtparams.setVarrate11(format("#,###.00", cropbdgtvars.getVarrate11().doubleValue()));
                                cbdgtparams.setVarrate12(format("#,###.00", cropbdgtvars.getVarrate12().doubleValue()));
                                cbdgtparams.setVarrate13(format("#,###.00", cropbdgtvars.getVarrate13().doubleValue()));
                                cbdgtparams.setVarrate14(format("#,###.00", cropbdgtvars.getVarrate14().doubleValue()));
                                cbdgtparams.setVarrate15(format("#,###.00", cropbdgtvars.getVarrate15().doubleValue()));
                                cbdgtparams.setVarrate16(format("#,###.00", cropbdgtvars.getVarrate16().doubleValue()));
                                cbdgtparams.setVarrate17(format("#,###.00", cropbdgtvars.getVarrate17().doubleValue()));
                                cbdgtparams.setVarrate18(format("#,###.00", cropbdgtvars.getVarrate18().doubleValue()));
                                cbdgtparams.setVarrate19(format("#,###.00", cropbdgtvars.getVarrate19().doubleValue()));
                                updatable = updatable + 1;
                            }else{
                                msg = "Some list items are not selected or rates not entered. ";
                                errors.add(msg);
                            }

                            if(updatable == 1){
                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                respmsg = cbdgtServices.modifyCBDGTVars(JNDI_NAME_CBDGT, cropbdgtvars, clyptvars);  //, username.trim(), userRole.trim());
                                loggedtrail = (String)sess.getAttribute("loggedtrail");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                loggedtrail = loggedtrail + "Existing record(rates) modified. Time: " + getCurrentDateTime() + "#";
                                //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                String loggeduserid = loggedUserid.getLoogeduserid();
                                //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                String loggedsummary = cunrDaytime.getUNRDaytime();
                                System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                Long userId = cuserId.getCusrid();
                                UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                cloggedInfos.setLoggeddetails(loggedtrail);
                                sess.setAttribute("cloggedInfos", cloggedInfos);
                                sess.setAttribute("loggedtrail", loggedtrail);
                            }
                            cbdgtqties = (CBDGTQties)sess.getAttribute("cbdgtqties");
                            request.setAttribute("cbdgtqties", cbdgtqties);
                            request.setAttribute("cbdgtparams", cbdgtparams);
                            request.setAttribute("respmsg", respmsg);
                            //request.setAttribute("locdetails", locdetails);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/cropBdgtUpdateForm.jsp");
                            rd.include(request, response);
                        } finally {
                            lupdaterate.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";
                        //ServletContext context = request.getServletContext();
                        cbdgtqties = (CBDGTQties)sess.getAttribute("cbdgtqties");
                        cbdgtparams = (CBDGTParams)sess.getAttribute("cbdgtparams");
                        request.setAttribute("cbdgtqties", cbdgtqties);
                        request.setAttribute("cbdgtparams", cbdgtparams);
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/cropBdgtUpdateForm.jsp");
                        rd.include(request, response);
                    }
                    break;
                case "updatecpbdgtqty":
                    errors = new ArrayList();
                    if(lupdatecpbdgtqty.tryLock()){
                        try {
                            int updatable = 0;
                            qty1 = noNull(request.getParameter("qty1"));
                            qty2 = noNull(request.getParameter("qty2"));
                            qty3 = noNull(request.getParameter("qty3"));
                            qty4 = noNull(request.getParameter("qty4"));
                            qty5 = noNull(request.getParameter("qty5"));
                            qty6 = noNull(request.getParameter("qty6"));
                            qty7 = noNull(request.getParameter("qty7"));
                            qty8 = noNull(request.getParameter("qty8"));
                            qty9 = noNull(request.getParameter("qty9"));
                            qty10 = noNull(request.getParameter("qty10"));
                            qty11 = noNull(request.getParameter("qty11"));
                            qty12 = noNull(request.getParameter("qty12"));
                            qty13 = noNull(request.getParameter("qty13"));
                            qty14 = noNull(request.getParameter("qty14"));
                            qty15 = noNull(request.getParameter("qty15"));
                            qty16 = noNull(request.getParameter("qty16"));
                            qty17 = noNull(request.getParameter("qty17"));
                            qty18 = noNull(request.getParameter("qty18"));
                            qty19 = noNull(request.getParameter("qty19"));

                            //if(isBlank(qty16))
                            //    qty16 = "0.00";
                            //if(isBlank(qty16) || (qty16.trim()).equals("0"))
                            //    rate16 = "0.00";
                            //else{
                            try{
                                Double hdq16 = Double.parseDouble(qty16);
                            }catch (NumberFormatException nfex){
                                qty16 = "0.00";
                            }
                            //}
                            System.out.println("About to test for empty qtys");
                            System.out.println("Testing qtys for emptiness:" + ((!isBlank(qty1) 
                                && !isBlank(qty2) && !isBlank(qty3) && !isBlank(qty4) 
                                && !isBlank(qty5) && !isBlank(qty6) && !isBlank(qty7) && !isBlank(qty8)
                                && !isBlank(qty9) && !isBlank(qty10) && !isBlank(qty11) && !isBlank(qty12)
                                && !isBlank(qty13) && !isBlank(qty14) && !isBlank(qty15) && !isBlank(qty16)
                                && !isBlank(qty17) && !isBlank(qty18) && !isBlank(qty19))));
                            System.out.println("qty1: " + qty1);
                            System.out.println("qty5: " + qty5);
                            System.out.println("qty8: " + qty8);
                            System.out.println("qty12: " + qty12);
                            System.out.println("qty16: " + qty16);
                            System.out.println("qty17: " + qty17);
                            System.out.println("qty18: " + qty18);
                            System.out.println("qty19: " + qty19);

                            if((!isBlank(qty1) && !isBlank(qty2) && !isBlank(qty3) && !isBlank(qty4)  
                                && !isBlank(qty5) && !isBlank(qty6) && !isBlank(qty7) && !isBlank(qty8)
                                && !isBlank(qty9) && !isBlank(qty10) && !isBlank(qty11) && !isBlank(qty12)
                                && !isBlank(qty13) && !isBlank(qty14) && !isBlank(qty15) && !isBlank(qty16)
                                && !isBlank(qty17) && !isBlank(qty18) && !isBlank(qty19))) {
                                System.out.println("Point 00000000000000000000000000000");

                                cbdgtqties = new CBDGTQties(); 
                                try{
                                    cbdgtqties.setQuantity1(format("#,###.00", (Double.parseDouble(refmt(qty1)))));
                                    cbdgtqties.setQuantity2(format("#,###.00", (Double.parseDouble(refmt(qty2)))));
                                    cbdgtqties.setQuantity3(format("#,###.00", (Double.parseDouble(refmt(qty3)))));
                                    cbdgtqties.setQuantity4(format("#,###.00", (Double.parseDouble(refmt(qty4)))));
                                    cbdgtqties.setQuantity5(format("#,###.00", (Double.parseDouble(refmt(qty5)))));
                                    cbdgtqties.setQuantity6(format("#,###.00", (Double.parseDouble(refmt(qty6)))));
                                    cbdgtqties.setQuantity7(format("#,###.00", (Double.parseDouble(refmt(qty7)))));
                                    cbdgtqties.setQuantity8(format("#,###.00", (Double.parseDouble(refmt(qty8)))));
                                    cbdgtqties.setQuantity9(format("#,###.00", (Double.parseDouble(refmt(qty9)))));
                                    cbdgtqties.setQuantity10(format("#,###.00", (Double.parseDouble(refmt(qty10)))));
                                    cbdgtqties.setQuantity11(format("#,###.00", (Double.parseDouble(refmt(qty11)))));
                                    cbdgtqties.setQuantity12(format("#,###.00", (Double.parseDouble(refmt(qty12)))));
                                    cbdgtqties.setQuantity13(format("#,###.00", (Double.parseDouble(refmt(qty13)))));
                                    cbdgtqties.setQuantity14(format("#,###.00", (Double.parseDouble(refmt(qty14)))));
                                    cbdgtqties.setQuantity15(format("#,###.00", (Double.parseDouble(refmt(qty15)))));
                                    cbdgtqties.setQuantity16(format("#,###.00", (Double.parseDouble(refmt(qty16)))));
                                    cbdgtqties.setQuantity17(format("#,###.00", (Double.parseDouble(refmt(qty17)))));
                                    cbdgtqties.setQuantity18(format("#,###.00", (Double.parseDouble(refmt(qty18)))));
                                    cbdgtqties.setQuantity19(format("#,###.00", (Double.parseDouble(refmt(qty19)))));
                                }catch (NumberFormatException nfex){
                                    msg = "Some quantities are not entered.";
                                    errors.add(msg);
                                }
                                System.out.println("cbdgtqties.getQuantity1(): " + cbdgtqties.getQuantity1());
                                System.out.println("cbdgtqties.getQuantity2(): " + cbdgtqties.getQuantity2());
                                System.out.println("cbdgtqties.getQuantity3(): " + cbdgtqties.getQuantity3());
                                System.out.println("cbdgtqties.getQuantity4(): " + cbdgtqties.getQuantity4());
                                System.out.println("cbdgtqties.getQuantity5(): " + cbdgtqties.getQuantity5());
                                System.out.println("cbdgtqties.getQuantity6(): " + cbdgtqties.getQuantity6());
                                System.out.println("cbdgtqties.getQuantity7(): " + cbdgtqties.getQuantity7());
                                System.out.println("cbdgtqties.getQuantity8(): " + cbdgtqties.getQuantity8());
                                System.out.println("cbdgtqties.getQuantity9(): " + cbdgtqties.getQuantity9());
                                System.out.println("cbdgtqties.getQuantity10(): " + cbdgtqties.getQuantity10());
                                System.out.println("cbdgtqties.getQuantity11(): " + cbdgtqties.getQuantity11());
                                System.out.println("cbdgtqties.getQuantity12(): " + cbdgtqties.getQuantity12());
                                System.out.println("cbdgtqties.getQuantity13(): " + cbdgtqties.getQuantity13());
                                System.out.println("cbdgtqties.getQuantity14(): " + cbdgtqties.getQuantity14());
                                System.out.println("cbdgtqties.getQuantity15(): " + cbdgtqties.getQuantity15());
                                System.out.println("cbdgtqties.getQuantity16(): " + cbdgtqties.getQuantity16());
                                System.out.println("cbdgtqties.getQuantity17(): " + cbdgtqties.getQuantity17());
                                System.out.println("cbdgtqties.getQuantity18(): " + cbdgtqties.getQuantity18());
                                System.out.println("cbdgtqties.getQuantity19(): " + cbdgtqties.getQuantity19());

                                updatable = updatable + 1;
                            }else{
                                msg = msg + "Some quantities are not entered.";
                                errors.add(msg);
                            }
                            if(updatable == 1){
                                System.out.println("Existing record(rates) modified. Time: " + getCurrentDateTime() + "#");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                CropBDGTRemoteBusiness JNDI_NAME_CBDGT = (CropBDGTRemoteBusiness)ServiceLocator.getRemoteObject(context, "CBDGTGMP_REMOTE");
                                respmsg = cbdgtServices.modifyCBDGTQties(JNDI_NAME_CBDGT, cbdgtqties);  //, username.trim(), userRole.trim());
                                loggedtrail = (String)sess.getAttribute("loggedtrail");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                loggedtrail = loggedtrail + "Existing record(quantities) modified. Time: " + getCurrentDateTime() + "#";
                                //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                String loggeduserid = loggedUserid.getLoogeduserid();
                                //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                String loggedsummary = cunrDaytime.getUNRDaytime();
                                System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                Long userId = cuserId.getCusrid();
                                UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                cloggedInfos.setLoggeddetails(loggedtrail);
                                sess.setAttribute("cloggedInfos", cloggedInfos);
                                sess.setAttribute("loggedtrail", loggedtrail);
                            }
                            request.setAttribute("cbdgtqties", cbdgtqties);
                            request.setAttribute("respmsg", respmsg);
                            request.setAttribute("errors", errors);
                            rd = request.getRequestDispatcher("/updateBDGTVarsForm.jsp");
                            rd.include(request, response); 
                        } finally {
                            lupdatecpbdgtqty.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";
                        //ServletContext context = request.getServletContext();
                        cbdgtqties = (CBDGTQties)sess.getAttribute("cbdgtqties");
                        request.setAttribute("cbdgtqties", cbdgtqties);
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/updateBDGTVarsForm.jsp");
                        rd.include(request, response);
                    }
                    break;  
                case "usrncntrl":
                    errors = new ArrayList();
                    String usrname = null, logDate1, logDate2, loggeddetails = "";  //lgdetail, 
                    List<String> loggedsummaries = new ArrayList<>();
                    if(lusrncntrl.tryLock()){
                        try {
                            usrname = noNull(request.getParameter("usrname"));
                            logDate1 = noNull(request.getParameter("logDate1"));
                            logDate2 = noNull(request.getParameter("logDate2"));
                            //lgdetail = noNull(request.getParameter("lgdetail"));
                            if (isBlank(usrname)) {
                                errors.add("You must enter username date.");
                            }
                            if (isBlank(logDate1)) {
                                errors.add("You must enter starting date.");
                            }
                            if (isBlank(logDate2)) {
                                errors.add("You must enter ending date.");
                            }
                            if (!validateDate(logDate1)) {
                                errors.add("Starting date not valid.");
                            }
                            if (!validateDate(logDate2)) {
                                errors.add("Ending date not valid.");
                            }
                            
                            if(errors.isEmpty()){  // && lgdetail.isEmpty()){ 
                                logDate1 = properDate(logDate1);
                                logDate2 = properDate(logDate2);
                                
                                System.out.println("Logged summaries for " + usrname.toUpperCase().trim() + " accessed. Time: " + getCurrentDateTime() + "#");
                                
                                respmsg = "Logging of summaries successful";
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                loggedsummaries = audtrailServices.loggedSummaries(JNDI_NAME_USERTRAIL, usrname.trim(), logDate1.trim(), logDate2.trim());
                                loggedtrail = (String)sess.getAttribute("loggedtrail");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                loggedtrail = loggedtrail + "Logged summaries for " + usrname.trim() + " accessed. Time: " + getCurrentDateTime() + "#";
                                //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                String loggeduserid = loggedUserid.getLoogeduserid();
                                //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                String loggedsummary = cunrDaytime.getUNRDaytime();
                                System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                Long userId = cuserId.getCusrid();
                                //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                cloggedInfos.setLoggeddetails(loggedtrail);
                                sess.setAttribute("cloggedInfos", cloggedInfos);
                                sess.setAttribute("loggedtrail", loggedtrail);
                            }
                            if(loggedsummaries == null)
                                loggedsummaries = Collections.EMPTY_LIST;
                            CLoggedSummaries cloggedSummaries = new CLoggedSummaries();
                            cloggedSummaries.setLoggedSummaries(loggedsummaries);
                            sess.setAttribute("cloggedSummaries", cloggedSummaries);
                            //sess.setAttribute("loggeddetails", loggeddetails);
                            System.out.println("loggedsummaries: " + loggedsummaries.size());
                            request.setAttribute("loggedsummaries", loggedsummaries);
                            request.setAttribute("loggeddetails", loggeddetails);
                            sess.setAttribute("usrname", usrname);
                            sess.setAttribute("logDate1", logDate1);
                            sess.setAttribute("logDate2", logDate2);
                            request.setAttribute("respmsg", respmsg);
                            request.setAttribute("errors", errors);                                                        
                            rd = request.getRequestDispatcher("/auditTrail.jsp");
                            rd.include(request, response);
                        } finally {
                            lusrncntrl.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";
                        //ServletContext context = request.getServletContext();
                        //cbdgtqties = (CBDGTQties)context.getAttribute("cbdgtqties");
                        //request.setAttribute("cbdgtqties", cbdgtqties);
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/auditTrail.jsp");
                        rd.include(request, response);
                    }
                    break;
                case "loggedcntrl":
                    errors = new ArrayList();                    
                    //loggeddetails = "";
                    //loggedsummaries = new ArrayList<>();
                    //if(loggedsummaries == null)
                    //    loggedsummaries = Collections.EMPTY_LIST;
                    //ctrlNamesVals.put(ctrlStr, valStr);
                    
                    if(lloggedcntrl.tryLock()){
                        try {
                            String lgdetail = ctrlNamesVals.get("loggedcntrl");
                            //lgdetail = noNull(request.getParameter("lgdetail"));
                            System.out.println("lgdetail: " + lgdetail); 
                            usrname = noNull(request.getParameter("username"));
                            loggeddetails = "";                    
                            if(!lgdetail.isEmpty()){
                                UserTrailRemoteBusiness JNDI_NAME_USERTRAIL = (UserTrailRemoteBusiness)ServiceLocator.getRemoteObject(context, "USERTRAIL_REMOTE");
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                loggeddetails = audtrailServices.loggedDetails(JNDI_NAME_USERTRAIL, lgdetail.trim());
                                loggedtrail = (String)sess.getAttribute("loggedtrail");
                                respmsg = "Logging of details successful";
                                //sess.setAttribute("loggedtrail", loggedtrail);
                                /*
                                loggedtrail = loggedtrail + "Logged details for " + usrname.trim() + " accessed. Time: " + getCurrentDateTime() + "#";
                                //LOGGEDUserid loggedUserid = new LOGGEDUserid();
                                LOGGEDUserid loggedUserid = (LOGGEDUserid)sess.getAttribute("loggedUserid");
                                String loggeduserid = loggedUserid.getLoogeduserid();
                                //CUNRDaytime cunrDaytime = new CUNRDaytime();
                                CUNRDaytime cunrDaytime = (CUNRDaytime)sess.getAttribute("cunrDaytime");
                                String loggedsummary = cunrDaytime.getUNRDaytime();
                                System.out.println("loggeduserid, loggedtrail.trim(): " + loggeduserid + ", " + loggedtrail.trim());
                                CUserId cuserId = (CUserId)sess.getAttribute("cuserId");
                                Long userId = cuserId.getCusrid();                                
                                //audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, userId, loggedsummary, loggedtrail);
                                audtrailServices.updateUserDetails(JNDI_NAME_USERTRAIL, loggeduserid, loggedtrail);
                                //CLoggedInfos cloggedInfos = new CLoggedInfos();
                                */
                                cloggedInfos = (CLoggedInfos)sess.getAttribute("cloggedInfos");
                                cloggedInfos.setLoggeddetails(loggedtrail);
                                sess.setAttribute("cloggedInfos", cloggedInfos);
                                sess.setAttribute("loggedtrail", loggedtrail);
                            }
                            CLoggedSummaries cloggedSummaries = (CLoggedSummaries)sess.getAttribute("cloggedSummaries");
                            //loggeddetails = (String)sess.getAttribute("loggeddetails");
                            request.setAttribute("loggedsummaries", cloggedSummaries.getLoggedSummaries());
                            request.setAttribute("loggeddetails", loggeddetails);
                            request.setAttribute("usrname", usrname);
                            request.setAttribute("respmsg", respmsg);
                            request.setAttribute("errors", errors);                                                        
                            rd = request.getRequestDispatcher("/auditTrail.jsp");
                            rd.include(request, response);
                        } finally {
                            lloggedcntrl.unlock();
                        }
                    } else {
                        errors = (List) request.getAttribute("errors");
                        if(errors == null)                    
                            errors = Collections.EMPTY_LIST;
                        respmsg = "PROTECTED STATE STILL LOCKED BY A USER.";
                        //ServletContext context = request.getServletContext();
                        //cbdgtqties = (CBDGTQties)context.getAttribute("cbdgtqties");
                        //request.setAttribute("cbdgtqties", cbdgtqties);
                        request.setAttribute("respmsg", respmsg);
                        request.setAttribute("errors", errors);
                        rd = request.getRequestDispatcher("/auditTrail.jsp");
                        rd.include(request, response);
                    }
                    break;
                default:                    
                    
                    break;
            }
        }
    }
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        try { 
            super.service(request, response);
            Thread.currentThread().isAlive();
        }finally {

        }
    }
    
    @Override
    public void destroy(){
        
    }
    //protected CropBDGTRemoteBusiness getCropBudget(){
    //    return JNDI_NAME_CBDGT;
    //}
    
    //protected String getUserNameVal(){
    //    return userlogin;
    //}
    
    //protected String getUserPswdVal(){
    //    return psswdlogin;
    //}
    
    //protected String getReqServVal(){
    //    return reqservice;
    //}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>  
    
   // protected Context getInitialContext(){
   //     return namingContext;
   // } 
    
    private static String noNull(String s) {
        return s == null ? "" : s;
    }
    
    private boolean isBlank(String s) {
        return s == null || s.trim().length() == 0; 
    }
    
    private static String validStr(String s) {
        if(s == null || s.trim().length() == 0)
            s = " "; 
        return s;
    }
    
    private boolean hasAddingUserRoles(String role){
        boolean inRole;
        switch (role) {
            case Roles.ADMIN: 
                inRole = true;
                break;
            default:
                inRole = false;
                break;
        }
        return inRole;
    }

    private boolean hasDataEntryRoles(String role){
        boolean inRole;
        switch (role) {
            case Roles.ADMIN: case Roles.SUPERVISORY:
                inRole = true;
                break;
            default:
                inRole = false;
                break;
        }
        return inRole;
    }

    private boolean hasReportAccessRoles(String role){
        boolean inRole;
        switch (role) {
            case Roles.ADMIN: case Roles.SUPERVISORY: case Roles.PUBLIC:
                inRole = true;
                break;
            default:
                inRole = false;
                break;
        }
        return inRole;
    }
        
    private String format(String pattern, double value ) {
            
            //String strinvestment = custformat.customFormat("#,###.00", investment*10000);
            //String ftcashinflow = custformat.customFormat("#,###.00", cashinflow*10000);
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(value);
    }
        
    private String getCurrentDateTime() {

	DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        String currentDateTime;
	// Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
	//LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        LocalDateTime dateTimeNow = LocalDateTime.now();
	ZoneId dateTimeNowZone = ZoneId.of("Africa/Lagos"); 
	ZonedDateTime currentDT = ZonedDateTime.of(dateTimeNow, dateTimeNowZone);
	try {
    		//String out1 = currentDT.format(format);
                currentDateTime = currentDT.format(format);
    		System.out.printf("LEAVING:  %s (%s)%n", currentDateTime, dateTimeNowZone);
	} catch (DateTimeException exc) {
    		System.out.printf("%s can't be formatted!%n", currentDT);
    		throw exc;
	}
	return currentDateTime;
    }
    
    public CLYPIDnums getPKS(String dtstr)  {
        String dstr = (dtstr == null) ? "0" : dtstr;
        String ids1,ids2,ids3,ids4;
        int dlen,s1,s2,s3,s4;
        int cpid,locid,yrid,pltid;
        dstr = dstr.trim();
        dlen = dstr.length();
        s1 = dstr.indexOf('!', 1);
        s2 = dstr.indexOf('!', s1 + 1);
        s3 = dstr.indexOf('!', s2 + 1);
        s4 = dstr.indexOf('!', s3 + 1);
        System.out.println("s1, s2, s3, s4: " + s1 + ", " + s2 + ", " + s3 + ", " + s4);
        ids1 = dstr.substring(1, s1);
        ids2 = dstr.substring(s1+1, s2);
        ids3 = dstr.substring(s2+1, s3);
        ids4 = dstr.substring(s3+1, s4);
        System.out.println("ids1, ids2, ids3, ids4: " + ids1 + ", " + ids2 + ", " + ids3 + ", " + ids4);
        CLYPIDnums clypids = null;
        try{
            cpid = Integer.parseInt(ids1);
            locid = Integer.parseInt(ids2);
            yrid = Integer.parseInt(ids3);
            pltid = Integer.parseInt(ids4);
            clypids = new CLYPIDnums(cpid,locid,yrid,pltid);
        } catch (NumberFormatException e) {
		System.out.println("Exception: " + e.getMessage());
        }
        return clypids;
    }
    
    public CLYPTVars getCLPTNames(String dtstr)  {
        String dstr = (dtstr == null) ? "0" : dtstr;
        String ids1,ids2,ids3,ids4;
        int dlen,s1,s2,s3,s4,s5,s6,s7,s8,yrval;
        String cpstr,locstr,pltstr;
        dstr = dstr.trim();
        dlen = dstr.length();
        s1 = dstr.indexOf('!', 1);
        s2 = dstr.indexOf('!', s1 + 1);
        s3 = dstr.indexOf('!', s2 + 1);
        s4 = dstr.indexOf('!', s3 + 1);
        s5 = dstr.indexOf('!', s4 + 1);
        s6 = dstr.indexOf('!', s5 + 1);
        s7 = dstr.indexOf('!', s6 + 1);
        s8 = dstr.indexOf('!', s7 + 1);
        System.out.println("s5, s6, s7, s8: " + s5 + ", " + s6 + ", " + s7 + ", " + s8);
        ids1 = dstr.substring(s4+1, s5);
        ids2 = dstr.substring(s5+1, s6);
        ids3 = dstr.substring(s6+1, s7);
        ids4 = dstr.substring(s7+1, s8);
        System.out.println("ids1, ids2, ids3, ids4: " + ids1 + ", " + ids2 + ", " + ids3 + ", " + ids4);        
        cpstr = ids1;
        locstr = ids2;
        CLYPTVars clyptvats = null;
        try{
            yrval = Integer.parseInt(ids3);
            pltstr = ids4;
            clyptvats = new CLYPTVars(cpstr,locstr,yrval,pltstr);
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return clyptvats;
    }
    
    private String refmt(String dtstr)  {
            String dstr = (dtstr == null) ? "0.00" : dtstr;
            String ids1,valstr = "";
            int dlen;
            dstr = dstr.trim();
            dlen = dstr.length();
            
            try{
                for (int i = 0; i < dlen; i++){
                    ids1 = dstr.substring(i, i + 1);
                    if(!ids1.equals(",")) 
                        valstr = valstr + ids1;
                }
                System.out.println("dstr, valstr: " + dstr + ", " + valstr);
            } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
            }
            return valstr;
    }
    
    private boolean validateDate(String s) {
        char ch;
        if(((s.length() < 8 || s.length() > 10))) {
            return false;
        }
        if(s.length() == 8){
            for(int i = 0; i < 8; i++){
                ch = s.charAt(i);
                if(i == 1 || i == 3){
                    if(ch != '/')
                        return false;
                } else if(!Character.isDigit(ch)){
                    return false;
                }
            }
            //return true;
        }else if(s.length() == 9){
            for(int i = 0; i < 9; i++){
                ch = s.charAt(i);
                if(i == 1 || i == 2 || i == 4){
                    if(ch != '/')
                        return false;
                } else if(!Character.isDigit(ch)){
                    return false;
                }
            }
            //return true;
        }else if(s.length() == 10){
            for(int i = 0; i < 10; i++){
                ch = s.charAt(i);
                if(i == 2 || i == 5){
                    if(ch != '/')
                        return false;
                } else if(!Character.isDigit(ch)){
                    return false;
                }
            }
            //return true;
        }
        return true;
    }
    
    private String properDate(String s) {
        StringBuilder sbd = new StringBuilder();
        char ch;
        int cnt = 0;
        s = s.trim();
        if(s.length() == 8){
            for(int i = 0; i < 8; i++){
                ch = s.charAt(i);
                if(cnt == 0 || cnt == 2)
                    sbd.append('0');
                sbd.append(ch);
                cnt++;
            }
            //return sbd.toString();
        }else if(s.length() == 9){
            if(s.charAt(2) == '/' && s.charAt(4) == '/'){
                for(int i = 0; i < 9; i++){
                    ch = s.charAt(i);
                    if(cnt == 3)
                        sbd.append('0');
                    sbd.append(ch);
                    cnt++;
                }
                //return sbd.toString();
            }else if(s.charAt(1) == '/' && s.charAt(4) == '/'){
                for(int i = 0; i < 9; i++){
                    ch = s.charAt(i);
                    if(cnt == 0)
                        sbd.append('0');
                    sbd.append(ch);
                    cnt++;
                }
                //return sbd.toString();
            }
        }else if(s.length() == 10){           
            for(int i = 0; i < 10; i++){
                ch = s.charAt(i);
                sbd.append(ch);
            }
            //return sbd.toString();
        }
        return sbd.toString();
    }
}
