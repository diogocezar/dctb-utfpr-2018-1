package model.table;

import model.Pokemon;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author christian
 */
public class TableModelPokemon extends AbstractTableModel {

    private List<Pokemon> list;
    
    public TableModelPokemon(List<Pokemon> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() { return this.list.size(); }

    @Override
    public int getColumnCount() { return 9; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return this.list.get(rowIndex).getId();
            case 1: return this.list.get(rowIndex).getName();
            case 2: return this.list.get(rowIndex).getLevel();
            case 3: return this.list.get(rowIndex).getHp();
            case 4: return this.list.get(rowIndex).getAgility();
            case 5: return this.list.get(rowIndex).getAttack();
            case 6: return this.list.get(rowIndex).getDefense();
            case 7: return this.list.get(rowIndex).getSpecialAttack();
            case 8: return this.list.get(rowIndex).getSpecialDefense();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "NOME";
            case 2: return "NIVEL";
            case 3: return "HP";
            case 4: return "AGILIDADE";
            case 5: return "ATAQUE";
            case 6: return "DEFESA";
            case 7: return "AT. ESPECIAL";
            case 8: return "DF. ESPECIAL";
            default : return null;
        }
    }

}
