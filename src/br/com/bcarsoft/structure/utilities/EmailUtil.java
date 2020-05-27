/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.utilities;

/**
 * Email Checker Class.
 * @author abel
 */
public abstract class EmailUtil {
    private int i;
    private boolean valid;
    
    /**
     * Builder Method.
     */
    public EmailUtil() {
        this.i = 0;
        this.valid = false;
    }
    
    /**
     * This method is for validate or not an email address sent.
     * @param email String
     * @return true if it be valid.
     */
    public boolean isEmailValid(String email) {
        // first and last character is a letter
        this.setValid(this.isFistLastLetter(email));
        if (!this.isValid()) return this.isValid();
        // reset
        this.setValid(false);
        // is found index of @
        this.setI(this.atIndex(email));
        if (this.getI() == 0) return this.isValid();
        // invalid before and after
        this.setValid(this.isValidAtCloser(email));
        if (!this.isValid()) return this.isValid();
        // name mail verification
        String namemail = email.substring(0, this.getI()-1);
        this.setValid(this.isNameMailValid(namemail));
        if (!this.isValid()) return this.isValid();
        // service mail verification
        String service = email.substring(this.getI()+1, email.length()-1);
        this.setValid(this.isServiceValid(service));
        if (!this.isValid()) return this.isValid();
        // if came here, was a success
        this.setValid(true);
        return this.isValid();
    }
    
    /**
     * First and Last Character checked if it is considered a letter.
     * @param word String.
     * @return true if it be a success.
     */
    private boolean isFistLastLetter(String word) {
        return StringUtil.isLetter(word.charAt(0)) && StringUtil.isLetter(word.charAt(word.length()-1));
    }
    
    /**
     * Returns the index of '@'.
     * @param email String.
     * @return Integer greter than zero if it be a success
     */
    private int atIndex(String email) {
        short atn = 0;
        int idx = 0;
        for (this.setI(0); this.getI() < email.length(); this.setI(this.getI()+1)) {
            if (this.isAt(email.charAt(this.getI()))) {
                idx = this.getI();
                atn += 1;
            }
        }
        if (atn < 1) return 0;
        if (atn > 1) return 0;
        return idx;
    }
    
    /**
     * returns true if the character is a '@'.
     * @param letter Character.
     * @return true it it's.
     */
    private boolean isAt(char letter) {
        return letter == '@';
    }
    
    /**
     * This method verifies if there are . _ or - imediately before and 
     * after an '@'.
     * @param email String
     * @return true if there's.
     */
    private boolean isValidAtCloser(String email) {
        this.setValid(false);
        if (this.getI() == 0) return this.isValid();
        // before
        if (!StringUtil.isLetter(email.charAt(this.getI()-1)) && 
                !StringUtil.isNumeric(email.charAt(this.getI()-1))) return this.isValid();
        // after
        if (!StringUtil.isLetter(email.charAt(this.getI()+1)) && 
                !StringUtil.isNumeric(email.charAt(this.getI()+1))) return this.isValid();
        // if come here, will returns false, it represents a success
        this.setValid(true);
        return this.isValid();
    }
    
    /**
     * It verifies if name mail is valid.
     * @param namemail String.
     * @return true if it's.
     */
    private boolean isNameMailValid(String namemail) {
        this.setValid(true);
        for (short c = 0; c < namemail.length(); c++) {
            if (!StringUtil.isLetter(namemail.charAt(c))) {
                if (StringUtil.isNumeric(namemail.charAt(c))) {
                    this.setValid(true);
                }
                else if (StringUtil.isUnderscoreFound(namemail.charAt(c))) {
                    this.setValid(true);
                }
                else if (StringUtil.isPointFound(namemail.charAt(c))) {
                    this.setValid(true);
                }
                else if (StringUtil.isHyphen(namemail.charAt(c))) {
                    this.setValid(true);
                }
                else {
                    return !this.isValid();
                }
            }
        }
        return this.isValid();
    }
    
    /**
     * It verifies if service is valid.
     * @param servicel String.
     * @return true if it's.
     */
    private boolean isServiceValid(String service) {
        this.setValid(true);
        short qp = 0; // how many points
        for (short d = 0; d < service.length(); d += 1) {
            if (!StringUtil.isLetter(service.charAt(d))) {
                if (StringUtil.isNumeric(service.charAt(d))) {
                    this.setValid(true);
                }
                else if (StringUtil.isUnderscoreFound(service.charAt(d))) {
                    this.setValid(true);
                }
                else if (StringUtil.isHyphen(service.charAt(d))) {
                    this.setValid(true);
                }
                else if (StringUtil.isPointFound(service.charAt(d))) {
                    qp++; // point index
                    if (!StringUtil.isLetter(service.charAt(d-1)) || !StringUtil.isLetter(service.charAt(d+1))) {
                        return !this.isValid();
                    }
                    this.setValid(true);
                }
                else {
                    return !this.isValid();
                }
            }
        }
        if (qp == 0) return !this.isValid();
        return this.isValid();
    }

    // getters and setters
    
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
