/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.site.structure.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is for create a connection with database.
 * @author abel
 */
public class ConFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/loginfo";
    private static final String USER = "root";
    private static final String PASS = "";

    /**
     * Opening connection.
     * @return Connection Object.
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Error with connection ", ex);
        }
    }

    /**
     * Close Connection With DataBase.
     * @param con Connection Object.
     */
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error: "+ex);
            }
        }
    }

    /**
     * Close Connection With DataBase.
     * @param con Connection Object.
     * @param stmt PreparedStatemente Object.
     */
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Error: "+ex);
            }
        }
        closeConnection(con);
    }

    /**
     * Close Connection With DataBase.
     * @param con Connection Object.
     * @param stmt PreparedStatemente Object.
     * @param rs ResultSet Object.
     */
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Error: "+ex);
            }
        }
        closeConnection(con, stmt);
    }
    
}
