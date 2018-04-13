/**
 * Battle
 */
public class Battle {

    private int roundStatus;

    public Creature battleStart(Creature monster, Creature hero) {
        roundStatus = 0;
        System.out.println("|------------------------ Beginning of the Battle ------------------------|");
        do {
            roundStatus++;
            this.roundStart(monster, hero);
        } while (monster.alive() && hero.alive());
        Creature creature = monster.alive() ? monster : hero;
        this.battleWinner(creature);
        return creature;
    }

    public void roundStart(Creature monster, Creature hero) {
        this.roundHeader();
        this.attackRound(monster, hero);
        if (hero.alive()) {
            this.attackRound(hero, monster);
        }
    }

    public void attackRound(Creature creature1, Creature creature2) {
        float attackValue = creature1.attack();
        float defenseValue = creature2.defense();
        if (attackValue > defenseValue) {
            creature2.losesLife();
        }
        this.statusRound(attackValue, defenseValue, creature1.getName(), creature2.getName());
    }

    public void roundHeader() {
        System.out.println("|------------------------ Round " + roundStatus + " ------------------------|");
        System.out.println();
    }

    public void statusRound(float attackValue, float defenseValue, String nameAttacker, String nameDefender) {
        System.out.println("Turno do "+ nameAttacker);
        System.out.println();
        System.out.println("Valor Ataque "+ nameAttacker +": " + attackValue);
        System.out.println("Valor Defesa "+ nameDefender +": " + defenseValue);
        if (attackValue > defenseValue) {
            System.out.println(nameAttacker +" Ganhou no ataque.");
            System.out.println(nameDefender +" perdeu 8 de vida.");
        } else {
            System.out.println(nameAttacker +" Perdeu no ataque.");
            System.out.println(nameDefender +" não sofreu dano.");
        }
        System.out.println();
        System.out.println();
    }

    public void battleWinner(Creature winner) {
        System.out.println("|------------------------ Battle Finished ------------------------|");
        System.out.println();
        System.out.println(winner.getName() +" Ganhou a batalha.");
        if (this.winnerRest(winner.rest())) {
            System.out.println(winner.getName() +" Pode descansar.");
            winner.revitalize();
        } else {
            System.out.println(winner.getName() +" Não pode descansar.");
        }
        System.out.println();
        System.out.println();
        System.out.println("|------------------------ Player Winner Status ------------------------|");
        System.out.println();
        System.out.println(winner.toString());
    }

    public boolean winnerRest(float valueRest) {
        if(valueRest > 20) {
            return true;
        }
        return false;
    }
}