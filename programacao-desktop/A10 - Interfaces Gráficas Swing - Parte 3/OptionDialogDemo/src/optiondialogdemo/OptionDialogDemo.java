
package optiondialogdemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OptionDialogDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFrame jfrm;

  OptionDialogDemo() {
    // Create a new JFrame container.
    jfrm = new JFrame("EXEMPLO DE SHOW OPTION DIALOG");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 250);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the selection.
    jlab = new JLabel();

    // Create button that will display the dialog.
    jbtnShow = new JButton("Caixa de Dialogo");

    // Add action listener for the button.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {

        // Define the connection options.
        String[] connectOpts = { "Modem", "Wireless",
                                 "Satelite", "Cabo" };

        // Create a dialog that lets the user
        // choose how to connect to the network.
        int response = JOptionPane.showOptionDialog(
                              jfrm,
                              "Escolha a Conexão",
                              "Tipo de Conexão",
                              JOptionPane.DEFAULT_OPTION,
                              JOptionPane.QUESTION_MESSAGE,
                              null,
                              connectOpts,
                              "Wireless");

         // Display the choice.
         switch(response) {
           case 0:
             jlab.setText("Conectar via modem.");
             break;
           case 1:
             jlab.setText("Conectar via wireless.");
             break;
           case 2:
             jlab.setText("Conectar via satelite.");
             break;
           case 3:
             jlab.setText("Conectar via cabo.");
             break;
           case JOptionPane.CLOSED_OPTION:
             jlab.setText("Dialog cancelled.");
             break;
         }
      }
    });

    // Add the button and label to the content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new OptionDialogDemo();
      }
    });
  }
}