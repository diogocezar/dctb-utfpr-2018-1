/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import Configurations.ConfigurationsMySQL;
import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Pokemon;
import models.interfaces.ImplementPokemon;

/**
 *
 * @author nadook
 */
public class PokemonDAO implements ImplementPokemon {

    private List<Pokemon> list;
    private final Database db = new Database(new ConfigurationsMySQL());
    
    @Override
    public void insert(Pokemon pokemon) {
        this.db.execute("INSERT INTO pokemon (name, level, hp, agility, attack, defense, specialAttack, specialDefense) VALUES (?, ?, ?, ?, ?, ?, ? ,? )", pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense());
    }

    @Override
    public void update(Pokemon pokemon) {
        this.db.execute("UPDATE pokemon SET name=?, level=?, hp=?, agility=?, attack=?, defense=?, specialAttack=?, specialDefense=? WHERE id=?", pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense(), pokemon.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM pokemon WHERE id=?", id);
    }

    @Override
    public List<Pokemon> getPokemon(String name) {
        list = new ArrayList<Pokemon>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM pokemon WHERE name LIKE '%" + name + "%'");
            while (rs.next()) 
            {
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
        }
        catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um pokemon: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Pokemon> getPokemonById(int id) {
        list = new ArrayList<Pokemon>();
        ResultSet rs = this.db.query("SELECT * FROM pokemon WHERE id="+ id);
        
        try {
            while (rs.next())
            {
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
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        list = new ArrayList<Pokemon>();
        ResultSet rs = this.db.query("SELECT * FROM pokemon ORDER BY id");
        
        try {
            while (rs.next()) {
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
            System.out.println("Erro ao retornar um curso: " + ex.getMessage());
        }
        return null;
    }
    
    
}
