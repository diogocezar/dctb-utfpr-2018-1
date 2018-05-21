/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pokemonregister.Database.Database;
import pokemonregister.Model.Interfaces.PokemonOperations;
import pokemonregister.Model.Pokemon;

/**
 *
 * @author ecsanchesjr
 */
public class PokemonDAO implements PokemonOperations {
    private final String insert = "INSERT INTO `pokemon`(`name`, `level`, `hp`, `agility`, `attack`, `defense`, `specialAttack`, `specialDefense`) VALUES (?,?,?,?,?,?,?,?)";
    private final String update = "UPDATE `pokemon` SET `name`=?,`level`=?,`hp`=?,`agility`=?,`attack`=?,`defense`=?,`specialAttack`=?,`specialDefense`=? WHERE `name`=?";
    private final String delete = "DELETE FROM `pokemon` WHERE `name`=?";
    private final String select = "SELECT * FROM `pokemon` WHERE `name`=?";
    private final String selectAll = "SELECT * FROM `pokemon`";

    @Override
    public boolean insert(Pokemon poke) {
        int ex = Database.getInstance().execute(insert, getPokemonData(poke));
        return ex == 1;
    }

    @Override
    public boolean update(Pokemon poke, String pokeName) {
        int ex = Database.getInstance().execute(update, pokeName, getPokemonData(poke));
        return ex == 1;
    }

    @Override
    public void delete(Pokemon poke) {
        Database.getInstance().execute(delete, poke.getName());
    }

    @Override
    public Pokemon getPokemon(Pokemon poke) {
        Pokemon pokemon = null;
        try {
            ResultSet rs = Database.getInstance().query(select, poke.getName());
            rs.next();
            
            pokemon = new Pokemon(rs.getString(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8));
            
        } catch (SQLException ex) {
            System.out.println("Erro na busca de pokemon");
        }
        return pokemon;
    }

    @Override
    public ArrayList<Pokemon> getAllPokemons() {
        ArrayList<Pokemon> listOfPokemons = new ArrayList<>();
        try {
            ResultSet rs = Database.getInstance().query(selectAll);
            
            while(rs.next()) {
                listOfPokemons.add(new Pokemon(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));   
            }
        } catch (SQLException ex) {
            System.out.println("Erro na busca de pokemon");
        }
        return listOfPokemons;
    }
    
    private Object[] getPokemonData(Pokemon poke) {
        Object[] pokeData = new Object[8];
        
        pokeData[0] = poke.getName();
        pokeData[1] = poke.getLevel();
        pokeData[2] = poke.getHp();
        pokeData[3] = poke.getAgility();
        pokeData[4] = poke.getAttack();
        pokeData[5] = poke.getDefense();
        pokeData[6] = poke.getSpecialAttack();
        pokeData[7] = poke.getSpecialDefense();
        
        return pokeData;
    }
}
