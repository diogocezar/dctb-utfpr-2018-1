/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pokemon.Class.Pokemon;
import pokemon.DataBase.DataBase;
import pokemon.Model.Interfaces.InterfacePokemon;
import pokemon.Config.ConfigurationsMySQL;
/**
 *
 * @author Danilo
 */
public class PokemonDAO implements InterfacePokemon{
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
    private List<Pokemon> list;

    @Override
    public void insert(Pokemon pokemon) {
        this.db.execute("INSERT INTO Pokemon (name, level, hp, agility, attack, defense, specialAttack, specialDefense) VALUES (?,?,?,?,?,?,?,?)",
            pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getAgility(),
            pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense());    }

    @Override
    public void update(Pokemon pokemon) {
        this.db.execute("UPDATE Pokemon SET name=?, level=?, hp=?, agility=?, attack=?, defense=?, specialAttack=?, specialDefense=? WHERE id=?",
            pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getAgility(),
            pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense(), pokemon.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM pokemons WHERE id=?", id);
    }

    @Override
    public List<Pokemon> getPokemon(int id) {
        list = new ArrayList<Pokemon>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM pokemons WHERE id ="+id);
            while (rs.next()) { 
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setHp(rs.getInt("hp"));
                pokemon.setLevel(rs.getInt("level"));
                pokemon.setAttack(rs.getInt("attack"));
                pokemon.setDefense(rs.getInt("defense"));
                pokemon.setSpecialAttack(rs.getInt("specialAttack"));
                pokemon.setSpecialDefense(rs.getInt("specialDefense"));
                pokemon.setAgility(rs.getInt("agility"));
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
        ResultSet rs = this.db.query("SELECT * FROM pokemons ORDER BY id");
        try {
            while(rs.next()){
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setHp(rs.getInt("hp"));
                pokemon.setLevel(rs.getInt("level"));
                pokemon.setAttack(rs.getInt("attack"));
                pokemon.setDefense(rs.getInt("defense"));
                pokemon.setSpecialAttack(rs.getInt("specialAttack"));
                pokemon.setSpecialDefense(rs.getInt("specialDefense"));
                pokemon.setAgility(rs.getInt("agility"));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um pokemon pelo nome: " + ex.getMessage());
        }
        return null;    }
    
}
