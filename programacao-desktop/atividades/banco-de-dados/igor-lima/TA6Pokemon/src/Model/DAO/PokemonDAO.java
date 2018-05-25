/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Interfaces.ImplementPokemon;
import Configurations.ConfigurationsMySQL;
import Database.Database;
import Model.Pokemon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorv
 */
public class PokemonDAO implements ImplementPokemon {
    private List<Pokemon> list;
    
    private final Database db = new Database(new ConfigurationsMySQL());
                //id,name,level,hp,agility,attack,defense,spA,spD
    @Override
    public void insert(Pokemon p) {
        this.db.execute("INSERT INTO pokemon (name, level, hp, agility, attack, defense, specialAttack, specialDefense) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                p.getName(), p.getLevel(), p.getHp(), p.getAgility(), p.getAttack(), p.getDefense(), p.getSpecialAttack(), p.getSpecialDefense());
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        this.db.execute("UPDATE pokemon SET name=? WHERE id=?", pokemon.getName(), pokemon.getId());
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
            while (rs.next()) { 
                Pokemon p = new Pokemon();
                p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setLevel(rs.getInt(3));
                p.setHp(rs.getInt(4));
                p.setAttack(rs.getInt(5));
                p.setDefense(rs.getInt(6));
                p.setSpecialAttack(rs.getInt(7));
                p.setSpecialDefense(rs.getInt(8));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao recuperar o Pokemon: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        list = new ArrayList<Pokemon>();
        ResultSet rs = this.db.query("SELECT id, name, level, agility, hp, attack, specialAttack, specialDefense FROM pokemon ORDER BY id");
        try {
            while(rs.next()){
                Pokemon p = new Pokemon();
                p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setLevel(rs.getInt(3));
                p.setHp(rs.getInt(4));
                p.setAttack(rs.getInt(5));
                p.setDefense(rs.getInt(6));
                p.setSpecialAttack(rs.getInt(7));
                p.setSpecialDefense(rs.getInt(8));
                list.add(p);
                
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
    
}
