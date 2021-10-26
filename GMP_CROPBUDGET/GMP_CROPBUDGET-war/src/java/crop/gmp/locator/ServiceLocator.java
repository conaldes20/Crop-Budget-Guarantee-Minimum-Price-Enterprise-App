/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.locator;

import javax.naming.Context;;

/**
 *
 * @author user
 */
public class ServiceLocator {
    
    private static Cache cache;
    static {
        cache = new Cache();
    }
    
    public static Object getRemoteObject(Context namingContext, String jndiName){
        Object service = cache.getService(jndiName);
        if(service != null){
            return service;
        }
        BusinessInterface businessInterface = new BusinessInterface();
        service = businessInterface.getRemoteBusiness(namingContext, jndiName);
        cache.addService(service);
        return service;
    }
}
