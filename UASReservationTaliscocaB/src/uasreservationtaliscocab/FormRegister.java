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
import javax.swing.JTextField;

/**
 *
 * @author natha
 */
public class FormRegister extends javax.swing.JFrame {

    /**
     * Creates new form FormRegister
     */
    public FormRegister() {
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

        jLabel4 = new javax.swing.JLabel();
        jButtonSignup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passTxt = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JTextField();
        repeatPassTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dobDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1600, 900));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("i've an account");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(660, 660, 114, 25);

        jButtonSignup.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSignup.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonSignup.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignup.setText("Sign Up");
        jButtonSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignupActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSignup);
        jButtonSignup.setBounds(740, 550, 110, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Date Of Birth");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(480, 220, 99, 25);

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(540, 160, 46, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Email");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 290, 41, 30);
        getContentPane().add(nameTxt);
        nameTxt.setBounds(610, 160, 504, 29);
        getContentPane().add(emailTxt);
        emailTxt.setBounds(610, 290, 510, 29);

        jButtonLogin.setBackground(new java.awt.Color(0, 153, 153));
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(800, 660, 90, 29);

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("Username");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(500, 350, 77, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel7.setText("Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(510, 410, 71, 25);
        getContentPane().add(passTxt);
        passTxt.setBounds(610, 410, 511, 29);
        getContentPane().add(usernameTxt);
        usernameTxt.setBounds(610, 350, 512, 29);
        getContentPane().add(repeatPassTxt);
        repeatPassTxt.setBounds(610, 470, 511, 29);

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel8.setText("Repeat Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(450, 470, 128, 25);

        dobDate.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dobDate);
        dobDate.setBounds(610, 220, 504, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/signup.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1182, 726);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignupActionPerformed
        try {
            String hasil;
            
            Socket clientSocket = new Socket("localhost",6666);
            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            if (!passTxt.getText().equals(repeatPassTxt.getText())) {
                JOptionPane.showConfirmDialog(this, "Password dan repeat password berbeda!");
            } else {
                String dateOfBirth = ((JTextField)dobDate.getDateEditor().getUiComponent()).getText();
                sendToServer.writeBytes("REGISTER~" + nameTxt.getText() + "~" + dateOfBirth + "~" + emailTxt.getText()
                        + "~" + usernameTxt.getText() + "~" + passTxt.getText() + "\n");
            }
            
            BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            hasil = chatFromServer.readLine();
            System.out.println(hasil);
            String[] hasils = hasil.split("~");
            if(hasils[0].equals("TRUE")) {
                JOptionPane.showConfirmDialog(this, "Register berhasil!");
                FormLogin home = new FormLogin();
                home.show();
                dispose();
            } else if(hasils[0].equals("FALSE")) {
                JOptionPane.showConfirmDialog(this, "Register gagal! email atau password sudah ada sebelumnya");
            }
            
        } catch(IOException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jButtonSignupActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dobDate;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField passTxt;
    private javax.swing.JTextField repeatPassTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
