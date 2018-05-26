/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MySQL;

import Configurations.ConfigurationsMySQL;
import DAO.Interfaces.PokemonDAO;
import DataBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Pokemon;

/**
 *
 * @author kassia
 */
public class PokemonMySQL implements PokemonDAO {
    DataBase db;
    
    public PokemonMySQL(){
        this.db = new DataBase(new ConfigurationsMySQL());
    }
    
    @Override
    public void insert(Pokemon pokemon){
        this.db.execute("INSERT INTO pokemon (name) VALUES (?)", pokemon.getName());
    }
    
    @Override
    public Pokemon findByName(Pokemon pokemon){
        ResultSet rs = this.db.query("SELECT id, name FROM pokemon WHERE name LIKE %?%", pokemon.getName());
        try {
            return new Pokemon(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public void update(Pokemon pokemon) {
        this.db.execute("UPDATE pokemon SET name=? WHERE id=?", pokemon.getName(), pokemon.getId());
    }

    @Override
    public void delete(Pokemon pokemon) {
        this.db.execute("DELETE FROM pokemon WHERE id=?", pokemon.getId());
    }

    @Override
    public ArrayList<Pokemon> getAll() {
        ResultSet rs = this.db.query("SELECT id, name FROM java_course ORDER BY id");
        ArrayList<Pokemon> result = new ArrayList<>();
        try {
            while(rs.next()){
                Pokemon c = new Pokemon(rs.getInt("id"), rs.getString("name"));
                result.add(c);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}
