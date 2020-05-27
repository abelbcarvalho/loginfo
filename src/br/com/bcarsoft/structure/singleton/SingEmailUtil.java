/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.singleton;

import br.com.bcarsoft.structure.utilities.EmailUtil;

/**
 * Singleton Pattern to EmailUtil.
 * @author abel
 */
public class SingEmailUtil extends EmailUtil {
    
     /**
     * Represents the singleton instance of the class.
     */
    private static SingEmailUtil instance;

    /**
     * Object monitor for synchronize.
     */
    private static final Object MONITOR = new Object();
    
    /**
     * Create a new instance of this class.
     */
    public SingEmailUtil() {
        super();
    }
    
    /**
     * Return a new instance of EmailUtil if there's not.
     * @return 
     */
    public static SingEmailUtil getInstance() {
        synchronized (MONITOR) {
            if (instance == null) {
                instance = new SingEmailUtil();
            }
        }
        return instance;
    }
    
}
