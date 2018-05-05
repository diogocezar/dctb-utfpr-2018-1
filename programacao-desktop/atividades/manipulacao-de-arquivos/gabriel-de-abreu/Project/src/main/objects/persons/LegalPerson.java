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
public class LegalPerson extends Person{
    private String RG;

    public LegalPerson(String RG, String name, Address address, ArrayList<String> telephones, String cpf) {
        super(name, address, telephones, cpf);
        this.RG = RG;
    }


    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
    public String getCPF(){
        return getId();
    }
    public void setCPF(String cpf){
        setId(cpf);
    }

    @Override
    public String toString() {
        
        return super.toString()+"LegalPerson{" + "RG=" + RG + '}';
    }
}
