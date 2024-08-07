/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uasreservationtaliscocab;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class FormMyEvent extends javax.swing.JFrame {

    /**
     * Creates new form FormMyEvent
     */
    public FormMyEvent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonViewParking = new javax.swing.JButton();
        jButtonReservationParking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMyEvent = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idMyEventTxt = new javax.swing.JTextField();
        jButtonClaim = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Parkir Area", "Status", "Tanggal", "Lokasi", "Harga", "Update", "Created"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButtonViewParking.setBackground(new java.awt.Color(0, 153, 153));
        jButtonViewParking.setForeground(new java.awt.Color(255, 255, 255));
        jButtonViewParking.setText("View");

        jButtonReservationParking.setBackground(new java.awt.Color(0, 153, 153));
        jButtonReservationParking.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReservationParking.setText("Reserve");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonViewParking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonReservationParking)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonViewParking)
                    .addComponent(jButtonReservationParking))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 450));
        getContentPane().setLayout(null);

        jTableMyEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_event_reservation", "account_id ", "event_id ", "quantity", "amount", "status", "claim_date", "claimed_date", "updated_at", "created_at"
            }
        ));
        jScrollPane1.setViewportView(jTableMyEvent);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 40, 840, 270);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("ID to claim : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 350, 109, 24);
        getContentPane().add(idMyEventTxt);
        idMyEventTxt.setBounds(490, 360, 71, 29);

        jButtonClaim.setBackground(new java.awt.Color(0, 102, 102));
        jButtonClaim.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonClaim.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClaim.setText("Claim");
        jButtonClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClaimActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClaim);
        jButtonClaim.setBounds(790, 450, 90, 30);

        viewBtn.setBackground(new java.awt.Color(0, 102, 102));
        viewBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        viewBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBtn.setText("VIEW");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewBtn);
        viewBtn.setBounds(670, 450, 90, 30);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(560, 450, 90, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/event.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        try {
            String hasil;
            
            Socket clientSocket = new Socket("localhost",6666);
            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            sendToServer.writeBytes("MYEVENTVIEW~" + "\n");
            
            BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            hasil = chatFromServer.readLine();
            System.out.println(hasil);
            
            DefaultTableModel tableModel = (DefaultTableModel) jTableMyEvent.getModel();
            tableModel.setRowCount(0);  
            String[] hasils = hasil.split("~");
            
            for (int i = 0; i < hasils.length; i += 10) {
                String[] row = new String[10];
                System.arraycopy(hasils, i, row, 0, 10);
                tableModel.addRow(row);
            }
            
        } catch(IOException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_viewBtnActionPerformed

    private void jButtonClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClaimActionPerformed
        try {
            String hasil;
            int id_myevent = Integer.parseInt(idMyEventTxt.getText());

            DefaultTableModel tableModel = (DefaultTableModel) jTableMyEvent.getModel();
            int rowCount = tableModel.getRowCount();
            boolean found = false;

            int account_id = 0;
            int event_id = 0;
            int quantity = 0;
            double amount = 0.0; 
            String status = "";
            String claim_date = "";
            String claimed_date = "";
            String updated_at = "";
            String created_at = "";

            for (int row = 0; row < rowCount; row++) {
                if (Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 0))) == id_myevent) {
                    found = true;
                    account_id = Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 1)));
                    event_id = Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 2)));
                    quantity = Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 3)));
                    amount = Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 4)));  
                    status = String.valueOf(tableModel.getValueAt(row, 5));
                    claim_date = String.valueOf(tableModel.getValueAt(row, 6));
                    claimed_date = String.valueOf(tableModel.getValueAt(row, 7));
                    updated_at = String.valueOf(tableModel.getValueAt(row, 8));
                    created_at = String.valueOf(tableModel.getValueAt(row, 9));
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Event ID not found in table.");
                return;
            }

            Socket clientSocket = new Socket("localhost", 6666);
            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());

            FormMenu menu = new FormMenu();
            String dataToSend = "MYEVENTCLAIM~" 
                + id_myevent + "~" 
                + account_id + "~" 
                + event_id + "~" 
                + quantity + "~" 
                + amount + "~"  
                + status + "~" 
                + claim_date + "~" 
                + claimed_date + "~" 
                + updated_at + "~" 
                + created_at + "\n";

            sendToServer.writeBytes(dataToSend);

            BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            hasil = chatFromServer.readLine();
            System.out.println(hasil);

            String[] hasils = hasil.split("~");

            if (hasils[0].equals("TRUE")) {
                JOptionPane.showMessageDialog(this, "Claim successful!");
                FormMenu form = new FormMenu();
                form.balance = Double.parseDouble(hasils[1]);
                System.out.println(form.balance);
            } else {
                JOptionPane.showMessageDialog(this, "Claim failed, masih belum bisa claim, perhatikan tanggal claimnya!");
                FormMenu form = new FormMenu();
                form.balance = Double.parseDouble(hasils[1]);
                System.out.println(form.balance);
            }
        } catch (IOException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format: " + ex.getMessage());
        }

    }//GEN-LAST:event_jButtonClaimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormMenu home = new FormMenu();
        home.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMyEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMyEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMyEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMyEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMyEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idMyEventTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClaim;
    private javax.swing.JButton jButtonReservationParking;
    private javax.swing.JButton jButtonViewParking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableMyEvent;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
