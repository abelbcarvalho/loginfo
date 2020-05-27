/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.date.model;

import br.com.bcarsoft.structure.model.AbsModel;

/**
 * Date Table Model.
 * @author abel
 */
public class Date extends AbsModel {
    private int month;
    private int day;
    private int year;

    /**
     * Builder Method.
     */
    public Date() {
        super();
        this.month = 0;
        this.day = this.month;
        this.year = this.day;
    }
    
    // getters and setters

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
