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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
            int id_user = 0;
            String name = "";
            LocalDate dob = LocalDate.now();
            String email = "";
            String username = "";
            double balance = 0f;
            LocalDateTime updated_at = LocalDateTime.now();
            LocalDateTime created_at = LocalDateTime.now();
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter inputFormatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
                    String check = checkLogin(commands[1], commands[2]);
                    System.out.println(check);
                    String[] checkData = check.split("~");
                    if (checkData[0].equals("TRUE")) {
                        id_user = Integer.parseInt(checkData[1]);
                        name = checkData[2];
                        dob = LocalDate.parse(checkData[3], inputFormatter);
                        email = checkData[4];
                        username = checkData[5];
                        balance = Double.parseDouble(checkData[6]);
                        updated_at = LocalDateTime.parse(checkData[7], inputFormatterTime);
                        created_at = LocalDateTime.parse(checkData[8], inputFormatterTime);
                        
                        msgToClient.writeBytes("TRUE~" + name + "~" + id_user + "\n");
                    }
                    else if (checkData[0].equals("FALSE")){
                        msgToClient.writeBytes("FALSE~" + "\n");
                    }
                } else if (commands[0].equals("REGISTER")) {
                    
                } else if(commands[0].equals("EVENT")) {
                    System.out.println("");
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


    private static java.util.List<java.lang.String> viewListDataAccount() {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        return port.viewListDataAccount();
    }

    private static String checkLogin(java.lang.String email, java.lang.String password) {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        return port.checkLogin(email, password);
    }

    
}
