/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.persons;

import java.io.Serializable;

/**
 *
 * @author gabriel
 */
public class Address implements Serializable{
    private String street;
    private int number;
    private String block;
    private String city;
    private String state;

    public Address(){}
    
    public Address(String street, int number, String block, String city, String state) {
        this.street = street;
        this.number = number;
        this.block = block;
        this.city = city;
        this.state = state;
    }
    
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", number=" + number + ", block=" + block + ", city=" + city + ", state=" + state + '}';
    }
}
