/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interfaces;

import java.util.List;
import model.Pokemon;

/**
 *
 * @author felipe
 */
public interface ImplementPokemon {

    public void insert(Pokemon pokemon);

    public void update(Pokemon pokemon);

    public void delete(int id);

    public List<Pokemon> getPokemonByName(String name);

    public List<Pokemon> getAllPokemons();

    public Pokemon getOnePokemon(int id);

}
