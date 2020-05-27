/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.site.structure.model;

/**
 * Abstract model for all another models to SQL tables.
 * @author abel
 */
public class AbsModel {
    private int id;
    private int fk;

    /**
     * Builder Method.
     */
    public AbsModel() {
        this.id = 0;
        this.fk = this.id;
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk() {
        return fk;
    }

    public void setFk(int fk) {
        this.fk = fk;
    }
    
}
