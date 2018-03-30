/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Database {
    private ArrayList<Conta> Contas= new ArrayList<>();

    public ArrayList<Conta> getContas() {
        return Contas;
    }

    public void setContas(ArrayList<Conta> Contas) {
        this.Contas = Contas;
    }
    public void addToContas(Conta conta){
        Contas.add(conta);
    }
    
    private Database() {
    }
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }
}
