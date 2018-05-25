/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Configurations.Configurations;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class DataBase {
    private String dbType; 
    private String dbHost;
    private String dbUser;
    private String dbPass;
    private String dbPort;
    private String dbBase;
    private String dbDriv;
    
    private String connection;
    
    private Connection dbConnection;
    private Statement dbStatement;
    private PreparedStatement dbPreparedStatement;
    
    public DataBase(Configurations config){
        this.connect(config);
    }
    
    private void connect(Configurations config){
        this.dbType = config.TYPE;
        this.dbHost = config.HOST;
        this.dbUser = config.USER;
        this.dbPass = config.PASS;
        this.dbPort = config.PORT;
        this.dbBase = config.BASE;
        this.dbDriv = config.DRIV;
        
        this.connection = this.generateConnection();
        
        try{
            Class.forName(this.dbDriv);
            this.dbConnection = (Connection) DriverManager.getConnection(this.connection, this.dbUser, this.dbPass);
        }
        catch (ClassNotFoundException e){
            System.out.println("Erro ao carregar o driver: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Erro ao realizar a conexão: " + e.getMessage());
        }
    }
    
    private String generateConnection(){
        return "jdbc:"+this.dbType+"://"+this.dbHost+":"+this.dbPort+"/"+this.dbBase+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    }
    
    public ResultSet query(String sql){
        try{
            this.dbStatement = (Statement) this.dbConnection.createStatement();
            return this.dbStatement.executeQuery(sql);
        }
        catch(SQLException e){
            System.out.println("Erro ao tentar realizar a Consulta: " + e.getMessage());
            System.out.println("SQL que foi realizada: " + sql);
        }
        return null;
    }
    
    public ResultSet query(String sql, Object... params){
        try {
            this.dbPreparedStatement = (PreparedStatement) this.dbConnection.prepareStatement(sql);
            int i = 1;
            for (Object o:params)
                this.dbPreparedStatement.setObject(i++, o);
            return this.dbPreparedStatement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao tentar executar um sql (consulta) : " + ex.getMessage());
            System.out.println("SQL que foi realizada: " + sql);
        }
        return null;
    }
    
    public ResultSet execute(String sql, Object... params){
        try {
            this.dbPreparedStatement = (PreparedStatement) this.dbConnection.prepareStatement(sql);
            int i = 1;
            for (Object o:params)
                this.dbPreparedStatement.setObject(i++, o);
            this.dbPreparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao tentar executar um sql (execução) : " + ex.getMessage());
            System.out.println("SQL que foi realizada: " + sql);
        }
        return null;
    }
    
    public void disconnect(){
        try {
            this.dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao tentar fechar uma conexão: " + ex.getMessage());
        }
    }
}
