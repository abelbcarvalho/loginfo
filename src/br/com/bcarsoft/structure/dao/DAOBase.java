/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bcarsoft.structure.dao;

import br.com.bcarsoft.structure.sql.ConFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAOBase.
 * @author abel
 */
public class DAOBase implements IDAOBase {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet result;

    /**
     * Inserts data inside database.
     * @param table List
     * @param sql String
     * @return Boolean
     */
    @Override
    public boolean save(List table, String sql) {
        this.setCon(ConFactory.getConnection()); // do connection
        this.setStmt(null); // initial value null
        // try ... catch
        try {
            // sending sql command
            this.setStmt(this.getCon().prepareStatement(sql));
            this.setParamenter(table); // inserting arguments inside sql
            this.getStmt().executeUpdate(); // finish operation
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            // closing connection
            ConFactory.closeConnection(this.getCon(), this.getStmt());
        }
    }

    /**
     * Updates data inside database.
     * @param table List
     * @param sql String
     * @return Boolean
     */
    @Override
    public boolean update(List table, String sql) {
        return this.save(table,sql); // economize code with it
    }

    /**
     * Delete data inside database.
     * @param table List
     * @param sql String
     * @return Boolean
     */
    @Override
    public boolean delete(List table, String sql) {
        return this.save(table,sql); // economize code with it
    }
    
    /**
     * Delete data inside database by the key.
     * @param thekey Integer that represents the key.
     * @param sql String, SQL query.
     * @return true if it be a success.
     */
    @Override
    public boolean delete(int thekey, String sql) {
        this.setCon(ConFactory.getConnection());
        this.setStmt(null);
        try {
            // prepare the command
            this.setStmt(this.getCon().prepareStatement(sql));
            // insert parameter
            this.getStmt().setInt(1,thekey);
            // update table
            this.getStmt().executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            ConFactory.closeConnection(this.getCon(), this.getStmt());
        }
    }

    /**
     * Returns all registers inside database.
     * @param table List
     * @param sql String
     * @return List
     */
    @Override
    public ResultSet findAll(List table, String sql) {
        this.setCon(ConFactory.getConnection()); // open connection
        this.setStmt(null); // null
        this.setResult(null); // null
        // try ... catch
        try {
            this.setStmt(this.getCon().prepareStatement(sql)); // setting sql command
            this.setParamenter(table);
            this.setResult(this.getStmt().executeQuery());
            return this.getResult();
        } catch (SQLException ex) {
            return null;
        } finally {
            ConFactory.closeConnection(this.getCon(),this.getStmt(),this.getResult());
        }
    }

    /**
     * Returns the register by ID.
     * @param table List
     * @param sql String
     * @return List
     */
    @Override
    public ResultSet searchBy(List table, String sql) {
        return this.findAll(table,sql); // economize code with it.
    }

    /**
     * Get a Connection Instance.
     * @return Connection Instance
     */
    @Override
    public Connection getCon() {
        return this.con;
    }

    /**
     * Set a Connection Instance.
     * @param con Connection Instance
     */
    @Override
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * Get a Prepared Statement Instance.
     * @return PreparedStatement Instance
     */
    @Override
    public PreparedStatement getStmt() {
        return this.stmt;
    }

    /**
     * Set a PreparedStatement Instance.
     * @param stmt PreparedStatement Instance
     */
    @Override
    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    // ResultSet

    /**
     * Get a ResultSet.
     * @return ResultSet Instance
     */
    @Override
    public ResultSet getResult() {
        return this.result;
    }

    /**
     * Set a ResultSet.
     * @param result ResultSet Instance
     */
    @Override
    public void setResult(ResultSet result) {
        this.result = result;
    }

    /**
     * This method discovery data type and makes insert commands
     * inside SQL to salve into database.
     * @param table List
     */
    protected void setParamenter(List table) {
        // nothing can be inserted
        if (table == null) return; // can't be null.
        for (int i = 0; i < table.size(); i += 1) {
            if (table.get(i) instanceof java.lang.String) {
                try {
                    this.getStmt().setString(i+1, (String) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (table.get(i) instanceof java.lang.Integer) {
                try {
                    this.getStmt().setInt(i+1, (int) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (table.get(i) instanceof java.lang.Long) {
                try {
                    this.getStmt().setLong(i+1, (long) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (table.get(i) instanceof java.lang.Float) {
                try {
                    this.getStmt().setFloat(i+1, (float) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (table.get(i) instanceof java.lang.Double) {
                try {
                    this.getStmt().setDouble(i+1, (double) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (table.get(i) instanceof java.lang.Boolean) {
                try {
                    this.getStmt().setBoolean(i+1, (boolean) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (table.get(i) instanceof java.util.Date) {
                try {
                    this.getStmt().setDate(i+1, (Date) table.get(i));
                } catch (SQLException ex) {
                    Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
