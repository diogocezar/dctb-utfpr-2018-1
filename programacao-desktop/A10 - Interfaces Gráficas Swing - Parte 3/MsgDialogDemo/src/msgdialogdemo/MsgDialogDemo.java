package msgdialogdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MsgDialogDemo {

    JLabel jlab;
    JButton jbtnShow;
    JFrame jfrm;
    ImageIcon icon;

    MsgDialogDemo() {
        jfrm = new JFrame("Simples Caixa de Diálogo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 250);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlab = new JLabel();
        jbtnShow = new JButton("Caixa de Diálogo");
        icon = new ImageIcon("home.png");

        jbtnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Diálogo Aberto");
                //JOptionPane.showMessageDialog(jfrm,"Disco cheio");
                //JOptionPane.showMessageDialog(jfrm,"Disco cheio", "Atenção", JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(jfrm,"Disco cheio", "Erro", JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(jfrm,"Disco cheio", "Atenção", JOptionPane.PLAIN_MESSAGE);
                //JOptionPane.showMessageDialog(jfrm,"Disco cheio?", "Responda", JOptionPane.QUESTION_MESSAGE);        
                JOptionPane.showMessageDialog(jfrm, "Disco cheio?", "Responda", JOptionPane.PLAIN_MESSAGE, icon);
                jlab.setText("Diálogo Fechado");
            }
        });

        jfrm.add(jbtnShow);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MsgDialogDemo();
            }
        });
    }
}
