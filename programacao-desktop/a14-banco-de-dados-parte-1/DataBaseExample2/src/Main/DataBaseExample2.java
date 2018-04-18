package Main;

import DataBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseExample2 {
    public static void main(String[] args) {
        DataBase db  = new DataBase();
        
        // Exemplo Select
        ResultSet rs = db.query("SELECT * FROM item_java");
        try {
            while(rs.next()){
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Nome: " + rs.getString("name"));
            }
        } catch (SQLException ex){
            System.out.println("Erro ao exibir uma consulta: " + ex.getMessage());
        }
        
        // Exemplo Insert
        db.execute("INSERT INTO item_java (id, name) VALUES (?, ?)", 4, "Almeida");
        
        // Exemplo Update
        db.execute("UPDATE item_java SET name=? WHERE id=?", "Almeida Gomes", 4);
        
        // Exemplo Delete
        db.execute("DELETE FROM item_java WHERE id=?", 4);
        
        db.disconnect();
    }
}
