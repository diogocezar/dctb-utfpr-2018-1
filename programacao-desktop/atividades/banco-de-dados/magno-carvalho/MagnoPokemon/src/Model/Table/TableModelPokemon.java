/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Table;
import Model.Pokemon;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author MAGNO
 */
public class TableModelPokemon extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;

    List<Pokemon> list ;

    public TableModelPokemon(List<Pokemon> list) {
        this.list = list;
    }
       
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getName();
            case 2 : return list.get(rowIndex).getAgility();
            case 3 : return list.get(rowIndex).getAttack();
            case 4 : return list.get(rowIndex).getDefese();
            case 5 : return list.get(rowIndex).getHp();
            case 6 : return list.get(rowIndex).getLevel();
            case 7 : return list.get(rowIndex).getSpecialAttack();
            case 8 : return list.get(rowIndex).getSpecialDefense();
            case 9 : return list.get(rowIndex).getSeason();


            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0  : return "ID";
            case 1  : return "name";
            case 2 : return "Agility";
            case 3 : return "Attack";
            case 4 : return "Defese";
            case 5 : return "hp";
            case 6 : return "Level";
            case 7 : return "Special attack";
            case 8 : return "Special Defense";
            case 9 : return "Season";
            default : return null;
        }
    }
    
}
