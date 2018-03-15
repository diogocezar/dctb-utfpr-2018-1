/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author andre
 */
public class Confront {
    
    
    static Creature Start(Creature monster,Creature hero){
       
        int turn = 0;
        int flag = 1;
        int monsteraux;
        int heroaux;
        
        System.out.println("-----Let the Battle Begin----");
        
        monster.__toString();
        
        System.out.println(" Versus ");
        
        hero.__toString();
        
        System.out.println("-----------------------------"+"\n");
        
        while(monster.isAlive() && hero.isAlive()){
            turn++;
            System.out.println("Turn " + turn + "\n");
            //monster attack
            if(flag == 1){
                flag = 2;
                monsteraux = monster.attack();
                heroaux    = hero.defense();
                if(monsteraux> heroaux){
                    hero.losesLife(8);
                    System.out.println(monster.getName() + "Attacks ("+monsteraux+" x "+heroaux+")"+hero.getName() );
                    System.out.println("Hero loses 8 life");
                    System.out.println(hero.getName()+" life: "+hero.getLife() );
                    System.out.println(monster.getName()+" life: "+monster.getLife() );
                }
            }
            //hero attack
            else if(flag == 2){
                flag = 1;
                monsteraux = monster.attack();
                heroaux    = hero.defense();
                if(heroaux> monsteraux){
                    monster.losesLife(8);
                    System.out.println(hero.getName() + "Attacks ("+heroaux+" x "+monsteraux+")"+monster.getName() );
                    System.out.println("Monster loses 8 life");
                    System.out.println(hero.getName()+" life: "+hero.getLife() );
                    System.out.println(monster.getName()+" life: "+monster.getLife() );
                }
            }
            System.out.println("");
        }
        
        //winner
        if(monster.isAlive()){
            System.out.println(monster.getName() + " Wins");
            if(monster.rest() > 20){
                monster.revitalize(50,30);
                System.out.println(monster.getName()+" can rest");
            }
            return monster;
        }
        else{
            System.out.println(hero.getName() + " Wins");
            if(hero.rest() > 20){
                hero.revitalize(50,30);
                System.out.println(hero.getName()+" can rest");
            }
            
            return hero;   
        }
        
    }
    
}
