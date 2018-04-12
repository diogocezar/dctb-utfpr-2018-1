package View;

import Model.Calculo;

public class Calculadora extends javax.swing.JFrame {
    Calculo cal = new Calculo();
        
    public Calculadora() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrinc = new javax.swing.JPanel();
        jbZero = new javax.swing.JButton();
        jbUm = new javax.swing.JButton();
        jbDois = new javax.swing.JButton();
        jbTres = new javax.swing.JButton();
        jbQua = new javax.swing.JButton();
        jbCinco = new javax.swing.JButton();
        jbSeis = new javax.swing.JButton();
        jbSete = new javax.swing.JButton();
        jbOito = new javax.swing.JButton();
        jbNove = new javax.swing.JButton();
        jbVirgu = new javax.swing.JButton();
        javax.swing.JButton jbAC = new javax.swing.JButton();
        jbMM = new javax.swing.JButton();
        jbPorc = new javax.swing.JButton();
        jbDiv = new javax.swing.JButton();
        jbMult = new javax.swing.JButton();
        jbSub = new javax.swing.JButton();
        jbAdic = new javax.swing.JButton();
        jbResult = new javax.swing.JButton();
        jspTela = new javax.swing.JScrollPane();
        jtpTela = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setPreferredSize(new java.awt.Dimension(250, 300));
        setSize(new java.awt.Dimension(250, 300));

        jpPrinc.setPreferredSize(new java.awt.Dimension(250, 300));

