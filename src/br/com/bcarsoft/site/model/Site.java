/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.site.model;

import br.com.bcarsoft.structure.model.AbsModel;

/**
 * Site Table Model.
 * @author abel
 */
public class Site extends AbsModel {
    private String name;
    private String page;
    private String link;

    /**
     * Builder Method.
     */
    public Site() {
        super();
        this.name = "";
        this.page = this.name;
        this.link = this.page;
    }
    
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
