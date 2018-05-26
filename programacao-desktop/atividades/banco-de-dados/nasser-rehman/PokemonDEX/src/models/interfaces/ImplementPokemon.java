/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.interfaces;

import java.util.List;
import models.Pokemon;

/**
 *
 * @author nadook
 */
public interface ImplementPokemon {
    public void insert(Pokemon pokemon);
    public void update(Pokemon pokemon);
    public void delete(int id);
    public List<Pokemon> getPokemonById(int id);
    public List<Pokemon> getPokemon(String name);
    public List<Pokemon> getAllPokemons();
}
