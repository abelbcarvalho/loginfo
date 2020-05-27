/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.singleton;

import br.com.bcarsoft.structure.utilities.UserUtil;

/**
 * UserUtil Singleton Pattern.
 * @author abel
 */
public class SingUserUtil extends UserUtil {
    
    /**
     * Represents the singleton instance of the class.
     */
    private static SingUserUtil instance;

    /**
     * Object monitor for synchronize.
     */
    private static final Object MONITOR = new Object();
    
    /**
     * Create a new instance of this class.
     */
    public SingUserUtil() {
        super();
    }
    
    /**
     * Return a new instance of UserUtil if there's not.
     * @return 
     */
    public static SingUserUtil getInstance() {
        synchronized (MONITOR) {
            if (instance == null) {
                instance = new SingUserUtil();
            }
        }
        return instance;
    }
    
}
