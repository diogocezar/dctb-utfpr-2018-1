package databaseexample1;

import java.sql.*;

public class UpdateFromDatabase {
    
    private Connection con        = null;
    private PreparedStatement pst = null;
    
    public void updateDatabase() throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost:3306/items?useUnicode=true&characterEncoding=utf-8";
        
        String sql = "UPDATE item_java SET name=? WHERE id=?";
       
        con = DriverManager.getConnection(url, "root", "");
        
        pst = con.prepareStatement(sql);
       
        pst.setString(1, "Almeida Gomes");
        pst.setInt(2, 4);
        
        
        pst.executeUpdate();
   
    }
}
