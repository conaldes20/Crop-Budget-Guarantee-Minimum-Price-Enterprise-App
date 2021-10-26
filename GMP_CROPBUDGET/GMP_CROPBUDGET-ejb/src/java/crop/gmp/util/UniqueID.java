/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.util;

/**
 *
 * @author CONALDES
 */
public class UniqueID {
    
    public static String generateUID(){
        return  new java.rmi.server.UID().toString();        
    }
    
}
