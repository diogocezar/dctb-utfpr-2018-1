/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author noda
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Monster Montaro = new Monster("Montaro","Dark Elf",7,100,100,10,5,10,15,10);
        Monster LordBlack = new Monster("Lord Black","Human",10,100,20,32,12,10,10,1);
        Monster Matilda = new Monster("Matilda","Elf",10,100,80,10,8,10,18,5);
        
        Hero DarkGlorysson= new Hero("Dark Glorysson","Human",8,100,100,10,5,10,15,2,10);
        System.out.println(DarkGlorysson.__toString()+"\n");
        
        Hero Mellayne= new Hero("Mellayne","Human",5,100,80,25,10,8,2,20,10);
        System.out.println(Mellayne.__toString()+"\n");
        
        Hero Gryin= new Hero("Gryin", "Dwarf",10,100,50,30,5,10,5,1,10);
        System.out.println(Gryin.__toString());

    }
    
}
