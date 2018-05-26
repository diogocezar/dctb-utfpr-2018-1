package Model.DAO;

import Configuracao.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Poke;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Interfaces.ImplementPoke;

public class PokeDAO implements ImplementPoke{
    
    private List<Poke> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Poke course) {
        this.db.execute("INSERT INTO java_course (nome) VALUES (?)", course.getName());
    }

    @Override
    public void update(Poke course) {
        this.db.execute("UPDATE java_course SET nome=? WHERE id=?", course.getName(), course.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_course WHERE id=?", id);
    }

    @Override
    public List<Poke> getCourse(String name) {
        list = new ArrayList<Poke>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_course WHERE nome LIKE '%" + name + "%'");
            while (rs.next()) { 
                Poke course = new Poke();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("nome"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao achar o Pokemon: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Poke> getAllCourse() {
        list = new ArrayList<Poke>();
        ResultSet rs = this.db.query("SELECT id, nome FROM java_course ORDER BY id");
        try {
            while(rs.next()){
                Poke course = new Poke();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("nome"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um Pokenome: " + ex.getMessage());
        }
        return null;
    }
}
