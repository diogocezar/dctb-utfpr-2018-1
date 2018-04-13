/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;
import java.util.ArrayList;
/**
 *
 * @author arthu
 */
public class JavaRpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heroi h1 = new Heroi("Dark Glorysson", "Humano",8,100,100,10,5,10,15,2,10);
        Heroi h2 = new Heroi("Alexis Texas", "Humano",5,100,80,25,10,8,2,20,10);
        Heroi h3 = new Heroi("Gryin", "Anão",10,100,50,30,5,10,5,1,10);
        Monstro  m1 = new Monstro("Montaro","Elfo das Trevas",7,100,100,10,5,10,15,10);
        Monstro  m2 = new Monstro("Lord Black","Humano",10,100,20,32,12,10,10,1);
        Monstro  m3 = new Monstro("Matilda","Elfa",10,100,80,10,8,10,18,5);
        ArrayList<Creature> winners = new ArrayList();
        Heroi winH = new Heroi();
        Monstro winM = new Monstro();
        Confronto.Fight(m1,h1);
        if(h1.isAlive()){
            h1.Heal(h1.rest());
            winners.add(h1);
        }else{
            m1.Heal(m1.rest());
            winners.add(m1);
        }
        Confronto.Fight(m3, h2);
        if(h2.isAlive()){
            h2.Heal(h2.rest());
            winners.add(h2);
        }else{
            m3.Heal(m3.rest());
            winners.add(m3);
        }
        Confronto.Fight(winners.get(0), winners.get(1));
        if(winners.get(0).isAlive()){
            if(winners.get(0) instanceof Heroi){
                winH = (Heroi)winners.get(0);
                winH.Heal(winH.rest());
                winners.add(0,winH);
            }else{
                winM = (Monstro)winners.get(0);
                winM.Heal(winM.rest());
                winners.add(0,winM);
            }
        }else{
            if(winners.get(1) instanceof Heroi){
                winH = (Heroi)winners.get(1);
                winH.Heal(winH.rest());
                winners.add(0,winH);
            }else{
                winM = (Monstro)winners.get(1);
                winM.Heal(winM.rest());
                winners.add(0,winM);
            }
        }
        Confronto.Fight(m2, h3);
        if(m2.isAlive()){
            m2.Heal(m2.rest());
            winners.add(1,m2);
        }else{
            h3.Heal(h3.rest());
            winners.add(1,h3);
        }
        System.out.println("\n\n----------Final Round !!!----------\n\n");
        Confronto.Fight(winners.get(0),winners.get(1));
        if(winners.get(0).isAlive())
            System.out.println("\n----------\n"+winners.get(0).getName()+" are the new Champion !!");
        else
            System.out.println("\n----------\n"+winners.get(1).getName()+" are the new Champion !!");
    }
            
}