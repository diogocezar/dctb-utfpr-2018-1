/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author kamimuraf
 */
public class BdContas {
 
    
   private BdContas(){}
    
   private ArrayList<Conta> contas = new ArrayList<>();
   
   public void setContas(ArrayList<Conta> contas){
       this.contas = contas;
   }
   public ArrayList<Conta> getContas(){
       return contas;
   }
   
   private static class BdContasHolder{
        private static final BdContas INSTANCE = new BdContas();
    }
   public static BdContas getInstance(){
       return BdContasHolder.INSTANCE;
   }
  
   

    
}
