/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.singleton;

import br.com.bcarsoft.structure.utilities.PassUtil;

/**
 * PassUtil Singleton Pattern.
 * @author abel
 */
public class SingPassUtil extends PassUtil {
    
    /**
     * Represents the singleton instance of the class.
     */
    private static SingPassUtil instance;

    /**
     * Object monitor for synchronize.
     */
    private static final Object MONITOR = new Object();
    
    /**
     * Create a new instance of this class.
     */
    public SingPassUtil() {
        super();
    }
    
    /**
     * Return a new instance of PassUtil if there's not.
     * @return 
     */
    public static SingPassUtil getInstance() {
        synchronized (MONITOR) {
            if (instance == null) {
                instance = new SingPassUtil();
            }
        }
        return instance;
    }
    
}
