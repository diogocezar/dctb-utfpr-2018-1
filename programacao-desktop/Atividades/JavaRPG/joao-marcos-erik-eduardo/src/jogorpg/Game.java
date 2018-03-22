/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg;

/**
 *
 * @author JOAO
 */
public class Game  {
    
    public static void main(String [] args){
        Hero hero01 = new Hero("Dark Glorysson","Human",8,100,100,10,5,10,15,2,10);
        Hero hero02 = new Hero("Mellayne","Human",5,100,80,25,10,8,2,20,10);
        Hero hero03 = new Hero("Gryin","Dwarf",10,100,50,30,5,10,5,1,10);
        
        Monster monster01 = new Monster("Montaro","Dark Elf",7,100,100,10,5,10,15,10);
        Monster monster02 = new Monster("Lord Black","Human",10,100,20,32,12,10,10,1);
        Monster monster03 = new Monster("Matilda","Elf",10,100,80,10,8,10,18,5);
   
    }
}
