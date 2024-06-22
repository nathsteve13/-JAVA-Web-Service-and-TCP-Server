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
import java.sql.Timestamp;

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
            Timestamp updated_at = new java.sql.Timestamp(System.currentTimeMillis());
            Timestamp created_at = new java.sql.Timestamp(System.currentTimeMillis());
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
                        updated_at = Timestamp.valueOf(checkData[7]);
                        created_at = Timestamp.valueOf(checkData[8]);
                        
                        msgToClient.writeBytes("TRUE~" + name + "~" + id_user + "\n");
                    }
                    else if (checkData[0].equals("FALSE")){
                        msgToClient.writeBytes("FALSE~" + "\n");
                    }
                } 
                
                else if (commands[0].equals("REGISTER")) {
                    boolean check = checkEmail(commands[3], commands[5]);
                    if (check) {
                        insertDataAccount(commands[1], LocalDate.parse(commands[2], inputFormatter).toString(), commands[3], commands[4], commands[5], 0f, 
                                new java.sql.Timestamp(System.currentTimeMillis()).toString(), new java.sql.Timestamp(System.currentTimeMillis()).toString());
                        msgToClient.writeBytes("TRUE~" + "\n");
                    }
                    else { 
                        msgToClient.writeBytes("FALSE~" + "\n");
                    }
                } 
                
                else if(commands[0].equals("EVENTVIEW")) {
                    List<String> dataList = viewListDataEvent();
                    String data = String.join("~", dataList);
                    msgToClient.writeBytes(data + "\n");
                }
                
                else if(commands[0].equals("EVENTRESERVATION")) {
                    System.out.println("");
                }
                
                else if(commands[0].equals("PARKINGVIEW")) {
                    System.out.println("");
                }
                
                else if (commands[0].equals("PARKINGRESERVATION")) {
                    
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

    private static boolean checkEmail(java.lang.String email, java.lang.String password) {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        return port.checkEmail(email, password);
    }

    private static void insertDataAccount(java.lang.String name, java.lang.String dob, java.lang.String email, java.lang.String username, java.lang.String password, double balance, java.lang.String updatedAt, java.lang.String createdAt) {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        port.insertDataAccount(name, dob, email, username, password, balance, updatedAt, createdAt);
    }

    private static java.util.List<java.lang.String> viewListDataEvent() {
        uasserverreservationtaliscocab.ReservationServices_Service service = new uasserverreservationtaliscocab.ReservationServices_Service();
        uasserverreservationtaliscocab.ReservationServices port = service.getReservationServicesPort();
        return port.viewListDataEvent();
    }


    

    



    
}
