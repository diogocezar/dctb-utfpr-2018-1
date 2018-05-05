/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.persons;

import main.objects.transations.Brand;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Supplier extends JuridicalPerson {

    private AvaliableBrands avaliableBrands;

    public AvaliableBrands getAvaliableBrands() {
        return avaliableBrands;
    }

    public void setAvaliableBrands(AvaliableBrands avaliableBrands) {
        this.avaliableBrands = avaliableBrands;
    }
    

    public Supplier(ArrayList<Brand> avaliableBrands, String name, Address address, ArrayList<String> telephones, String Id) {
        super(name, address, telephones, Id);
        this.avaliableBrands = new AvaliableBrands(avaliableBrands);
    }

    private class AvaliableBrands {

        private ArrayList<Brand> avaliableBrands;

        public ArrayList<Brand> getAvaliableBrands() {
            return avaliableBrands;
        }

        public void setAvaliableBrands(ArrayList<Brand> avaliableBrands) {
            this.avaliableBrands = avaliableBrands;
        }

        public AvaliableBrands(ArrayList<Brand> avaliableBrands) {
            this.avaliableBrands = avaliableBrands;
        }

        @Override
        public String toString() {
            String brands = "";
            for (Brand avb : this.avaliableBrands) {
                brands += avb.toString() + " | ";
            }
            return brands;
        }

    }

    @Override
    public String toString() {
        return super.toString()+"Supplier{" + "avaliableBrands=" + avaliableBrands + '}';
    }
}
