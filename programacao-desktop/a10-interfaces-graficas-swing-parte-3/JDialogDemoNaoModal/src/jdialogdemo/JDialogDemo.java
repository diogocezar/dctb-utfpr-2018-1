package jdialogdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JDialogDemo {

    JLabel jlab;

    JButton jbtnShow;
    JButton jbtnReset;

    // These buttons are contained within the dialog.
    JButton jbtnUp;
    JButton jbtnDown;

    JDialog jdlg;

    JDialogDemo() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("JDialogo");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(400, 200);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label that shows the direction.
        jlab = new JLabel("Direção está pendente.");

        // Create a button that will show the dialog.
        jbtnShow = new JButton("Mostra dialogo");

        // Create button that will reset the direction.
        jbtnReset = new JButton("Reset direção");

        // Create a simple modal dialog.
        jdlg = new JDialog(jfrm, "Direção");
        jdlg.setSize(200, 100);
        jdlg.setLayout(new FlowLayout());

        // Create buttons used by the dialog.
        jbtnUp = new JButton("Acima");
        jbtnDown = new JButton("ABaixo");

        // Add buttons to the dialog.
        jdlg.add(jbtnUp);
        jdlg.add(jbtnDown);

        // Add a label to the dialog.
        jdlg.add(new JLabel("Aperte um botão."));

        // Show the dialog when the Show Dialog button is pressed.
        jbtnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jdlg.setVisible(true);
            }
        });

        // Reset the direction when the Reset Direction
        // button is pressed.
        jbtnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Direção está pendente.");
            }
        });

        // Respond to the Up button in the dialog.
        jbtnUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Direação está para cima.");
            }
        });

        // Respond to the Down button in the dialog.
        jbtnDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Direção está pra baixo.");
            }
        });

        // Add the Show Dialog button and label to the content pane.
        jfrm.add(jbtnShow);
        jfrm.add(jbtnReset);
        jfrm.add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the GUI on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JDialogDemo();
            }
        });
    }
}
