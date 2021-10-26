/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crop.gmp.cacheUtil;

import crop.gmp.util.UsernameRole;
import java.util.List;

/**
 *
 * @author user
 */
public class CachedListObject {
    
    private static CachedList cachedlist;
    static {
        cachedlist = new CachedList();
    }
    
    public static void cacheObjlist(List<UsernameRole> objlist){ 
        cachedlist.copyObjlist(objlist);
    }
       
    public static void cachedNewObject(UsernameRole obj){
        cachedlist.cachedNewObj(obj);
    }
    
    public static List<UsernameRole> getObjectList(){        
        return cachedlist.getObjlist();
    }
}
