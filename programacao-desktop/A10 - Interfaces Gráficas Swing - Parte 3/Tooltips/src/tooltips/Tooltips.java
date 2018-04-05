
package tooltips;

import javax.swing.*;

class Tooltips {

  Tooltips() {

    // Create the frame and set its size and close op
    JFrame jfrm = new JFrame("Tooltip Demo");
    jfrm.setSize(220, 200);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the menu bar, menu, & menu item
    JMenuBar jmb = new JMenuBar();
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiExit = new JMenuItem("Exit");
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    // Create the label
    JLabel label = new JLabel("Sample text.");

    // Add tooltips to everything
    jmb.setToolTipText("This is the menu bar.");
    label.setToolTipText("This is a label.");
    jmFile.setToolTipText("This is a menu.");
    jmiExit.setToolTipText("This is a menu item.");

    // Add the label & menubar to the frame & display it
    jfrm.add(label);
    jfrm.setJMenuBar(jmb);
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Tooltips();
      }
    });
  }
}

