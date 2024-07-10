/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.uasreservation.services;

import com.uasreservation.model.Account;
import com.uasreservation.model.Event_reservations;
import com.uasreservation.model.Events;
import com.uasreservation.model.Parking_reservations;
import com.uasreservation.model.Parkings;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author natha
 */
@WebService(serviceName = "reservationServices")
public class reservationServices {

    Account a;
    Events e;
    Parkings p;
    Parking_reservations pr;
    Event_reservations er;
    
    /**
     * Web service operation
     * @param name
     * @param dob
     * @param email
     * @param username
     * @param password
     * @param balance
     * @param updated_at
     * @param created_at
     */
    @WebMethod(operationName = "insertDataAccount")
    public void insertDataAccount(@WebParam(name = "name") String name, @WebParam(name = "dob") String dob, 
            @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password, 
            @WebParam(name = "balance") double balance, @WebParam(name = "updated_at") String updated_at, 
            @WebParam(name = "created_at") String created_at) {
        a = new Account(name, LocalDate.parse(dob), email, username, password, balance, Timestamp.valueOf(updated_at), 
                Timestamp.valueOf(created_at));
        a.insertData();
    }
    
    @WebMethod(operationName = "updateDataAccount")
    public void updateDataAccount(@WebParam(name = "id") int id, @WebParam(name = "balance") double balance) {
        a = new Account(id, balance);
        a.updateData();
    }

    @WebMethod(operationName = "deleteDataAccount")
    public void deleteDataAccount(@WebParam(name = "id") int id) {
        a = new Account();
        a.setId(id);
        a.deleteData();
    }
    
    @WebMethod(operationName = "viewListDataAccount")
    public ArrayList<String> viewListDataAccount() {
        a = new Account();
        return a.viewListData();
    }

    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        a = new Account();
        a.setEmail(email);
        a.setPassword(password);
        return a.checkLogin();
    }
    
    @WebMethod(operationName = "checkEmail")
    public boolean checkEmail(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        a = new Account();
        a.setEmail(email); 
        a.setPassword(password);
        return a.checkEmail();
    }

    @WebMethod(operationName = "updateDataEvent")
    public void updateDataEvent(
        @WebParam(name = "id") int id,
        @WebParam(name = "status") String status,
        @WebParam(name = "participant_slot") int participant_slot,
        @WebParam(name = "number_of_participant") int number_of_participant
    ) {
        e = new Events(id, status, participant_slot, number_of_participant);
        e.setId(id);
        e.updateData();
    }

    @WebMethod(operationName = "deleteDataEvent")
    public void deleteDataEvent(@WebParam(name = "id") int id) {
        e = new Events();
        e.setId(id);
        e.deleteData();
    }

    @WebMethod(operationName = "viewListDataEvent")
    public ArrayList<String> viewListDataEvent() {
        e = new Events();
        return e.viewListData();
    }

    @WebMethod(operationName = "viewListDataParking")
    public ArrayList<String> viewListDataParking() {
        p = new Parkings();
        return p.viewListData();
    }
    
    @WebMethod(operationName = "insertDataParkingReservation")
    public void insertDataParkingReservation(
        @WebParam(name = "accounts_id") int accounts_id,
        @WebParam(name = "parkings_id") int parkings_id,
        @WebParam(name = "amount") double amount
    ) {
        pr = new Parking_reservations(accounts_id, parkings_id, amount);
        pr.insertData();
    }

    @WebMethod(operationName = "updateDataParkingReservation")
    public void updateDataParkingReservation(
        @WebParam(name = "accounts_id") int id
    ) {
        pr = new Parking_reservations(id);
        pr.updateData();
    }

    @WebMethod(operationName = "deleteDataParkingReservation")
    public void deleteDataParkingReservation(
        @WebParam(name = "accounts_id") int accounts_id,
        @WebParam(name = "parkings_id") int parkings_id
    ) {
        pr = new Parking_reservations();
        pr.setAccount_id(accounts_id);
        pr.setParking_id(parkings_id);
        pr.deleteData();
    }

    @WebMethod(operationName = "viewListDataParkingReservation")
    public ArrayList<String> viewListDataParkingReservation(@WebParam(name = "account_id") int account_id) {
        pr = new Parking_reservations();
        pr.setAccount_id(account_id);
        return pr.viewListData();
    }
    
    @WebMethod(operationName = "insertDataEventReservation")
    public void insertDataEventReservation(
        @WebParam(name = "account_id") int account_id,
        @WebParam(name = "event_id") int event_id,
        @WebParam(name = "quantity") int quantity,
        @WebParam(name = "amount") double amount,
        @WebParam(name = "status") String status,
        @WebParam(name = "claim_date") String claim_date
    ) {
        er = new Event_reservations(account_id, event_id, quantity, amount, status, LocalDate.parse(claim_date));
        er.insertData();
    }

    @WebMethod(operationName = "updateDataEventReservation")
    public void updateDataEventReservation(
        @WebParam(name = "id_event_reservation") int id_event_reservation,
        @WebParam(name = "status") String status
    ) {
        er = new Event_reservations(id_event_reservation, status);
        er.updateData();
    }

    @WebMethod(operationName = "deleteDataEventReservation")
    public void deleteDataEventReservation(
        @WebParam(name = "account_id") int account_id,
        @WebParam(name = "event_id") int event_id
    ) {
        er = new Event_reservations();
        er.setAccount_id(account_id);
        er.setEvent_id(event_id);
        er.deleteData();
    }

    @WebMethod(operationName = "viewListDataEventReservation")
    public ArrayList<String> viewListDataEventReservation( @WebParam(name = "account_id") int account_id) {
        er = new Event_reservations();
        er.setAccount_id(account_id);
        return er.viewListData();
    }
    
    @WebMethod(operationName = "slotCheck")
    public ArrayList<String> slotCheck( @WebParam(name = "id_location") int id_location, @WebParam(name = "reservation_date") String reservation_date) {
        p = new Parkings();
        Date sqlDate = Date.valueOf(reservation_date);
        return p.slotCheck(id_location, sqlDate);
    }
}
