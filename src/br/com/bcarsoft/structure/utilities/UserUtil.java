/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.utilities;

/**
 * Username Checker Class.
 * @author abel
 */
public abstract class UserUtil {
    private boolean done;
    private int i;

    /**
     * Builder Method.
     */
    public UserUtil() {
        this.done = false;
        this.i = 0;
    }
    
    /**
     * This method can determine if a word can be considered a username.
     * @param user String.
     * @return true if a String is an username.
     */
    public boolean isValidUsername(String user) {
        // first character may be a letter
        this.setDone(StringUtil.isLetter(user.charAt(0)));
        if (!this.isDone()) return this.isDone();
        // reset done, if came here, last checker was a success
        this.setDone(false);
        // a loop for to run the string and check char by char
        for (this.setI(0); this.getI() < StringUtil.strLen(user); this.setI(this.getI()+1)) {
            this.setDone(true);
            if (!StringUtil.isLetter(user.charAt(this.getI()))) {
                // something else letter
                if (StringUtil.isUnderscoreFound(user.charAt(this.getI()))) {
                    // ok
                    this.setDone(true);
                }
                else if (StringUtil.isNumeric(user.charAt(user.charAt(this.getI())))) {
                    // ok
                    this.setDone(true);
                }
                else if (StringUtil.isHyphen(user.charAt(this.getI()))) {
                    // ok
                    this.setDone(true);
                }
                else {
                    // error // break
                    this.setDone(false);
                    break;
                }
            }
        }
        // the final result
        return this.isDone();
    }
    
    // getters and setters

    private boolean isDone() {
        return done;
    }

    private void setDone(boolean done) {
        this.done = done;
    }

    private int getI() {
        return i;
    }

    private void setI(int i) {
        this.i = i;
    }
    
}
