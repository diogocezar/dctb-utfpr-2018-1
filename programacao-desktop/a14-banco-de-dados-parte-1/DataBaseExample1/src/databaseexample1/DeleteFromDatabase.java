package databaseexample1;

import java.sql.*;

public class DeleteFromDatabase {
    private Connection con        = null;
    private PreparedStatement pst = null;
    
    public void deleteDatabase() throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost:3306/items?useUnicode=true&characterEncoding=utf-8";
        
        String sql = "DELETE FROM item_java WHERE id=?";
       
        con = DriverManager.getConnection(url, "root", "");
        
        pst = con.prepareStatement(sql);
       
        pst.setInt(1, 4);
        
        pst.executeUpdate();
   
    }
}
