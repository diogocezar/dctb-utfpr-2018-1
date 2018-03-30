package buttondemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonDemo {

    JLabel jlab;

    ButtonDemo() {
        JFrame jfrm = new JFrame("A Button Example");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220, 90);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jbtnFirst = new JButton("First");
        JButton jbtnSecond = new JButton("Second");

        // Add action listeners.
        jbtnFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                jlab.setText("First button was pressed.");
            }
        });

        jbtnSecond.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                jlab.setText("Second button was pressed.");
            }
        });

        jfrm.add(jbtnFirst);
        jfrm.add(jbtnSecond);
        jlab = new JLabel("Press a button.");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
