/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedex.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pokedex.Classes.Pokemon;
import pokedex.Config.ConfigurationsMySQL;
import pokedex.DataBase.DataBase;
import pokedex.model.Interfaces.PokemonOperations;

/**
 *
 * @author noda
 */
public class PokemonDAOMySql implements PokemonOperations{
    DataBase db;
    
    String insert = "INSERT INTO `Pokemon`(`name`, `level`, `hp`, `agility`, `attack`, `defense`, `special_attack`, `special_defense`) VALUES (?,?,?,?,?,?,?,?)";
    String update = "UPDATE `Pokemon` SET `name`=?,`level`=?,`hp`=?,`agility`=?,`attack`=?,`defense`=?,`special_attack`=?,`special_defense`=? WHERE `name`=?";
    String delete = "DELETE FROM `Pokemon` WHERE `name`=?";
    String select = "SELECT * FROM `Pokemon` WHERE `name`=?";
    String selectAll = "SELECT * FROM `Pokemon`";
    
    public PokemonDAOMySql(){
        DataBase.getInstance().setConfig(new ConfigurationsMySQL());
        this.db = DataBase.getInstance();
    }
    
    private Object[] getData(Pokemon pokemon, int len){
        Object[] tmp = new Object[len];
        tmp[0] = pokemon.getName();
        tmp[1] = pokemon.getLevel();
        tmp[2] = pokemon.getHp();
        tmp[3] = pokemon.getAgility();
        tmp[4] = pokemon.getAttack();
        tmp[5] = pokemon.getDefense();
        tmp[6] = pokemon.getSpecialAttack();
        tmp[7] = pokemon.getSpecialDefense();
        return tmp;
    }
    
    private Pokemon getDataFromResultSet(ResultSet result) throws SQLException{
        return new Pokemon(result.getString("name"), 
                    result.getInt("level"),
                    result.getInt("hp"), 
                    result.getInt("agility"), 
                    result.getInt("attack"), 
                    result.getInt("defense"), 
                    result.getInt("special_attack"), 
                    result.getInt("special_defense"));
    }
    
    @Override
    public void insert(Pokemon pokemon) {
        db.exec(insert, getData(pokemon,8));
        db.disconnect();
    }
    
    //cant change name of pokemon
    @Override
    public void update(Pokemon pokemon) {
        Object[] data = getData(pokemon, 9);
        data[8] = pokemon.getName();
        db.exec(update,data);
        db.disconnect();
    }

    @Override
    public void delete(Pokemon pokemon) {
        db.exec(delete, pokemon.getName());
        db.disconnect();
    }

    @Override
    public Pokemon getPokemon(String name) {
        try {
            ResultSet result = db.query(select, name);
            if(result.next()){
                Pokemon pokemon = getDataFromResultSet(result);
                db.disconnect();
                return pokemon;
            }
        } catch (SQLException ex) {
            System.out.println("Error getting pokemon with name: "+name);
            System.out.println(ex.getMessage());
        }
        db.disconnect();
        return null;
    }

    @Override
    public ArrayList<Pokemon> getAllPokemon() {
        try {
            ResultSet result = db.query(selectAll);
            ArrayList<Pokemon> pokemonList = new ArrayList<>();
            while(result.next()){
                pokemonList.add(getDataFromResultSet(result));
            }
            db.disconnect();
            return pokemonList;
        } catch (SQLException ex) {
            System.out.println("Error while getting list of pokemon");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
