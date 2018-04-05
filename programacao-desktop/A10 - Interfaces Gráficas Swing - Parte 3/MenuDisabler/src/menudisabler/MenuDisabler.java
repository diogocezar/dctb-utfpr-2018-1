package menudisabler;
import javax.swing.*;
import java.awt.event.*;

class MenuDisabler implements ActionListener {

  JMenu fileMenu, editMenu, textMenu, showMenu;

  MenuDisabler() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Menu Demo");

    // Give the frame an initial size.
    jfrm.setSize(300, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the menu bar.
    JMenuBar jmb = new JMenuBar();

    // Create the File menu.
    fileMenu = new JMenu("File");
    JMenuItem jmiOpen = new JMenuItem("Open");
    fileMenu.add(jmiOpen);
    jmb.add(fileMenu);

    // Create the Edit menu.
    editMenu = new JMenu("Edit");
    JMenuItem jmiUndo = new JMenuItem("Undo");
    editMenu.add(jmiUndo);
    jmb.add(editMenu);

    // Create the Text menu.
    textMenu = new JMenu("Text");
    JMenuItem jmiFont = new JMenuItem("Courier bold");
    textMenu.add(jmiFont);
    jmb.add(textMenu);

    // Create the Show menu.
    showMenu = new JMenu("Show");
    // Use check boxes for the three menu items.
    JCheckBoxMenuItem jmiFile = new JCheckBoxMenuItem("File", true);
    JCheckBoxMenuItem jmiEdit = new JCheckBoxMenuItem("Edit", true);
    JCheckBoxMenuItem jmiText = new JCheckBoxMenuItem("Text", true);
    showMenu.add(jmiFile);
    showMenu.add(jmiEdit);
    showMenu.add(jmiText);
    jmiFile.addActionListener(this);
    jmiEdit.addActionListener(this);
    jmiText.addActionListener(this);
    jmb.add(showMenu);

    // Add the menu bar to the frame.
    jfrm.setJMenuBar(jmb);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle menu item action events.
  public void actionPerformed(ActionEvent ae) {
    // Get the action command from the menu selection.
    String menuName = ae.getActionCommand();

    // Enable or disable the menus
    if(menuName.equals("File")) 
      fileMenu.setEnabled(! fileMenu.isEnabled());
    if(menuName.equals("Edit")) 
      editMenu.setEnabled(! editMenu.isEnabled());
    if(menuName.equals("Text")) 
      textMenu.setEnabled(! textMenu.isEnabled());
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MenuDisabler();
      }
    });
  }
}

