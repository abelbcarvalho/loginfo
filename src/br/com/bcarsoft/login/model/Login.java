/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.login.model;

import br.com.bcarsoft.structure.model.AbsModel;

/**
 * Login Table Model.
 * @author abel
 */
public class Login extends AbsModel {
    private String site;
    private String user;
    private String email;
    private String pass;

    /**
     * Builder Method.
     */
    public Login() {
        super();
        this.site = "";
        this.user = this.site;
        this.email = this.user;
        this.pass = this.email;
    }
    
    // getters and setters

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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
    
}
