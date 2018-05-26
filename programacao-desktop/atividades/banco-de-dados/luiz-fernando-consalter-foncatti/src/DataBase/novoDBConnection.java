/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Configuration.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luiz-
 */
public class novoDBConnection {
    private String dbType;
    private String dbHost;
    private String dbUser;
    private String dbPass;
    private String dbPort;
    private String dbBase;
    private String dbDriv;
    
    private String connString;
    
    private Connection        dbConnection;
    private Statement         dbStatement;
    private PreparedStatement dbPreparedStm;
    
    public novoDBConnection(Config config){
        this.connect(config);
    }

private String generateConnectionString(){
        return "jdbc:" + this.dbType + "://" + this.dbHost + ":" + this.dbPort + "/" + this.dbBase + "?useUnicode=true&characterEncoding=utf-8";
    }
    
    public void connect(Config config){
        this.dbType = config.TYPE;
        this.dbHost = config.HOST;
        this.dbUser = config.USER;
        this.dbPass = config.PASS;
        this.dbPort = config.PORT;
        this.dbBase = config.BASE;
        this.dbDriv = config.DRIV;
        
        this.connString = this.generateConnectionString();
        
        try{
            Class.forName(this.dbDriv);
            this.dbConnection = DriverManager.getConnection(this.connString, this.dbUser, this.dbPass);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver nao carregado: " + ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println("Falha na tentativa de conexao: " + ex.getMessage());
        }
    }
    
    public ResultSet query(String sql){
        try {
            this.dbStatement = dbConnection.createStatement();
            return this.dbStatement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Falha na consulta ao banco (consulta) : " + ex.getMessage());
            System.out.println("[SQL] " + sql);
        }
        return null;
    }
    
    public ResultSet query(String sql, Object... params){
        try {
            this.dbPreparedStm = this.dbConnection.prepareStatement(sql);
            int i = 1;
            for (Object o:params)
                this.dbPreparedStm.setObject(i++, o);
            return this.dbPreparedStm.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Falha na tentativa de uso do banco (consulta) : " + ex.getMessage());
            System.out.println("[SQL] " + sql);
        }
        return null;
    }
    
    public void execute(String sql, Object... params){
        try {
            this.dbPreparedStm = this.dbConnection.prepareStatement(sql);
            int i = 1;
            for (Object o:params)
                this.dbPreparedStm.setObject(i++, o);
            this.dbPreparedStm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Falha na tentativa de uso ao banco (execução) : " + ex.getMessage());
            System.out.println("[SQL] " + sql);
        }
    }
    
    public void disconnect(){
        try {
            this.dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Falha no encarramento da conexao: " + ex.getMessage());
        }
    }
}    
