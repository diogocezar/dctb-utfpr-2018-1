/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utfpr.pokedex.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Type {

    private int id;
    private List<String> type = new ArrayList<>(2);
    private List<String> weaknesses = new ArrayList<>(7);

    public Type(int id, String type0, String type1, String weaknesses0, String weaknesses1, String weaknesses2, String weaknesses3, String weaknesses4, String weaknesses5, String weaknesses6) {
        this.id = id;
        type.add(type0);
        type.add(type1);
        weaknesses.add(weaknesses0);
        weaknesses.add(weaknesses1);
        weaknesses.add(weaknesses2);
        weaknesses.add(weaknesses3);
        weaknesses.add(weaknesses4);
        weaknesses.add(weaknesses5);
        weaknesses.add(weaknesses6);
    }

    public Type(String type0) {
        type.add(type0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getType() {
        return type;
    }

}
