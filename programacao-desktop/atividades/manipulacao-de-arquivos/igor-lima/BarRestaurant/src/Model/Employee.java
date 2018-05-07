package Model;

import java.io.Serializable;

public class Employee implements Serializable{
    String name;
    String address;
    int id;
    private static int inc = 1;
    String phone;
    
    public Employee(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = inc++;
    }
    
    public Employee(){
    
    }
    
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public int getID(){
        return id;
    }
}
