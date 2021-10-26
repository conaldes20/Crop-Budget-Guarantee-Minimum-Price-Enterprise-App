/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.locator;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<Object> services;
    
    public Cache(){
        services = new ArrayList<>();
    }
    
    public Object getService(String serviceName){
        for (Object service : services) {
            System .out.println("service.getClass().getName() " + service.getClass().getName());
            if((serviceName.equals("USER_REMOTE")) && (service.getClass().getName().equals("crop.gmp.intface._UserRemoteBusiness_Wrapper"))){
                System .out.println("Returning cached " + serviceName + " object");
                return service;
            }else if((serviceName.equals("USERTRAIL_REMOTE")) && (service.getClass().getName().equals("crop.gmp.intface._UserTrailRemoteBusiness_Wrapper"))){
                System .out.println("Returning cached " + serviceName + " object");
                return service;
            }else if((serviceName.equals("CBDGTGMP_REMOTE")) && (service.getClass().getName().equals("crop.gmp.intface._CropBDGTRemoteBusiness_Wrapper"))){
                System .out.println("Returning cached " + serviceName + " object");
                return service;
            }                    
        }
        return null;
    }

    public void addService(Object newService){
        boolean exists = false;
        for (Object service : services) {
            if(service.equals(newService)){
                System .out.println("service.equals(newService) " + service.equals(newService));
                exists = true;
            }
        }

        if(!exists){
            services.add(newService);
        }
    }
}