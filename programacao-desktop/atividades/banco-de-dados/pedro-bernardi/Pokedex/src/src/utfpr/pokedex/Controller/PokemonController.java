/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/
package src.utfpr.pokedex.Controller;

import src.utfpr.pokedex.Model.Table.TabelModelPokemon;
import java.util.List;
import javax.swing.JOptionPane;
import src.utfpr.pokedex.Model.DAO.PokemonDAO;
import src.utfpr.pokedex.Model.Interfaces.ImplementPokemon;
import src.utfpr.pokedex.Model.Move;
import src.utfpr.pokedex.Model.Pokemon;
import src.utfpr.pokedex.Model.Type;
import src.utfpr.pokedex.View.PokemonForm;

public class PokemonController {

    private final PokemonForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;

    public PokemonController(PokemonForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
        implementPokemon.create();
        list = implementPokemon.getAllPokemon();
    }

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTxtAttack().setText("");
        panel.getTxtType().setText("");
        panel.getTxtDefense().setText("");
        panel.getTxtHp().setText("");
        panel.getTxtSp_atk().setText("");
        panel.getTxtSp_def().setText("");
        panel.getTxtSpeed().setText("");
        panel.getTxtHeight().setText("");
        panel.getTxtWeight().setText("");
        panel.getTabelCourse().clearSelection();
    }

    public void setTabel() {
        list = implementPokemon.getAllPokemon();
        panel.getTabelCourse().setModel(new TabelModelPokemon(list));
    }

    public void getDataField() {
        int row = panel.getTabelCourse().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
            panel.getTxtAttack().setText(Integer.toString(list.get(row).getMove().getAttack()));
            panel.getTxtDefense().setText(Integer.toString(list.get(row).getMove().getDefense()));
            panel.getTxtHp().setText(Integer.toString(list.get(row).getMove().getHp()));
            panel.getTxtSp_atk().setText(Integer.toString(list.get(row).getMove().getSp_atk()));
            panel.getTxtSp_def().setText(Integer.toString(list.get(row).getMove().getSp_def()));
            panel.getTxtSpeed().setText(Integer.toString(list.get(row).getMove().getSpeed()));
            panel.getTxtHeight().setText(list.get(row).getHeight());
            panel.getTxtWeight().setText(list.get(row).getWeight());
            panel.getTxtType().setText(list.get(row).getType().getType().get(0));

        }
    }

    public void insert() {
        String error = isEmpy();
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(panel, error, null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        Pokemon pokemon = new Pokemon();
        pokemon.setId(Integer.parseInt(panel.getTxtId().getText()));
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setMove(new Move(
                Integer.parseInt(panel.getTxtAttack().getText()),
                Integer.parseInt(panel.getTxtDefense().getText()),
                Integer.parseInt(panel.getTxtHp().getText()),
                Integer.parseInt(panel.getTxtSp_atk().getText()),
                Integer.parseInt(panel.getTxtSp_def().getText()),
                Integer.parseInt(panel.getTxtSpeed().getText())
        ));
        pokemon.setType(new Type(panel.getTxtType().getText()));
        pokemon.setHeight(panel.getTxtHeight().getText());
        pokemon.setWeight(panel.getTxtWeight().getText());
        implementPokemon.insert(pokemon);
    }

    public String isEmpy() {
        String erro = "";
        String message = "não pode estar vazio";
        if (panel.getTxtName().getText().trim().isEmpty())
            erro += "Nome " + message + "\n";
        if (panel.getTxtAttack().getText().trim().isEmpty())
            erro += "Ataque " + message + "\n";
        if (panel.getTxtDefense().getText().trim().isEmpty())
            erro += "Defesa " + message + "\n";
        if (panel.getTxtHp().getText().trim().isEmpty())
            erro += "HP " + message + "\n";
        if (panel.getTxtSp_atk().getText().trim().isEmpty())
            erro += "Ataque Esp. " + message + "\n";
        if (panel.getTxtSp_def().getText().trim().isEmpty())
            erro += "Defesa Esp. " + message + "\n";
        if (panel.getTxtSpeed().getText().trim().isEmpty())
            erro += "Velocidade " + message + "\n";
        if (panel.getTxtHeight().getText().trim().isEmpty())
            erro += "Altura " + message + "\n";
        if (panel.getTxtWeight().getText().trim().isEmpty())
            erro += "Peso " + message + "\n";
        if (panel.getTxtType().getText().trim().isEmpty())
            erro += "Tipo " + message + "\n";
        return erro;
    }

    public void update() {
        
        String error = isEmpy();
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(panel, error, null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        Pokemon pokemon = new Pokemon();
        pokemon.setId(Integer.parseInt(panel.getTxtId().getText()));
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setMove(new Move(
                Integer.parseInt(panel.getTxtAttack().getText()),
                Integer.parseInt(panel.getTxtDefense().getText()),
                Integer.parseInt(panel.getTxtHp().getText()),
                Integer.parseInt(panel.getTxtSp_atk().getText()),
                Integer.parseInt(panel.getTxtSp_def().getText()),
                Integer.parseInt(panel.getTxtSpeed().getText())
        ));
        pokemon.setType(new Type(panel.getTxtType().getText()));
        pokemon.setHeight(panel.getTxtHeight().getText());
        pokemon.setWeight(panel.getTxtWeight().getText());
        implementPokemon.update(pokemon);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementPokemon.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementPokemon.getPokemon(name);
        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementPokemon.getPokemon(name);
        panel.getTabelCourse().setModel(new TabelModelPokemon(list));
    }
}
