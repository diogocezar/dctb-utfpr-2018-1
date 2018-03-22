package rpg2;

/**
 *
 * @author luiz-
 */
public class Confronto {

    private static String vencedor;
    
    static String iniciar(Heroi heroi, Monstro monstro){
        
        System.out.println(heroi.nome + " " + heroi.classe);
        System.out.println("Versus");
        System.out.println(monstro.nome + " " + monstro.classe);
        
        
        int flag = 1;
        float vAtaque, vDefesa;
        while (heroi.vivo() && monstro.vivo()){
            if (flag == 1){
                flag = 2;
                vAtaque = monstro.atacar();
                vDefesa = heroi.defender();
                
                if (vAtaque > vDefesa){
                    heroi.perdeVida(8);
                    System.out.println(monstro.nome +" atacou com sucesso! " + heroi.nome + " perde 8 de vida.");
                } else{
                    System.out.println("O ataque de "+ monstro.nome + " falhou.");
                }
            } else {
                flag = 1;
                vAtaque = heroi.atacar();
                vDefesa = monstro.defender();
                
                if (vAtaque > vDefesa){
                    monstro.perdeVida(8);
                    System.out.println(heroi.nome + " atacou com sucesso! "+ monstro.nome+ " perde 8 de vida.");
                } else {
                    System.out.println("O ataque de "+ heroi.nome + " falhou.");
                }
            }
            System.out.println("Vida do monstro: " + monstro.vida);
            System.out.println("Vida do heroi: " + heroi.vida);
        }
        
        if (heroi.vivo()){
            vencedor = heroi.nome;
            heroi.revitalizar();
        } else{
            vencedor = monstro.nome;
            monstro.revitalizar();
        }
        
        return vencedor;
    }

    String iniciar(Monstro monstro1, Monstro monstro2) {
            
        System.out.println(monstro1.nome + " " + monstro1.classe);
        System.out.println("Versus");
        System.out.println(monstro2.nome + " " + monstro2.classe);
        
        
        int flag = 1;
        float vAtaque, vDefesa;
        while (monstro1.vivo() && monstro2.vivo()){
            if (flag == 1){
                flag = 2;
                vAtaque = monstro1.atacar();
                vDefesa = monstro2.defender();
                
                if (vAtaque > vDefesa){
                    monstro2.perdeVida(8);
                    System.out.println(monstro1.nome +" atacou com sucesso! " + monstro2.nome + " perde 8 de vida.");
                } else{
                    System.out.println("O ataque de "+ monstro1.nome + " falhou.");
                }
            } else {
                flag = 1;
                vAtaque = monstro2.atacar();
                vDefesa = monstro1.defender();
                
                if (vAtaque > vDefesa){
                    monstro1.perdeVida(8);
                    System.out.println(monstro2.nome + " atacou com sucesso! "+ monstro1.nome+ " perde 8 de vida.");
                } else {
                    System.out.println("O ataque de "+ monstro2.nome + " falhou.");
                }
            }
            System.out.println("Vida do monstro 1: " + monstro1.vida);
            System.out.println("Vida do monstro 2: " + monstro2.vida);
        }
        
        if (monstro2.vivo()){
            vencedor = monstro2.nome;
            monstro2.revitalizar();
        } else{
            vencedor = monstro1.nome;
            monstro1.revitalizar();
        }
        
        return vencedor;
    }

    String iniciar(Heroi heroi1, Heroi heroi2) {
            
        System.out.println(heroi1.nome + " " + heroi1.classe);
        System.out.println("Versus");
        System.out.println(heroi2.nome + " " + heroi2.classe);
        
        
        int flag = 1;
        float vAtaque, vDefesa;
        while (heroi1.vivo() && heroi2.vivo()){
            if (flag == 1){
                flag = 2;
                vAtaque = heroi1.atacar();
                vDefesa = heroi2.defender();
                
                if (vAtaque > vDefesa){
                    heroi2.perdeVida(8);
                    System.out.println(heroi1.nome +" atacou com sucesso! " + heroi2.nome + " perde 8 de vida.");
                } else{
                    System.out.println("O ataque de "+ heroi1.nome + " falhou.");
                }
            } else {
                flag = 1;
                vAtaque = heroi2.atacar();
                vDefesa = heroi1.defender();
                
                if (vAtaque > vDefesa){
                    heroi1.perdeVida(8);
                    System.out.println(heroi2.nome + " atacou com sucesso! "+ heroi1.nome+ " perde 8 de vida.");
                } else {
                    System.out.println("O ataque de "+ heroi2.nome + " falhou.");
                }
            }
            System.out.println("Vida do monstro 1: " + heroi1.vida);
            System.out.println("Vida do monstro 2: " + heroi2.vida);
        }
        
        if (heroi2.vivo()){
            vencedor = heroi2.nome;
            heroi2.revitalizar();
        } else{
            vencedor = heroi1.nome;
            heroi1.revitalizar();
        }
        
        return vencedor;
    }
}
