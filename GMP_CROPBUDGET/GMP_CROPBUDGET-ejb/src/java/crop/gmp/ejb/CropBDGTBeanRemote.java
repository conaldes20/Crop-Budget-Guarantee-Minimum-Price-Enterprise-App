/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.ejb;

//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import crop.gmp.intface.CropBDGTRemoteBusiness;
import crop.gmp.model.Cbcrop;
//import crop.gmp.model.Cbcrop_;
import crop.gmp.model.Cblocation;
import crop.gmp.model.Cbplantingtype;
import crop.gmp.model.Cbquantity;
import crop.gmp.model.Cbvarrate;
import crop.gmp.model.Cbyear;
import crop.gmp.util.CBDGTAmounts;
import crop.gmp.util.CBDGTParams;
import crop.gmp.util.CBDGTQties;
import crop.gmp.util.CLYPIDnums;
import crop.gmp.util.CLYPTVars;
import crop.gmp.util.CropbudgetVars;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.ParameterExpression;
//import javax.persistence.criteria.Path;
//import javax.persistence.criteria.Root;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
//import org.apache.log4j.Logger;
/**
 *
 * @author user
 */
@Stateless
public class CropBDGTBeanRemote implements CropBDGTRemoteBusiness {

        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")
        private static final Logger log = Logger.getLogger(CropBDGTBeanRemote.class.getName());	
        private String msg = " ";
        
        @PersistenceContext(unitName="GMP_CROPBUDGET-ejbPU", type=PersistenceContextType.TRANSACTION)
        private EntityManager entityManager;
	
	@Override
	public String enterData(final CropbudgetVars cropbdgtvars, final CLYPTVars clyptvars)  //, final String username, final String role)
	{
            //String sql = "insert into cbvarrate (cropId,locationId,yearId,pltypeId,varrate1,varrate2,varrate3,varrate4,varrate5,varrate6,varrate7,varrate8,varrate9," +
            //    "varrate10,varrate11,varrate12,varrate13,varrate14,varrate15,varrate16,varrate17,varrate18,varrate19) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println("enterData 00");
            System.out.println("clyptvars => " + clyptvars.getCrop() + ", " + clyptvars.getLocation() + ", " + clyptvars.getYeear() + ", " + clyptvars.getPltype());
            //Query query;
            try{
                //entityManager.getTransaction().begin();
                int cropid = getCropIdNum(clyptvars.getCrop());
                Cbcrop cbcrop = new Cbcrop();
                cbcrop.setCropid(cropid);
                cbcrop.setCrop(clyptvars.getCrop());
                int locationid = getLocationIdNum(clyptvars.getLocation());
                Cblocation cblocation = new Cblocation();
                cblocation.setLocationid(locationid);
                cblocation.setLocation(clyptvars.getLocation());
                int yearid = getYearIdNum(clyptvars.getYeear());
                Cbyear cbyear = new Cbyear();
                cbyear.setYearid(yearid);
                cbyear.setYeear(clyptvars.getYeear());
                int plttypeid = getPltypeIdNum(clyptvars.getPltype());
                Cbplantingtype cbplantingtype = new Cbplantingtype();
                cbplantingtype.setPltypeid(plttypeid);
                cbplantingtype.setPltype(clyptvars.getPltype());
                System.out.println("cropid, locationid, yearid, plttypeid => " + cropid + ", " + locationid + ", " + yearid + ", " + plttypeid);
                Cbvarrate cbvarrate = new Cbvarrate();
                cbvarrate.setCropid(cropid);
                cbvarrate.setLocationid(locationid);
                cbvarrate.setYearid(yearid);
                cbvarrate.setPltypeid(plttypeid);
                cbvarrate.setVarrate1(cropbdgtvars.getVarrate1());
                cbvarrate.setVarrate2(cropbdgtvars.getVarrate2());
                cbvarrate.setVarrate3(cropbdgtvars.getVarrate3());
                cbvarrate.setVarrate4(cropbdgtvars.getVarrate4());
                cbvarrate.setVarrate5(cropbdgtvars.getVarrate5());
                cbvarrate.setVarrate6(cropbdgtvars.getVarrate6());
                cbvarrate.setVarrate7(cropbdgtvars.getVarrate7());
                cbvarrate.setVarrate8(cropbdgtvars.getVarrate8());
                cbvarrate.setVarrate9(cropbdgtvars.getVarrate9());
                cbvarrate.setVarrate10(cropbdgtvars.getVarrate10());
                cbvarrate.setVarrate11(cropbdgtvars.getVarrate11());
                cbvarrate.setVarrate12(cropbdgtvars.getVarrate12());
                cbvarrate.setVarrate13(cropbdgtvars.getVarrate13());
                cbvarrate.setVarrate14(cropbdgtvars.getVarrate14());
                cbvarrate.setVarrate15(cropbdgtvars.getVarrate15());
                cbvarrate.setVarrate16(cropbdgtvars.getVarrate16());
                cbvarrate.setVarrate17(cropbdgtvars.getVarrate17());
                cbvarrate.setVarrate18(cropbdgtvars.getVarrate18());
                cbvarrate.setVarrate19(cropbdgtvars.getVarrate19());                
                entityManager.persist(cbvarrate);
                System.out.println("enterData 11");
                
                System.out.println("enterData => Action successfully performed.");
                msg = "Rates successfully performed.\n";
                //entityManager.getTransaction().commit();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                msg = "Rates not successfully performed.\n";
            }
            return msg;
        }
        
