/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.data.controller;

import javax.swing.SwingUtilities;
import utfpr.itsone.view.Index;

/**
 *
 * @author Vinicius
 */
public class Application {
    public static void main(String[] args) {
         // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new CreateObj();
        //new Sign().openSignUp();  
        new Index();
      }
    });
    }
}
