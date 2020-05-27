/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.utilities;

/**
 * Password Checker Class.
 * @author abel
 */
public abstract class PassUtil {
    private boolean done;
    private int i;

    /**
     * Builder Method.
     */
    public PassUtil() {
        this.done = false;
        this.i = 0;
    }
    
    /**
     * This method verifies if the password short is valid.
     * @param password String
     * @return true if it's.
     */
    public boolean isShortPassValid(String password) {
        this.setDone(false); // if a letter was found, error!
        if (StringUtil.isNullOrEmpty(password)) return this.isDone();
        for (this.setI(0); this.getI() < password.length(); this.setI(this.getI()+1)) {
            if (!StringUtil.isNumeric(password.charAt(this.getI()))) {
                // something else was found, insert false because an error was found.
                this.setDone(false);
                break;
            }
        }
        return this.isDone();
    }
    
    /**
     * This method verifies if the password long is valid.
     * @param password String
     * @return true if it's.
     */
    public boolean isLongPassValid(String password) {
        this.setDone(false); // default
        if (StringUtil.isNullOrEmpty(password)) return this.isDone();
        for (this.setI(0); this.getI() < password.length(); this.setI(this.getI()+1)) {
            if (!StringUtil.isNumeric(password.charAt(this.getI()))) {
                if (StringUtil.isLetter(password.charAt(this.getI()))) {
                    this.setDone(true);
                }
                else {
                    this.setDone(false);
                    break;
                }
            }
        }
        return this.isDone();
    }
    
    /**
     * This method is for validate a application password.
     * @param password String.
     * @return true if it be a success.
     */
    public boolean isAppPasswordValid(String password) {
        this.setDone(StringUtil.isLetter(password.charAt(0)));
        if (!this.isDone()) return this.isDone();
        this.setDone(true);
        for (this.setI(0); this.getI() < password.length(); this.setI(this.getI()+1)) {
            if (!StringUtil.isLetter(password.charAt(this.getI()))) {
                if (StringUtil.isNumeric(password.charAt(this.getI()))) {
                    this.setDone(true);
                }
                else if (this.isSymbol1(password.charAt(this.getI()))) {
                    this.setDone(true);
                }
                else if (this.isSymbol2(password.charAt(this.getI()))) {
                    this.setDone(true);
                }
                else if (this.isSymbol3(password.charAt(this.getI()))) {
                    this.setDone(true);
                }
                else if (this.isSymbol4(password.charAt(this.getI()))) {
                    this.setDone(true);
                }
                else {
                    this.setDone(false);
                    break;
                }
            }
        }
        return this.isDone();
    }
    
    // symbols checker
    
    private boolean isSymbol1(char letter) {
        return letter > 32 && letter < 48;
    }
    
    private boolean isSymbol2(char letter) {
        return letter > 57 && letter < 64;
    }
    
    private boolean isSymbol3(char letter) {
        return letter > 90 && letter < 97;
    }
    
    private boolean isSymbol4(char letter) {
        return letter > 122 && letter < 127;
    }
    
    // getters and setters

    private boolean isDone() {
        return done;
    }

    private void setDone(boolean done) {
        this.done = done;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    
}
