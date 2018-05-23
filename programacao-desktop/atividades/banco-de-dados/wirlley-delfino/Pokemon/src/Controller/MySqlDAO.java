
package Controller;
import java.sql.*;

/**
 *
 * @author Wirlley Delfino
 */
public class MySqlDAO {
    private Connection con;
    private Statement stm;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public void insert(String name, int level, int hp, int agi, int atk, int def, int specialAtk, int specialDef) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex", "root", "123456");
        String query = "insert into pokemons(name, level, hp, agi, atk, def, specialAtk, specialDef)" + " values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString (1, name);
        ps.setInt(2,level);
        ps.setInt(3,hp);
        ps.setInt(4,agi);
        ps.setInt(5,atk);
        ps.setInt(6,def);
        ps.setInt(7,specialAtk);
        ps.setInt(8,specialDef);
        ps.execute();
    }
    
    public void delete(String id) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex", "root", "123456");
        String query = "delete from pokemons where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ps.execute();
    }
    
    public void update(int id, String name, int level, int hp, int agi, int atk, int def, int specialAtk, int specialDef, String nome) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex", "root", "123456");
        String query = "update pokemons set name = ?, level = ?, hp = ?, agi = ?, atk = ?, def = ?, specialAtk = ?, specialDef = ?" + " where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString (1, name);
        ps.setInt(2,level);
        ps.setInt(3,hp);
        ps.setInt(4,agi);
        ps.setInt(5,atk);
        ps.setInt(6,def);
        ps.setInt(7,specialAtk);
        ps.setInt(8,specialDef);
        ps.setInt (9, id);
        ps.execute();
    }
    
    public ResultSet select() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex", "root", "123456");
        String query = "select * from pokemons";
        PreparedStatement ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        return rs;
    }
    
    public ResultSet select_especifique(String n) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex", "root", "123456");
        String query = "select * from pokemons where id='"+n+"'";
        PreparedStatement ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        return rs;
    }
}
