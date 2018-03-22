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
public abstract class Criatura implements Generica {
    String nome, classe;
    int nivel, vida, magia, força, agilidade, destreza, inteligência, carisma;

    public Criatura(String nome, String classe, int nivel, int vida, int magia, int força, int agilidade, int destreza, int inteligência, int carisma) {
        
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.vida = vida;
        this.magia = magia;
        this.força = força;
        this.agilidade = agilidade;
        this.destreza = destreza;
        this.inteligência = inteligência;
        this.carisma = carisma;
    }
    
    float atacar(){
        float r = (float) (1.1 + (Math.random()* (1.66 - 1.1)));
        
        float ataque = (float) ((this.nivel + this.força + this.agilidade + (this.magia *0.1)) * r);
        
        return ataque;
    }
    float defender(){
        float r = (float) (1.1 + (Math.random()* (1.66 - 1.1)));
        
        float defesa = (float) (this.inteligência + (this.destreza*0.7) + this.agilidade) * r;
        
        return defesa;  
    }
    boolean vivo(){
        return this.vida > 0;
    }
    void perdeVida(int valor){
        this.vida -= valor;  
    }  
    void revitalizar(){
        float r = (float) (1.1 + (Math.random()* (1.66 - 1.1)));
        
        float coeficiente = (this.vida + this.nivel) * r;
        
        if (coeficiente > 20){
            vida += 50;
            magia += 30;
            System.out.println("Criatura " + this.nome + " pode descansar.");
        }
        
        if (vida > 100)
            vida = 100;
        if (magia > 100)
            magia = 100;
        
    }
}
