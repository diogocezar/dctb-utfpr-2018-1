/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Model.DAO;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Pokemon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Interfaces.ImplementPokemon;

public class PokemonDAO implements ImplementPokemon{
    
    private List<Pokemon> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Pokemon pokemon) {
        this.db.execute("INSERT INTO Pokemon (name,level,hp,agility,attack,defense,specialAttack,specialDefense) VALUES (?,?,?,?,?,?,?,?)", pokemon.getName(), pokemon.getLevel(), 
            pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense());
    }

    @Override
    public void update(Pokemon pokemon) {
        this.db.execute("UPDATE Pokemon SET name=?,level=?,hp=?,agility=?,attack=?,defense=?,specialAttack=?,specialDefense=? WHERE id=?", pokemon.getName(), pokemon.getLevel(), 
            pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense(), pokemon.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM Pokemon WHERE id=?", id);
    }

    @Override
    public List<Pokemon> getPokemon(String name) {
        list = new ArrayList<Pokemon>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM Pokemon WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(1));
                pokemon.setName(rs.getString("name"));
                 pokemon.setLevel(rs.getInt(1));
                 pokemon.setHp(rs.getInt(1));
                 pokemon.setAgility(rs.getInt(1));
                 pokemon.setAttack(rs.getInt(1));
                 pokemon.setDefense(rs.getInt(1));
                 pokemon.setSpecialAttack(rs.getInt(1));
                 pokemon.setSpecialDefense(rs.getInt(1));
                 
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um pokemon: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        list = new ArrayList<Pokemon>();
        ResultSet rs = this.db.query("SELECT * FROM Pokemon ORDER BY id");
        try {
            while(rs.next()){
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setLevel(rs.getInt("level"));
                pokemon.setHp(rs.getInt("hp"));
                 pokemon.setAgility(rs.getInt("agility"));
                 pokemon.setAttack(rs.getInt("attack"));
                 pokemon.setDefense(rs.getInt("defense"));
                 pokemon.setSpecialAttack(rs.getInt("specialAttack"));
                 pokemon.setSpecialDefense(rs.getInt("specialDefense"));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um pokemon pelo nome: " + ex.getMessage());
        }
        return null;
    }
}
