/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo5;

import javax.swing.*;
import java.awt.*;

class exemplo5 {

  exemplo5() {
    JFrame jfrm = new JFrame("A Simple Swing Application");
    jfrm.setSize(200, 200);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create 5 text-based labels.
    JLabel center = new JLabel("   Swing ");
    JLabel west = new JLabel("West  ");
    JLabel east = new JLabel("  East");
    JLabel north = new JLabel("            North");
    JLabel south = new JLabel("            South");

    // Add the labels to the content pane.
    jfrm.add(center, BorderLayout.CENTER);
    jfrm.add(west, BorderLayout.WEST);
    jfrm.add(east, BorderLayout.EAST);
    jfrm.add(north, BorderLayout.NORTH);
    jfrm.add(south, BorderLayout.SOUTH);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new exemplo5();
      }
    });
  }
}

