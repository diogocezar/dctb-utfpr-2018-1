package Main;

import Class.Course;
import DAO.Interfaces.CourseDAO;
import DAO.MySQL.CourseMySQL;
import java.util.ArrayList;

public class DataBaseExemple3 {
    static public CourseDAO getCourseDB(){
        return new CourseMySQL();
    }
    public static void main(String[] args) {
        
        // Exemplo de Inserção
        
        String[] names = {"ADS", "Computação", "Engenharia"};
        int i = 1;
        
        CourseDAO db = DataBaseExemple3.getCourseDB();
        
        for(String name: names){
            db.insert(new Course(i++, name));
        }
        
        // Exemplo de Consulta
        
        ArrayList<Course> all = db.getAll();
        for(Course one : all){
            System.out.println(one.name);
        }
    }
}
