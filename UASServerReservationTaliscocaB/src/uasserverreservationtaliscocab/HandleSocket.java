/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasserverreservationtaliscocab;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natha
 */
public class HandleSocket extends Thread {
    UASServerReservationTaliscocaB parent;
    Socket client;
    DataOutputStream out;
    BufferedReader in;
    
    public HandleSocket(UASServerReservationTaliscocaB _parent, Socket _client) {
        try {
            this.parent = _parent;
            this.client = _client;
            out = new DataOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void sendChat(String tmp) {
        try {
            out.writeBytes(tmp + "\n");
        } catch (IOException ex) {
            Logger.getLogger(UASServerReservationTaliscocaB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run() {
        try {
            while(true){
                String msg = in.readLine();//untuk membaca pesan dari client
                parent.showChat(msg);
            }
            
        } catch (Exception e) {
            System.out.println("Error run HS "+e);
        }
    }

}
