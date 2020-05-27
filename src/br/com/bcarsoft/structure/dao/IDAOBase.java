/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * DAOBase interface.
 * @author abel
 */
public interface IDAOBase {
    public abstract boolean save(List table, String sql);
    public abstract boolean update(List table, String sql);
    public abstract boolean delete(List table, String sql);
    public abstract boolean delete(int thekey, String sql);
    public abstract ResultSet findAll(List table, String sql);
    public abstract ResultSet searchBy(List table, String sql);
    public abstract Connection getCon();
    public abstract void setCon(Connection con);
    public abstract PreparedStatement getStmt();
    public abstract void setStmt(PreparedStatement stmt);
    public abstract ResultSet getResult();
    public abstract void setResult(ResultSet result);
}
