/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DAO;
import Model.Pokemon;
import View.InterfacePokemon;
import java.util.ArrayList;

/**
 *
 * @author geovannemoro
 */

public class PokemonControl {
    private ArrayList<Pokemon> pokemons;
    private DAO dao;
    private final InterfacePokemon panel;
    
    public PokemonControl(InterfacePokemon panel){
        this.dao = new DAO();
        this.pokemons = dao.consultarPokemon();
        this.panel = panel;
    }
    
    public void resetTable(){
        int i = panel.getModelo().getRowCount();
        for(int j=0; j<i; j++){
            panel.getModelo().removeRow(j);
        }
    }
    
    public void setTable(){
        this.pokemons = dao.consultarPokemon();
        for(Pokemon pokemon : this.pokemons){
            String[] poke = {""+pokemon.getId(), pokemon.getName(), ""+pokemon.getLevel(), ""+pokemon.getHp(), ""+pokemon.getAgility(), ""+pokemon.getAttack(), ""+pokemon.getDefense(), ""+pokemon.getSpecialAttack(), ""+pokemon.getSpecialDefense()};
            panel.getModelo().addRow(poke);
        }
    }
    
    public void insert(Pokemon poke){
        dao.inserirPokemon(poke);
        this.resetTable();
    }
    
    public void remove(int id){
        dao.deletePokemon(id);
        this.resetTable();
    }
    
    public void getData(){
        this.resetTable();
        this.setTable();
    }
}
