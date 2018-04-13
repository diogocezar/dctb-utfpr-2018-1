import java.util.HashMap;

/**
 * Confrontation
 */
public class Confrontation {

    private BuildCharacter bCharacter;
    private HashMap<String, Hero> heroes;
    private HashMap<String, Monster> monsters;
    private Battle battle;
    private ExitOnEnter enter;

    public Confrontation() {
        bCharacter = new BuildCharacter();
        heroes = bCharacter.listHeroes();
        monsters = bCharacter.listMonsters();
        battle = new Battle();
        enter = new ExitOnEnter();
    }

    public void init() {
        Creature winnerFirst = callBattle(monsters.get("montaro"), heroes.get("dark-glorysson"));
        enter.listener();
        Creature winnerSecond = callBattle(monsters.get("matilda"), heroes.get("mellayne"));
        enter.listener();
        Creature winnerThird = callBattle(monsters.get("lord-black"), heroes.get("gryin"));
        enter.listener();
        Creature winnerLast = callBattle(winnerFirst, winnerSecond);
        enter.listener();
        Creature winnerFinished = callBattle(winnerThird, winnerLast);
        enter.listener();
        championshipFinished(winnerFinished);
    }

    public Creature callBattle(Creature first, Creature second) {
        System.out.println(first.toString());
        System.out.println();
        System.out.println(second.toString());
        return battle.battleStart(first, second);
    }

    public void championshipFinished(Creature winner) {
        System.out.println("|------------------------ Championship Finished ------------------------|");
        System.out.println();
        System.out.println(winner.toString());
        System.out.println("\n\n");
    }
}