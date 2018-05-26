/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBaseGeneric;
import Model.Interfaces.ImplementPokemon;
import Model.Pokemon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MAGNO
 */
public class PokemonDAO extends DataBaseGeneric implements ImplementPokemon {

    public ArrayList<Pokemon> list;

    public PokemonDAO() {
        super(new ConfigurationsMySQL(), "pokemon");
    }

    @Override
    public void insert(Pokemon course) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("name", course.getName());
        mapObj.put("agility", course.getAgility());
        mapObj.put("attack", course.getAttack());
        mapObj.put("defese", course.getDefese());
        mapObj.put("hp", course.getHp());
        mapObj.put("level", course.getLevel());
        mapObj.put("specialAttack", course.getSpecialAttack());
        mapObj.put("specialDefense", course.getSpecialDefense());
        mapObj.put("season", course.getSeason());

        this.genericInsert(mapObj);
    }

    @Override
    public void update(Pokemon course) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("name", course.getName());
        mapConditions.put("id", course.getId());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("id", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Pokemon> getCourseByName(String name) {
    this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) { 
                Pokemon course = new Pokemon();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("name"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex){
            System.out.println("Houve um erro ao obter um pokemon: \n\n\n\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllCourse() {
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Pokemon course = new Pokemon();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setAgility(rs.getInt("agility"));
                course.setAttack(rs.getInt("attack"));
                course.setDefese(rs.getInt("defese"));
                course.setHp(rs.getInt("hp"));
                course.setLevel(rs.getInt("level"));
                course.setSpecialAttack(rs.getInt("specialattack"));
                course.setSpecialDefense(rs.getInt("specialdefense"));
                course.setSeason(rs.getInt("season"));
                

                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um pokemon pelo nome: " + ex.getMessage());
        }
        return null;       
    }

    @Override
    public Pokemon getOneCourse(int id) {
        ResultSet rs = this.getOne(id);
        Pokemon course = new Pokemon();
        try {
            course.setId(rs.getInt(1));
            course.setName(rs.getString("name"));
             course.setAgility(rs.getInt("agility"));
                course.setAttack(rs.getInt("attack"));
                course.setDefese(rs.getInt("defese"));
                course.setHp(rs.getInt("hp"));
                course.setLevel(rs.getInt("level"));
                course.setSpecialAttack(rs.getInt("specialattack"));
                course.setSpecialDefense(rs.getInt("specialdefense"));
                course.setSeason(rs.getInt("season"));
            return course;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um pokemon pelo id: " + ex.getMessage());
        }
        return null;
    }

}
