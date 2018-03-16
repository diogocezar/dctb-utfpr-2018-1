/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Championship {

    private Monster Montaro;
    private Monster LordBlack;
    private Monster Matilda;

    private Hero DarkGlorysson;
    private Hero Mellayne;
    private Hero Gryin;

    private ArrayList<Creature> FirstStageWinners= new ArrayList<>();

    public static void runChampionship(){
        Championship chp= new Championship();
        chp.setChampions();
        chp.runFirstStage();
        chp.runFinalStage();
    }

    private void setChampions() {
        Montaro = new Monster("Montaro", "Dark Elf", 7, 100, 100, 10, 5, 10, 15, 10);
        LordBlack = new Monster("Lord Black", "Human", 10, 100, 20, 32, 12, 10, 10, 1);
        Matilda = new Monster("Matilda", "Elf", 10, 100, 80, 10, 8, 10, 18, 5);

        DarkGlorysson = new Hero("Dark Glorysson", "Human", 8, 100, 100, 10, 5, 10, 15, 2, 10);
        Mellayne = new Hero("Mellayne", "Human", 5, 100, 80, 25, 10, 8, 2, 20, 10);
        Gryin = new Hero("Gryin", "Dwarf", 10, 100, 50, 30, 5, 10, 5, 1, 10);
    }

    private void runFirstStage() {
        FirstStageWinners.add(Confront.Start(DarkGlorysson, Montaro));
        FirstStageWinners.add(Confront.Start(Mellayne, Matilda));
        FirstStageWinners.add(Confront.Start(Gryin, LordBlack));
        printFirstStageResults();
    }
    
    private Creature runSemiFinalStage(){
        Creature Winner1x2 = Confront.Start(FirstStageWinners.get(0), FirstStageWinners.get(1));
        System.out.println("The semifinal winner is "+Winner1x2.getName()+" ! \n");
        return Winner1x2;
    }

    private void runFinalStage() {
        Creature Winner1x2=runSemiFinalStage();
        Creature FinalWinner = Confront.Start(Winner1x2, FirstStageWinners.get(2));
        System.out.println(FinalWinner.getName()+ " is the ultimate winner!");
    }

    private void printFirstStageResults() {
        int i=1;
        for (Creature FirstStageWinner : FirstStageWinners) {
            System.out.println("The Winner from round "+i+ " is "+FirstStageWinner.getName()+" ! \n");
            i++;
        }
    }
}
