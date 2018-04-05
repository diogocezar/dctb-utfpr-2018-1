package utils;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Battle {

    private boolean bothAlive = true;
    private int count = 1;
    DecimalFormat df = new DecimalFormat("0.#");

    public Creature confrontation(Creature creature1, Creature creature2) {
        System.out.println(creature1.getName() + " Vs. " + creature2.getName() + "\n");
        showCreatures(creature1, creature2);
        do {
            double attackCreature1 = creature1.attack();
            double attackCreature2 = creature2.attack();
            double defendCreature1 = creature1.defend();
            double defendCreature2 = creature2.defend();

            System.out.println("\n◉ Round " + count);
            if (attackCreature1 > defendCreature2) {
                creature2.loseLife();
                System.out.println(creature1.getName() + " atacou (" + df.format(attackCreature1) + " x " + df.format(defendCreature2) + ") " + creature2.getName());
                System.out.println(creature2.getName() + " perdeu 8 pontos de vida");
            } else {
                System.out.println(creature1.getName() + " atacou (" + df.format(attackCreature1) + " x " + df.format(defendCreature2) + ") " + creature2.getName());
                System.out.println(creature2.getName() + " não perdeu vida");
            }
            if (attackCreature2 > defendCreature1) {
                creature1.loseLife();
                System.out.println(creature2.getName() + " atacou (" + df.format(attackCreature2) + " x " + df.format(defendCreature1) + ") " + creature1.getName());
                System.out.println(creature1.getName() + " perdeu 8 pontos de vida");
            } else {
                System.out.println(creature2.getName() + " atacou (" + df.format(attackCreature2) + " x " + df.format(defendCreature1) + ") " + creature1.getName());
                System.out.println(creature1.getName() + " não perdeu vida");
            }
            System.out.println("Vida de " + creature1.getName() + ": " + creature1.getLife());
            System.out.println("Vida de " + creature2.getName() + ": " + creature2.getLife());
            if ((!creature1.alive()) || (!creature2.alive())) {
                bothAlive = false;
            } else {
                bothAlive = true;
            }
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
            attackCreature1 = 0;
            attackCreature2 = 0;
            defendCreature1 = 0;
            defendCreature2 = 0;
        } while (bothAlive);
        count = 1;
        if (creature1.alive()) {
            System.out.println("\n" + creature1.getName() + " venceu o confronto");
            if (creature1.revitalize()){
                System.out.println(creature1.getName() + " tem o direito de descansar");
            } else {
                System.out.println(creature1.getName() + " não tem o direito de descansar");
            }
            return creature1;
        } else {
            System.out.println("\n" + creature2.getName() + " venceu o confronto");
            if (creature2.revitalize()) {
                System.out.println(creature2.getName() + " tem o direito de descansar");
            } else {
                System.out.println(creature2.getName() + " não tem o direito de descansar");
            }
            return creature2;
        }
    }
    
    public void showCreatures(Creature creature1, Creature creature2){
        System.out.println("Nome: " + creature1.getName());
        System.out.println("Vida: " + creature1.getLife());
        System.out.println("Nivel: " + creature1.getLevel());
        System.out.println("Magia: " + creature1.getMagic());
        System.out.println("Força: " + creature1.getPower());
        System.out.println("Agilidade: " + creature1.getAgility());
        System.out.println("Destreza: " + creature1.getDexterity());
        System.out.println("Inteligencia: " + creature1.getIntelligence());
        System.out.println("Carisma: " + creature1.getCharisma() + "\n");
        System.out.println("Nome: " + creature2.getName());
        System.out.println("Vida: " + creature2.getLife());
        System.out.println("Nivel: " + creature2.getLevel());
        System.out.println("Magia: " + creature2.getMagic());
        System.out.println("Força: " + creature2.getPower());
        System.out.println("Agilidade: " + creature2.getAgility());
        System.out.println("Destreza: " + creature2.getDexterity());
        System.out.println("Inteligencia: " + creature2.getIntelligence());
        System.out.println("Carisma: " + creature2.getCharisma() + "");
    }
}
