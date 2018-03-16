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
       
        int turn = 0, flag = 1, monsteraux, heroaux, restLimit = 20, lifeRegen = 50, magRegen = 30, damage = 8;
        
        System.out.println("-----Let the Battle Begin----");
        
        System.out.println(monster.__toString());
        
        System.out.println(" Versus ");
        
        System.out.println(hero.__toString());
        
        System.out.println("-----------------------------"+"\n");
        
        while(monster.isAlive() && hero.isAlive()){
            turn++;
            System.out.println("Turn " + turn + "\n");
            //monster attack
            if(flag == 1){
                flag = 2;
                monsteraux = monster.attack();
                heroaux    = hero.defense();
                System.out.println(monster.getName() + " Attacks ("+monsteraux+" x "+heroaux+") "+hero.getName() );
                
                if(monsteraux> heroaux){
                    hero.lifeDamage(damage);
                    System.out.println("Attack succeed");
                    System.out.println("Hero loses "+damage+" life");
                    System.out.println(hero.getName()+" life: "+hero.getLife() );
                    System.out.println(monster.getName()+" life: "+monster.getLife() );
                }else{
                    System.out.println("Attack failed");
                }
            }
            //hero attack
            else if(flag == 2){
                flag = 1;
                monsteraux = monster.attack();
                heroaux    = hero.defense();
                System.out.println(hero.getName() + " Attacks ("+heroaux+" x "+monsteraux+") "+monster.getName() );
                    
                if(heroaux> monsteraux){
                    monster.lifeDamage(damage);
                    System.out.println("Attack succeed");
                    System.out.println("Monster loses "+damage+" life");
                    System.out.println(hero.getName()+" life: "+hero.getLife() );
                    System.out.println(monster.getName()+" life: "+monster.getLife() );
                }else{
                    System.out.println("Attack failed");
                }
            }
            System.out.println("");
            
        }
        
        //winner
        if(monster.isAlive()){
            System.out.println(monster.getName() + " Wins");
            if(monster.rest() > restLimit){
                monster.revitalize(lifeRegen,magRegen);
                System.out.println(monster.getName()+" can rest");
            }
            return monster;
        }
        else{
            System.out.println(hero.getName() + " Wins");
            if(hero.rest() > 20){
                hero.revitalize(lifeRegen,magRegen);
                System.out.println(hero.getName()+" can rest");
            }
            return hero;   
        }
        
    }
    
}
