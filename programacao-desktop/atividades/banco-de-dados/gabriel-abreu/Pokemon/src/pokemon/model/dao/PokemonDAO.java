/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.model.dao;

import java.util.ArrayList;
import pokemon.model.objects.Pokemon;

/**
 *
 * @author gabriel
 */
public abstract class PokemonDAO {
    public abstract void insertPokemon(Pokemon pokemon) throws Exception;
    public abstract void removePokemon(Pokemon pokemon) throws Exception;
    public abstract void updatePokemon(String oldName,Pokemon pokemon) throws Exception;
    public abstract Pokemon getPokemon(String name) throws Exception;
    public abstract ArrayList<Pokemon> getALlPokemons() throws Exception;
}
