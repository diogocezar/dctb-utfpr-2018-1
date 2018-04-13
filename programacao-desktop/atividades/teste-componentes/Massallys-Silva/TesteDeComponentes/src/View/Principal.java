package View;

import Controller.Tabela;

public class Principal extends javax.swing.JFrame {
    Tabela tab = new Tabela();
    
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jpPrinc = new javax.swing.JPanel();
        jlForm1 = new javax.swing.JLabel();
        jtCx1 = new javax.swing.JTextField();
        jbSub = new javax.swing.JButton();
        jtbTur1 = new javax.swing.JToggleButton();
        jcbEsc = new javax.swing.JComboBox<>();
        jrbEsc1 = new javax.swing.JRadioButton();
        jrbEsc2 = new javax.swing.JRadioButton();
        jtbTur2 = new javax.swing.JToggleButton();
        jtbTur3 = new javax.swing.JToggleButton();
        jsp1 = new javax.swing.JScrollPane();
        jt1Res = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlForm1.setText("DIGITE SEU NOME");

        jtCx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCx1ActionPerformed(evt);
            }
        });

        jbSub.setText("SUBMETER");
        jbSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubActionPerformed(evt);
            }
        });

        jtbTur1.setText("TURNO MATUTINO ");
        jtbTur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbTur1ActionPerformed(evt);
            }
        });

        jcbEsc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENG SOFTWARE", "ENG COMPUTACAO", "ADS" }));
        jcbEsc.setToolTipText("");
        jcbEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEscActionPerformed(evt);
            }
        });

        jrbEsc1.setText("ESTUDANTE");
        jrbEsc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEsc1ActionPerformed(evt);
            }
        });

        jrbEsc2.setText("PROFESSOR");
        jrbEsc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEsc2ActionPerformed(evt);
            }
        });

        jtbTur2.setText("TURNO VESPERTINO");
        jtbTur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbTur2ActionPerformed(evt);
            }
        });

        jtbTur3.setText("TURNO NOTURNO");
        jtbTur3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbTur3ActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jbSub, org.jdesktop.beansbinding.ObjectProperty.create(), jt1Res, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);
        binding.bind();
        jsp1.setViewportView(jt1Res);

        javax.swing.GroupLayout jpPrincLayout = new javax.swing.GroupLayout(jpPrinc);
        jpPrinc.setLayout(jpPrincLayout);
        jpPrincLayout.setHorizontalGroup(
            jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSub))
            .addGroup(jpPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincLayout.createSequentialGroup()
                        .addComponent(jlForm1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtCx1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEsc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpPrincLayout.createSequentialGroup()
                        .addComponent(jrbEsc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbEsc2))
                    .addGroup(jpPrincLayout.createSequentialGroup()
                        .addComponent(jtbTur1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbTur2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbTur3))
                    .addComponent(jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpPrincLayout.setVerticalGroup(
            jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbSub)
                .addGap(24, 24, 24)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlForm1)
                    .addComponent(jtCx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEsc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbEsc2)
                    .addComponent(jrbEsc1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtbTur1)
                    .addComponent(jtbTur2)
                    .addComponent(jtbTur3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEscActionPerformed
        jcbEsc.addItem("ENG SOFTWARE");
        jcbEsc.addItem("ENG COMP");
        jcbEsc.addItem("ADS");
        add(jcbEsc);
        
        if(!jcbEsc.isFocusable()){
           jtbTur1.getAction().equals(("ENG SOFTWARE"));
        }
        else if(!jcbEsc.isFocusable()){
            jtbTur1.getAction().equals(("ENG COMP"));
        }
        else if(!jcbEsc.isFocusable()){
            jtbTur1.getAction().equals(("ADS"));
        }
    }//GEN-LAST:event_jcbEscActionPerformed

    private void jbSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubActionPerformed
        if(jbSub.isSelected())
            jt1Res.add("NOME", jsp1).equals(jt1Res.getColumn(jtCx1.getText()));
            jt1Res.add("CURSO", jsp1).equals(jt1Res.getColumn(jcbEsc.getAccessibleContext()));
        
        if(jrbEsc1.isSelected() || jrbEsc2.isSelected())    
            jt1Res.add("EST/PROF", jsp1).equals(jt1Res.getColumn(jrbEsc1.getAction()));
            jt1Res.add("EST/PROF", jsp1).equals(jt1Res.getColumn(jrbEsc2.getAction()));
            
        if(jtbTur1.isSelected() || jtbTur2.isSelected() || jtbTur3.isSelected())
            jt1Res.add("TURNO", jsp1).equals(jt1Res.getColumn(jtbTur1.getAction()));
            jt1Res.add("TURNO", jsp1).equals(jt1Res.getColumn(jtbTur2.getAction()));
            jt1Res.add("TURNO", jsp1).equals(jt1Res.getColumn(jtbTur3.getAction()));
    }//GEN-LAST:event_jbSubActionPerformed

    private void jrbEsc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEsc2ActionPerformed
        if(!jrbEsc2.isEnabled())
            jrbEsc2.getAction(); 
    }//GEN-LAST:event_jrbEsc2ActionPerformed

    private void jtCx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCx1ActionPerformed
        String nome = jtCx1.getText();
    }//GEN-LAST:event_jtCx1ActionPerformed

    private void jrbEsc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEsc1ActionPerformed
        if(!jrbEsc1.isEnabled())
            jrbEsc1.getAction();
    }//GEN-LAST:event_jrbEsc1ActionPerformed

    private void jtbTur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbTur1ActionPerformed
       if(!jtbTur1.isFocusable())
           jtbTur1.getAction();
    }//GEN-LAST:event_jtbTur1ActionPerformed

    private void jtbTur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbTur2ActionPerformed
        if(!jtbTur2.isFocusable())
           jtbTur2.getAction();
    }//GEN-LAST:event_jtbTur2ActionPerformed

    private void jtbTur3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbTur3ActionPerformed
        if(!jtbTur3.isFocusable())
           jtbTur3.getAction();
    }//GEN-LAST:event_jtbTur3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbSub;
    private javax.swing.JComboBox<String> jcbEsc;
    private javax.swing.JLabel jlForm1;
    private javax.swing.JPanel jpPrinc;
    private javax.swing.JRadioButton jrbEsc1;
    private javax.swing.JRadioButton jrbEsc2;
    private javax.swing.JScrollPane jsp1;
    private javax.swing.JTable jt1Res;
    private javax.swing.JTextField jtCx1;
    private javax.swing.JToggleButton jtbTur1;
    private javax.swing.JToggleButton jtbTur2;
    private javax.swing.JToggleButton jtbTur3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
