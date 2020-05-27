/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.account.model;

import br.com.bcarsoft.structure.model.AbsModel;

/**
 * Account Table Model.
 * @author abel
 */
public class Account extends AbsModel {
    private String name;
    private String gender;
    private String user;
    private String email;
    private String pass;
    private String mobile;

    /**
     * Builder Method.
     */
    public Account() {
        super();
        this.name = "";
        this.gender = this.name;
        this.user = this.gender;
        this.email = this.user;
        this.pass = this.email;
        this.mobile = this.pass;
    }
    
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
}
