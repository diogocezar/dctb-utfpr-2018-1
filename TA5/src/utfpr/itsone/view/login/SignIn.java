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
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import utfpr.itsone.data.UserData;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class SignIn extends JPanel implements ActionListener {
    protected JFrame parent;
    protected JLabel userLabel = new JLabel("Username");
    protected JTextField userField = new JTextField();
    protected JLabel passwordLabel = new JLabel("Password");
    protected JPasswordField passwordField = new JPasswordField();

    public SignIn(JFrame parent){
        this.parent = parent;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(0x000a1f));
        createFields();
        JButton submit = styleButtons();
        submit.setText("SIGN IN");
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(submit);
        /*submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("login");
            }
        });*/
        submit.addActionListener(this);
    }

    private void createFields() {
        userField.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0, new Color(0xcccccc)));
        userField.setMaximumSize(new Dimension(300,userField.getPreferredSize().height+5));
        userField.setBackground(new Color(0x000a1f));
        userField.setForeground(new Color(0xcccccc));
        passwordField.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0, new Color(0xcccccc)));
        passwordField.setMaximumSize(new Dimension(300,userField.getPreferredSize().height+5));
        passwordField.setBackground(new Color(0x000a1f));
        passwordField.setForeground(new Color(0xcccccc));
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userLabel.setForeground(new Color(0x8D8D8D));
        passwordLabel.setForeground(new Color(0x8D8D8D));
        add(Box.createRigidArea(new Dimension(0, 150)));
        add(userLabel);
        add(Box.createRigidArea(new Dimension(0, 2)));
        add(userField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(passwordLabel);
        add(Box.createRigidArea(new Dimension(0, 2)));
        add(passwordField);
    }

    public JButton styleButtons(){
        JButton submit = new JButton();
        Color colorForeground = new Color(0x8D8D8D);
        Color colorBackground = new Color(0xF1F1F1);
        submit.setForeground(colorForeground);
        submit.setBackground(colorBackground);
        Border line = new LineBorder(colorForeground);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        submit.setBorder(compound);
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        return submit;
    }

    public boolean validaUserName(String user){
        return UserData.getData().getUsers().stream().anyMatch((userName) -> (userName.getUsername().equals(user)));
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return !m.matches();
    }

    public boolean validaEmail(String email){
        if (UserData.getData().getUsers().stream().anyMatch((userName) -> (userName.getEmail().equals(email)))) {
            return true;
        }
        return isValidEmailAddress(email);
    }

    public boolean validaSenha(String senha){
        String senhaEnc = encrpPass(senha);
        return UserData.getData().getUsers().stream().anyMatch((userName) -> (userName.getPassword().equals(senhaEnc)));
    }

    public long acess(){
        for(User userName : UserData.getData().getUsers()){
            if(userField.getText().equals(userName.getUsername()) && encrpPass(passwordField.getText()).equals(userName.getPassword())){
                return userName.getId();
            }
        }
        return -1;
    }

    public String encrpPass(String password){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (new HexBinaryAdapter()).marshal(md5.digest(password.getBytes()));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (validaUserName(userField.getText()) && validaSenha(passwordField.getText())){
            showMessageDialog(null, "Acesso concedido para " + userField.getText());
        } else {
            showMessageDialog(null, "Usuário e/ou senha inválidos");
        }
    }

}
