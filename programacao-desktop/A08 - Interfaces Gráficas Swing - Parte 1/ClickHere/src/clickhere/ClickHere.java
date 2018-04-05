package clickhere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ClickHere implements ActionListener {

    JButton[] buttons
            = {new JButton("Click here"), new JButton("Not here"),
                new JButton("Not here"), new JButton("Not here")};
    int clickIndex = 0;
    JLabel msgLabel;

    ClickHere() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("Random Clicker");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(340, 130);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the action commands for the buttons,
        // add listeners, and add them to the window
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setActionCommand("button" + i);
            buttons[i].addActionListener(this);
            jfrm.add(buttons[i]);
        }

        // Create the label & add it to the frame
        msgLabel = new JLabel(" Click a button. ");
        jfrm.add(msgLabel);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {

        // If the "Click here" button was clicked
        if (ae.getActionCommand().equals("button" + clickIndex)) {

            msgLabel.setText("Good job.  Do it again.");

            // Choose a new "Click here" button
            clickIndex = (int) (4 * Math.random());
            for (int i = 0; i < buttons.length; i++) {
                if (i == clickIndex) {
                    buttons[i].setText("Click here");
                } else {
                    buttons[i].setText("Not here");
                }
            }
        } else {  // a "Not here" button was clicked
            msgLabel.setText("Wrong.  Try again.");
        }
    }

    public static void main(String[] args) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClickHere();
            }
        });
    }
}
