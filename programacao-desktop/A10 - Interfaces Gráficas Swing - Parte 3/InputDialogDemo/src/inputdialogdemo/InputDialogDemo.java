package inputdialogdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InputDialogDemo {

    JLabel jlab;

    JButton jbtnShow;

    JFrame jfrm;

    InputDialogDemo() {
        // Create a new JFrame container.
        jfrm = new JFrame("Caixa De Diálogo: INPUT");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(400, 250);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label that shows the response.
        jlab = new JLabel();

        // Create button that will display the dialog.
        jbtnShow = new JButton("Caixa de Diálogo");

        // Add action listener for the button.
        jbtnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                // Create a dialog that inputs a string.
                String [] nomes = {"Tom Jones", "Bob Smith", "Mary Doe", "Nancy Oliver"};
                //String response = JOptionPane.showInputDialog("Digite o nome");

                //String response2 = JOptionPane.showInputDialog(jfrm,"Digite o nome", "Emilia Corte");

                String response3 = (String) JOptionPane.showInputDialog(jfrm,
                        "Escolha o usuário", "Selecione o nome de usuário",
                        JOptionPane.QUESTION_MESSAGE, null, nomes, "Emilia Flores");

                // If the response is null, then the dialog
                // was cancelled or closed. If response is a
                // zero-length string, then no input was entered.
                // Otherwise, response contains a string entered
                // by the user.
                if (response3 == null) {
                    jlab.setText("Cancelado ou Fechado");
                } else if (response3.length() == 0) {
                    jlab.setText("Nenhum nome digitado");
                } else {
                    jlab.setText("Olá " + response3);
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
                new InputDialogDemo();
            }
        });
    }
}
