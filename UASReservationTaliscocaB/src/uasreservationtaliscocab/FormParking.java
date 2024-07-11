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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class FormParking extends javax.swing.JFrame {

    /**
     * Creates new form FormParking
     */
    public FormParking() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        idLocTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idParkTxt = new javax.swing.JTextField();
        btnReserve = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        reserveDate = new com.toedter.calendar.JDateChooser();
        btnCheck = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParking = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 450));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("ID Location : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 370, 120, 22);
        getContentPane().add(idLocTxt);
        idLocTxt.setBounds(160, 370, 71, 29);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setText("ID Parking:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(500, 380, 90, 18);
        getContentPane().add(idParkTxt);
        idParkTxt.setBounds(590, 380, 250, 29);

        btnReserve.setBackground(new java.awt.Color(0, 102, 102));
        btnReserve.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setText("Reserve");
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });
        getContentPane().add(btnReserve);
        btnReserve.setBounds(740, 440, 120, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Date : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 410, 73, 18);
        getContentPane().add(reserveDate);
        reserveDate.setBounds(140, 410, 145, 29);

        btnCheck.setBackground(new java.awt.Color(0, 102, 102));
        btnCheck.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        getContentPane().add(btnCheck);
        btnCheck.setBounds(310, 440, 90, 30);

        jTableParking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "parking_area", "locations_id", "price", "slot"
            }
        ));
        jScrollPane1.setViewportView(jTableParking);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 840, 200);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(720, 610, 48, 21);

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
        jButton1.setBounds(220, 20, 90, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parkings.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        try {
            String hasil;
            int id_location = Integer.parseInt(idLocTxt.getText());
            
            Socket clientSocket = new Socket("localhost",6666);
            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());
            String reserve_date = ((JTextField)reserveDate.getDateEditor().getUiComponent()).getText();
            System.out.println(reserve_date);
            
            SimpleDateFormat originalFormat = new SimpleDateFormat("MMM d, yyyy");
            SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = originalFormat.parse(reserve_date);
            String formattedDate = targetFormat.format(date);
            
            sendToServer.writeBytes("PARKINGVIEW~" + id_location + "~" + formattedDate + "\n");
            
            BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            hasil = chatFromServer.readLine();
            System.out.println(hasil);
            
            DefaultTableModel tableModel = (DefaultTableModel) jTableParking.getModel();
            tableModel.setRowCount(0);  
            String[] hasils = hasil.split("~");
            
            for (int i = 0; i < hasils.length; i += 5) {
                String[] row = new String[5];
                System.arraycopy(hasils, i, row, 0, 5);
                tableModel.addRow(row);
            }
        } catch(IOException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ParseException ex) {
            Logger.getLogger(FormParking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed
        try {
            String hasil;

            DefaultTableModel tableModel = (DefaultTableModel) jTableParking.getModel();
            int rowCount = tableModel.getRowCount();
            boolean found = false;

            int id_parking = Integer.parseInt(idParkTxt.getText());
            String parking_area = "";
            int locations_id = 0;
            double price = 0.0;
            String slot = "";

            for (int row = 0; row < rowCount; row++) {
                int tableId = Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 0)));
                if (tableId == id_parking) {
                    found = true;
                    parking_area = String.valueOf(tableModel.getValueAt(row, 1));
                    locations_id = Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 2)));
                    price = Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 3)));
                    slot = String.valueOf(tableModel.getValueAt(row, 4));
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Parking ID not found in table.");
                return;
            }

            Socket clientSocket = new Socket("localhost", 6666);
            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());

            FormMenu menu = new FormMenu();
            String dataToSend = "PARKINGRESERVATION~" 
                    + menu.id_user + "~" 
                    + id_parking + "~" 
                    + parking_area + "~"
                    + locations_id + "~"
                    + price + "~"
                    + slot;

            sendToServer.writeBytes(dataToSend + "\n"); // Add newline to properly end the message

            BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            hasil = chatFromServer.readLine();
            System.out.println(hasil);

            String[] hasils = hasil.split("~");

            if (hasils[0].equals("TRUE")) {
                JOptionPane.showMessageDialog(this, "Reservation successful!");
                FormMenu form = new FormMenu();
                form.balance = Double.parseDouble(hasils[1]);
                System.out.println(form.balance);
            } else {
                JOptionPane.showMessageDialog(this, "Reservation failed, balance insufficient");
                FormMenu form = new FormMenu();
                form.balance = Double.parseDouble(hasils[1]);
                System.out.println(form.balance);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnReserveActionPerformed

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
            java.util.logging.Logger.getLogger(FormParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormParking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnReserve;
    private javax.swing.JTextField idLocTxt;
    private javax.swing.JTextField idParkTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableParking;
    private com.toedter.calendar.JDateChooser reserveDate;
    // End of variables declaration//GEN-END:variables
}
