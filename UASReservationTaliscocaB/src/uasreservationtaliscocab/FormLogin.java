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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author natha
 */
public class FormLogin extends javax.swing.JFrame {

    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
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

        jButtonSignUp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setSize(new java.awt.Dimension(1600, 900));

        jButtonSignUp.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSignUp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignUp.setText("Sign Up");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Password");

        jButtonLogin.setBackground(new java.awt.Color(0, 102, 102));
        jButtonLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("Don't have account ?");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginss.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonLogin)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41)
                                .addComponent(jButtonSignUp)
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonLogin)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSignUp)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        try {
            String hasil;
            
            Socket clientSocket = new Socket("localhost",6666);
            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());
            sendToServer.writeBytes("LOGIN~" + emailTxt.getText() + "~" + passwordTxt.getText() + "\n");
            
            BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            hasil = chatFromServer.readLine();
            System.out.println(hasil);
            String[] hasils = hasil.split("~");
            if(hasils[0].equals("TRUE")) {
                FormMenu home = new FormMenu();
                home.show();
                dispose();
                
                home.name = hasils[1];
                home.id_user = Integer.parseInt(hasils[2]);
                System.out.println(home.id_user + ", " + home.name);
            } else if(hasils[0].equals("FALSE")) {
                JOptionPane.showConfirmDialog(this, "LOGIN gagal, periksa kembali email dan password");
            }
            
        } catch(IOException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField passwordTxt;
    // End of variables declaration//GEN-END:variables
}
