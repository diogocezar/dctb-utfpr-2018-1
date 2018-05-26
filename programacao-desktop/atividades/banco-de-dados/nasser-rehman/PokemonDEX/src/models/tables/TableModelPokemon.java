/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Pokemon;

/**
 *
 * @author nadook
 */
public class TableModelPokemon extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    
    
    public List<Pokemon> list;
    
    public TableModelPokemon(List<Pokemon> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getName();
            case 2 : return list.get(rowIndex).getLevel();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NOME";
            case 2 : return "LEVEL";
            default : return null;
        }
    }
    
}
