package exemplo6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class exemplo6 {

    JLabel jlab;

    exemplo6() {
        JFrame jfrm = new JFrame("A Button Example");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(300, 300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlab = new JLabel("Press a button.");
        JButton jbtnFirst = new JButton("First");
        JButton jbtnSecond = new JButton("Second");

        // Add action listeners.
        jbtnFirst.addActionListener(new ButtonListener(
                "First button was pressed."));
        jbtnSecond.addActionListener(new ButtonListener(
                "Second button was pressed"));

        jfrm.add(jbtnFirst);
        jfrm.add(jbtnSecond);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new exemplo6();
            }
        });
    }

    class ButtonListener implements ActionListener {

        String msg;

        ButtonListener(String m) {
            msg = m;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            jlab.setText(msg);
        }
    }
}
