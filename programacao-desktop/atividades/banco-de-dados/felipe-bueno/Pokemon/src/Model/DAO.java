/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class DAO {
    
    private final DataBase bd = new DataBase(new ConfigurationsMySQL());
    private ArrayList<Pokemon> pokemons;
    
    public void inserirPokemon(Pokemon pokemon){
        this.bd.execute("INSERT INTO Pokemon(Id, Nome, Nivel, HP, Agility, Attack, Defense, SpecialAttack, SpecialDefense) VALUES (?,?,?,?,?,?,?,?,?)"
        , pokemon.getId(), pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getAgility(), pokemon.getAttack()
        , pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense());
    }
    
    public void deletePokemon(int id){
        this.bd.execute("DELETE FROM Pokemon WHERE Id=?", id);
    }
    
    public ArrayList<Pokemon> consultarPokemon(){
        this.pokemons = new ArrayList<Pokemon>();
        ResultSet rs = this.bd.query("SELECT * FROM Pokemon ORDER BY Id");
        try {
            while(rs.next()){
                Pokemon poke = new Pokemon();
                poke.setId(rs.getInt("Id"));
                poke.setName(rs.getString("Nome"));
                poke.setLevel(rs.getInt("Nivel"));
                poke.setHp(rs.getInt("HP"));
                poke.setAgility(rs.getInt("Agility"));
                poke.setAttack(rs.getInt("Attack"));
                poke.setDefense(rs.getInt("Defense"));
                poke.setSpecialAttack(rs.getInt("SpecialAttack"));
                poke.setSpecialDefense(rs.getInt("SpecialDefense"));
                pokemons.add(poke);
            }
            return pokemons;
        } catch(SQLException e){
            System.out.println("Erro a: " + e.getMessage());
        }
        return null;
    }
}
