package codificacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class codificacao implements ActionListener {

    JTextField jtfPlaintext;
    JTextField jtfCiphertext;

    codificacao() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("A Simple Code Machine");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(400, 400);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two labels.
        JLabel jlabPlaintext = new JLabel("   Plain Text: ");
        JLabel jlabCiphertext = new JLabel("Cipher Text: ");

        // Create two text field instances.
        jtfPlaintext = new JTextField(20);
        jtfCiphertext = new JTextField(20);

        // Set the action commands for the text fields.
        jtfPlaintext.setActionCommand("Encode");
        jtfCiphertext.setActionCommand("Decode");

        // Add action listeners for the text fields.
        jtfPlaintext.addActionListener(this);
        jtfCiphertext.addActionListener(this);

        // Add the text fields and labels to the content pane.
        jfrm.add(jlabPlaintext);
        jfrm.add(jtfPlaintext);
        jfrm.add(jlabCiphertext);
        jfrm.add(jtfCiphertext);

        // Create push button instances.
        JButton jbtnEncode = new JButton("Encode");
        JButton jbtnDecode = new JButton("Decode");
        JButton jbtnReset = new JButton("Reset");

        // Add action listeners for the buttons.
        jbtnEncode.addActionListener(this);
        jbtnDecode.addActionListener(this);
        jbtnReset.addActionListener(this);

        // Add the buttons to the content pane.
        jfrm.add(jbtnEncode);
        jfrm.add(jbtnDecode);
        jfrm.add(jbtnReset);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {

        // If action command is "Encode" then encode the string.
        if (ae.getActionCommand().equals("Encode")) {

            // This will hold the encoded string.
            String encStr = "";

            // Obtain the plain text.
            String str = jtfPlaintext.getText();

            // Add 1 to each character.
            for (int i = 0; i < str.length(); i++) {
                encStr += (char) (str.charAt(i) + 1);
            }

            // Set the coded text into the Cipher Text field.
            jtfCiphertext.setText(encStr.toString());
        } // If action command is "Decode" then decode the string.
        else if (ae.getActionCommand().equals("Decode")) {

            // This will hold the decoded string.
            String decStr = "";

            // Obtain the cipher text.
            String str = jtfCiphertext.getText();

            // Subtract 1 from each character.
            for (int i = 0; i < str.length(); i++) {
                decStr += (char) (str.charAt(i) - 1);
            }

            // Set the decoded text into the Plain Text field.
            jtfPlaintext.setText(decStr.toString());
        } // Otherwise, must be "Reset" command.
        else {
            jtfPlaintext.setText("");
            jtfCiphertext.setText("");
        }
    }

    public static void main(String[] args) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new codificacao();
            }
        });
    }
}
