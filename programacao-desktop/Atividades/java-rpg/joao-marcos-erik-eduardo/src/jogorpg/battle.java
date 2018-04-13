package jogorpg;

/**
 *
 * @author Erik Lima
 */

public class battle {
    
    
    
            //===methods==
    public  static Creature Iniciar(Creature c1,Creature c2){
        
      int round = 1;
      Creature vencedor = null; 
      double ataque;
      double defesa;
      boolean descanso= false;
   int flag = 1;
     
     while ((c1.vivo(c1.getVida()) == true)&& (c2.vivo(c2.getVida()) == true)  ){
         if (flag == 1){
             flag = 2;
                ataque =  c2.atacar(c2.getNivel(), c2.getForca(), c2.getAgilidade(), c2.getMagia());
                defesa = c1.defender(c1.getAgilidade(), c1.getDestreza(),c1.getIntelligencia());
                
             if (ataque > defesa){
                 c1.setVida(c1.perderVida(c1.getVida()));
             
                 if(c1.getVida()< 0){
                     break;
                 }
                     
                 
                 System.out.println("===========Round "+round+"===========");
                 System.out.println(c2.getNome() + " ("+ ataque + "x" + defesa + ")"+ c1.getNome());
                 System.out.println(c1.getNome()+" perdeu 8 pontos de vida");
                 System.out.println(" Vida do Heroi " + c1.getVida());
                 System.out.println(" Vida do Monstro " + c2.getVida());
                 round= round +1;
             }
            
         }
         
         else{  
             flag = 1;
                  ataque =  c1.atacar(c1.getNivel(), c1.getForca(), c1.getAgilidade(), c1.getMagia());
                  defesa = c2.defender(c2.getAgilidade(), c2.getDestreza(),c2.getIntelligencia());

                  if (ataque > defesa){
                    c2.setVida(c2.perderVida(c2.getVida())); 
                    if(c1.getVida()< 0){
                        break;
                     }
                 System.out.println("===========Round "+round+"===========");
                 System.out.println(c1.getNome() + " ("+ ataque + "x" + defesa + ")"+ c2.getNome());
                 System.out.println(c2.getNome()+" perdeu 8 pontos de vida");
                 System.out.println(" Vida do Heroi " + c1.getVida());
                 System.out.println(" Vida do Monstro " + c2.getVida());
                 round= round +1;
                 
             }
         }
         
         
    }
     if((c1.vivo(c1.getVida()) == true)  ){
         
       double coeficienteDeDescanco = c1.descancar( c1.getVida(),c1.getNivel());
            if(coeficienteDeDescanco > 20 ){
                c1.revitalizar(c1);
                
            }
            
           vencedor=  c1;
            
           
              
     }else if((c2.vivo(c2.getVida()) == true)){
               double coeficienteDeDescanco = c2.descancar(c2.getVida(), c2.getNivel());
            
            if(coeficienteDeDescanco > 20 ){
                c2.revitalizar(c2);
            }
            
             vencedor = c2;
    }
        return vencedor;
       
    
}

   
}
   

