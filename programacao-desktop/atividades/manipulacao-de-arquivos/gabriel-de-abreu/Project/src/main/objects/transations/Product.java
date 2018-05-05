/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.transations;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Product {
    private class Brands{
        private ArrayList<Brand> brands;

        public ArrayList<Brand> getBrands() {
            return brands;
        }

        public void setBrands(ArrayList<Brand> brands) {
            this.brands = brands;
        }

        public Brands(ArrayList<Brand> brands) {
            this.brands = brands;
        }

        @Override
        public String toString() {
            String name="";
            for(Brand brand : brands){
               name+= brand.getName()+ " | ";
            }
            return name;
        }
        
    }
    private String barCode;
    private int quantityInStock;
    private Brands brands;
    private float price;
    private String name;

    public Product(String barCode) {
        this.barCode = barCode;
    }

    
    public Product(String barCode, ArrayList<Brand> brands, float price, String name) {
        this.barCode = barCode;
        this.brands = new Brands(brands);
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Brands getBrand() {
        return brands;
    }

    public void setBrand(Brands brand) {
        this.brands = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
}
