/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Wirlley Delfino
 */
public class Adventurer implements Serializable{
    private String nome;
    public ArrayList<Item> item;
    private String gold;

    public Adventurer(String nome, String gold) {
        this.nome = nome;
        this.gold = gold;
    }

    public Adventurer(){};
    
    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
    
    @Override
    public String toString() {
        return  nome + "\n" + gold;
    }
}
