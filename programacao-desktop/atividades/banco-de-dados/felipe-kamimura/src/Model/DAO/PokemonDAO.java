/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Interfaces.ImplementPokemon;
import Model.Pokemon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamimuraf
 */
public class PokemonDAO  implements ImplementPokemon{
    private List<Pokemon> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Pokemon pokemon) {
        this.db.execute("INSERT INTO cadpokemon (name, level, hp, agility, attack, defense, specialAttack, specialDefense) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", 
                                            pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack(),
                                                pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense());
    }

    @Override
    public void update(Pokemon pokemon) {
        this.db.execute("UPDATE cadpokemon SET name=?, level=?, hp=?, agility=?, attack=?, defense=?, specialAttack=?, specialDefense=? WHERE id=?", 
                pokemon.getName(), pokemon.getLevel(),pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack(),
                                                pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense(), pokemon.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM cadpokemon WHERE id=?", id);
    }

    @Override
    public List<Pokemon> getPokemon(String name) {
        list = new ArrayList<Pokemon>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM cadpokemon WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(1));
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
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        list = new ArrayList<Pokemon>();
        ResultSet rs = this.db.query("SELECT * FROM cadpokemon ORDER BY id");
        try {
            while(rs.next()){
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(1));
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
