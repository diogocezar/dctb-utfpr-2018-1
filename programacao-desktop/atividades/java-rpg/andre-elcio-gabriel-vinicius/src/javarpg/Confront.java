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

    static void printBattleStart(Creature champion1, Creature champion2) {
        System.out.println("-----Let the Battle Begin----");

        System.out.println(champion1.__toString());

        System.out.println(" Versus ");

        System.out.println(champion2.__toString());

        System.out.println("-----------------------------" + "\n");
    }

    static Creature endBattle(Creature creature, int restLimit, int lifeRegen, int magRegen) {
        System.out.println(creature.getName() + " Wins");
        if (creature.rest() > restLimit) {
            creature.revitalize(lifeRegen, magRegen);
            System.out.println(creature.getName() + " can rest");
        }
        return creature;
    }

    static void creatureDamage(Creature damaged, Creature damager, int damage) {
        damaged.lifeDamage(damage);
        System.out.println("Attack succeed");
        System.out.println("Hero loses " + damage + " life");
        System.out.println(damaged.getName() + " life: " + damaged.getLife());
        System.out.println(damager.getName() + " life: " + damager.getLife());
    }

    static void validateDamage(Creature damaged, Creature damager, int damage) {
        int damageX = damager.attack();
        int defense = damaged.defense();
        System.out.println(damager.getName() + " Attacks (" + damageX + " x " + defense + ") " + damaged.getName());
        if (damageX > defense) {
            creatureDamage(damaged, damager, damage);
        }
    }

    static Creature Start(Creature creature1, Creature creature2) {
        //monster x hero
        int turn = 0, flag = 1, restLimit = 20, lifeRegen = 50, magRegen = 30, damage = 8;

        printBattleStart(creature1, creature2);

        while (creature1.isAlive() && creature2.isAlive()) {
            turn++;
            System.out.println("Turn " + turn + "\n");
            //monster attack
            if (flag == 1) {
                flag = 2;
                validateDamage(creature2, creature1, damage);

            } //hero attack
            else if (flag == 2) {
                flag = 1;
                validateDamage(creature1, creature2, damage);
            }
            System.out.println("");
        }
        //winner
        if (creature1.isAlive()) {
            return endBattle(creature1, restLimit, lifeRegen, magRegen);
        } else {
            return endBattle(creature2, restLimit, lifeRegen, magRegen);
        }

    }

}
