package database;

import config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author christian
 */

/**
 * 
 * Classe que realiza a conexão com um banco de dados
 */
public class DataBase {
    
    private String dbType, dbHost, dbUser, dbPass, dbPort, dbBase, dbDriv;
    
    private String strConn;
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    
    /**
    * @param config Atributo de configurações de
    * conexão com o banco de dados
    * @see Configuration
    * 
    */
    public DataBase(Configuration config) {
        this.connect(config);
    }
    
    
    private String generateConn() {
        return "jdbc:" + this.dbType + "://" + this.dbHost + ":" + this.dbPort + "/" + this.dbBase + "?useUnicode=true&characterEncoding=utf-8";
    }
    
    public void connect(Configuration config) {
        this.dbType = config.TYPE;
        this.dbHost = config.HOST;
        this.dbUser = config.USER;
        this.dbPass = config.PASS;
        this.dbPort = config.PORT;
        this.dbBase = config.BASE;
        this.dbDriv = config.DRIV;
        
        this.strConn = this.generateConn();
        
        try {
            Class.forName(this.dbDriv);
            this.connection = DriverManager.getConnection(this.strConn, this.dbUser, this.dbPass);
        } catch (ClassNotFoundException e) {
            System.out.println("Error on driver load.\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error on trying a connection.\n" + e.getMessage());
        }
    }
    
    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Error on try closing a connection.");
        }
    }
    
    public ResultSet query(String sql) {
        try {
            this.statement = this.connection.createStatement();
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error on trying execute sql (query).\n" + e.getMessage());
            System.out.println("[SQL] " + sql);
        }
        return null;
    }
    
    public ResultSet query(String sql, Object... params) {
        try {
            this.preparedStatement = this.connection.prepareStatement(sql);
            int i = 1;
            for (Object obj : params) {
                this.preparedStatement.setObject(i++, obj);
            }
            return this.preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error on trying execute sql (query).\n" + e.getMessage());
            System.out.println("[SQL] " + sql);
        }
        return null;
    }
    
    public void execute(String sql, Object... params){
        try {
            this.preparedStatement = this.connection.prepareStatement(sql);
            int i = 1;
            for (Object o:params)
                this.preparedStatement.setObject(i++, o);
            this.preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error on trying execute sql (execute).\n" + ex.getMessage());
            System.out.println("[SQL] " + sql);
        }
    }
    
}
