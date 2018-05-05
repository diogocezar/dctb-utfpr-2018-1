/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.persons;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Employee extends LegalPerson{
    private String login;
    private String password;

    public Employee(String login, String password, String RG, String name, Address address, ArrayList<String> telephones, String cpf) {
        super(RG, name, address, telephones, cpf);
        this.login = login;
        this.password = password;
    }




    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString()+"Employee{" + "login=" + login + ", password=" + password + '}';
    }
    
}
