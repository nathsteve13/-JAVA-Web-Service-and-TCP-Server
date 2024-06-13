/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.uasreservation.services;

import com.uasreservation.model.Account;
import com.uasreservation.model.Events;
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
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertDataAccount")
    public void insertDataAccount(@WebParam(name = "name") String name, @WebParam(name = "dob") LocalDate dob, @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "balance") double balance, @WebParam(name = "updated_at") LocalDate updated_at, @WebParam(name = "created_at") LocalDate created_at) {
        a = new Account(name, dob, email, username, password, balance, updated_at, created_at);
        a.insertData();
    }
    
    @WebMethod(operationName = "updateDataAccount")
    public void updateDataAccount(@WebParam(name = "name") String name, @WebParam(name = "dob") LocalDate dob, @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "balance") double balance, @WebParam(name = "updated_at") LocalDate updated_at, @WebParam(name = "created_at") LocalDate created_at) {
        a = new Account(name, dob, email, username, password, balance, updated_at, created_at);
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
    public boolean checkLogin(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
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
    
    @WebMethod(operationName = "insertDataEvent")
    public void insertDataEvent(
        @WebParam(name = "event_name") String event_name,
        @WebParam(name = "event_date") LocalDate event_date,
        @WebParam(name = "category") String category,
        @WebParam(name = "status") String status,
        @WebParam(name = "participant_slot") int participant_slot,
        @WebParam(name = "number_of_participant") int number_of_participant,
        @WebParam(name = "open_reservation_date") LocalDate open_reservation_date,
        @WebParam(name = "close_reservation_date") LocalDate close_reservation_date,
        @WebParam(name = "locations_id") int locations_id,
        @WebParam(name = "price") double price,
        @WebParam(name = "description") String description
    ) {
        e = new Events(event_name, event_date, category, status, participant_slot, number_of_participant, open_reservation_date, close_reservation_date, locations_id, price, description);
        e.insertData();
    }

    @WebMethod(operationName = "updateDataEvent")
    public void updateDataEvent(
        @WebParam(name = "id") int id,
        @WebParam(name = "event_name") String event_name,
        @WebParam(name = "event_date") LocalDate event_date,
        @WebParam(name = "category") String category,
        @WebParam(name = "status") String status,
        @WebParam(name = "participant_slot") int participant_slot,
        @WebParam(name = "number_of_participant") int number_of_participant,
        @WebParam(name = "open_reservation_date") LocalDate open_reservation_date,
        @WebParam(name = "close_reservation_date") LocalDate close_reservation_date,
        @WebParam(name = "locations_id") int locations_id,
        @WebParam(name = "price") double price,
        @WebParam(name = "description") String description
    ) {
        e = new Events(event_name, event_date, category, status, participant_slot, number_of_participant, open_reservation_date, close_reservation_date, locations_id, price, description);
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
}
