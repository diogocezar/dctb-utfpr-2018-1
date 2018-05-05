/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.persons;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public abstract class Person implements Serializable{
    private String name;
    private Address address;
    private ArrayList<String> telephones;
    private String Id;
    

    public Person(String name, Address address, ArrayList<String> telephones, String Id) {
        this.name = name;
        this.address = address;
        this.telephones = telephones;
        this.Id = Id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(ArrayList<String> telephones) {
        this.telephones = telephones;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + ", telephones=" + telephones + ", Id=" + Id + '}';
    }
    
    
    
}
