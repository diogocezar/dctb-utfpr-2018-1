public class Confrontation 
{
    public static void main(String[] args)
    {

        Hero hero = new Hero("DARK GLORYSSON", "Humano", 8, 100, 100, 10, 5, 10, 15, 2, 10);
        hero.__toString();
        System.out.println("");
        Monster monster = new Monster("MONTARO", "Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10);
        monster.__toString();

        int flag = 1;
        int count_round=0;
        int attack;
        int defence;
        while (hero.isAlive() && monster.isAlive())
        {
            attack = 0;
            defence = 0;
            count_round++;
            System.out.println("ROUND "+count_round);
            if (flag == 1)
            {
                flag = 2;
                attack = (int) monster.attack();
                defence = (int) hero.defend();

                System.out.println(monster.getName()+ " attacked ("+attack+"X"+defence+""+hero.getName());
                System.out.println("");

                if (attack > defence)
                {
                    hero.losesLife(8);
                    System.out.println(hero.getName() + " lost 8 of life!");                   
                    System.out.println("Life of Hero: "+ hero.getLife());
                    System.out.println("Life of Monster: " + monster.getLife());
                    System.out.println("");
                } else {
                    System.out.println(hero.getName() + " blocked the attack!");
                    System.out.println("Life of Hero: " + hero.getLife());
                    System.out.println("Life of Monster: " + monster.getLife());
                    System.out.println("");
                }
            } else if (flag == 2)
            {
                flag = 1;
                attack = (int) hero.attack();
                defence = (int) monster.defend();
                System.out.println(hero.getName()+ " attacked ("+attack+"X"+defence+""+monster.getName());
                System.out.println("");

                if (attack > defence)
                {
                    monster.losesLife(8);
                    System.out.println(monster.getName() + "lost 8 of life!");
                    System.out.println("Life of Hero: " + hero.getLife());
                    System.out.println("Life of Monster: " + monster.getLife());
                    System.out.println("");

                } else {
                    System.out.println(monster.getName() + " blocked the attack!");
                    System.out.println("Life of Hero: " + hero.getLife());
                    System.out.println("Life of Monster: " + monster.getLife());
                    System.out.println("");
                }
            }

        }
    }
}