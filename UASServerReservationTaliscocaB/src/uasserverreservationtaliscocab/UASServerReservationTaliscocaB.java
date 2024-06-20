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
            LocalDate updated_at = LocalDate.now();
            LocalDate created_at = LocalDate.now();
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
                    boolean check = checkLogin(commands[1], commands[2]);
                    if (check) {
                        List<String> dataList = viewListDataAccount();
                        System.out.println(dataList);
                        for (String data : dataList) {
                            String[] splitData = data.split("~");
                            id_user = Integer.parseInt(splitData[0]);
                            name = splitData[1];
                            dob = LocalDate.parse(splitData[2], inputFormatter);
                            email = splitData[3];
                            username = splitData[4];
                            balance = Double.parseDouble(splitData[5]);
                            updated_at = LocalDate.parse(splitData[6], inputFormatterTime);
                            created_at = LocalDate.parse(splitData[7], inputFormatterTime);
                        }
                        
                        msgToClient.writeBytes("TRUE~" + name + "~" + id_user + "\n");
                    }
                    else {
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

    private static boolean checkLogin(java.lang.String email, java.lang.String password) {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        return port.checkLogin(email, password);
    }

    private static java.util.List<java.lang.String> viewListDataAccount() {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        return port.viewListDataAccount();
    }
    
}
