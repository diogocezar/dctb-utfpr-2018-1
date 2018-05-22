/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.model.dao;

import java.sql.Connection;

/**
 *
 * @author gabriel
 */
public  abstract class DatabaseConnection {
    private Connection connect;
    
    public abstract void startConnection() throws Exception;
    public abstract void closeConnection() throws Exception;
    public abstract void restartConnection() throws Exception;
    
    public Connection getConnection(){
        return connect;
    }

    public void setConnection(Connection connect) {
        this.connect = connect;
    }
}
