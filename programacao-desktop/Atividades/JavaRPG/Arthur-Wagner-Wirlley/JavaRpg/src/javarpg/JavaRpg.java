/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author arthu
 */
public class JavaRpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heroi  m1 = new Heroi("Carlinhos","Elfo",7,100,100,10,5,10,15,10,10);
        Monstro  m2 = new Monstro("Jaler","Demonio do avesso",14,100,100,15,30,20,12,23);
        System.out.println(m1);
        System.out.println(m2);
    }
    
}
