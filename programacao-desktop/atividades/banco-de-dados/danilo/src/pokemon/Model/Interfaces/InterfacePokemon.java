/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.Model.Interfaces;

import java.util.List;
import pokemon.Class.Pokemon;

/**
 *
 * @author Danilo
 */
public interface InterfacePokemon {
    public void insert(Pokemon pokemon);
    public void update(Pokemon pokemon);
    public void delete(int id);
    public List<Pokemon> getPokemon(int id);
    public List<Pokemon> getAllPokemon();
}
