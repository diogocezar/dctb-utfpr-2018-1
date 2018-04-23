package Model.Table;

import Model.Course;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelCourse extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<Course> list ;

    public TabelModelCourse(List<Course> list) {
        this.list = list;
    }
       
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getName();
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0  : return "ID";
            case 1  : return "NOME";
            default : return null;
        }
    }
}