        @Override
	public String enterQTYData(final CBDGTQties cbdgtqties)  //, final String username, final String role)
	{
                Cbquantity cbquantity = new Cbquantity();
                try{                
                    cbquantity.setQuantity1(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity1()))));
                    cbquantity.setQuantity2(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity2()))));
                    cbquantity.setQuantity3(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity3()))));
                    cbquantity.setQuantity4(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity4()))));
                    cbquantity.setQuantity5(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity5()))));
                    cbquantity.setQuantity6(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity6()))));
                    cbquantity.setQuantity7(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity7()))));
                    cbquantity.setQuantity8(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity8()))));
                    cbquantity.setQuantity9(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity9()))));
                    cbquantity.setQuantity10(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity10()))));
                    cbquantity.setQuantity11(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity11()))));
                    cbquantity.setQuantity12(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity12()))));
                    cbquantity.setQuantity13(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity13()))));
                    cbquantity.setQuantity14(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity14()))));
                    cbquantity.setQuantity15(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity15()))));
                    cbquantity.setQuantity16(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity16()))));
                    cbquantity.setQuantity17(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity17()))));
                    cbquantity.setQuantity18(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity18()))));
                    cbquantity.setQuantity19(BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity19()))));
                    entityManager.persist(cbquantity);
                    msg = "Quantities successfully entered.\n";
                }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                    System.out.println("Exception: " + nniex.getMessage());
                    msg = "Quantities not successfully entered.\n";
                }
                return msg;
        }
        
        @Override
        public String modifyData(final CropbudgetVars cropbdgtvars, final CLYPTVars clyptvars)  //, final String username, final String role)
	{
            try{
                //entityManager.getTransaction().begin(); 
                
                int cropid = getCropIdNum(clyptvars.getCrop());
                Cbcrop cbcrop = new Cbcrop();
                cbcrop.setCropid(cropid);
                cbcrop.setCrop(clyptvars.getCrop());
                //entityManager.merge(cbcrop);
                int locationid = getLocationIdNum(clyptvars.getLocation());
                Cblocation cblocation = new Cblocation();
                cblocation.setLocationid(locationid);
                cblocation.setLocation(clyptvars.getLocation());
                //entityManager.merge(cblocation);
                int yearid = getYearIdNum(clyptvars.getYeear());
                Cbyear cbyear = new Cbyear();
                cbyear.setYearid(yearid);
                cbyear.setYeear(clyptvars.getYeear());
                //entityManager.merge(cbyear);
                int plttypeid = getPltypeIdNum(clyptvars.getPltype());
                Cbplantingtype cbplantingtype = new Cbplantingtype();
                cbplantingtype.setPltypeid(plttypeid);
                cbplantingtype.setPltype(clyptvars.getPltype());
                //entityManager.merge(cbplantingtype); 
                System.out.println("Update: cropid, locationid, yearid, plttypeid => " + cropid + ", " + locationid + ", " + yearid + ", " + plttypeid);
                Cbvarrate cbvarrate;  // = new Cbvarrate();
                //try{
                Query query;  // = entityManager.createNamedQuery("Cbvarrate.findByUniqueKey");
                //System.out.println("(public void logon) username, password: " + username + ", " + password);
                String SQL = "SELECT * FROM cbvarrate WHERE cropid = "  + cropid + " AND locationid = "  + locationid + " AND yearid = "  + yearid + " AND pltypeid = " + plttypeid + "";
            
                query = entityManager.createNativeQuery(SQL);
                List<Object[]> valueArray = query.getResultList();
                cbvarrate = new Cbvarrate(); 
                
                System.out.println("valueArray.size(): " + valueArray.size());
                Integer cbvarrid = null;
                for ( Object[] values : valueArray ) {
                    cbvarrid = (Integer)values[0];
                    System.out.println("cbvarrid = (Integer)values[0]: " + (Integer)values[0]);
                    cbvarrate.setVarrate1((BigDecimal)values[5]);
                    System.out.println("(BigDecimal)values[5]: " + (BigDecimal)values[5]);
                    cbvarrate.setVarrate2((BigDecimal)values[6]);
                    System.out.println("(BigDecimal)values[6]: " + (BigDecimal)values[6]);
                    cbvarrate.setVarrate3((BigDecimal)values[7]);
                    cbvarrate.setVarrate4((BigDecimal)values[8]);
                    cbvarrate.setVarrate5((BigDecimal)values[9]);
                    cbvarrate.setVarrate6((BigDecimal)values[10]);
                    cbvarrate.setVarrate7((BigDecimal)values[11]);
                    cbvarrate.setVarrate8((BigDecimal)values[12]);
                    cbvarrate.setVarrate9((BigDecimal)values[13]);
                    cbvarrate.setVarrate10((BigDecimal)values[14]);
                    cbvarrate.setVarrate11((BigDecimal)values[15]);
                    cbvarrate.setVarrate12((BigDecimal)values[16]);
                    cbvarrate.setVarrate13((BigDecimal)values[17]);
                    cbvarrate.setVarrate14((BigDecimal)values[18]);
                    cbvarrate.setVarrate15((BigDecimal)values[19]);
                    cbvarrate.setVarrate16((BigDecimal)values[20]);
                    cbvarrate.setVarrate17((BigDecimal)values[21]);
                    cbvarrate.setVarrate18((BigDecimal)values[22]);
                    cbvarrate.setVarrate19((BigDecimal)values[23]);
                } 
                System.out.println("valueArray.size(): " + valueArray.size());
                System.out.println("(Before testing cbvarrate for null");
                System.out.println("(cbvarrate.getVarrateid(): " + cbvarrate.getVarrateid());               

                msg = "Successfully authenticated.";    
                SQL = "UPDATE cbvarrate " +
                        "SET varrate1 = " + cropbdgtvars.getVarrate1() + ", " +
                        " varrate2 = " + cropbdgtvars.getVarrate2() + ", " +
                        " varrate3 = " + cropbdgtvars.getVarrate3() + ", " +
                        " varrate4 = " + cropbdgtvars.getVarrate4() + ", " +
                        " varrate5 = " + cropbdgtvars.getVarrate5() + ", " +
                        " varrate6 = " + cropbdgtvars.getVarrate6() + ", " +
                        " varrate7 = " + cropbdgtvars.getVarrate7() + ", " +
                        " varrate8 = " + cropbdgtvars.getVarrate8() + ", " +
                        " varrate9 = " + cropbdgtvars.getVarrate9() + ", " +
                        " varrate10 = " + cropbdgtvars.getVarrate10() + ", " +
                        " varrate11 = " + cropbdgtvars.getVarrate11() + ", " +
                        " varrate12 = " + cropbdgtvars.getVarrate12() + ", " +
                        " varrate13 = " + cropbdgtvars.getVarrate13() + ", " +
                        " varrate14 = " + cropbdgtvars.getVarrate14() + ", " +
                        " varrate15 = " + cropbdgtvars.getVarrate15() + ", " +
                        " varrate16 = " + cropbdgtvars.getVarrate16() + ", " +
                        " varrate17 = " + cropbdgtvars.getVarrate17() + ", " +
                        " varrate18 = " + cropbdgtvars.getVarrate18() + ", " +
                        " varrate19 = " + cropbdgtvars.getVarrate19() + "" +
                        " WHERE varrateid = " + cbvarrid + "";   
                    
                query = entityManager.createNativeQuery(SQL);
                int done = query.executeUpdate();
                msg = "Update Action successfully performed.\n";
                System.out.println("Updating of Rates successfully performed.\n ");
                //entityManager.getTransaction().commit();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                msg = "Update Action not successfully performed.\n";
            }
            return msg;
        }
        
        @Override
        public String modifyQties(final CBDGTQties cbdgtqties)  //, final String username, final String role)
	{
            Query query;  
            String SQL; 
            Integer cbqtyid = 100002;
            try{                 
                SQL = "UPDATE cbquantity " +
                        "SET quantity1 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity1())))) + ", " +
                        " quantity2 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity2())))) + ", " +
                        " quantity3 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity3())))) + ", " +
                        " quantity4 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity4())))) + ", " +
                        " quantity5 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity5())))) + ", " +
                        " quantity6 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity6())))) + ", " +
                        " quantity7 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity7())))) + ", " +
                        " quantity8 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity8())))) + ", " +
                        " quantity9 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity9())))) + ", " +
                        " quantity10 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity10())))) + ", " +
                        " quantity11 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity11())))) + ", " +
                        " quantity12 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity12())))) + ", " +
                        " quantity13 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity13())))) + ", " +
                        " quantity14 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity14())))) + ", " +
                        " quantity15 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity15())))) + ", " +
                        " quantity16 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity16())))) + ", " +
                        " quantity17 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity17())))) + ", " +
                        " quantity18 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity18())))) + ", " +
                        " quantity19 = " + (BigDecimal.valueOf(Double.parseDouble(refmt(cbdgtqties.getQuantity19())))) + "" +
                        " WHERE quantityid = " + cbqtyid + "";                 
                    
                query = entityManager.createNativeQuery(SQL);
                int done = query.executeUpdate();
                msg = "Update Action successfully performed.\n";
                System.out.println("Updating of Quantities successfully performed.\n ");
                //entityManager.getTransaction().commit();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                msg = "Update Action not successfully performed.\n";
            }
            return msg;
        }

        @Override
        public String updatingLists(final String crop, final String location, final String farmtype) {  
            System.out.println("updatingLists => crop, location, farmtype (Have valid values): " + crop + ", " + location + ", " + farmtype);
            try{
                if(crop.trim().length() != 0){                    
                    int crpsn = getNumberOfCrops();
                    crpsn = crpsn + 1;
                    Cbcrop cbcrop = new Cbcrop(crpsn, crop.trim());
                    System.out.println("entityManager.persist(cbcrop)");
                    entityManager.persist(cbcrop);
                    System.out.println("Crop inserted successfully.");
                    msg = "Crop update successfully.";
                }
                if(location.trim().length() != 0){
                    int locsn = getNumberOfLocations();
                    locsn = locsn + 1;
                    Cblocation cblocation = new Cblocation(locsn, location.trim());
                    System.out.println("entityManager.persist(cblocation)");
                    entityManager.persist(cblocation);
                    System.out.println("Location inserted successfully.");
                    msg = "Location update successfully.";
                }
                if(farmtype.trim().length() != 0){
                    int pltsn = getNumberOfPlttypes();
                    pltsn = pltsn + 1;
                    Cbplantingtype cbplantingtype = new Cbplantingtype(pltsn, farmtype.trim());
                    System.out.println("entityManager.persist(cbplantingtype)");
                    entityManager.persist(cbplantingtype);
                    System.out.println("FarmingType inserted successfully.");
                    msg = "Farming type update successfully.";
                }
                System.out.println("Updating of Crop/Location/FarmingType table(s) successful.");
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                msg = "Update action not successfully executed.";
            }
            return msg;
        }
        
        @Override
        public List<String> cropList()
	{    
            List<String> crops = new ArrayList();
            List<Cbcrop> cbcrops;  // = null; 
            //final String querySTR = "SELECT u FROM User u";
            System.out.println("CropList() => 0");
            try{
                Query query = entityManager.createNamedQuery("Cbcrop.findAll");
                System.out.println("CropList() => 1");
                cbcrops = query.getResultList();
                System.out.println("(cbcrops.size())): " + Integer.toString(cbcrops.size()));  
                System.out.println("(cbcrops.isEmpty()): " + Boolean.toString(cbcrops.isEmpty()));
                System.out.println("CropList() => 2");
                if(cbcrops.isEmpty()){
                    System.out.println("cbcrops.isEmpty() " + cbcrops.isEmpty());
                    //crops.add("NA");
                }else {
                    for(Cbcrop cbcrop: cbcrops){
                       String cpStr = cbcrop.getCrop();
                       crops.add(cpStr);
                    }
                }
                log.info("CropList() => 3");
                System.out.println("CropList() => 3");
                System.out.println("(cbcrops == null): " + (cbcrops == null));
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(cbcrops == null). No entity returned.");
                crops = Collections.EMPTY_LIST;
            }
            return crops;
	}
        
        @Override
        public List<String> locationList()
	{    
            List<String> locations = new ArrayList();
            List<Cblocation> cblocations;  // = null; 
            //final String querySTR = "SELECT u FROM User u";
            System.out.println("CropList() => 0");
            try{
                Query query = entityManager.createNamedQuery("Cblocation.findAll");
                System.out.println("LocationList() => 1");
                cblocations = query.getResultList();
                System.out.println("(cblocations.size())): " + Integer.toString(cblocations.size()));  //info(Integer.toString(usernamesRoles.size()));
                System.out.println("(cblocations.isEmpty()): " + Boolean.toString(cblocations.isEmpty()));
                System.out.println("LocationList() => 2");
                if(cblocations.isEmpty()){
                    System.out.println("cblocations.isEmpty() " + cblocations.isEmpty());
                    //crops.add("NA");
                }else {
                    for(Cblocation cblocation: cblocations){
                       String locStr = cblocation.getLocation();
                       locations.add(locStr);
                    }
                }
                log.info("LocationList() => 3");
                System.out.println("LocationList() => 3");
                System.out.println("(cblocations == null): " + (cblocations == null));
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(cblocations == null). No entity returned.");
                locations = Collections.EMPTY_LIST;
            }
            return locations;
	}
        
        @Override
        public List<String> plantingtypeList()
	{    
            List<String> plantingtypes = new ArrayList();
            List<Cbplantingtype> cbplantingtypes;  // = null; 
            //final String querySTR = "SELECT u FROM User u";
            System.out.println("CropList() => 0");
            try{
                Query query = entityManager.createNamedQuery("Cbplantingtype.findAll");
                System.out.println("PlantingtypeList() => 1");
                cbplantingtypes = query.getResultList();
                System.out.println("(cbplantingtypes.size())): " + Integer.toString(cbplantingtypes.size()));  //info(Integer.toString(usernamesRoles.size()));
                System.out.println("(cbplantingtypes.isEmpty()): " + Boolean.toString(cbplantingtypes.isEmpty()));
                System.out.println("PlantingtypeList() => 2");
                if(cbplantingtypes.isEmpty()){
                    System.out.println("cbplantingtypes.isEmpty() " + cbplantingtypes.isEmpty());
                    //crops.add("NA");
                }else {
                    for(Cbplantingtype cbplantingtype: cbplantingtypes){
                       String locStr = cbplantingtype.getPltype();
                       plantingtypes.add(locStr);
                    }
                }
                System.out.println("(cbplantingtypes == null): " + (cbplantingtypes == null));
                log.info("PlantingtypeList() => 3");
                System.out.println("PlantingtypeList() => 3");
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(cbplantingtype == null). No entity returned.");
                plantingtypes = Collections.EMPTY_LIST;
            }
            return plantingtypes;
	}        
        
        @Override
        public List<String> yearList()
	{    
            List<String> years = new ArrayList();
            List<Cbyear> cbyears;  // = null; 
            //final String querySTR = "SELECT u FROM User u";
            System.out.println("YearList() => 0");
            try{
                Query query = entityManager.createNamedQuery("Cbyear.findAll");
                System.out.println("YearList() => 1");
                cbyears = query.getResultList();
                System.out.println("(cbyears.size())): " + Integer.toString(cbyears.size()));  //info(Integer.toString(usernamesRoles.size()));
                System.out.println("(cbyears.isEmpty()): " + Boolean.toString(cbyears.isEmpty()));
                System.out.println("YearList() => 2");
                if(cbyears.isEmpty()){
                    System.out.println("cbyears.isEmpty() " + cbyears.isEmpty());
                    //years.add("NA");
                }else {
                    for(Cbyear cbyear: cbyears){
                       String yrStr = (Integer.toString(cbyear.getYeear()));
                       years.add(yrStr);
                    }
                }
                System.out.println("(cbyears == null): " + (cbyears == null));
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("(cbyears == null). No entity returned.");
                years = Collections.EMPTY_LIST;
            }
            log.info("YearList() => 3");
            System.out.println("YearList() => 3");
            return years;
	}
        
        @Override
        public String getMSG() {
            if(msg == null) 
                msg = "No service.\n";
            return msg;
        }
        
        private int getNumberOfCrops() {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbcrop.findAll");
		List<Cbcrop> beanlist = query.getResultList();
		Cbcrop[] array = new Cbcrop[beanlist.size()];
                System.out.println("Cbcrop[beanlist.size()]: " + beanlist.toArray(array).length);
		return beanlist.toArray(array).length;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getNumberOfLocations() {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cblocation.findAll");
		List<Cblocation> beanlist = query.getResultList();
		Cblocation[] array = new Cblocation[beanlist.size()];
                System.out.println("Cblocation[beanlist.size()]: " + beanlist.toArray(array).length);
		return beanlist.toArray(array).length;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getNumberOfYears() {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbyear.findAll");
		List<Cbyear> beanlist = query.getResultList();
		Cbyear[] array = new Cbyear[beanlist.size()];
                System.out.println("Cbyear[beanlist.size()]: " + beanlist.toArray(array).length);
		return beanlist.toArray(array).length;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getNumberOfPlttypes() {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbplantingtype.findAll");
		List<Cbplantingtype> beanlist = query.getResultList();
		Cbplantingtype[] array = new Cbplantingtype[beanlist.size()];
                System.out.println("Cbplantingtype[beanlist.size()]: " + beanlist.toArray(array).length);
		return beanlist.toArray(array).length;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getCropIdNum(String crop) {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbcrop.findByCrop");
                query.setParameter("crop", crop.trim());
		Cbcrop cbcrop = (Cbcrop)query.getSingleResult();
                System.out.println("cbcrop.getCropid(): " + cbcrop.getCropid());
		return cbcrop.getCropid();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getLocationIdNum(String location) {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cblocation.findByLocation");
                query.setParameter("location", location.trim());
		Cblocation cblocation = (Cblocation)query.getSingleResult();
                System.out.println("cblocation.getLocationid(): " + cblocation.getLocationid());
		return cblocation.getLocationid();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getYearIdNum(int yeear) {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbyear.findByYeear");
                query.setParameter("yeear", yeear);
		Cbyear cbyear = (Cbyear)query.getSingleResult();
                System.out.println("cbyear.getYearid(): " + cbyear.getYearid());
		return cbyear.getYearid();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        private int getPltypeIdNum(String plttype) {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbplantingtype.findByPltype");
                query.setParameter("pltype", plttype.trim());
		Cbplantingtype cbplantingtype = (Cbplantingtype)query.getSingleResult();
                System.out.println("cbplantingtype.getPltypeid(): " + cbplantingtype.getPltypeid());
		return cbplantingtype.getPltypeid();
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return 0;
            }
	}
        
        @Override
        public CBDGTParams getVarsRates(final CLYPIDnums clypidnums) //,  final String role)
	{       
            CBDGTParams cbgdtparams = new CBDGTParams();
            Query query;  // = null;
            String SQL = "SELECT * FROM cbvarrate WHERE cropid = "  + clypidnums.getCropId() + " AND locationid = "  + clypidnums.getLocationId() + " AND yearid = "  + clypidnums.getYearId() + " AND pltypeid = " + clypidnums.getPltypeId() + "";
            //Cbvarrate cbvarrate = new Cbvarrate();
            //String[] cblinfos = new String[23];
            try {
                
                query = entityManager.createNativeQuery(SQL);
                List<Object[]> valueArray = query.getResultList();
                
                if(valueArray != null) {
                    int lstln = valueArray.size();
                    System.out.println("locationInfos (lstln):" + lstln);
                    for(int i = 0; i < lstln; i++){
                        //String locationinfo = "!";
                        Object[] values = valueArray.get(i);
                        cbgdtparams.setCrop(getCbcrop((Integer)values[1]).getCrop());
                        System.out.println("getCbcrop((Integer)values[1]).getCrop():" + getCbcrop((Integer)values[1]).getCrop());
                        cbgdtparams.setLocation(getCblocation((Integer)values[2]).getLocation());
                        System.out.println("getCblocation((Integer)values[2]).getLocation():" + getCblocation((Integer)values[2]).getLocation());
                        cbgdtparams.setYeear(Integer.toString(getCbyear((Integer)values[3]).getYeear()));
                        System.out.println("getCbyear((Integer)values[3]).getYeear():" + getCbyear((Integer)values[3]).getYeear());
                        cbgdtparams.setPltype(getCbplantingtype((Integer)values[4]).getPltype());
                        System.out.println("getCbplantingtype((Integer)values[4]).getPltype():" + getCbplantingtype((Integer)values[4]).getPltype());
                        //String hdstr = values[5].toString();
                        cbgdtparams.setVarrate1(format("#,###.00",Double.parseDouble(values[5].toString())));
                        cbgdtparams.setVarrate2(format("#,###.00",Double.parseDouble(values[6].toString())));
                        cbgdtparams.setVarrate3(format("#,###.00",Double.parseDouble(values[7].toString())));
                        cbgdtparams.setVarrate4(format("#,###.00",Double.parseDouble(values[8].toString())));
                        cbgdtparams.setVarrate5(format("#,###.00",Double.parseDouble(values[9].toString())));
                        cbgdtparams.setVarrate6(format("#,###.00",Double.parseDouble(values[10].toString())));
                        cbgdtparams.setVarrate7(format("#,###.00",Double.parseDouble(values[11].toString())));
                        cbgdtparams.setVarrate8(format("#,###.00",Double.parseDouble(values[12].toString())));
                        cbgdtparams.setVarrate9(format("#,###.00",Double.parseDouble(values[13].toString())));
                        cbgdtparams.setVarrate10(format("#,###.00",Double.parseDouble(values[14].toString())));
                        cbgdtparams.setVarrate11(format("#,###.00",Double.parseDouble(values[15].toString())));
                        cbgdtparams.setVarrate12(format("#,###.00",Double.parseDouble(values[16].toString())));
                        cbgdtparams.setVarrate13(format("#,###.00",Double.parseDouble(values[17].toString())));
                        cbgdtparams.setVarrate14(format("#,###.00",Double.parseDouble(values[18].toString())));
                        cbgdtparams.setVarrate15(format("#,###.00",Double.parseDouble(values[19].toString())));
                        cbgdtparams.setVarrate16(format("#,###.00",Double.parseDouble(values[20].toString())));
                        cbgdtparams.setVarrate17(format("#,###.00",Double.parseDouble(values[21].toString())));
                        cbgdtparams.setVarrate18(format("#,###.00",Double.parseDouble(values[22].toString())));
                        cbgdtparams.setVarrate19(format("#,###.00",Double.parseDouble(values[23].toString())));
                        //locinfos.add(locationinfo);
                    }
                }                
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                return null;
            }
            return cbgdtparams;
	}
        
        @Override
        public CBDGTAmounts getVarsAmounts(final CLYPIDnums clypidnums, String cyield, String cmktp, String rptType)  //,  final String role)
	{       
            CBDGTAmounts cbdgtamounts = new CBDGTAmounts();
            double totcost = 0.0; 
            Query query;  // = null;
            String SQL = "SELECT * FROM cbvarrate WHERE cropid = "  + clypidnums.getCropId() + " AND locationid = "  + clypidnums.getLocationId() + " AND yearid = "  + clypidnums.getYearId() + " AND pltypeid = " + clypidnums.getPltypeId() + "";
            //String[] cblinfos = new String[23];
            double yield, mktp;
            try{
                yield = Double.parseDouble(cyield);
            }catch (NumberFormatException nfex){
                yield = 2.00;
            }
            try{
                mktp = Double.parseDouble(cmktp);
            }catch (NumberFormatException nfex){
                mktp = 70000.00;
            }
            try {
                query = entityManager.createNativeQuery(SQL);
                List<Object[]> valueArray = query.getResultList();
                
                if(valueArray != null) {
                    int lstln = valueArray.size();
                    System.out.println("locationInfos (lstln):" + lstln);
                    for(int i = 0; i < lstln; i++){
                        //String locationinfo = "!";
                        Object[] values = valueArray.get(i);                        
                        cbdgtamounts.setAmount1(format("#,###.00", ((BigDecimal)values[5]).doubleValue()*1.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount1()))*1.00;
                        cbdgtamounts.setAmount2(format("#,###.00", ((BigDecimal)values[6]).doubleValue()*10.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount2()))*10.00;
                        cbdgtamounts.setAmount3(format("#,###.00", ((BigDecimal)values[7]).doubleValue()*1.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount3()))*1.00;
                        cbdgtamounts.setAmount4(format("#,###.00", ((BigDecimal)values[8]).doubleValue()*1.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount4()))*1.00;
                        cbdgtamounts.setAmount5(format("#,###.00", ((BigDecimal)values[9]).doubleValue()*2.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount5()))*2.00;
                        cbdgtamounts.setAmount6(format("#,###.00", ((BigDecimal)values[10]).doubleValue()*15.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount6()))*15.00;
                        cbdgtamounts.setAmount7(format("#,###.00", ((BigDecimal)values[11]).doubleValue()*3.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount7()))*3.00;
                        cbdgtamounts.setAmount8(format("#,###.00", ((BigDecimal)values[12]).doubleValue()*10.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount8()))*10.00;
                        cbdgtamounts.setAmount9(format("#,###.00", ((BigDecimal)values[13]).doubleValue()*1.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount9()))*1.00;
                        cbdgtamounts.setAmount10(format("#,###.00", ((BigDecimal)values[14]).doubleValue()*1.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount10()))*1.00;
                        cbdgtamounts.setAmount11(format("#,###.00", ((BigDecimal)values[15]).doubleValue()*30.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount11()))*30.00;
                        cbdgtamounts.setAmount12(format("#,###.00", ((BigDecimal)values[16]).doubleValue()*10.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount12()))*4.00;
                        cbdgtamounts.setAmount13(format("#,###.00", ((BigDecimal)values[17]).doubleValue()*10.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount13()))*10.00;
                        cbdgtamounts.setAmount14(format("#,###.00", ((BigDecimal)values[18]).doubleValue()*4.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount14()))*4.00;
                        cbdgtamounts.setAmount15(format("#,###.00", ((BigDecimal)values[19]).doubleValue()*2.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount15()))*2.00;
                        cbdgtamounts.setAmount16(format("#,###.00", ((BigDecimal)values[20]).doubleValue()*0.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount16()))*0.00;
                        cbdgtamounts.setAmount17(format("#,###.00", ((BigDecimal)values[21]).doubleValue()*5.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount17()))*5.00;
                        cbdgtamounts.setAmount18(format("#,###.00", ((BigDecimal)values[22]).doubleValue()*2.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount18()))*2.00;
                        cbdgtamounts.setAmount19(format("#,###.00", ((BigDecimal)values[23]).doubleValue()*1.00));
                        totcost = totcost + Double.parseDouble(refmt(cbdgtamounts.getAmount19()))*1.00;
                        cbdgtamounts.setAmount20(format("#,###.00", (totcost)));
                        cbdgtamounts.setAmount21(format("#,###.00", (totcost*0.10)));
                        cbdgtamounts.setAmount22(format("#,###.00", (totcost + (totcost*0.10))));
                        
                        switch (rptType) {
                            case "A":
                                cbdgtamounts.setAmount23(format("#,###.00", ((100.00/100.00) + ((6.00/12.00)*(10.00/100.00)))));
                                cbdgtamounts.setAmount24(format("#,###.00", ((Double.parseDouble(refmt(cbdgtamounts.getAmount22())))*(Double.parseDouble(refmt(cbdgtamounts.getAmount23()))))));
                                cbdgtamounts.setAmount25(format("#,###.00", (Double.parseDouble(refmt(cbdgtamounts.getAmount24()))/2.00)));
                                cbdgtamounts.setAmount25(format("#,###.00", (Double.parseDouble(refmt(cbdgtamounts.getAmount25())))));
                                cbdgtamounts.setAmount26(format("#,###.00", (Double.parseDouble(refmt(cbdgtamounts.getAmount25())))));
                                cbdgtamounts.setAmount27(format("#,###.00", (0.00)));
                                cbdgtamounts.setAmount28(format("#,###.00", (0.00)));
                                cbdgtamounts.setAmount29(format("#,###.00", (0.00)));
                                break;
                            case "B":
                                cbdgtamounts.setAmount23(format("#,###.00", (totcost/yield)));
                                cbdgtamounts.setAmount24(format("#,###.00", (yield*mktp)));
                                cbdgtamounts.setAmount25(format("#,###.00", (((yield*mktp) - totcost)/totcost)));
                                cbdgtamounts.setAmount26(format("#,###.00", ((((yield*mktp) - totcost)/totcost)*mktp)));
                                cbdgtamounts.setAmount27(format("#,###.00", (((((yield*mktp) - totcost)/totcost)*mktp)/yield)));
                                cbdgtamounts.setAmount28(format("#,###.00", (((totcost/yield) + (((((yield*mktp) - totcost)/totcost)*mktp)/yield)))));
                                cbdgtamounts.setAmount29(format("#,###.00", (((totcost/yield) + (((((yield*mktp) - totcost)/totcost)*mktp)/yield)))));
                                break;
                        }
                    }
                }
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("Exception: " + nniex.getMessage());
                return null;
            }
            return cbdgtamounts;
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
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                    System.out.println("Exception: " + nniex.getMessage());
            }
            return valstr;
        }
        
        private Cbcrop getCbcrop(int cropId) {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cbcrop.findByCropid");
                query.setParameter("cropid", cropId);
		Cbcrop cbcrop = (Cbcrop)query.getSingleResult();
                System.out.println("(Cbcrop)query.getSingleResult(): " + ((Cbcrop)query.getSingleResult()).getCrop());
		return cbcrop;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return null;
            }
	}
        
        private Cblocation getCblocation(int locationId) {
            Query query;  // = null;
            try {
		query = entityManager.createNamedQuery("Cblocation.findByLocationid");
                query.setParameter("locationid", locationId);
		Cblocation cblocation = (Cblocation)query.getSingleResult();
                System.out.println("(Cblocation)query.getSingleResult(): " + ((Cblocation)query.getSingleResult()).getLocation());
		return cblocation;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return null;
            }
	}
        
        @Override
        public Cbquantity getCbquantity() {
            Query query;  // = null;
            System.out.println("getCbquantity: 111");
            //System.out.println("quantityId: " + quantityId);
            Cbquantity cbquantity;
            try {
		query = entityManager.createNamedQuery("Cbquantity.findAll");
                //query.setParameter("quantityid", quantityId);
                
                //Object[] recArray = query.getResultList();
                Object valueObj = query.getSingleResult();  //getResultList();
                cbquantity = (Cbquantity)valueObj;
                System.out.println("cbquantity.getQuantity1(): " + cbquantity.getQuantity1());
                
                System.out.println("getCbquantity: 333");
		return cbquantity;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                System.out.println("getCbquantity: 444");
		System.out.println("Exception: " + nniex.getMessage());
		return null;
            }
	}        
        
        private Cbyear getCbyear(int yearId) {
            Query query;  
            try {
		query = entityManager.createNamedQuery("Cbyear.findByYearid");
                query.setParameter("yearid", yearId);
		Cbyear cbyear = (Cbyear)query.getSingleResult();
                System.out.println("(Cbyear)query.getSingleResult(): " + ((Cbyear)query.getSingleResult()).getYeear());
		return cbyear;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return null;
            }
	}
        
        private Cbplantingtype getCbplantingtype(int plttypeId) {
            Query query;  
            try {
		query = entityManager.createNamedQuery("Cbplantingtype.findByPltypeid");
                query.setParameter("pltypeid", plttypeId);
		Cbplantingtype cbplantingtype = (Cbplantingtype)query.getSingleResult();
                System.out.println("(Cbplantingtype)query.getSingleResult(): " + ((Cbplantingtype)query.getSingleResult()).getPltype());
		return cbplantingtype;
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
		System.out.println("Exception: " + nniex.getMessage());
		return null;
            }
	}
        
        @Override
        public List<String> locationInfos(String crop, String state, String year1, String year2)
        {
            Query query;
            
            int cropid = getCropIdNum(crop);
            int locationid = getLocationIdNum(state);
            int year1id = 0,year2id = 0;
            try{
                int yrId = Integer.parseInt(year1);
                year1id = getYearIdNum(yrId);
                yrId = Integer.parseInt(year2);
                year2id = getYearIdNum(yrId);
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            System.out.println("locationInfos => cropid, year1id, year2id: " + cropid + ", " + year1id + ", " + year2id);
            
            String SQL = "SELECT c.cropid, l.locationid, y.yearid, p.pltypeid, c.crop, l.location, y.yeear, p.pltype FROM cbvarrate AS v JOIN cbcrop AS c " +
            "ON v.cropid = c.cropid " +
            "JOIN cblocation As l " + 
            "ON v.locationid = l.locationid " +
            "JOIN cbyear As y " +
            "ON v.yearid = y.yearid " +
            "JOIN cbplantingtype As p " +
            "ON v.pltypeid = p.pltypeid " +
            "WHERE v.cropid = " + cropid + " AND v.locationid = " + locationid + " AND v.yearid BETWEEN " + year1id + " AND " + year2id + "";
                      
            String[] cblinfos = {" ", " ", " ", " ", " ", " ", " ", " "};
            List<String> locinfos = new ArrayList<>();
            System.out.println("locationInfos 11");
            try{
                System.out.println("locationInfos 12");
                query = entityManager.createNativeQuery(SQL);
                List<Object[]> valueArray = query.getResultList();
                System.out.println("locationInfos: Result Retreived");
                if(valueArray != null) {
                    int lstln = valueArray.size();
                    System.out.println("locationInfos (lstln):" + lstln);
                    for(int i = 0; i < lstln; i++){
                        String locationinfo = "!";
                        Object[] values = valueArray.get(i);
                        cblinfos[0] = ((Integer)values[0]).toString();
                        System.out.println("((Integer)values[0]).toString():" + ((Integer)values[0]).toString());
                        locationinfo = locationinfo + cblinfos[0] + "!";
                        cblinfos[1] = ((Integer)values[1]).toString();
                        System.out.println("((Integer)values[1]).toString():" + ((Integer)values[1]).toString());
                        locationinfo = locationinfo + cblinfos[1] + "!";
                        cblinfos[2] = ((Integer)values[2]).toString();
                        System.out.println("((Integer)values[2]).toString():" + ((Integer)values[2]).toString());
                        locationinfo = locationinfo + cblinfos[2] + "!";
                        cblinfos[3] = ((Integer)values[3]).toString();
                        System.out.println("((Integer)values[3]).toString():" + ((Integer)values[3]).toString());
                        locationinfo = locationinfo + cblinfos[3] + "!";
                        cblinfos[4] = (String) values[4];
                        locationinfo = locationinfo + cblinfos[4] + "!";
                        cblinfos[5] = (String) values[5];
                        locationinfo = locationinfo + cblinfos[5] + "!";
                        cblinfos[6] = ((Integer)values[6]).toString();
                        locationinfo = locationinfo + cblinfos[6] + "!";
                        cblinfos[7] = (String) values[7];
                        locationinfo = locationinfo + cblinfos[7] + "!";
                        locinfos.add(locationinfo);
                    }
                }
                System.out.println("locationInfos 13");
               
            }catch (NullPointerException|NoResultException|IllegalArgumentException nniex){
                locinfos = Collections.EMPTY_LIST;
                System.out.println("Exception: " + nniex.getMessage());
            }
            return locinfos;
        }
        
        @Override
        public CLYPIDnums namesToIds(String crop, String location, int year, String pltype)
        {
            CLYPIDnums clypidnums = new CLYPIDnums();
            int cropid = getCropIdNum(crop);
            int locationid = getLocationIdNum(location);
            int yearId = getYearIdNum(year);
            int pltypeid = getPltypeIdNum(pltype);
            clypidnums.setCropId(cropid);
            clypidnums.setLocationId(locationid);
            clypidnums.setYearId(yearId);
            clypidnums.setPltypeId(pltypeid);
            return clypidnums;
        }
        
        private String format(String pattern, double value ) {
            
            //String strinvestment = custformat.customFormat("#,###.00", investment*10000);
            //String ftcashinflow = custformat.customFormat("#,###.00", cashinflow*10000);
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            return myFormatter.format(value);
        }
}


/*
            int cropid = getCropIdNum(crop);
            Cbcrop cbcrop = new Cbcrop(cropid,crop.trim());
            int year1id = 0,year2id = 0;
            try{
                int yrId = Integer.parseInt(year1);
                year1id = getYearIdNum(yrId);
                yrId = Integer.parseInt(year2);
                year2id = getYearIdNum(yrId);
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            
            try {
                CriteriaBuilder builder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
                Root<Cbvarrate> varrateRoot = criteria.from( Cbvarrate.class );
                Root<Cbcrop> cropRoot = criteria.from( Cbcrop.class );
                Root<Cbplantingtype> plttypeRoot = criteria.from( Cbplantingtype.class );
                Root<Cbyear> yearRoot = criteria.from( Cbyear.class );
                Root<Cblocation> locationRoot = criteria.from( Cblocation.class );
                Path<Integer> cpidPath = cropRoot.get( Cbcrop_.cropId );
                Path<String> cpnmPath = cropRoot.get( Cbcrop_.crop );
                Path<Integer> ptidPath = plttypeRoot.get( Cbplantingtype_.pltypeId );
                Path<String> ptnmPath = plttypeRoot.get( Cbplantingtype_.pltype );
                Path<Integer> yridPath = yearRoot.get( Cbyear_.yearId );
                Path<Integer> yrnmPath = yearRoot.get( Cbyear_.yeear );
                Path<Integer> lcidPath = locationRoot.get( Cblocation_.locationId );
                Path<String> lcnmPath = locationRoot.get( Cblocation_.location );
               
                criteria.multiselect( cpidPath, ptidPath, yridPath, yridPath, cpnmPath, ptnmPath, yrnmPath, lcnmPath );

                ParameterExpression<Integer> cpIdParam = builder.parameter( Integer.class );
                ParameterExpression<Integer> yrId1Param = builder.parameter( Integer.class );
                ParameterExpression<Integer> yrId2Param = builder.parameter( Integer.class );

                criteria.where(builder.equal(  
                        builder.equal(varrateRoot.get( Cbvarrate_.cropId), cpIdParam ),
                        builder.between(varrateRoot.get( Cbvarrate_.yearId), yrId1Param, yrId2Param ))
                );

                List<Object[]> valueArray = entityManager.createQuery( criteria )
                        .setParameter(cpIdParam, cropid)
                        .setParameter(yrId1Param, year1id)
                        .setParameter(yrId2Param, year2id)
                        .getResultList();

                if(valueArray != null) {
                    int lstln = valueArray.size();
                    for(int i = 0; i < lstln; i++){
                        String locationinfo = "!";
                        Object[] values = valueArray.get(i);
                        cblinfos[0] = ((Integer) values[0]).toString().trim();
                        locationinfo = locationinfo + cblinfos[0] + "!";
                        cblinfos[1] = ((Integer) values[1]).toString().trim();
                        locationinfo = locationinfo + cblinfos[1] + "!";
                        cblinfos[2] = ((Integer) values[2]).toString().trim();
                        locationinfo = locationinfo + cblinfos[2] + "!";
                        cblinfos[3] = ((Integer) values[3]).toString().trim();
                        locationinfo = locationinfo + cblinfos[3] + "!";
                        cblinfos[4] = (String) values[4];
                        locationinfo = locationinfo + cblinfos[4] + "!";
                        cblinfos[5] = (String) values[5];
                        locationinfo = locationinfo + cblinfos[5] + "!";
                        cblinfos[6] = (String) values[6];
                        locationinfo = locationinfo + cblinfos[6] + "!";
                        cblinfos[7] = (String) values[7];
                        locationinfo = locationinfo + cblinfos[7] + "!";
                        locinfos.add(locationinfo);
                    }
                }            
            } catch (Exception e) {
                if(locinfos == null)
                    locinfos = Collections.EMPTY_LIST;
                System.out.println("Exception: " + e.getMessage());
            }
            */