package matchingboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatchingBoxes implements ActionListener {

    JTextField jtf1;
    JTextField jtf2;
    JLabel jlab;
    JButton jbutton;

    MatchingBoxes() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("Match Two Text Fields");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(440, 160);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two text field instances.
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);

        // Add the text fields to the content pane.
        jfrm.add(jtf1);
        jfrm.add(jtf2);

        // Create a label and a button.
        jlab = new JLabel("Type the same thing in both boxes.");
        jbutton = new JButton("OK");

        // Add the label and button to the frame.
        jfrm.add(jlab);
        jfrm.add(jbutton);

        // Add action listener for the button
        jbutton.addActionListener(this);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {

        if (jtf1.getText().equals(jtf2.getText())) {
            displayNewFrame();
        } else {
            jlab.setText("Try again. Type the same thing in both boxes.");
        }
    }

    private void displayNewFrame() {
        JFrame msgframe = new JFrame("They matched");
        msgframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        msgframe.setSize(200, 60);
        JLabel label = new JLabel("   They matched!");
        msgframe.add(label);
        msgframe.setVisible(true);
    }

    public static void main(String[] args) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatchingBoxes();
            }
        });
    }
}
