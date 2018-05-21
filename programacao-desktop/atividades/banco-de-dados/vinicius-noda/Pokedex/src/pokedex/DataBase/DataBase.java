package pokedex.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import pokedex.Config.Configurations;

/**
 *
 * @author noda
 */
public class DataBase {
    private Configurations config;
    private String connString;
    
    private static DataBase instance;
    private Connection dbConnection;
    private Statement dbStatement;
    private PreparedStatement dbPreparedStm;
    
    private DataBase(){}
    
    public void setConfig(Configurations config){
        this.config = config;
    }
    
    public static DataBase getInstance(){
        return(instance==null?instance = new DataBase():instance);
    }
    
    private void generateConnectionString(){
        connString =  "jdbc:" + config.TYPE + "://" + config.HOST + ":" + config.PORT + "/" + config.BASE + "?useUnicode=true&characterEncoding=utf-8";
    }
    
    private void connect(){
        try {
            generateConnectionString();
            Class.forName(config.DRIV);
            this.dbConnection = (Connection) DriverManager.getConnection(connString, config.USER, config.PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error while loading driver: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error connecting to database: "+ex.getMessage());
        }
    }
    
    public void checkConnection() throws SQLException{
        if(this.dbConnection == null || this.dbConnection.isClosed()){
            connect();
        }
    }
    
    public void disconnect(){
        try {
            this.dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Error closing connection: "+ex.getMessage());
        }
    }
    
    public ResultSet query(String sql){
        try {
            checkConnection();
            this.dbStatement = dbConnection.createStatement();
            ResultSet rs = this.dbStatement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error with query: "+this.dbPreparedStm);
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ResultSet query(String sql, Object... params){
        try {
            checkConnection();
            this.dbPreparedStm = this.dbConnection.prepareStatement(sql);
            int i=1;
            for(Object o : params){
                this.dbPreparedStm.setObject(i++, o);
            }
            ResultSet rs = this.dbPreparedStm.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error with query: "+this.dbPreparedStm);
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void exec(String sql, Object... params){
        try {
            checkConnection();
            this.dbPreparedStm = this.dbConnection.prepareStatement(sql);
            int i=1;
            for(Object o : params){
                this.dbPreparedStm.setObject(i++, o);
            }
            this.dbPreparedStm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error with update: "+this.dbPreparedStm);
            System.out.println(ex.getMessage());
        }
    }
}
