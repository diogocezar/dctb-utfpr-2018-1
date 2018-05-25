package controller;

import model.Pokemon;
import model.dao.PokemonDAO;
import model.interfaces.IPokemon;
import view.PokemonPanelData;
import javax.swing.JFrame;
import controller.ControllerMainForm;
import java.util.List;

/**
 *
 * @author christian
 */
public class ControllerDataForm {
    
    private JFrame parent;
    private final PokemonPanelData panel;
    private final IPokemon ipokemon;
    
    public ControllerDataForm(PokemonPanelData panel, JFrame parent) {
        this.panel = panel;
        this.ipokemon = new PokemonDAO();
        this.parent = parent;
    }
    
    public Pokemon prepareToSave() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(this.panel.getTxtName().getText());
        pokemon.setLevel(this.panel.getSliderLevel().getValue());
        pokemon.setHp((Integer)this.panel.getSpinnerHp().getValue());
        pokemon.setAgility(this.panel.getSliderAgility().getValue());
        pokemon.setAttack(this.panel.getSliderAttack().getValue());
        pokemon.setDefense(this.panel.getSliderDefense().getValue());
        pokemon.setSpecialAttack(this.panel.getSliderSpecialAt().getValue());
        pokemon.setSpecialDefense(this.panel.getSliderSpecialDf().getValue());
        return pokemon;
    }
    
    public void save() {
        this.ipokemon.insert(prepareToSave());
        this.close();
    }
    
    public void close() {
        this.parent.dispose();
    }
    
}
