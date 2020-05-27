/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.singleton;

import br.com.bcarsoft.structure.utilities.DateUtil;

/**
 * Singleton Pattern for DateUtil.
 * @author abel
 */
public class SingDateUtil extends DateUtil{
    
    /**
     * Represents the singleton instance of the class.
     */
    private static SingDateUtil instance;

    /**
     * Object monitor for synchronize.
     */
    private static final Object MONITOR = new Object();
    
    /**
     * Create a new instance of this class.
     */
    public SingDateUtil() {
        super();
    }
    
    /**
     * Return a new instance of DateUtil if there's not.
     * @return 
     */
    public static SingDateUtil getInstance() {
        synchronized (MONITOR) {
            if (instance == null) {
                instance = new SingDateUtil();
            }
        }
        return instance;
    }
    
}
