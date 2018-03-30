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
public class Fights {

    public static Creature startHeroMonster(Creature hero, Creature monster) {

        Creature winner = new Creature("name", "ranking", 0, 0, 0, 0, 0, 0, 0, 0, 0) {
        };

        System.out.println("\nMonster");
        showInfo(monster);
        System.out.println("\nHero");
        showInfo(hero);
        System.out.println(" Blessing: " + hero.getBlessing());

        int flag = 1, i = 1;

        while ((monster.alive() > 0) && (hero.alive() > 0)) {

            System.out.println("\n --- Round " + i + " ---");

            if (flag == 1) {
                if (monster.attack() > hero.defend()) {
                    System.out.println("\nMonster " + monster.getName() + " attacked hero " + hero.getName());
                    hero.loseLife(8);

                    System.out.println("\nHero's life: " + hero.alive());
                    System.out.println("Monster's life: " + monster.alive());

                }
                flag = 2;

            } else if (flag == 2) {
                flag = 1;
                if (hero.attack() > monster.defend()) {
                    System.out.println("\nHero " + hero.getName() + " attacked monster " + monster.getName());

                    monster.loseLife(8);

                    System.out.println("\nHero's life: " + hero.alive());

                    System.out.println("\nMonster's life: " + monster.alive());

                }

            }
            i++;
        }

        if (hero.getLife() > monster.getLife()) {

            System.out.println("\nHero " + hero.getName() + " defeated monster " + monster.getName());

            if (hero.rest(hero.getBlessing()) > 20) {

                hero.rest(hero.getBlessing());

                System.out.println("\nHero rests");

                winner = hero;

            } else if (monster.rest(0) > 20) {

                monster.rest(0);

                System.out.println("\nMonster rests");

                winner = monster;
            }

        } else {
            System.out.println("\nMonster " + monster.getName() + " defeated hero " + hero.getName());
            winner = monster;
        }

        return winner;

    }

    public static Creature startHeroHero(Creature hero1, Creature hero2) {

        Creature winner = new Creature("name", "ranking", 0, 0, 0, 0, 0, 0, 0, 0, 0) {
        };

        System.out.println("\nHero");
        showInfo(hero1);
        System.out.println("\nHero");
        showInfo(hero2);
        System.out.println(" Blessing: " + hero1.getBlessing());
        System.out.println(" Blessing: " + hero2.getBlessing());

        int flag = 1, i = 1;

        while ((hero1.alive() > 0) && (hero2.alive() > 0)) {

            System.out.println("\n --- Round " + i + " ---");

            if (flag == 1) {
                if (hero1.attack() > hero2.defend()) {
                    System.out.println("\nHero's " + hero1.getName() + " attacked hero " + hero2.getName());
                    hero2.loseLife(8);

                    System.out.println("\nHero's life: " + hero2.alive());
                    System.out.println("Hero's life: " + hero1.alive());

                }
                flag = 2;

            } else if (flag == 2) {
                flag = 1;
                if (hero2.attack() > hero1.defend()) {
                    System.out.println("\nHero " + hero2.getName() + " attacked hero " + hero1.getName());

                    hero1.loseLife(8);

                    System.out.println("\nHero's life: " + hero2.alive());

                    System.out.println("\nHero's life: " + hero1.alive());

                }

            }
            i++;
        }

        if (hero2.getLife() > hero1.getLife()) {

            System.out.println("\nHero " + hero2.getName() + " defeated monster " + hero1.getName());

            if (hero2.rest(hero2.getBlessing()) > 20) {

                hero2.rest(hero2.getBlessing());

                System.out.println("\nHero rests");

                winner = hero2;

            } else if (hero1.rest(hero1.getBlessing()) > 20) {

                hero1.rest(hero1.getBlessing());

                System.out.println("\nHero rests");

                winner = hero1;
            }

        } else {
            System.out.println("\nHero " + hero1.getName() + " defeated hero " + hero2.getName());
            winner = hero1;
        }

        return winner;

    }

    public static Creature startMonsterMonster(Creature monster1, Creature monster2) {

        Creature winner = new Creature("name", "ranking", 0, 0, 0, 0, 0, 0, 0, 0, 0) {
        };

        System.out.println("\nMonster");
        showInfo(monster1);
        System.out.println("\nMonster");
        showInfo(monster2);
      
        int flag = 1, i = 1;

        while ((monster1.alive() > 0) && (monster2.alive() > 0)) {

            System.out.println("\n --- Round " + i + " ---");

            if (flag == 1) {
                if (monster1.attack() > monster2.defend()) {
                    System.out.println("\nMonster's " + monster1.getName() + " attacked monster " + monster2.getName());
                    monster2.loseLife(8);

                    System.out.println("\nMonster's life: " + monster2.alive());
                    System.out.println("Monster's life: " + monster1.alive());

                }
                flag = 2;

            } else if (flag == 2) {
                flag = 1;
                if (monster2.attack() > monster1.defend()) {
                    System.out.println("\nMonster " + monster2.getName() + " attacked monster " + monster1.getName());

                    monster1.loseLife(8);

                    System.out.println("\nMonster's life: " + monster2.alive());

                    System.out.println("\nMonster's life: " + monster1.alive());

                }

            }
            i++;
        }

        if (monster2.getLife() > monster1.getLife()) {

            System.out.println("\nMonster " + monster2.getName() + " defeated monster " + monster1.getName());

            if (monster2.rest(0) > 20) {

                monster2.rest(0);

                System.out.println("\nMonster rests");

                winner = monster2;

            } else if (monster1.rest(0) > 20) {

                monster1.rest(0);

                System.out.println("\nMonster rests");

                winner = monster1;
            }

        } else {
            System.out.println("\nMonster " + monster1.getName() + " defeated monster " + monster2.getName());
            winner = monster1;
        }

        return winner;

    }

    static void showInfo(Creature creature) {
        System.out.println(" Name: " + creature.getName()
                + "\n Clase: " + creature.getRanking()
                + "\n Level: " + creature.getLevel()
                + "\n Life: " + creature.getLife()
                + "\n Magic: " + creature.getMagic()
                + "\n Strength: " + creature.getStrength()
                + "\n Agility: " + creature.getAgility()
                + "\n Dexterity: " + creature.getDexterity()
                + "\n Intelligence: " + creature.getIntelligence()
                + "\n Charisma: " + creature.getCharisma()
                + "\n Blessing: " + creature.getBlessing()
        );
    }

}
