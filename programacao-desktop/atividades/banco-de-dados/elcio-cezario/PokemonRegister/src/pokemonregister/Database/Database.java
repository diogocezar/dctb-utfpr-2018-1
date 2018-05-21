/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pokemonregister.Configurations.BDConfigurations;
import pokemonregister.Configurations.MySQLConfigurations;

/**
 *
 * @author ecsanchesjr
 */
public final class Database {
    private BDConfigurations configs;
    private String connectionUrl;
    private Connection connection;
    private PreparedStatement dbPreparedStatement;
    private Statement dbStatement;
    
    private Database() {
        setConfigs(new MySQLConfigurations());
    }
    
    public void setConfigs(BDConfigurations configs) {
        this.configs = configs;
        generateConUrl();
    }
    
    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar");
        }
    }
    
    public ResultSet query(String query) {
        try {
            checkConnection();
            dbStatement = connection.createStatement();
            return dbStatement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Erro para executar a query\n"+ex.getMessage());
            System.out.println(query);
        }
        return null;
    }
    
    public ResultSet query(String query, Object... params) {
        try {
            checkConnection();
            dbPreparedStatement = connection.prepareStatement(query);
            int i=1;
            for(Object o : params) {
                dbPreparedStatement.setObject(i++, o);
            }
            return dbPreparedStatement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro para executar a query\n"+ex.getMessage());
            System.out.println(query);
        }
        return null;
    }
    
    public int execute(String query, String pokeName, Object... params) {
        try {
            checkConnection();
            dbPreparedStatement = connection.prepareStatement(query);
            int i=1;
            for (Object o : params) {
                dbPreparedStatement.setObject(i++, o);
            }
            dbPreparedStatement.setString(i, pokeName);
            return dbPreparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro para executar a Update\n"+ex.getMessage());
            System.out.println(dbPreparedStatement.toString());
        }
        return 0;
    }
    
    public int execute(String query, Object... params) {
        try {
            checkConnection();
            dbPreparedStatement = connection.prepareStatement(query);
            int i=1;
            for (Object o : params) {
                dbPreparedStatement.setObject(i++, o);
            }
            return dbPreparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro para executar a Inserção\n"+ex.getMessage());
            System.out.println(dbPreparedStatement.toString());
        }
        return 0;
    }
    
    private void generateConUrl() {
        connectionUrl = "jdbc:" + configs.TYPE + "://" + configs.HOST + ":" + configs.PORT + "/" + configs.BASE + "?useUnicode=true&characterEncoding=utf-8";
    }
    
    private void connect() {
        try {
            Class.forName(configs.DRIV);
            connection = DriverManager.getConnection(connectionUrl, configs.USER, configs.PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro para conectar\n"+ex.getMessage());
        }
    }
    
    private void checkConnection() {
        if(connection == null)
            connect();
    }
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {
        private static final Database INSTANCE = new Database();
    }
}
