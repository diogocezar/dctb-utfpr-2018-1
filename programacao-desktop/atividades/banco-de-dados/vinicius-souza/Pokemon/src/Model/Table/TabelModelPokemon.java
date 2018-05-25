
package Model.Table;

import Model.Pokemon;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelPokemon extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<Pokemon> list ;

    public TabelModelPokemon(List<Pokemon> list) {
        this.list = list;
    }
       
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getName();
            case 2 : return list.get(rowIndex).getLevel();
            case 3 : return list.get(rowIndex).getHp();
            case 4 : return list.get(rowIndex).getAgility();
            case 5 : return list.get(rowIndex).getAttack();
            case 6 : return list.get(rowIndex).getDefense();
            case 7 : return list.get(rowIndex).getSpecialAttack();
            case 8 : return list.get(rowIndex).getSpecialDefense();
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NOME";
            case 2 : return "Nivel";
            case 3 : return "Vida";
            case 4 : return "Agilidade";
            case 5 : return "Ataque";
            case 6 : return "Defesa";
            case 7 : return "Ataque Especial";
            case 8 : return "Defesa Especial";
            default : return null;
        }
    }
}