package view;

import java.awt.event.KeyEvent;
import utils.Main;
import utils.ControlCalculator;

import javax.swing.JLabel;

public class Calculator extends javax.swing.JFrame {

    ControlCalculator controller = new ControlCalculator();
    private boolean positive = true;
    boolean showResult = false;

    public Calculator() {
        initComponents();
        this.setLocationRelativeTo(null);
        viewNumbers.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        n1 = new javax.swing.JButton();
        n2 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        subtract = new javax.swing.JButton();
        n6 = new javax.swing.JButton();
        comma = new javax.swing.JButton();
        n5 = new javax.swing.JButton();
        n3 = new javax.swing.JButton();
        n4 = new javax.swing.JButton();
        result = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        n7 = new javax.swing.JButton();
        multiply = new javax.swing.JButton();
        n9 = new javax.swing.JButton();
        n8 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        percent = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        viewNumbers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        n1.setText("1");
        n1.setFocusPainted(false);
        n1.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1ActionPerformed(evt);
            }
        });
        n1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                n1KeyReleased(evt);
            }
        });

        n2.setText("2");
        n2.setFocusPainted(false);
        n2.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2ActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(255, 153, 0));
        add.setText("+");
        add.setFocusPainted(false);
        add.setMargin(new java.awt.Insets(14, 14, 14, 14));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jButton4.setText("0");
        jButton4.setFocusPainted(false);
        jButton4.setMargin(new java.awt.Insets(14, 14, 14, 14));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        subtract.setBackground(new java.awt.Color(255, 153, 0));
        subtract.setText("-");
        subtract.setFocusPainted(false);
        subtract.setMargin(new java.awt.Insets(14, 14, 14, 14));
        subtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtractActionPerformed(evt);
            }
        });

        n6.setText("6");
        n6.setFocusPainted(false);
        n6.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n6ActionPerformed(evt);
            }
        });

        comma.setText(",");
        comma.setFocusPainted(false);
        comma.setMargin(new java.awt.Insets(14, 14, 14, 14));
        comma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commaActionPerformed(evt);
            }
        });

        n5.setText("5");
        n5.setFocusPainted(false);
        n5.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n5ActionPerformed(evt);
            }
        });

        n3.setText("3");
        n3.setFocusPainted(false);
        n3.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n3ActionPerformed(evt);
            }
        });

        n4.setText("4");
        n4.setFocusPainted(false);
        n4.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n4ActionPerformed(evt);
            }
        });

        result.setBackground(new java.awt.Color(255, 153, 0));
        result.setForeground(new java.awt.Color(51, 51, 51));
        result.setText("=");
        result.setFocusPainted(false);
        result.setMargin(new java.awt.Insets(14, 14, 14, 14));
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setText("AC");
        jButton12.setFocusPainted(false);
        jButton12.setMargin(new java.awt.Insets(14, 14, 14, 14));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        n7.setText("7");
        n7.setFocusPainted(false);
        n7.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n7ActionPerformed(evt);
            }
        });

        multiply.setBackground(new java.awt.Color(255, 153, 0));
        multiply.setText("x");
        multiply.setFocusPainted(false);
        multiply.setMargin(new java.awt.Insets(14, 14, 14, 14));
        multiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplyActionPerformed(evt);
            }
        });

        n9.setText("9");
        n9.setFocusPainted(false);
        n9.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n9ActionPerformed(evt);
            }
        });

        n8.setText("8");
        n8.setFocusPainted(false);
        n8.setMargin(new java.awt.Insets(14, 14, 14, 14));
        n8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n8ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(204, 204, 204));
        jButton17.setText("+/-");
        jButton17.setFocusPainted(false);
        jButton17.setMargin(new java.awt.Insets(14, 14, 14, 14));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        divide.setBackground(new java.awt.Color(255, 153, 0));
        divide.setText("÷");
        divide.setFocusPainted(false);
        divide.setMargin(new java.awt.Insets(14, 14, 14, 14));
        divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divideActionPerformed(evt);
            }
        });

        percent.setBackground(new java.awt.Color(204, 204, 204));
        percent.setText("%");
        percent.setFocusPainted(false);
        percent.setMargin(new java.awt.Insets(14, 14, 14, 14));
        percent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        viewNumbers.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        viewNumbers.setForeground(new java.awt.Color(255, 255, 255));
        viewNumbers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        viewNumbers.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(comma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "0");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "1");
    }//GEN-LAST:event_n1ActionPerformed

    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "2");
    }//GEN-LAST:event_n2ActionPerformed

    private void n3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n3ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "3");
    }//GEN-LAST:event_n3ActionPerformed

    private void n4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n4ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "4");
    }//GEN-LAST:event_n4ActionPerformed

    private void n5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n5ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "5");
    }//GEN-LAST:event_n5ActionPerformed

    private void n6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n6ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "6");
    }//GEN-LAST:event_n6ActionPerformed

    private void n7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n7ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "7");
    }//GEN-LAST:event_n7ActionPerformed

    private void n8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n8ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "8");
    }//GEN-LAST:event_n8ActionPerformed

    private void n9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n9ActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + "9");
    }//GEN-LAST:event_n9ActionPerformed

    private void commaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commaActionPerformed
        if(showResult){
            viewNumbers.setText("");
            showResult = false;
        }
        viewNumbers.setText(getViewNumbers() + ".");
        comma.setEnabled(false);
    }//GEN-LAST:event_commaActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        setViewNumbers("");
        controller.clean();
        add.setEnabled(true);
        subtract.setEnabled(true);
        multiply.setEnabled(true);
        divide.setEnabled(true);
        percent.setEnabled(true);
        comma.setEnabled(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        multiply.setEnabled(false);
        divide.setEnabled(false);
        subtract.setEnabled(false);
        percent.setEnabled(false);
        comma.setEnabled(true);

        Double aux;
        aux = Double.parseDouble(viewNumbers.getText());
        controller.setToAdd(aux);
        viewNumbers.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        if (controller.getToAdd().size() > 0) {
            Double aux;
            aux = Double.parseDouble(viewNumbers.getText());
            controller.setToAdd(aux);
            viewNumbers.setText("");
        }
        if (controller.getToDivide().size() > 0) {
            Double aux;
            aux = Double.parseDouble(viewNumbers.getText());
            controller.setToDivide(aux);
            viewNumbers.setText("");
        }
        if (controller.getToMultiply().size() > 0) {
            Double aux;
            aux = Double.parseDouble(viewNumbers.getText());
            controller.setToMultiply(aux);
            viewNumbers.setText("");
        }
        if (controller.getToSubtract().size() > 0) {
            Double aux;
            aux = Double.parseDouble(viewNumbers.getText());
            controller.setToSubtract(aux);
            viewNumbers.setText("");
        }
        if(controller.getToPercent().size() > 0){
            Double aux;
            aux = Double.parseDouble(viewNumbers.getText());
            controller.setToPercent(aux);
            viewNumbers.setText("");
        }

        String result = controller.result();
        viewNumbers.setText(result);
        controller.clean();
        showResult = true;
        add.setEnabled(true);
        subtract.setEnabled(true);
        multiply.setEnabled(true);
        divide.setEnabled(true);
        percent.setEnabled(true);
    }//GEN-LAST:event_resultActionPerformed

    private void subtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtractActionPerformed
        multiply.setEnabled(false);
        divide.setEnabled(false);
        add.setEnabled(false);
        percent.setEnabled(false);
        comma.setEnabled(true);

        Double aux;
        aux = Double.parseDouble(viewNumbers.getText());
        controller.setToSubtract(aux);
        viewNumbers.setText("");
    }//GEN-LAST:event_subtractActionPerformed

    private void multiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplyActionPerformed
        add.setEnabled(false);
        divide.setEnabled(false);
        subtract.setEnabled(false);
        percent.setEnabled(false);
        comma.setEnabled(true);

        Double aux;
        aux = Double.parseDouble(viewNumbers.getText());
        controller.setToMultiply(aux);
        viewNumbers.setText("");
    }//GEN-LAST:event_multiplyActionPerformed

    private void divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed
        multiply.setEnabled(false);
        add.setEnabled(false);
        subtract.setEnabled(false);
        percent.setEnabled(false);
        comma.setEnabled(true);

        Double aux;
        aux = Double.parseDouble(viewNumbers.getText());
        controller.setToDivide(aux);
        viewNumbers.setText("");
    }//GEN-LAST:event_divideActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(positive){
            viewNumbers.setText("-" + getViewNumbers());
            positive = false;
        } else {
            String s = viewNumbers.getText();
            s = s.substring(1, s.length());
            viewNumbers.setText(s);
            positive = true;
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void percentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentActionPerformed
        add.setEnabled(false);
        divide.setEnabled(false);
        subtract.setEnabled(false);
        percent.setEnabled(false);
        multiply.setEnabled(false);
        comma.setEnabled(true);
        
        Double aux;
        aux = Double.parseDouble(viewNumbers.getText());
        controller.setToPercent(aux);
        viewNumbers.setText("");
    }//GEN-LAST:event_percentActionPerformed

    private void n1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n1KeyReleased
        
    }//GEN-LAST:event_n1KeyReleased

    public String getViewNumbers() {
        return viewNumbers.getText();
    }

    public void setViewNumbers(String ViewNumbers) {
        this.viewNumbers.setText(ViewNumbers);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton comma;
    private javax.swing.JButton divide;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton multiply;
    private javax.swing.JButton n1;
    private javax.swing.JButton n2;
    private javax.swing.JButton n3;
    private javax.swing.JButton n4;
    private javax.swing.JButton n5;
    private javax.swing.JButton n6;
    private javax.swing.JButton n7;
    private javax.swing.JButton n8;
    private javax.swing.JButton n9;
    private javax.swing.JButton percent;
    private javax.swing.JButton result;
    private javax.swing.JButton subtract;
    private javax.swing.JLabel viewNumbers;
    // End of variables declaration//GEN-END:variables
}
