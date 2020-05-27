/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.utilities;

/**
 * Mobile Checker Class.
 * @author abel
 */
public abstract class MobileUtil {
    private int i;
    private boolean valid;
    
    /**
     * Builder Method.
     */
    public MobileUtil() {
        this.i = 0;
        this.valid = false;
    }
    
    /**
     * This method can validate a mobile number
     * @param mobile String
     * @return true if it be a success
     */
    public boolean isValidMobile(String mobile) {
        if (!this.isValidSize(mobile)) {
            return false;
        }
        else if (!this.isPlus(mobile.charAt(0))) {
            return false;
        }
        for (this.setI(1); this.getI() < mobile.length(); this.setI(this.getI()+1)) {
            if (!StringUtil.isNumeric(mobile.charAt(this.getI()))) {
                if (StringUtil.isSpaceFound(mobile.charAt(this.getI()))) {
                    this.setValid(true);
                }
                else if (StringUtil.isHyphen(mobile.charAt(this.getI()))) {
                    this.setValid(true);
                } 
                else if (this.isPlus(mobile.charAt(this.getI()))) {
                    this.setValid(true);
                }
                else {
                    this.setValid(false);
                    break;
                }
            }
        }
        this.setValid(this.isValidMobile2(mobile));
        return this.isValid();
    }
    
    /**
     * This method can validate a mobile number in Brazilian format
     * @param mobile String
     * @return true if it's good
     */
    public boolean isValidMobile2(String mobile) {
        // reset boolean
        this.setValid(false);
        // verify size
        if (!this.isValidSize(mobile)) return this.isValid();
        // verify is +
        if (!this.isPlus(mobile.charAt(0))) return this.isValid();
        // verify the spaces
        if (!StringUtil.isSpaceFound(mobile.charAt(3))) return this.isValid();
        if (!StringUtil.isSpaceFound(mobile.charAt(6))) return this.isValid();
        // verify hyphen
        if (!StringUtil.isHyphen(mobile.charAt(12))) return this.isValid();
        // verify numbers
        if (!StringUtil.isNumeric(mobile.charAt(1)) || 
                !StringUtil.isNumeric(mobile.charAt(2))) return this.isValid();
        if (!StringUtil.isNumeric(mobile.charAt(4)) || 
                !StringUtil.isNumeric(mobile.charAt(5))) return this.isValid();
        // numbers 1st group
        for (this.setI(7); this.getI() < 12; this.setI(this.getI()+1)) {
            if (!StringUtil.isNumeric(mobile.charAt(this.getI()))) return this.isValid();
        }
        // numbers 2nd group
        for (this.setI(13); this.getI() < 17; this.setI(this.getI()+1)) {
            if (!StringUtil.isNumeric(mobile.charAt(this.getI()))) return this.isValid();
        }
        // if came here, the phone number is valid, so, set true in valid, after, return it
        this.setValid(true);
        return this.isValid();
    }
    
    // need methods
    
    /**
     * Verifies if a string has a valid size.
     * @param word
     * @return 
     */
    private boolean isValidSize(String mobile) {
        return mobile.length() > 17;
    }
    
    /**
     * Verifies if a character is a '+' plus
     * @param letter Character
     * @return true if it is '+' hyphen
     */
    private boolean isPlus(char letter) {
        return letter == '+';
    }
    
    // getter and setter

    private int getI() {
        return i;
    }

    private void setI(int i) {
        this.i = i;
    }

    private boolean isValid() {
        return valid;
    }

    private void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
