package recentsubmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RecentSubmenu implements ActionListener {

  JMenu recent;
  int count;

  RecentSubmenu() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Dynamic Menu Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(220, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the menu bar.
    JMenuBar jmb = new JMenuBar();

    // Create the File menu.
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiOpen = new JMenuItem("Open");
    jmiOpen.addActionListener(this);
    recent = new JMenu("Recent");
    JMenuItem jmiExit = new JMenuItem("Exit");
    jmiExit.addActionListener(this);
    jmFile.add(jmiOpen);
    jmFile.add(recent);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    // Add the menu bar to the frame.
    jfrm.setJMenuBar(jmb);

    // Initialize count.
    count = 0;

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle menu item action events.
  public void actionPerformed(ActionEvent ae) {
    String actionCommand = ae.getActionCommand();

    if (actionCommand.equals("Exit"))
      System.exit(0);
    else if (actionCommand.equals("Open")) {
      count++;
      recent.add("Open" + count);
    }
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new RecentSubmenu();
      }
    });
  }
}

