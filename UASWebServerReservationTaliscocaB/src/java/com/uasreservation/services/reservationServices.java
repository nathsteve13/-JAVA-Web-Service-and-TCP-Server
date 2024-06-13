/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.uasreservation.services;

import com.uasreservation.model.Account;
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
    
    @WebMethod(operationName = "viewListDataVehicle")
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
}
