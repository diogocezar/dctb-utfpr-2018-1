/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/
package src.utfpr.pokedex.Model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import src.utfpr.pokedex.Model.Pokemon;

public class TabelModelPokemon extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    List<Pokemon> list;

    public TabelModelPokemon(List<Pokemon> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getMove().getAttack();
            case 3:
                return list.get(rowIndex).getMove().getDefense();
            case 4:
                return list.get(rowIndex).getMove().getHp();
            case 5:
                return list.get(rowIndex).getMove().getSp_atk();
            case 6:
                return list.get(rowIndex).getMove().getSp_def();
            case 7:
                return list.get(rowIndex).getMove().getSpeed();
            case 8:
                return list.get(rowIndex).getHeight();
            case 9:
                return list.get(rowIndex).getWeight();
            case 10:
                return list.get(rowIndex).getType().getType().get(0);
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NOME";
            case 2:
                return "ATAQUE";
            case 3:
                return "DEFESA";
            case 4:
                return "HP";
            case 5:
                return "ATAQUE ESPECIAL";
            case 6:
                return "DEFESA ESPECIAL";
            case 7:
                return "VELOCIDADE";
            case 8:
                return "ALTURA";
            case 9:
                return "PESO";
            case 10:
                return "TIPO";
            default:
                return null;
        }
    }
}
