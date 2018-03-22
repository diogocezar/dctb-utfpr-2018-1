/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg2;

/**
 *
 * @author luiz-
 */
public class Monstro extends Criatura {

    public Monstro(String nome, String classe, int nivel, int vida, int magia, int força, int agilidade, int destreza, int inteligência, int carisma) {
        super(nome, classe, nivel, vida, magia, força, agilidade, destreza, inteligência, carisma);
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
