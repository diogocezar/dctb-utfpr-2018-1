package confirmdialogdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ConfirmDialogDemo {

    JLabel jlab;
    JButton jbtnShow;
    JFrame jfrm;

    ConfirmDialogDemo() {
        jfrm = new JFrame("Caixa de diálogo de confirmação");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 250);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlab = new JLabel();
        jbtnShow = new JButton("Mostra Diálogo");
        jbtnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                int response = JOptionPane.showConfirmDialog(jfrm,
                        "Remove arquivos?");
                switch (response) {
                    case JOptionPane.YES_OPTION:
                        jlab.setText("Sua resposta foi sim.");
                        break;
                    case JOptionPane.NO_OPTION:
                        jlab.setText("Sua resposta foi não.");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        jlab.setText("Botão cancelar pressionado.");
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        jlab.setText("Caixa de dialogo fechada.");
                        break;
                }
            }
        });

        jfrm.add(jbtnShow);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConfirmDialogDemo();
            }
        });
    }
}
