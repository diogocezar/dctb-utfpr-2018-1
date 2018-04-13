/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte1;

/**
 *
 * @author felipe
 */
public class Main {

    public static void main(String[] args) {

        Hero darkGlorysson = new Hero(
                "Dark Glorysson",
                "Human",
                8,
                100,
                100,
                10,
                5,
                10,
                15,
                2,
                10);

        Hero mellayne = new Hero(
                "Mellayne",
                "Human",
                5,
                100,
                80,
                25,
                10,
                8,
                2,
                20,
                10);

        Hero gryin = new Hero(
                "Gryin",
                "Dwarf",
                10,
                100,
                50,
                30,
                5,
                10,
                5,
                1,
                10);

        Monster montaro = new Monster(
                "Montaro",
                "Elf of darkness",
                7,
                100,
                100,
                10,
                5,
                10,
                15,
                10,
                0);
        Monster lordBlack = new Monster(
                "Lord Black",
                "Human",
                10,
                100,
                20,
                32,
                12,
                10,
                10,
                1,
                0);

        Monster matilda = new Monster(
                "Matilda",
                "Elf",
                10,
                100,
                80,
                10,
                8,
                10,
                18,
                5,
                0);

        Confrontation conf = new Confrontation();

        Creature winner1 = conf.start(darkGlorysson, montaro);

        System.out.println("\n--- New Confront ---");
        Creature winner2 = conf.start(mellayne, matilda);

        System.out.println("\n--- New Confront ---");
        System.out.println(winner1.getName() + " x " + winner2.getName());
        Creature winner3 = conf.start(winner1, winner2);

        System.out.println("\n--- New Confront ---");
        Creature winner4 = conf.start(gryin, lordBlack);

        System.out.println("\n--- New Confront ---");
        System.out.println(winner3.getName() + " x " + winner4.getName());
        Creature winner5 = conf.start(winner3, winner4);


    }

}
