package javarpg;

/**
 *
 * @author arthu
 */
public  class Confronto {
    public static void Fight(Creature player1 ,Creature player2){
        
            System.out.println("--------------\n("+player1.getHealth()+")"+player1.getName()+" VS "+player2.getName()+"("+player2.getHealth()+")");
            int turn =1, atk, def;
            while (player1.isAlive() && player2.isAlive())
            {
                if (turn == 1){
                    turn =2;
                    System.out.println("\nHP("+player1.getHealth()+") "+ player1.getName()+"'s Turn.");
                    atk = player1.attack();
                    def = player2.defend();
                    if(atk > def){
                        player2.loseHealth();
                        System.out.println("\n" + player2.getName()+" got hit " + "ATK[" + atk + "] VS [" + def + "]DEF");
                    }
                    else {
                        System.out.println("\n" + player2.getName()+" manage to defend " + "ATK[" + atk + "] VS [" + def + "]DEF");
                    }
                }
                else
                {
                    turn =1;
                    System.out.println("\nHP("+player2.getHealth()+") "+ player2.getName()+"'s Turn.");
                    atk = player2.attack();
                    def = player1.defend();
                    
                    if(atk > def){
                        player1.loseHealth();
                        System.out.println("\n" + player1.getName()+" got hit " + "ATK[" + atk + "] VS [" + def + "]DEF");
                    }
                    else {
                        System.out.println("\n" + player1.getName()+" manage to defend " + "ATK[" + atk + "] VS [" + def + "]DEF");
                    }
                }
            }
            if(player1.isAlive()){
                System.out.println("--------------\n"+player1.getName() + " won.\n");
            }else
                    System.out.println("--------------\n"+player2.getName() + " won.");
    }
}