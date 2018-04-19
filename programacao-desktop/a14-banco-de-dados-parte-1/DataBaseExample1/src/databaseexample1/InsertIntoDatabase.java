package databaseexample1;

import java.sql.*;

public class InsertIntoDatabase {
    private Connection con        = null;
    private PreparedStatement pst = null;
    
    public void saveDatabase() throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost:3306/utfpr_tests?useUnicode=true&characterEncoding=utf-8";
        
        String sql = "INSERT INTO java_item (id, name) VALUES (?, ?)";
       
        con = DriverManager.getConnection(url, "root", "");
        
        pst = con.prepareStatement(sql);
        
        pst.setInt(1, 4);
        pst.setString(2, "Almeida");
        
        pst.executeUpdate();
   
    }
}
