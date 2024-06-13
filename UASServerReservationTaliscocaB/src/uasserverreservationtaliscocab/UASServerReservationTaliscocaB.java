/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uasserverreservationtaliscocab;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natha
 */
public class UASServerReservationTaliscocaB implements Runnable{

    
    ArrayList<HandleSocket> clients = new ArrayList<HandleSocket>();
    Thread t;
    Socket incoming;
    ServerSocket s = new ServerSocket(6000);
    
    public UASServerReservationTaliscocaB() throws IOException, Exception {
        if (t == null) {
            t = new Thread(this, "Server");
            t.start();
        }
    }
    
    public void broadCast(String tmp) {
        for (HandleSocket client : clients) {
            client.sendChat(tmp);
        }
    }

    public void showChat(String tmp) {
        broadCast(tmp);
    }
    public static void main(String[] args) {
        try {
            Socket incoming;
            String message;
            ServerSocket s = new ServerSocket(6666);
            Account a = new Account();
            Events e = new Events();
            Event_reservations er = new Event_reservations();
            Locations l = new Locations();
            Parkings p = new Parkings();
            Parking_reservations pr = new Parking_reservations();
            while (true) {
                incoming = s.accept();

                BufferedReader msgFClient = new BufferedReader(
                        new InputStreamReader(incoming.getInputStream()));
                message = msgFClient.readLine();
                String command = message;
                String[] commands = command.split("~");
                System.out.println(command);
                
                DataOutputStream msgToClient = new DataOutputStream(incoming.getOutputStream());
                if (commands[0].equals("LOGIN")) {
                    a.setEmail(commands[1]);
                    a.setPassword(commands[2]);
                    boolean tmp = a.checkLogin();
                    
                    if (tmp) {
                        String namePengguna = a.getName();
                        msgToClient.writeBytes("TRUE~" + namePengguna + "\n");
                    } else {
                        msgToClient.writeBytes("FALSE\n");
                    }
                } else if (commands[0].equals("REGISTER")) {
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    
                    a.setEmail(commands[1]);
                    a.setPassword(commands[2]);
                    a.setName(commands[3]);
                    a.setUsername(commands[4]);
                    a.setDob(LocalDate.parse(commands[5], inputFormatter));
                    a.setBalance(0f);
                    a.setUpdated_at(LocalDate.now());
                    a.setCreated_at(LocalDate.now());
                    
                    boolean tmp = a.checkEmail();
                    
                    if (tmp) {
                        a.insertData();
                        msgToClient.writeBytes("TRUE" + "\n");
                    } else {
                        msgToClient.writeBytes("FALSE" + "\n");
                    }
                } else if(commands[0].equals("EVENT")) {
                    System.out.println("halo");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error di server : " + ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                incoming = s.accept();
                HandleSocket hs = new HandleSocket(this, incoming);
                hs.start();
                clients.add(hs);
            } catch (IOException ex) {
                Logger.getLogger(UASServerReservationTaliscocaB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
