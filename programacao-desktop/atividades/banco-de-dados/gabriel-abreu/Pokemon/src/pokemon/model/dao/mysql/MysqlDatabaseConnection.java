/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.model.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import pokemon.model.dao.DatabaseConnection;

/**
 *
 * @author gabriel
 */
public class MysqlDatabaseConnection extends DatabaseConnection{

    
    @Override
    public void restartConnection() throws Exception{        
        getConnection().close();
        Class.forName("com.mysql.jdbc.Driver");         
        setConnection(DriverManager.getConnection("jdbc:mysql://localhost/Pokemon","root",""));
    }

    @Override
    public void startConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        setConnection(DriverManager.getConnection("jdbc:mysql://localhost/Pokemon","root",""));
    }

    @Override
    public void closeConnection() throws Exception {
         getConnection().close();
    }

}
