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
    
    
    static String Start(Monster monster,Hero hero){
       
        int turn = 0;
        int flag = 1;
        
        while(monster.isAlive() && hero.isAlive()){
            turn++;
            //monster attack
            if(flag == 1){
                flag = 2;
                if(monster.attack()> hero.defense()){
                    hero.losesLife(8);
                }
            }
            //hero attack
            else if(flag == 2){
                flag = 1;
                if(hero.attack()>monster.defense()){
                    monster.losesLife(8);
                }
            }
        }
        
        //winner
        if(monster.isAlive()){
            if(monster.rest() > 20){
                monster.revitalize(50,30);
            }
            return monster.getName() + " Wins";
        }
        else{
            if(hero.rest() > 20){
                hero.revitalize(50,30);
            }
            return hero.getName() + " Wins";   
        }
        
    }
    
}
