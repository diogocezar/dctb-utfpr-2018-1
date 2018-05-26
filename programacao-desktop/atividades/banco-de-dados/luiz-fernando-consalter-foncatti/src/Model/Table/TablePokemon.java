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
 * @author luiz-
 */
public class TablePokemon extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    List<Pokemon> list ;

    public TablePokemon(List<Pokemon> list) {
        this.list = list;
    }
       
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8; //qtidade de atributos
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getName();
            case 1 : return list.get(rowIndex).getLevel();
            case 2 : return list.get(rowIndex).getAgility();
            case 3 : return list.get(rowIndex).getHp();
            case 4 : return list.get(rowIndex).getAttack();
            case 5 : return list.get(rowIndex).getDefense();
            case 6 : return list.get(rowIndex).getSpecialAttack();
            case 7 : return list.get(rowIndex).getSpecialDefense();
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0  : return "Nome";
            case 1  : return "Level";
            case 2  : return "Agilidade";
            case 3  : return "Vida";
            case 4  : return "Atk";
            case 5  : return "Def";
            case 6  : return "Atk Especial";
            case 7  : return "Def Especial";
            default : return null;
        }
    }
}