package DataBase;

import Configurations.Configurations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private String dbType;
    private String dbHost;
    private String dbUser;
    private String dbPass;
    private String dbPort;
    private String dbBase;
    
    private String connString;
    
    private Connection        dbConnection;
    private Statement         dbStatement;
    private PreparedStatement dbPreparedStm;
    
    public DataBase(){
        this.connect();
    }
    
    private String generateConnectionString(){
        return "jdbc:" + this.dbType + "://" + this.dbHost + ":" + this.dbPort + "/" + this.dbBase + "?useUnicode=true&characterEncoding=utf-8";
    }
    
    public void connect(){
        this.dbType = Configurations.TYPE;
        this.dbHost = Configurations.HOST;
        this.dbUser = Configurations.USER;
        this.dbPass = Configurations.PASS;
        this.dbPort = Configurations.PORT;
        this.dbBase = Configurations.BASE;
        
        this.connString = this.generateConnectionString();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConnection = DriverManager.getConnection(this.connString, this.dbUser, this.dbPass);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Houve um erro ao carregar o driver: " + ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println("Houve um erro ao tentar relizar uma conexão: " + ex.getMessage());
        }
    }
    
    public ResultSet query(String sql){
        try {
            this.dbStatement = dbConnection.createStatement();
            return this.dbStatement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao tentar executar um sql (consulta) : " + ex.getMessage());
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
            System.out.println("Houve um erro ao tentar executar um sql (execução) : " + ex.getMessage());
            System.out.println("[SQL] " + sql);
        }
    }
    
    public void disconnect(){
        try {
            this.dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao tentar fechar uma conexão: " + ex.getMessage());
        }
    }
}
