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
        Heroi h1 = new Heroi("Dark Glorysson", "Humano",8,100,100,10,5,10,15,2,10);
        Heroi h2 = new Heroi("Alexis Texas", "Humano",5,100,80,25,10,8,2,20,10);
        Heroi h3 = new Heroi("Gryin", "Anão",10,100,50,30,5,10,5,1,10);
        Monstro  m1 = new Monstro("Montaro","Elfo das Trevas",7,100,100,10,5,10,15,10);
        Monstro  m2 = new Monstro("Lord Black","Humano",10,100,20,32,12,10,10,1);
        Monstro  m3 = new Monstro("Matilda","Elfa",10,100,80,10,8,10,18,5);

        int round1, round2, round3,round3h,round3m, round4, finalRound;
        
        
        
        Confronto.Fight(h1,m1);
        Confronto.Fight(h2, m3);
        Confronto.Fight(h3, m2);
        round4 = h3.isAlive() ? 1 : 2;
        round1 = h1.isAlive() ? 1 : 2;
        round2 = h2.isAlive() ? 1 : 2;
        
        if(round1 == 1 && round2 == 2){
            Confronto.Fight(h1, m3);
            round3 = h1.isAlive() ? 1: 2;
        }
        else if(round1 == 2 && round2 == 1 ){
            Confronto.Fight(m1, h2);
            round3 = h2.isAlive() ? 1: 2;
        }
        else if(round1 == 1 && round2 == 1){
            Confronto.Fight(h1, h2);
            round3h = h1.isAlive() ? 1 : 2;
        }
        else if(round1 == 1 && round2 == 1){
            Confronto.Fight(m1, m3);
            round3m = m1.isAlive() ? 1 : 2;
        }
        
        if(round3h == null && round3m == null){
            round3 == 1 ? Confronto.Fight(h1, h2)
        }
    }
        
        
      
}
