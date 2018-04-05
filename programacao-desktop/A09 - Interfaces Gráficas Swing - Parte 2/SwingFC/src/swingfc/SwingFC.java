/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingfc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SwingFC implements ActionListener {

    JTextField jtfFirst;  // holds the first file name
    JTextField jtfSecond; // holds the second file name

    JButton jbtnComp; // button to compare the files

    JLabel jlabFirst, jlabSecond; // displays prompts
    JLabel jlabResult; // displays results and error messages

    JCheckBox jcbLoc; // check to display location of mismatch

    SwingFC() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("Compare Files");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(200, 220);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the text fields for the file names.
        jtfFirst = new JTextField(14);
        jtfSecond = new JTextField(14);

        // Create the Compare button.
        JButton jbtnComp = new JButton("Compare");

        // Add action listener for the Compare button.
        jbtnComp.addActionListener(this);

        // Create the labels.
        jlabFirst = new JLabel("First file: ");
        jlabSecond = new JLabel("Second file: ");
        jlabResult = new JLabel("");

        // Create check box.
        jcbLoc = new JCheckBox("Show position of mismatch");

        // Add the components to the content pane.
        jfrm.add(jlabFirst);
        jfrm.add(jtfFirst);
        jfrm.add(jlabSecond);
        jfrm.add(jtfSecond);
        jfrm.add(jcbLoc);
        jfrm.add(jbtnComp);
        jfrm.add(jlabResult);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Compare the files when the Compare button is pressed.
    public void actionPerformed(ActionEvent ae) {
        int i = 0, j = 0;
        int count = 0;

        // First, confirm that both file names have been entered.
        if (jtfFirst.getText().equals("")) {
            jlabResult.setText("First file name missing.");
            return;
        }
        if (jtfSecond.getText().equals("")) {
            jlabResult.setText("Second file name missing.");
            return;
        }

        // Compare files. Use try-with-resources to manage the files.
        try (FileInputStream f1
                = new FileInputStream(jtfFirst.getText());
                FileInputStream f2
                = new FileInputStream(jtfSecond.getText())) {

            // Check the contents of each file.
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) {
                    break;
                }
                count++;
            } while (i != -1 && j != -1);

            if (i != j) {
                if (jcbLoc.isSelected()) {
                    jlabResult.setText("Files differ at location " + count);
                } else {
                    jlabResult.setText("Files are not the same.");
                }
            } else {
                jlabResult.setText("Files compare equal.");
            }

        } catch (IOException exc) {
            jlabResult.setText("File Error");
        }
    }

    public static void main(String[] args) {

        // Create the GUI on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingFC();
            }
        });
    }
}
