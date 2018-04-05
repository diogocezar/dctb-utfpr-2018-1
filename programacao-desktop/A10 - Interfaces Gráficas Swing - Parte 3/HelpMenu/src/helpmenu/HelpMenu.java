package helpmenu;
import javax.swing.*;
import java.awt.event.*;

class HelpMenu implements ActionListener {

  HelpMenu() {
    JFrame jfrm = new JFrame("Help Menu Demo");
    jfrm.setSize(220, 200);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the menu bar.
    JMenuBar jmb = new JMenuBar();
    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiFAQ = new JMenuItem("FAQ");
    jmiFAQ.addActionListener(this);
    jmHelp.add(jmiFAQ);
    jmb.add(jmHelp);

    // Add the menu bar & label to the frame & display it
    jfrm.setJMenuBar(jmb);
    jfrm.setVisible(true);
  }

  // Handle FAQ menu item action event.
  public void actionPerformed(ActionEvent ae) {
    JFrame helpFrame = new JFrame("Frequently Asked Questions");
    helpFrame.setSize(320, 100);
    helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JLabel faqLabel = new JLabel();
    faqLabel.setText("<html>Question: " +
        "What are the book authors' names?<br>" +
        "Answer: Herbert Schildt and Dale Skrien");

    helpFrame.add(faqLabel);
    helpFrame.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new HelpMenu();
      }
    });
  }
}
