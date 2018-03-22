/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg2;

import java.util.Random;

/**
 *
 * @author luiz-
 */
public class Heroi extends Criatura {
    
    int blessing;

    public Heroi(String nome, String classe, int nivel, int vida, int magia, int força, int agilidade, int destreza, int inteligência, int carisma, int blessing) {
        super(nome, classe, nivel, vida, magia, força, agilidade, destreza, inteligência, carisma);
        this.blessing = blessing;
    }
    
    @Override
    void revitalizar(){
        float r = (float) (1.1 + (Math.random()* (1.66 - 1.1)));
        
        float coeficiente = (this.vida + this.nivel + this.blessing) * r;
        
        if (coeficiente > 20){
            vida += 50;
            magia += 30;
        }
        
        if (vida > 100)
            vida = 100;
        if (magia > 100)
            magia = 100;
        
    }

    @Override
    public void _toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _call() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
