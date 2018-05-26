/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;
import Model.Interface.ImplementPokemon;
import Configuration.ConfigurationsMysql;
import DataBase.DataBase;
import Model.Pokemon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JOAO
 */
public class PokemonDao implements ImplementPokemon{
    private List<Pokemon> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMysql());
            
    @Override
    public void insert(Pokemon pokemon) {
        this.db.execute("INSERT INTO java_pokemon (name,level,hp,agility,attack,defense,specialAttack,specialDefense)VALUES (?,?,?,?,?,?,?,?) ", pokemon.getName(), pokemon.getLevel(),pokemon.getHp(),pokemon.getAgility(),pokemon.getAttack(),pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense());
       
    }

    @Override
    public void update(Pokemon pokemon) {
        this.db.execute("UPDATE java_pokemon SET Level=?,HP=?,Agility=?,Attack=?,Defense=?,SpecialAttack=?,SpecialDefense=? WHERE name LIKE '%" + pokemon.getName() + "%'",
                pokemon.getLevel(), pokemon.getHp(),pokemon.getAgility(),
                pokemon.getAttack(),pokemon.getDefense(),pokemon.getSpecialAttack(),
                pokemon.getSpecialDefense());
    }

    @Override
    public void delete(String name) {
        this.db.execute("DELETE FROM java_pokemon WHERE name LIKE '%"+ name + "%'");
    }

    @Override
    public List<Pokemon> getPokemon(String name) {
        list = new ArrayList<Pokemon>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_pokemon WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
               
                Pokemon pokemon = new Pokemon();
                pokemon.setName(rs.getString(1));
                pokemon.setLevel(rs.getInt(2));
                pokemon.setHp(rs.getInt(3));
                pokemon.setAgility(rs.getInt(4));
                pokemon.setAttack(rs.getInt(5));
                pokemon.setDefense(rs.getInt(6));
                pokemon.setSpecialAttack(rs.getInt(7));
                pokemon.setSpecialDefense(rs.getInt(8));
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
        ResultSet rs = this.db.query("SELECT * FROM java_pokemon ORDER BY name");
        try {
            while(rs.next()){
               Pokemon pokemon = new Pokemon();
                pokemon.setName(rs.getString(1));
                pokemon.setLevel(rs.getInt(2));
                pokemon.setHp(rs.getInt(3));
                pokemon.setAgility(rs.getInt(4));
                pokemon.setAttack(rs.getInt(5));
                pokemon.setDefense(rs.getInt(6));
                pokemon.setSpecialAttack(rs.getInt(7));
                pokemon.setSpecialDefense(rs.getInt(8));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um pokemon pelo nome: " + ex.getMessage());
        }
        return null;
    }


}


