/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.util;

import java.util.Calendar;  
import java.util.GregorianCalendar;

/**
 *
 * @author CONALDES
 */
public class Functions {    
    public static Calendar createDate(String datestr)
    {
        Calendar calender;
        datestr = datestr.trim();
        String dtStr;
        System.out.println("extractDate datestr.substring(0, 8): " + datestr.substring(0, 8));        
        int day = 0, month = 0, year = 0;
        try{            
            dtStr = datestr.substring(0, 2);
            day = Integer.parseInt(dtStr);
            dtStr = datestr.substring(3, 5);
            month = Integer.parseInt(dtStr);
            dtStr = datestr.substring(6);
            year = Integer.parseInt(dtStr);
        }catch (NumberFormatException nfe) {
            System.out.println("(NumberFormatException nfe): " + nfe.getMessage());
        }
        calender = new GregorianCalendar(year, month - 1, day);
        return calender;
    }
    
    public static Calendar extractDate(String logusrid)
    {
        Calendar calender;
        logusrid = (logusrid.trim()).substring(0, 8);
        String dtStr;
        System.out.println("extractDate logusrid.substring(0, 8): " + logusrid.substring(0, 8));        
        int day = 0, month = 0, year = 0;
        try{            
            dtStr = logusrid.substring(6);
            day = Integer.parseInt(dtStr);
            dtStr = logusrid.substring(4, 6);
            month = Integer.parseInt(dtStr);
            dtStr = logusrid.substring(0, 4);
            year = Integer.parseInt(dtStr);
        }catch (NumberFormatException nfe) {
            System.out.println("(NumberFormatException nfe): " + nfe.getMessage());  
        }
        calender = new GregorianCalendar(year, month - 1, day); 
        return calender;
    }
}
