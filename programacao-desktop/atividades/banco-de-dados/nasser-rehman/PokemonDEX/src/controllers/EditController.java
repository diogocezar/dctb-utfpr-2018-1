/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.DAO.PokemonDAO;
import models.Pokemon;
import models.interfaces.ImplementPokemon;
import views.EditPanelForm;

/**
 *
 * @author nadook
 */
public class EditController {
    
    private final EditPanelForm panel;
    private final PokemonDAO implementPokemon;
            
    public EditController(EditPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
    }
    
    public void update(int id) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(id);
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setHp(Integer.parseInt(panel.getTxtLife().getText()));
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
        
        implementPokemon.update(pokemon);
        
    }
    
}
