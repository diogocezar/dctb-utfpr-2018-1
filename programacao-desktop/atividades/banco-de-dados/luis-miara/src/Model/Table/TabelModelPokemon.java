/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

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
                default:return null;
        }
    }
}