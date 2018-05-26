/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Configurations.ConfigurationsMySQL;
import Database.DatabaseGeneric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Interfaces.ImplementPokemon;
import model.Pokemon;

/**
 *
 * @author felipe
 */
public class PokemonDAO extends DatabaseGeneric implements ImplementPokemon {

    public ArrayList<Pokemon> list;

    public PokemonDAO() {
        super(new ConfigurationsMySQL(), "pokemon");
    }

    @Override
    public void insert(Pokemon pokemon) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("name", pokemon.getName());
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Pokemon pokemon) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("name", pokemon.getName());
        mapConditions.put("id", pokemon.getId());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("id", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Pokemon> getPokemonByName(String name) {
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(1));
                pokemon.setName(rs.getString("name"));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um Pokemon: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(1));
                pokemon.setName(rs.getString("name"));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um Pokemon pelo nome: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Pokemon getOnePokemon(int id) {
        ResultSet rs = this.getOne(id);
        Pokemon pokemon = new Pokemon();
        try {
            pokemon.setId(rs.getInt(1));
            pokemon.setName(rs.getString("name"));
            return pokemon;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um Pokemon pelo id: " + ex.getMessage());
        }
        return null;
    }
}
