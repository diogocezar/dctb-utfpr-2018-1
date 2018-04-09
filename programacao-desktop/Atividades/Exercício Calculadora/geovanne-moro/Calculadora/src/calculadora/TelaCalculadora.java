package calculadora;

/**
 *
 * @author geovannemoro
 */
public class TelaCalculadora extends javax.swing.JFrame {

    /**
     * Creates new form TelaCalculadora
     */
    public TelaCalculadora() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        ButtonCE = new javax.swing.JButton();
        ButtonPercent = new javax.swing.JButton();
        Button7 = new javax.swing.JButton();
        Button8 = new javax.swing.JButton();
        Button9 = new javax.swing.JButton();
        ButtonDivison = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Button6 = new javax.swing.JButton();
        Button5 = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        ButtonSubtraction = new javax.swing.JButton();
        Button1 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        ButtonAddition = new javax.swing.JButton();
        Button0 = new javax.swing.JButton();
        ButtonEqual = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        VisorCalculator = new javax.swing.JTextPane();
        ButtonDot = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        ButtonCE.setText("CE");
        ButtonCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonCEMouseClicked(evt);
            }
        });

        ButtonPercent.setText("*");
        ButtonPercent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonPercentMouseClicked(evt);
            }
        });

        Button7.setText("7");
        Button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button7MouseClicked(evt);
            }
        });

        Button8.setText("8");
        Button8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button8MouseClicked(evt);
            }
        });

        Button9.setText("9");
        Button9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button9MouseClicked(evt);
            }
        });

        ButtonDivison.setText("/");
        ButtonDivison.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonDivisonMouseClicked(evt);
            }
        });

        jLabel1.setText("Calculadora");

        Button6.setText("6");
        Button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button6MouseClicked(evt);
            }
        });

        Button5.setText("5");
        Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button5MouseClicked(evt);
            }
        });

        Button4.setText("4");
        Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button4MouseClicked(evt);
            }
        });

        ButtonSubtraction.setText("-");
        ButtonSubtraction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSubtractionMouseClicked(evt);
            }
        });

        Button1.setText("1");
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
        });

        Button2.setText("2");
        Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button2MouseClicked(evt);
            }
        });

        Button3.setText("3");
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button3MouseClicked(evt);
            }
        });

        ButtonAddition.setText("+");
        ButtonAddition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAdditionMouseClicked(evt);
            }
        });

        Button0.setText("0");
        Button0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button0MouseClicked(evt);
            }
        });

        ButtonEqual.setText("=");
        ButtonEqual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonEqualMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(VisorCalculator);

        ButtonDot.setText(".");
        ButtonDot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonDotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ButtonCE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(ButtonPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Button7)
                                            .addGap(18, 18, 18)
                                            .addComponent(Button8)
                                            .addGap(18, 18, 18)
                                            .addComponent(Button9)
                                            .addGap(18, 18, 18)
                                            .addComponent(ButtonDivison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(Button4)
                                            .addGap(18, 18, 18)
                                            .addComponent(Button5)
                                            .addGap(18, 18, 18)
                                            .addComponent(Button6)
                                            .addGap(18, 18, 18)
                                            .addComponent(ButtonSubtraction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(Button1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Button2)
                                            .addGap(18, 18, 18)
                                            .addComponent(Button3)
                                            .addGap(18, 18, 18)
                                            .addComponent(ButtonAddition)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(Button0)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonEqual)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonDot)))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCE)
                    .addComponent(ButtonPercent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button7)
                    .addComponent(Button8)
                    .addComponent(Button9)
                    .addComponent(ButtonDivison))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button6)
                        .addComponent(Button5)
                        .addComponent(ButtonSubtraction)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button1)
                    .addComponent(Button2)
                    .addComponent(Button3)
                    .addComponent(ButtonAddition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button0)
                    .addComponent(ButtonEqual)
                    .addComponent(ButtonDot))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCEMouseClicked
        VisorCalculator.setText("");
    }//GEN-LAST:event_ButtonCEMouseClicked

    private void ButtonPercentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPercentMouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "*");
    }//GEN-LAST:event_ButtonPercentMouseClicked

    private void Button7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button7MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "7");
    }//GEN-LAST:event_Button7MouseClicked

    private void Button8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button8MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "8");
    }//GEN-LAST:event_Button8MouseClicked

    private void Button6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button6MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "6");
    }//GEN-LAST:event_Button6MouseClicked

    private void Button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button5MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "5");
    }//GEN-LAST:event_Button5MouseClicked

    private void Button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "4");
    }//GEN-LAST:event_Button4MouseClicked

    private void Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "2");
    }//GEN-LAST:event_Button2MouseClicked

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "1");    }//GEN-LAST:event_Button1MouseClicked

    private void Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "3");
    }//GEN-LAST:event_Button3MouseClicked

    private void ButtonAdditionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdditionMouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "+");
    }//GEN-LAST:event_ButtonAdditionMouseClicked

    private void Button0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button0MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "0");
    }//GEN-LAST:event_Button0MouseClicked

    private void ButtonEqualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEqualMouseClicked
        String value = VisorCalculator.getText();
        System.out.println(">>>"+value);
        Calculo calculo = new Calculo();
        String result = calculo.calculadora(value); 
        VisorCalculator.setText(result);
    }//GEN-LAST:event_ButtonEqualMouseClicked

    private void ButtonSubtractionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSubtractionMouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "-");
    }//GEN-LAST:event_ButtonSubtractionMouseClicked

    private void Button9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button9MouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "9");
    }//GEN-LAST:event_Button9MouseClicked

    private void ButtonDivisonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDivisonMouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + "/");
    }//GEN-LAST:event_ButtonDivisonMouseClicked

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentMoved

    private void ButtonDotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDotMouseClicked
        String value = VisorCalculator.getText();
        VisorCalculator.setText(value + ".");
    }//GEN-LAST:event_ButtonDotMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCalculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button0;
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JButton Button5;
    private javax.swing.JButton Button6;
    private javax.swing.JButton Button7;
    private javax.swing.JButton Button8;
    private javax.swing.JButton Button9;
    private javax.swing.JButton ButtonAddition;
    private javax.swing.JButton ButtonCE;
    private javax.swing.JButton ButtonDivison;
    private javax.swing.JButton ButtonDot;
    private javax.swing.JButton ButtonEqual;
    private javax.swing.JButton ButtonPercent;
    private javax.swing.JButton ButtonSubtraction;
    private javax.swing.JTextPane VisorCalculator;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
