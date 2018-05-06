/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.view.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import utfpr.itsone.data.UserData;
import utfpr.itsone.data.controller.config.BinArq;
import utfpr.itsone.data.controller.config.JsonArq;
import utfpr.itsone.data.controller.config.TextArq;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class SignUp extends SignIn {

    private JLabel emailLabel = new JLabel("Email");
    private JTextField emailField = new JTextField();
    protected JLabel passwordLabel2 = new JLabel("Confirm Password");
    protected JPasswordField passwordField2 = new JPasswordField();
        private ButtonGroup selectMode;
    private boolean isSelect;

    public SignUp(JFrame parent, boolean isSelect, ButtonGroup selectMode) {
        super(parent);
        this.isSelect = isSelect;
        this.selectMode = selectMode;
        remove(9);
        remove(8);
        register();
    }

    public void register() {
        passwordField2.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0, new Color(0xcccccc)));
        passwordField2.setMaximumSize(new Dimension(300, userField.getPreferredSize().height + 5));
        passwordField2.setBackground(new Color(0x000a1f));
        passwordField2.setForeground(new Color(0xcccccc));
        passwordField2.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel2.setForeground(new Color(0x8D8D8D));

        emailField.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0, new Color(0xcccccc)));
        emailField.setMaximumSize(new Dimension(300, emailField.getPreferredSize().height + 5));
        emailField.setBackground(new Color(0x000a1f));
        emailField.setForeground(new Color(0xcccccc));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailLabel.setForeground(new Color(0x8D8D8D));
        emailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                emailLabel.setForeground(new Color(0x285888));
            }

            public void focusLost(FocusEvent arg0) {
                emailLabel.setForeground(new Color(0x8D8D8D));
            }
        });
        userField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                userLabel.setForeground(new Color(0x285888));
            }

            public void focusLost(FocusEvent arg0) {
                userLabel.setForeground(new Color(0x8D8D8D));
            }
        });
        passwordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                passwordLabel.setForeground(new Color(0x285888));
            }

            public void focusLost(FocusEvent arg0) {
                passwordLabel.setForeground(new Color(0x8D8D8D));
            }
        });
        passwordField2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                passwordLabel2.setForeground(new Color(0x285888));
            }

            public void focusLost(FocusEvent arg0) {
                passwordLabel2.setForeground(new Color(0x8D8D8D));
            }
        });
        remove(0);
        add(Box.createRigidArea(new Dimension(0, 100)), 0);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(passwordLabel2);
        add(Box.createRigidArea(new Dimension(0, 2)));
        add(passwordField2);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(emailLabel);
        add(Box.createRigidArea(new Dimension(0, 2)));
        add(emailField);
        JButton submitRegister = styleButtons();
        /*submitRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register");
            }
        });*/
        submitRegister.addActionListener(this);
        submitRegister.setText("SIGN UP");
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(submitRegister);
    }

    public String valData(String user, String password, String password2, String email) {
        String error = "";
        if (user.isEmpty()) {
            error += "Nome de usuário é obrigatório\n";
        }
        if (password.isEmpty()) {
            error += "Senha de usuário é obrigatório\n";
        }
        if (email.isEmpty()) {
            error += "Email de usuário é obrigatório\n";
        }
        if (validaUserName(user)) {
            error += "Nome de usuário inválido\n";
        }
        if (validaEmail(email)) {
            error += "Email de usuário inválido\n";
        }
        if (!password.equals(password2)) {
            error += "Senhas não são iguais\n";
        }
        if (password.length() < 5) {
            error += "Senha deve ter 5 ou mais caracteres\n";
        }
        return error;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String error = valData(userField.getText(), passwordField.getText(), passwordField2.getText(), emailField.getText());
        if (error.isEmpty()) {
            UserData.getData().addUser(new User(userField.getText(), emailField.getText(), encrpPass(passwordField.getText())));
            User user = UserData.getData().getUsers().get(1);
            if(isSelect){
                if(selectMode.getSelection().getActionCommand().equals("text"))
                    new TextArq().write();
                if(selectMode.getSelection().getActionCommand().equals("bin"))
                    new BinArq().write();
                if(selectMode.getSelection().getActionCommand().equals("json"))
                    new JsonArq().write();
            }
                
        } else {
            showMessageDialog(null, error);
        }
    }
}
