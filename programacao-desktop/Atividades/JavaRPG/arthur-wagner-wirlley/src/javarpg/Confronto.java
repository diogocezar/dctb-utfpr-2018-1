package javarpg;

/**
 *
 * @author arthu
 */
public  class Confronto {
    public static boolean Fight(Heroi player1 ,Monstro player2){
        
            
            int turn =1, atk, def;
            
            while (player1.isAlive() && player2.isAlive())
            {
                if (turn == 1){
                    turn =2;
                    System.out.println("\n" + player1.getName()+"'s Turn.");
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
                    System.out.println("\n" + player2.getName()+"'s Turn.");
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
            
            if (player1.isAlive()){
                
                if (player1.Heal(player1.rest())){
                    System.out.println("\n" + player1.getName()+" Vencedor descansou");
                    return true;
                }
                else{
                    System.out.println("\n" + player1.getName()+" Vencedor não descansou");
                    return true;
                }
                
            }
            else
            {
                  if (player2.Heal((player1.rest()))){
                    System.out.println("\n" + player2.getName()+" Vencedor descansou");
                    return false;
                }
                else{
                    System.out.println("\n" + player2.getName()+" Vencedor não descansou");
                    return false;
                }
           
            }
        
    }
    public void apresenta(Heroi player1, Monstro player2){
        System.out.println("\n" + player1.getName() + " VS "+ player2.getName());
    }
    
        public static boolean Fight(Heroi player1 ,Heroi player2){
        
            
            int turn =1, atk, def;
            
            while (player1.isAlive() && player2.isAlive())
            {
                if (turn == 1){
                    turn =2;
                    System.out.println("\n" + player1.getName()+"'s Turn.");
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
                    System.out.println("\n" + player2.getName()+"'s Turn.");
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
            
            if (player1.isAlive()){
                
                if (player1.Heal(player1.rest())){
                    System.out.println("\n" + player1.getName()+" Vencedor descansou");
                    return true;
                }
                else{
                    System.out.println("\n" + player1.getName()+" Vencedor não descansou");
                    return true;
                }
                
            }
            else
            {
                  if (player2.Heal((player1.rest()))){
                    System.out.println("\n" + player2.getName()+" Vencedor descansou");
                    return false;
                }
                else{
                    System.out.println("\n" + player2.getName()+" Vencedor não descansou");
                    return false;
                }
           
            }
            
            
        
    }
        
        public static boolean Fight(Monstro player1 ,Monstro player2){
        
            
            int turn =1, atk, def;
            
            while (player1.isAlive() && player2.isAlive())
            {
                if (turn == 1){
                    turn =2;
                    System.out.println("\n" + player1.getName()+"'s Turn.");
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
                    System.out.println("\n" + player2.getName()+"'s Turn.");
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
            
            if (player1.isAlive()){
                
                if (player1.Heal(player1.rest())){
                    System.out.println("\n" + player1.getName()+" Vencedor descansou");
                    return true;
                }
                else{
                    System.out.println("\n" + player1.getName()+" Vencedor não descansou");
                    return true;
                }
                
            }
            else
            {
                  if (player2.Heal((player1.rest()))){
                    System.out.println("\n" + player2.getName()+" Vencedor descansou");
                    return false;
                }
                else{
                    System.out.println("\n" + player2.getName()+" Vencedor não descansou");
                    return false;
                }
           
            }
        
    }
        
            public static boolean Fight(Monstro player1 ,Heroi player2){
        
            
            int turn =1, atk, def;
            
            while (player1.isAlive() && player2.isAlive())
            {
                if (turn == 1){
                    turn =2;
                    System.out.println("\n" + player1.getName()+"'s Turn.");
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
                    System.out.println("\n" + player2.getName()+"'s Turn.");
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
            
            if (player1.isAlive()){
                
                if (player1.Heal(player1.rest())){
                    System.out.println("\n" + player1.getName()+" Vencedor descansou");
                    return true;
                }
                else{
                    System.out.println("\n" + player1.getName()+" Vencedor não descansou");
                    return true;
                }
                
            }
            else
            {
                  if (player2.Heal((player1.rest()))){
                    System.out.println("\n" + player2.getName()+" Vencedor descansou");
                    return false;
                }
                else{
                    System.out.println("\n" + player2.getName()+" Vencedor não descansou");
                    return false;
                }
           
            }
        
    }
}
