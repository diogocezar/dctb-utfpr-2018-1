package parte1;

public class Confrontation {

    public static Creature start(Creature c1, Creature c2) {

        Creature winner = new Creature("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0) {
        };

        Fights fights = new Fights();

        if (c1.getName().equalsIgnoreCase("Dark Glorysson") || c1.getName().equalsIgnoreCase("Mellayne")
                || c1.getName().equalsIgnoreCase("Gryin")) {

            //c1 is hero
            if (c2.getName().equalsIgnoreCase("Montaro") || c2.getName().equalsIgnoreCase("Lord Black")
                    || c2.getName().equalsIgnoreCase("Matilda")) {
                // c1 is hero and c2 is monster
                winner = fights.startHeroMonster(c1, c2);
                return winner;

            } else if (c2.getName().equals("Dark Glorysson") || c2.getName().equals("Mellayne")
                    || c2.getName().equals("Gryin")) {
                //c1 and c2 are hero
                winner = fights.startHeroHero(c1, c2);
                return winner;

            }
        }else if (c1.getName().equalsIgnoreCase("Montaro") || c1.getName().equalsIgnoreCase("Lord Black")
                    || c1.getName().equalsIgnoreCase("Matilda")) {
            
             if (c2.getName().equalsIgnoreCase("Montaro") || c2.getName().equalsIgnoreCase("Lord Black")
                    || c2.getName().equalsIgnoreCase("Matilda")) {
                //c1 and c2 are monsters
                winner = fights.startMonsterMonster(c1, c2);
                return winner;
            }
        }
        return winner;
    }
}
