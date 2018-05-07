/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author geova
 */
public class Info implements Serializable{
    
    public String name, address, age, occupation;
    
    public Info(String name, String address, String age, String occupation) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.occupation = occupation;
    }

    public Info() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return  name + "\n" + address + "\n" + age + "\n" + occupation + "\n";
    }
    
}