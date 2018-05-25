package controller;

import java.util.List;
import javax.swing.JFrame;
import view.PokemonPanelForm;
import model.Pokemon;
import model.dao.PokemonDAO;
import model.interfaces.IPokemon;
import model.table.TableModelPokemon;

/**
 *
 * @author christian
 */
public class ControllerMainForm {

    private JFrame parent;
    private final PokemonPanelForm panel;
    private final IPokemon ipokemon;
    private List<Pokemon> list;
    
    public ControllerMainForm(PokemonPanelForm panel, JFrame parent) {
        this.panel = panel;
        this.ipokemon = new PokemonDAO();
        this.list = this.ipokemon.getAllPokemon();
        this.parent = parent;
    }
    
    public void reset() {
        this.panel.getTxtQueryName();
        this.panel.getTablePokemon().clearSelection();
    }
    
    public void setTable() {
        this.list = this.ipokemon.getAllPokemon();
        this.panel.getTablePokemon().setModel(new TableModelPokemon(this.list));
    }
    
    public List<Pokemon> getData() {
        return this.list;
    }
    
    public void close() {
        this.parent.dispose();
    }
    
}
