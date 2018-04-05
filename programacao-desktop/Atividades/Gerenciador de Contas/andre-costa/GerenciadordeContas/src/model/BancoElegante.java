/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class BancoElegante {
    
    private ArrayList<Conta> contas = new ArrayList<>();
    
    private BancoElegante() {
        
    }
    
    public static BancoElegante getInstance() {
        return BancoEleganteHolder.INSTANCE;
    }
    
    private static class BancoEleganteHolder {

        private static final BancoElegante INSTANCE = new BancoElegante();
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
    
    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

}

