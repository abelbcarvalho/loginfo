/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.utilities;

import br.com.bcarsoft.date.model.Date;
import java.util.Calendar;

/**
 * DateBorn checker.
 * @author abel
 */
public abstract class DateUtil {
    private boolean valid;
    
    /**
     * Builder Method.
     */
    public DateUtil() {
        this.valid = false;
    }
    
    /**
     * This method is for validate a date.
     * @param date Date Instance.
     * @return true if it be a success
     */
    public boolean isDateBornValid(Date date) {
        // default false to valid
        this.setValid(false);
        // basic verification
        if (!this.isMonthValid(date.getMonth())) {
            return this.isValid();
        }
        else if (!this.isDayValid(date.getDay())) {
            return this.isValid();
        }
        else if (!this.isYearValid(date.getYear())) {
            return this.isValid();
        }
        // advenced date born month day
        this.setValid(true); // it will be used if the month ends in 31st.
        switch (date.getMonth()) {
            case 2:
                if (this.isLeapYear(date.getYear())) {
                    return date.getDay() < 30;
                }
                return date.getDay() < 29;
            case 4:
                return date.getDay() < 31;
            case 6:
                return date.getDay() < 31;
            case 9:
                return date.getDay() < 31;
            case 11:
                return date.getDay() < 31;
        }
        return this.isValid();
    }
    
    /**
     * It verify if a person is of age.
     * @param date Date Instance
     * @return true if it be a success
     */
    private boolean isOfAge(Date date) {
        Calendar today = Calendar.getInstance();
        // taking the data system
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int day = today.get(Calendar.DATE);
        // checking if is valid
        if (month < date.getMonth() && (year-date.getYear()) > 17) {
            this.setValid(true);
        }
        else if (month == date.getMonth()) {
            if (day <= date.getDay() && (year-date.getYear()) > 17) {
                this.setValid(true);
            } else {
                this.setValid(false);
            }
        }
        else {
            if ((year-date.getYear()) > 18) {
                this.setValid(true);
            } else {
                this.setValid(false);
            }
        }
        return this.isValid();
    }
    
    private boolean isDayValid(int day) {
        return day > 0 && day < 32;
    }
    
    private boolean isYearValid(int year) {
        return year > 1939;
    }
    
    private boolean isLeapYear(int year) {
        return year%4 == 0;
    }
    
    private boolean isMonthValid(int month) {
        return month > 0 && month < 13;
    }
    
    // getters and setters 

    private boolean isValid() {
        return valid;
    }

    private void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
