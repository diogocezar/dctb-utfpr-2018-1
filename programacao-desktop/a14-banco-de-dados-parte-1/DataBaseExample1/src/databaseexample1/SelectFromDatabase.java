package databaseexample1;

import java.sql.*;


public class SelectFromDatabase {
   
    private Connection con = null;
    private Statement  stm = null;
    private ResultSet  rst = null;
    
    public void readDatabase() throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost:3306/utfpr_tests?useUnicode=true&characterEncoding=utf-8";
        
        String sql = "SELECT * FROM java_item";
       
        con = DriverManager.getConnection(url, "root", "");
        stm = con.createStatement();
        rst = stm.executeQuery(sql);
        
        while(rst.next()){
            System.out.println("Id: " + rst.getString("id"));
            System.out.println("Nome: " + rst.getString("name"));
        }
    }
}
