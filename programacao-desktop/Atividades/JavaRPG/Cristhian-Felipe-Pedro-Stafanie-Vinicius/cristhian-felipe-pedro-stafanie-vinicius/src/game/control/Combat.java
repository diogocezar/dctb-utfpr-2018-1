package game.control;

import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Classe de combate
 */
public class Combat {

    private ArrayList<Creature> creatures = new ArrayList();
    private Creature player;
    private int countGame = 0;
    private int maxRounds = 100, rounds = 0;
    private int flag = 1;
    private boolean winner = false;

    /**
     * Cria criaturas sendo elas Heroi ou Monstro e atribuindo ao arraylist tipo Creature
     */
    public void create() {
        creatures.add(new Hero("DARK GLORYSSON", 6, 8, 100, 100, 20, 9, 10, 15, 2, 10));
        creatures.add(new Monster("MONTARO", 3, 11, 100, 100, 25, 5, 12, 22, 10));
        creatures.add(new Hero("MELLAYNE", 1, 12, 100, 80, 25, 10, 18, 2, 20, 10));
        creatures.add(new Monster("MATILDA", 2, 10, 100, 80, 10, 8, 10, 18, 5));
        creatures.add(new Hero("GRYN", 4, 10, 100, 90, 30, 5, 10, 25, 1, 10));
        creatures.add(new Monster("LORD BLACK", 5, 10, 100, 20, 32, 12, 10, 10, 1));
    }

    /**
     * Inicia lutas, e faz verificação na pós-lua
     * Caso indicie de acesso a criatura chege ao maximo ela volta a 0, e começa uam nova rodada
     * Caso a lista de criatura chege a 1, consequentemente a últuma criatura que sobrou, a mesma ganhou o jogo
     */
    public void init() {
        fight(creatures.get(countGame), creatures.get(countGame + 1));
        if (countGame >= creatures.size() - 1)
            countGame = 0;
        if (creatures.size() <= 1)
            winner = true;
    }

    /**
     * Metodo de luta de criatuas que recebe duas crituras
     *
     * @param creature1
     * @param creature2
     */
    public void fight(Creature creature1, Creature creature2) {

        if (creature1.isLive() && creature2.isLive() && rounds < maxRounds) {
            if (flag == 1) {
                flag = 2;
                if (attackCount(creature1.attack(), creature2.defend()))
                    creature2.loseLife();
            } else {
                flag = 1;
                if (attackCount(creature2.attack(), creature1.defend()))
                    creature1.loseLife();
            }
            rounds++;
        } else {
            winner(creature1, creature2);
        }
    }

    /**
     * Verifica ganhador de partida
     * @param creature1
     * @param creature2
     */
    public void winner(Creature creature1, Creature creature2) {
        if (creature1.getLife() > creature2.getLife()) {
            out(creature1, creature2);
        } else if (creature2.getLife() > creature1.getLife()) {
            out(creature2, creature1);
        } else {
            rounds = 0;
            fight(creature1, creature2);
        }
        rounds = 0;
    }

    /**
     * Cria mensgens e faz a remoção da criatura derrotada
     * @param creature1
     * @param creature2
     */
    public void out(Creature creature1, Creature creature2) {
        System.out.println(creature1.getName() + " venceu a partida");
        showMessageDialog(null, creature1.getName() + " venceu a partida");
        creature1.rest();
        creatures.remove(creature2);
        countGame++;
    }

    public boolean attackCount(float attack, float defend) {
        return attack > defend;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    public Creature getPlayer() {
        return player;
    }

    public void setPlayer(Creature player) {
        this.player = player;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public int getCountGame() {
        return countGame;
    }

    public boolean isWinner() {
        return winner;
    }
}
