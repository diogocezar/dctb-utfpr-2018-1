/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.transations;

/**
 *
 * @author gabriel
 */
public abstract class Transation {
    private float price;
    private int id;

    public Transation() {
    }
    
    public Transation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    protected void setPrice(float price) {
        this.price = price;
    }    

    @Override
    public String toString() {
        return "Transation{" + "price=" + price + ", id=" + id + '}';
    }
    
    
}
