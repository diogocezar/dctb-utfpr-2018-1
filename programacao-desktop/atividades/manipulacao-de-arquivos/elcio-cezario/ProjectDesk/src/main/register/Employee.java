/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.register;

import java.io.Serializable;

/**
 *
 * @author ecsanchesjr
 */
public class Employee implements Serializable {
    private String name;
    private String rg;
    private String cpf;
    private String phone;
    private String street;
    private int houseNumber;
    private String district;
    private String city;
    private String state;

    public Employee(String name, String rg, String cpf, String phone, String street, int houseNumber, String district, String city, String state) {
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.phone = phone;
        this.street = street;
        this.houseNumber = houseNumber;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "" + "name=" + name + ", rg=" + rg + ", cpf=" + cpf + ", phone=" + phone + ", street=" + street + ", houseNumber=" + houseNumber + ", district=" + district + ", city=" + city + ", state=" + state;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
    
    
    
}
