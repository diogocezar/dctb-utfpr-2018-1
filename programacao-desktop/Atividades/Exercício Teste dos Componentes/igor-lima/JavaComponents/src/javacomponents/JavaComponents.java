/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacomponents;

import javax.swing.SwingUtilities;

/**
 *
 * @author igorv
 */
public class JavaComponents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Components componentsMenu = new Components();
                componentsMenu.setVisible(true);
            }
        });
    
    }
    
}
