package gui;

import control.UserFileData;
import control.UserControl;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import model.User;

/**
 *
 * @author christian
 */
public class SignUp extends javax.swing.JFrame {

    private User user;

    public SignUp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbasePanel = new javax.swing.JPanel();
        jlblUserName = new javax.swing.JLabel();
        jtxtUsername = new javax.swing.JTextField();
        jlblPwd = new javax.swing.JLabel();
        jlblConfirmPwd = new javax.swing.JLabel();
        jlblEmail = new javax.swing.JLabel();
        jbtnSignUp = new javax.swing.JButton();
        jtxtEmail = new javax.swing.JTextField();
        jPwd = new javax.swing.JPasswordField();
        jConfirmPwd = new javax.swing.JPasswordField();
        jpanelSaveOpt = new javax.swing.JPanel();
        jbtnSaveJson = new javax.swing.JButton();
        jbtnLoadJson = new javax.swing.JButton();
        jbtnSaveTxt = new javax.swing.JButton();
        jbtnLoadTxt = new javax.swing.JButton();
        jbtnSaveBin = new javax.swing.JButton();
        jbtnLoadBin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 51));
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setResizable(false);

        jlblUserName.setText("Username");

        jlblPwd.setText("Password");

        jlblConfirmPwd.setText("Confirm password");

        jlblEmail.setText("Email");

        jbtnSignUp.setText("Sign Up");
        jbtnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSignUpActionPerformed(evt);
            }
        });

        jpanelSaveOpt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Save options", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jbtnSaveJson.setText("Save .json");
        jbtnSaveJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveJsonActionPerformed(evt);
            }
        });

        jbtnLoadJson.setText("Load .json");
        jbtnLoadJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoadJsonActionPerformed(evt);
            }
        });

        jbtnSaveTxt.setText("Save .txt");
        jbtnSaveTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveTxtActionPerformed(evt);
            }
        });

        jbtnLoadTxt.setText("Load .txt");
        jbtnLoadTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoadTxtActionPerformed(evt);
            }
        });

        jbtnSaveBin.setText("Save .bin");
        jbtnSaveBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveBinActionPerformed(evt);
            }
        });

        jbtnLoadBin.setText("Load .bin");
        jbtnLoadBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoadBinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelSaveOptLayout = new javax.swing.GroupLayout(jpanelSaveOpt);
        jpanelSaveOpt.setLayout(jpanelSaveOptLayout);
        jpanelSaveOptLayout.setHorizontalGroup(
            jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelSaveOptLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnSaveJson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnLoadJson, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnSaveTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnLoadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnSaveBin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnLoadBin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jpanelSaveOptLayout.setVerticalGroup(
            jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelSaveOptLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSaveJson)
                    .addComponent(jbtnSaveTxt)
                    .addComponent(jbtnSaveBin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelSaveOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLoadJson)
                    .addComponent(jbtnLoadTxt)
                    .addComponent(jbtnLoadBin))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jbasePanelLayout = new javax.swing.GroupLayout(jbasePanel);
        jbasePanel.setLayout(jbasePanelLayout);
        jbasePanelLayout.setHorizontalGroup(
            jbasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbasePanelLayout.createSequentialGroup()
                .addGroup(jbasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jbasePanelLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jlblPwd))
                    .addGroup(jbasePanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jbasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jConfirmPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jbasePanelLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jlblEmail))
                    .addGroup(jbasePanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jbtnSignUp))
                    .addGroup(jbasePanelLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jlblUserName))
                    .addGroup(jbasePanelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jlblConfirmPwd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpanelSaveOpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jbasePanelLayout.setVerticalGroup(
            jbasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jbasePanelLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jlblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblPwd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblConfirmPwd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConfirmPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnSignUp)
                .addGap(75, 75, 75)
                .addComponent(jpanelSaveOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearAllFields() {
        if (!this.jtxtUsername.getText().isEmpty()) {
            this.jtxtUsername.setText("");
        }
        if (!new String(this.jPwd.getPassword()).isEmpty()) {
            this.jPwd.setText("");
        }
        if (!new String(this.jConfirmPwd.getPassword()).isEmpty()) {
            this.jConfirmPwd.setText("");
        }
        if (!this.jtxtEmail.getText().isEmpty()) {
            this.jtxtEmail.setText("");
        }
        this.jtxtUsername.requestFocus();
    }

    private void jbtnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSignUpActionPerformed
        // TODO add your handling code here:
        String username = this.jtxtUsername.getText();
        String pwd = new String(this.jPwd.getPassword());
        String pwdConfirm = new String(this.jConfirmPwd.getPassword());
        String email = this.jtxtEmail.getText();

        try {
            if (UserControl.validate(username, pwd, pwdConfirm, email)) {
                this.user = new User(username, pwd, email);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.clearAllFields();
        }
    }//GEN-LAST:event_jbtnSignUpActionPerformed

    private void saveFile(String extension) throws IOException {
        if (this.user == null) {
            JOptionPane.showMessageDialog(this, "The object \"User\" was not created.");
            this.clearAllFields();
            return;
        }
        JFileChooser jfChooser = new JFileChooser();

        if (jfChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jfChooser.getSelectedFile();
            switch (extension) {
                case ".json":
                    new UserFileData().saveJson(file.getAbsolutePath() + extension, user);
                    break;
                case ".txt":
                    new UserFileData().saveText(file.getAbsolutePath() + extension, user);
                    break;
                case ".bin":
                    new UserFileData().saveBinary(file.getAbsolutePath() + extension, user);
                    break;
                default:
                    break;
            }
            JOptionPane.showMessageDialog(this, "File saved.", "File saved", JOptionPane.OK_OPTION);
        }
    }
    
    private void loadFile(String extension) throws IOException, ClassNotFoundException {
        JFileChooser jfChooser = new JFileChooser();
        if (jfChooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
            File file = jfChooser.getSelectedFile();
                if (file.getName().contains(".json"))
                    this.user = new UserFileData().loadJson(file.getAbsolutePath());
                if (file.getName().contains(".txt"))
                    this.user = new UserFileData().loadText(file.getAbsolutePath());
                if (file.getName().contains(".bin"))
                    this.user = new UserFileData().loadBinary(file.getAbsolutePath());
            
            this.fillFields();
        }
    }
    
    private void fillFields() {
        this.jtxtUsername.setText(user.getName());
        this.jPwd.setText(user.getPassword());
        this.jConfirmPwd.setText(new String(this.jPwd.getPassword()));
        this.jtxtEmail.setText(user.getEmail());
    }

    private void jbtnSaveJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveJsonActionPerformed
        try {
            this.saveFile(".json");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSaveJsonActionPerformed

    private void jbtnSaveTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveTxtActionPerformed
        try {
            this.saveFile(".txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSaveTxtActionPerformed

    private void jbtnSaveBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveBinActionPerformed
        try {
            this.saveFile(".bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSaveBinActionPerformed

    private void jbtnLoadJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoadJsonActionPerformed
        try {
            this.loadFile(".json");
        }
        catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnLoadJsonActionPerformed

    private void jbtnLoadTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoadTxtActionPerformed
        try {
            this.loadFile(".txt");
        }
        catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnLoadTxtActionPerformed

    private void jbtnLoadBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoadBinActionPerformed
        try {
            this.loadFile(".bin");
        }
        catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnLoadBinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField jConfirmPwd;
    private javax.swing.JPasswordField jPwd;
    private javax.swing.JPanel jbasePanel;
    private javax.swing.JButton jbtnLoadBin;
    private javax.swing.JButton jbtnLoadJson;
    private javax.swing.JButton jbtnLoadTxt;
    private javax.swing.JButton jbtnSaveBin;
    private javax.swing.JButton jbtnSaveJson;
    private javax.swing.JButton jbtnSaveTxt;
    private javax.swing.JButton jbtnSignUp;
    private javax.swing.JLabel jlblConfirmPwd;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblPwd;
    private javax.swing.JLabel jlblUserName;
    private javax.swing.JPanel jpanelSaveOpt;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
