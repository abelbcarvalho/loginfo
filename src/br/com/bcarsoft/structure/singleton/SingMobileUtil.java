/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.singleton;

import br.com.bcarsoft.structure.utilities.MobileUtil;

/**
 * Singleton Pattern to MobileUtil
 * @author abel
 */
public class SingMobileUtil extends MobileUtil {
    
    /**
     * Represents the singleton instance of the class.
     */
    private static SingMobileUtil instance;

    /**
     * Object monitor for synchronize.
     */
    private static final Object MONITOR = new Object();
    
    /**
     * Create a new instance of this class.
     */
    public SingMobileUtil() {
        super();
    }
    
    /**
     * Return a new instance of MobileUtil if there's not.
     * @return 
     */
    public static SingMobileUtil getInstance() {
        synchronized (MONITOR) {
            if (instance == null) {
                instance = new SingMobileUtil();
            }
        }
        return instance;
    }
    
}