        jbZero.setText("0");
        jbZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZeroActionPerformed(evt);
            }
        });

        jbUm.setText("1");
        jbUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUmActionPerformed(evt);
            }
        });

        jbDois.setText("2");
        jbDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDoisActionPerformed(evt);
            }
        });

        jbTres.setText("3");
        jbTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTresActionPerformed(evt);
            }
        });

        jbQua.setText("4");
        jbQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuaActionPerformed(evt);
            }
        });

        jbCinco.setText("5");
        jbCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCincoActionPerformed(evt);
            }
        });

        jbSeis.setText("6");
        jbSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeisActionPerformed(evt);
            }
        });

        jbSete.setText("7");
        jbSete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeteActionPerformed(evt);
            }
        });

        jbOito.setText("8");
        jbOito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOitoActionPerformed(evt);
            }
        });

        jbNove.setText("9");
        jbNove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNoveActionPerformed(evt);
            }
        });

        jbVirgu.setText(",");

        jbAC.setText("AC");
        jbAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbACActionPerformed(evt);
            }
        });

        jbMM.setText("+/-");

        jbPorc.setText("%");
        jbPorc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPorcActionPerformed(evt);
            }
        });

        jbDiv.setText("/");
        jbDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDivActionPerformed(evt);
            }
        });

        jbMult.setText("X");
        jbMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMultActionPerformed(evt);
            }
        });

        jbSub.setText("-");
        jbSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubActionPerformed(evt);
            }
        });

        jbAdic.setText("+");
        jbAdic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicActionPerformed(evt);
            }
        });

        jbResult.setText("=");
        jbResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResultActionPerformed(evt);
            }
        });

        jspTela.setViewportView(jtpTela);

        javax.swing.GroupLayout jpPrincLayout = new javax.swing.GroupLayout(jpPrinc);
        jpPrinc.setLayout(jpPrincLayout);
        jpPrincLayout.setHorizontalGroup(
            jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jspTela)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincLayout.createSequentialGroup()
                        .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbZero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpPrincLayout.createSequentialGroup()
                                .addComponent(jbUm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDois, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbTres, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jbVirgu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbAdic, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincLayout.createSequentialGroup()
                        .addComponent(jbQua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincLayout.createSequentialGroup()
                        .addComponent(jbSete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbOito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbMult, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincLayout.createSequentialGroup()
                        .addComponent(jbAC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbMM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPorc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jpPrincLayout.setVerticalGroup(
            jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jspTela, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPorc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbQua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbTres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbZero)
                    .addGroup(jpPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbVirgu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrinc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubActionPerformed
        String valor = jbSub.getText();
        jbSub.setText(valor + "-");
        cal.Operacoes();
        cal.verificarOp('-');
    }//GEN-LAST:event_jbSubActionPerformed

    private void jbZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZeroActionPerformed
        String valor = jbZero.getText();
        jbZero.setText(valor + "0");
    }//GEN-LAST:event_jbZeroActionPerformed

    private void jbUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUmActionPerformed
        String valor = jbUm.getText();
        jbUm.setText(valor + "1");
    }//GEN-LAST:event_jbUmActionPerformed

    private void jbDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDoisActionPerformed
        String valor = jbDois.getText();
        jbDois.setText(valor + "2");
    }//GEN-LAST:event_jbDoisActionPerformed

    private void jbTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTresActionPerformed
        String valor = jbTres.getText();
        jbTres.setText(valor + "3");
    }//GEN-LAST:event_jbTresActionPerformed

    private void jbQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuaActionPerformed
        String valor = jbQua.getText();
        jbQua.setText(valor + "4");
    }//GEN-LAST:event_jbQuaActionPerformed

    private void jbCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCincoActionPerformed
        String valor = jbCinco.getText();
        jbCinco.setText(valor + "5");
    }//GEN-LAST:event_jbCincoActionPerformed

    private void jbSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeisActionPerformed
        String valor = jbSeis.getText();
        jbSeis.setText(valor + "6");
    }//GEN-LAST:event_jbSeisActionPerformed

    private void jbSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeteActionPerformed
        String valor = jbSete.getText();
        jbSete.setText(valor + "7");
    }//GEN-LAST:event_jbSeteActionPerformed

    private void jbOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOitoActionPerformed
        String valor = jbOito.getText();
        jbOito.setText(valor + "8");
    }//GEN-LAST:event_jbOitoActionPerformed

    private void jbNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNoveActionPerformed
        String valor = jbNove.getText();
        jbNove.setText(valor + "9");
    }//GEN-LAST:event_jbNoveActionPerformed

    private void jbAdicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicActionPerformed
        String valor = jbAdic.getText();
        jbAdic.setText(valor + "+");
        cal.verificarOp('+');
    }//GEN-LAST:event_jbAdicActionPerformed

    private void jbACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbACActionPerformed
        //
    }//GEN-LAST:event_jbACActionPerformed

    private void jbResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResultActionPerformed
        String valor = jbResult.getText();
        jbResult.setText(valor + "=");
        cal.verificarOp('=');
        cal.finalCalculadora();
        cal.calculo();
        cal.execOp();
        cal.Numeros();
        
    }//GEN-LAST:event_jbResultActionPerformed

    private void jbDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDivActionPerformed
        String valor = jbDiv.getText();
        jbDiv.setText(valor + "/");   
        cal.verificarOp('/');
    }//GEN-LAST:event_jbDivActionPerformed

    private void jbMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMultActionPerformed
        String valor = jbMult.getText();
        jbMult.setText(valor + "*");
        cal.verificarOp('*');
    }//GEN-LAST:event_jbMultActionPerformed

    private void jbPorcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPorcActionPerformed
        String valor = jbPorc.getText();
        jbPorc.setText(valor + "/100");
        cal.verificarOp('%');
    }//GEN-LAST:event_jbPorcActionPerformed

   
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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAdic;
    private javax.swing.JButton jbCinco;
    private javax.swing.JButton jbDiv;
    private javax.swing.JButton jbDois;
    private javax.swing.JButton jbMM;
    private javax.swing.JButton jbMult;
    private javax.swing.JButton jbNove;
    private javax.swing.JButton jbOito;
    private javax.swing.JButton jbPorc;
    private javax.swing.JButton jbQua;
    private javax.swing.JButton jbResult;
    private javax.swing.JButton jbSeis;
    private javax.swing.JButton jbSete;
    private javax.swing.JButton jbSub;
    private javax.swing.JButton jbTres;
    private javax.swing.JButton jbUm;
    private javax.swing.JButton jbVirgu;
    private javax.swing.JButton jbZero;
    private javax.swing.JPanel jpPrinc;
    private javax.swing.JScrollPane jspTela;
    private javax.swing.JTextPane jtpTela;
    // End of variables declaration//GEN-END:variables
}
