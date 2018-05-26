/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.Model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import pokemon.Class.Pokemon;
/**
 *
 * @author Danilo
 */
public class PokemonTable extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    List<Pokemon> list;
    
    public PokemonTable(List<Pokemon> list) {
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
            case 0  : return "ID";
            case 1  : return "NAME";
            case 2  : return "LEVEL";
            case 3  : return "HP";
            case 4  : return "AGILITY";
            case 5  : return "ATK";
            case 6  : return "DEF";
            case 7  : return "SPC. ATK";
            case 8  : return "SPC. DEF";
            default : return null;
        }
    }
}
