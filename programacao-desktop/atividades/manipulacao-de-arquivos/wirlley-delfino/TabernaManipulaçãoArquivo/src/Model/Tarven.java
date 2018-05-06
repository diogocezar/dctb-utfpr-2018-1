/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Wirlley Delfino
 */
public class Tarven {
    private ArrayList<Item> storage;
    private double gold;
    private String name;
    private int storageLevel;
    private int mercenaryLevel;
    private int bardLevel;

    public ArrayList<Item> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<Item> storage) {
        this.storage = storage;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorageLevel() {
        return storageLevel;
    }

    public void setStorageLevel(int storageLevel) {
        this.storageLevel = storageLevel;
    }

    public int getMercenaryLevel() {
        return mercenaryLevel;
    }

    public void setMercenaryLevel(int mercenaryLevel) {
        this.mercenaryLevel = mercenaryLevel;
    }

    public int getBardLevel() {
        return bardLevel;
    }

    public void setBardLevel(int bardLevel) {
        this.bardLevel = bardLevel;
    }
    
    
}