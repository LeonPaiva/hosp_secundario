package views;

import javax.swing.JOptionPane;
import models.Ambulatorio;
import models.AmbulatorioDAO;
import models.ModelTabela;

/**
 *
 * @author Wesley
 */
public class TelaCadAmbu extends javax.swing.JInternalFrame {

    AmbulatorioDAO mDAO = new AmbulatorioDAO();
    ModelTabela mt = new ModelTabela(null, null);

    public TelaCadAmbu() {
        initComponents();
        exibirTabela();
        String[] colunas = {"Número", "Andar", "Capacidade"};
    }

    public void exibirTabela(){
        String[] colunas = new String[]{"Número da sala", "Andar", "Capacidade"};
        String num = txt_num.getText();
        String andar = txt_andar.getText();
        String cap = txt_cap.getText();
        mt = new ModelTabela(mDAO.selectAmbulatorio(num, andar, cap), colunas);
        tabela_ambu.setModel(mt);
    }

    public void restaurarTxtPesq() {
        txt_andar.setText("");
        txt_cap.setText("");
        txt_num.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jb_insert = new javax.swing.JButton();
        jb_delete = new javax.swing.JButton();
        txt_num = new javax.swing.JTextField();
        txt_andar = new javax.swing.JTextField();
        txt_cap = new javax.swing.JTextField();
        jb_update = new javax.swing.JButton();
        btn_novoAmbu = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_ambu = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_hospital_24px_1.png"))); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 544));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Capacidade:");

        jLabel2.setText("Andar:");

        jLabel1.setText("Número:");

        jb_insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jb_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_checkmark_24px.png"))); // NOI18N
        jb_insert.setText("SALVAR");
        jb_insert.setEnabled(false);
        jb_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_insertActionPerformed(evt);
            }
        });

        jb_delete.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jb_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_trash_24px_1.png"))); // NOI18N
        jb_delete.setText("APAGAR");
        jb_delete.setEnabled(false);
        jb_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_deleteActionPerformed(evt);
            }
        });

        txt_num.setEnabled(false);
        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        txt_andar.setEnabled(false);

        txt_cap.setEnabled(false);

        jb_update.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jb_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_checkmark_24px.png"))); // NOI18N
        jb_update.setText("EDITAR");
        jb_update.setEnabled(false);
        jb_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_insert))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_andar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cap, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_andar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_update)
                        .addComponent(jb_delete)))
                .addGap(34, 34, 34))
        );

        btn_novoAmbu.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_novoAmbu.setForeground(new java.awt.Color(0, 204, 51));
        btn_novoAmbu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_plus_math_24px.png"))); // NOI18N
        btn_novoAmbu.setText("MANIPULAR AMBULATÓRIO");
        btn_novoAmbu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_novoAmbuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_novoAmbuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_novoAmbuMouseExited(evt);
            }
        });

        tabela_ambu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tabela_ambu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_novoAmbu)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_novoAmbu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_insertActionPerformed
        Ambulatorio ambu = new Ambulatorio(Integer.parseInt(txt_num.getText()), Integer.parseInt(txt_andar.getText()), Integer.parseInt(txt_cap.getText()));
        AmbulatorioDAO ambuDAO = new AmbulatorioDAO();
        if (ambuDAO.insertAmbulatorio(ambu)) {
            restaurarTxtPesq();
            exibirTabela();
            JOptionPane.showMessageDialog(rootPane, "Ambulatório inserido com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar");
        }
    }//GEN-LAST:event_jb_insertActionPerformed

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void jb_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_updateActionPerformed
        Ambulatorio ambu = new Ambulatorio(Integer.parseInt(txt_num.getText()), Integer.parseInt(txt_andar.getText()), Integer.parseInt(txt_cap.getText()));
        AmbulatorioDAO ambuDAO = new AmbulatorioDAO();
        if (ambuDAO.updateAmbulatorio(ambu)) {
            restaurarTxtPesq();
            exibirTabela();
            JOptionPane.showMessageDialog(rootPane, "Ambulatório atualizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar");
        }
    }//GEN-LAST:event_jb_updateActionPerformed

    private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_deleteActionPerformed
        Ambulatorio ambu = new Ambulatorio(mDAO.selectAmbulatorio_Id(Integer.parseInt(txt_num.getText()), Integer.parseInt(txt_andar.getText())), 0, 0, 0);
        AmbulatorioDAO ambuDAO = new AmbulatorioDAO();
        if (ambuDAO.deleteAmbulatorio(ambu)) {
            restaurarTxtPesq();
            exibirTabela();
            JOptionPane.showMessageDialog(rootPane, "Ambulatório deletado com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar");
        }
    }//GEN-LAST:event_jb_deleteActionPerformed

    private void btn_novoAmbuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_novoAmbuMouseExited
        btn_novoAmbu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_btn_novoAmbuMouseExited

    private void btn_novoAmbuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_novoAmbuMouseEntered
        btn_novoAmbu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0)));
    }//GEN-LAST:event_btn_novoAmbuMouseEntered

    private void btn_novoAmbuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_novoAmbuMouseClicked
        txt_andar.setEnabled(true);
        txt_cap.setEnabled(true);
        txt_num.setEnabled(true);
        jb_delete.setEnabled(true);
        jb_insert.setEnabled(true);
        jb_update.setEnabled(true);
    }//GEN-LAST:event_btn_novoAmbuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_novoAmbu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_delete;
    private javax.swing.JButton jb_insert;
    private javax.swing.JButton jb_update;
    private javax.swing.JTable tabela_ambu;
    private javax.swing.JTextField txt_andar;
    private javax.swing.JTextField txt_cap;
    private javax.swing.JTextField txt_num;
    // End of variables declaration//GEN-END:variables
}
