import java.util.ArrayList;

public class Confrontation 
{
    public static void main(String[] args)
    {
        Hero hero = new Hero("DARK GLORYSSON", "Human", 8, 100, 100, 10, 5, 10, 15, 2, 10);
        Hero hero2 = new Hero("MELLAYNE", "Human", 5, 100, 80, 25, 10, 8, 2, 20, 10);
        Hero hero3 = new Hero("GRYIN", "Dwarf", 10, 100, 50, 30, 5, 10, 5, 1, 10);


        Monster monster = new Monster("MONTARO", "Dark Elf", 7, 100, 100, 10, 5, 10, 15, 10);
        Monster monster2 = new Monster("LORD BLACK", "Human", 10, 100, 20, 32, 12, 10, 10, 1);
        Monster monster3 = new Monster("MATILDA", "Elf", 10, 100, 80, 10, 8, 10, 18, 5);
        

        ArrayList<Hero> first_hero = new ArrayList<Hero>();
        ArrayList<Monster> first_monster = new ArrayList<Monster>();
        first_hero.add(hero);
        first_hero.add(hero2);
        first_hero.add(hero3);
        first_monster.add(monster);
        first_monster.add(monster3);
        first_monster.add(monster2);
         
        ArrayList<Creature> second_fight = new ArrayList<>();
        //Round 1
        int aux = 0;
        while (aux != 3){
           second_fight.add(battle(first_hero.get(aux), first_monster.get(aux)));
            aux++;
        }
        
        Creature final_fighter_1 = battle(second_fight.get(0), second_fight.get(1));
        Creature final_fighter_2 = second_fight.get(2);

        Creature winner = battle(final_fighter_1, final_fighter_2);


        System.out.println("The winner of the championship is " + winner.getName());


    }

        public static Creature battle(Creature hero, Creature monster){


        int flag = 1;
        int count_round=0;
        int attack;
        int defence;
        hero.__toString();
        System.out.println(" VS ");
        monster.__toString();        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (hero.isAlive() && monster.isAlive())
        {
            attack = 0;
            defence = 0;
            count_round++;
            System.out.println("");
            System.out.println("ROUND "+count_round);
            if (flag == 1)
            {
                flag = 2;
                attack = (int) monster.attack();
                defence = (int) hero.defend();

                System.out.println(monster.getName()+ " attacked ("+attack+"X"+defence+") "+hero.getName());

                if (attack > defence)
                {
                    hero.losesLife(8);
                    System.out.println(hero.getName() + " lost 8 of life!");                   
                } else {
                    System.out.println(hero.getName() + " blocked the attack!");
                }
                System.out.println("Life of Hero: " + hero.getLife());
                System.out.println("Life of Monster: " + monster.getLife());
                System.out.println("");

            } else if (flag == 2)
            {
                flag = 1;
                attack = (int) hero.attack();
                defence = (int) monster.defend();
                System.out.println(hero.getName()+ " attacked ("+attack+"X"+defence+") "+monster.getName());

                if (attack > defence)
                {
                    monster.losesLife(8);
                    System.out.println(monster.getName() + "lost 8 of life!");
                } else {
                    System.out.println(monster.getName() + " blocked the attack!");
                }
                System.out.println("Life of Hero: " + hero.getLife());
                System.out.println("Life of Monster: " + monster.getLife());
                System.out.println("");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (!hero.isAlive()){
                System.out.println("");
                System.out.println(monster.getName() + " WINS THE BATTLE!");
                System.out.println("");
                monster.rest();
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                return (Creature) monster;
            }
            else if (!monster.isAlive()) {
                System.out.println(hero.getName() + " WINS THE BATTLE!");
                System.out.println("");
                hero.rest(); 
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                return (Creature) hero;
                
            }
            
        }
        return null;
    }
}