package Controller;

import Model.Pokemon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PokemonDAO {
    private final Connection connection;
    
    public PokemonDAO(){
        this.connection = new ConnectionPokemon().getConnection();
    }
    public List<Pokemon> listPokemon(){
        List<Pokemon> PK = new ArrayList<Pokemon>();
        try {
            String sql = "SELECT * FROM java_Pokemon";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pokemon P= new Pokemon();
                P.setName(rs.getString("nome"));
                P.setLevel(rs.getInt("10"));
                P.setHp(rs.getInt("100"));
                P.setAgility(rs.getInt("25"));
                P.setAttack(rs.getInt("50"));
                P.setDefense(rs.getInt("100"));
                P.setSpecialAttack(rs.getInt("80"));
                P.setSpecialDefense(rs.getInt("10"));
                PK.add(P);
            }
            stmt.close();
            return PK;
        } catch (Exception e) {
            System.err.println("===============================");
            System.err.println("PokemonDAO");
            System.err.println("Erro no metodo Pokemon");
            System.err.println("\n" + e.getCause());
            System.err.println("\n" + e.getMessage());
            throw new RuntimeException(e);
            
        }
        
    }
    public void Inserir(Pokemon PK){
            String slq = "insert into java_Pokemon values(?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = this.connection.prepareStatement(slq);
                
                stmt.setInt(1,PK.getLevel());
                stmt.setString(2, PK.getName());
                stmt.setInt(3,PK.getHp());
                stmt.setInt(4,PK.getAgility());
                stmt.setInt(5,PK.getAttack());
                stmt.setInt(6,PK.getDefense());
                stmt.setInt(7,PK.getSpecialAttack());
                stmt.setInt(8,PK.getSpecialDefense());
                
                
                stmt.execute();
                stmt.close();
                
            } catch (Exception e) {
                System.err.println("===============================");
                System.err.println("PokemonDAO");
                System.err.println("Erro no metodo Pokemon");
                System.err.println("\n" + e.getCause());
                System.err.println("\n" + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException();
                
            }
            
        }
    public void remove(String PK){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from java_Pokemon where name=?");
            stmt.setString(1, PK);
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            System.err.println("===============================");
                System.err.println("PokemonDAO");
                System.err.println("Erro no metodo Pokemon");
                System.err.println("\n" + e.getCause());
                System.err.println("\n" + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
        }
    }
        
    }
    

