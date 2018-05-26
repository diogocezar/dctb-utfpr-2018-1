package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPokemon {
    public Connection getConnection(){
        try {
            return
            DriverManager.getConnection("jdbc:mysql://localhost:3306/atividade_06?", "root","12345");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
