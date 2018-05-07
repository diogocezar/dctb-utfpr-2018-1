package View;

import Model.SalvarTxt;

public class CadastrarEvento extends javax.swing.JFrame{

    public CadastrarEvento() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cevPrinc = new javax.swing.JPanel();
        cevEv = new javax.swing.JLabel();
        cevEqui = new javax.swing.JLabel();
        cevSala = new javax.swing.JLabel();
        cevLoc = new javax.swing.JLabel();
        cevCad = new javax.swing.JButton();
        cevVolt = new javax.swing.JButton();
        cevTEv = new javax.swing.JTextField();
        cevTEqui = new javax.swing.JTextField();
        cevTSala = new javax.swing.JTextField();
        cevTLoc = new javax.swing.JTextField();
        cevStxt = new javax.swing.JButton();
        cevSbin = new javax.swing.JButton();
        cevSjson = new javax.swing.JButton();
        cevRtxt = new javax.swing.JButton();
        cevRbin = new javax.swing.JButton();
        cevRjson = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cevEv.setText("EVENTO");

        cevEqui.setText("EQUIPAMENTO");

        cevSala.setText("SALA");

        cevLoc.setText("LOCAL");

        cevCad.setText("CADASTRAR");
        cevCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevCadActionPerformed(evt);
            }
        });

        cevVolt.setText("VOLTAR");

        cevTEv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevTEvActionPerformed(evt);
            }
        });

        cevTEqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevTEquiActionPerformed(evt);
            }
        });

        cevTSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevTSalaActionPerformed(evt);
            }
        });

        cevTLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevTLocActionPerformed(evt);
            }
        });

        cevStxt.setText(".txt");
        cevStxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevStxtActionPerformed(evt);
            }
        });

        cevSbin.setText(".bin");
        cevSbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevSbinActionPerformed(evt);
            }
        });

        cevSjson.setText(".json");

        cevRtxt.setText(".txt");

        cevRbin.setText(".bin");

        cevRjson.setText(".json");

        jLabel1.setText("SALVAR ARQUIVO:");

        jLabel2.setText("RECUPERAR ARQUIVO:");

        javax.swing.GroupLayout cevPrincLayout = new javax.swing.GroupLayout(cevPrinc);
        cevPrinc.setLayout(cevPrincLayout);
        cevPrincLayout.setHorizontalGroup(
            cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cevPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cevPrincLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cevVolt))
                    .addGroup(cevPrincLayout.createSequentialGroup()
                        .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cevLoc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cevPrincLayout.createSequentialGroup()
                                    .addComponent(cevEqui)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                    .addComponent(cevTEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cevPrincLayout.createSequentialGroup()
                                    .addComponent(cevEv)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cevTEv, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cevPrincLayout.createSequentialGroup()
                                    .addGap(125, 125, 125)
                                    .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cevTLoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(cevTSala)))
                                .addComponent(cevSala, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(cevPrincLayout.createSequentialGroup()
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cevPrincLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(cevCad))
                    .addGroup(cevPrincLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cevPrincLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cevStxt))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cevPrincLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cevRtxt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cevPrincLayout.createSequentialGroup()
                                .addComponent(cevRbin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cevRjson))
                            .addGroup(cevPrincLayout.createSequentialGroup()
                                .addComponent(cevSbin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cevSjson)))))
                .addGap(0, 133, Short.MAX_VALUE))
        );
        cevPrincLayout.setVerticalGroup(
            cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cevPrincLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cevVolt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevEv)
                    .addComponent(cevTEv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevEqui)
                    .addComponent(cevTEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevSala)
                    .addComponent(cevTSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cevLoc)
                    .addComponent(cevTLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cevCad)
                .addGap(52, 52, 52)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cevStxt)
                    .addComponent(cevSbin)
                    .addComponent(cevSjson))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cevPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cevRtxt)
                    .addComponent(cevRbin)
                    .addComponent(cevRjson))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cevPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cevPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cevTEvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevTEvActionPerformed
        cevTEv.getText();
    }//GEN-LAST:event_cevTEvActionPerformed

    private void cevCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevCadActionPerformed
        cevCad.add(cevEv);
        cevCad.add(cevTEqui);
        cevCad.add(cevSala);
        cevCad.add(cevTLoc);
        
        System.out.println(cevEv.getText() + "\n" + cevTEqui.getText() + "\n" + cevSala.getText() + "\n" 
                + cevTLoc.getText());
        
        
    }//GEN-LAST:event_cevCadActionPerformed

    private void cevTEquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevTEquiActionPerformed
        cevTEqui.getText();
    }//GEN-LAST:event_cevTEquiActionPerformed

    private void cevTSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevTSalaActionPerformed
        cevSala.getText();
    }//GEN-LAST:event_cevTSalaActionPerformed

    private void cevTLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevTLocActionPerformed
        cevTLoc.getText();
    }//GEN-LAST:event_cevTLocActionPerformed

    private void cevSbinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevSbinActionPerformed
        
    }//GEN-LAST:event_cevSbinActionPerformed

    private void cevStxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevStxtActionPerformed
       SalvarTxt txt = new SalvarTxt();
       
       //txt.salvarTxt().;
       
    }//GEN-LAST:event_cevStxtActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cevCad;
    private javax.swing.JLabel cevEqui;
    private javax.swing.JLabel cevEv;
    private javax.swing.JLabel cevLoc;
    private javax.swing.JPanel cevPrinc;
    private javax.swing.JButton cevRbin;
    private javax.swing.JButton cevRjson;
    private javax.swing.JButton cevRtxt;
    private javax.swing.JLabel cevSala;
    private javax.swing.JButton cevSbin;
    private javax.swing.JButton cevSjson;
    private javax.swing.JButton cevStxt;
    private javax.swing.JTextField cevTEqui;
    private javax.swing.JTextField cevTEv;
    private javax.swing.JTextField cevTLoc;
    private javax.swing.JTextField cevTSala;
    private javax.swing.JButton cevVolt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
