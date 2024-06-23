/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uasreservation.model;

/**
 *
 * @author natha
 */
import java.sql.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

public class Event_reservations extends MyModel{
    private Account account_id;
    private Events event_id;
    private int quantity;
    private double amount;
    private String status;
    private LocalDate claim_date;
    private Timestamp claimed_date;
    private Timestamp updated_at;
    private Timestamp created_at;

    public Event_reservations() {
        this.account_id = new Account();
        this.account_id.setId(0);
        this.event_id = new Events();
        this.event_id.setId(0);
        this.quantity = 0;
        this.amount = 0.0;
        this.status = "";
        this.claim_date = LocalDate.now();
        this.claimed_date = null;
        this.updated_at = new java.sql.Timestamp(System.currentTimeMillis());
        this.created_at = new java.sql.Timestamp(System.currentTimeMillis());
    }

    public Event_reservations(int account_id, int event_id, int quantity, double amount, String status, LocalDate claim_date, Timestamp claimed_date, Timestamp updated_at, Timestamp created_at) {
        this.account_id = new Account();
        this.account_id.setId(account_id);
        this.event_id = new Events();
        this.event_id.setId(event_id);
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.claim_date = claim_date;
        this.claimed_date = claimed_date;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }
    
    public Event_reservations(int account_id, int event_id, int quantity, double amount, String status, LocalDate claim_date) {
        this.account_id = new Account();
        this.account_id.setId(account_id);
        this.event_id = new Events();
        this.event_id.setId(event_id);
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.claim_date = claim_date;
    }
    
    public int getAccount_id() {
        return account_id.getId();
    }

    public void setAccount_id(int account_id) {
        this.account_id.setId(account_id);
    }

    public int getEvent_id() {
        return event_id.getId();
    }

    public void setEvent_id(int event_id) {
        this.event_id.setId(event_id);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getClaim_date() {
        return claim_date;
    }

    public void setClaim_date(LocalDate claim_date) {
        this.claim_date = claim_date;
    }

    public Timestamp getClaimed_date() {
        return claimed_date;
    }

    public void setClaimed_date(Timestamp claimed_date) {
        this.claimed_date = claimed_date;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO event_reservations (account_id, event_id, quantity, amount, status, claim_date, claimed_date, updated_at, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                sql.setInt(1, this.account_id.getId());
                sql.setInt(2, this.event_id.getId());
                sql.setInt(3, this.quantity);
                sql.setDouble(4, this.amount);
                sql.setString(5, this.status);
                sql.setDate(6, java.sql.Date.valueOf(this.claim_date));
                sql.setTimestamp(7, null);
                sql.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.setTimestamp(9, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "UPDATE event_reservations SET quantity = ?, amount = ?, status = ?, claim_date = ?, claimed_date = ?, updated_at = ?, created_at = ? WHERE account_id = ? AND event_id = ?");
                sql.setInt(1, this.quantity);
                sql.setDouble(2, this.amount);
                sql.setString(3, this.status);
                sql.setDate(4, java.sql.Date.valueOf(this.claim_date));
                sql.setTimestamp(5, this.claimed_date);
                sql.setTimestamp(6, this.updated_at);
                sql.setTimestamp(7, this.created_at);
                sql.setInt(8, this.account_id.getId());
                sql.setInt(9, this.event_id.getId());
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "DELETE FROM event_reservations WHERE account_id = ? AND event_id = ?");
                sql.setInt(1, this.account_id.getId());
                sql.setInt(2, this.event_id.getId());
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ArrayList<String> viewListData() {
        ArrayList<String> collections = new ArrayList<String>();
        try {
            statement = MyModel.conn.createStatement();
            result = statement.executeQuery("SELECT * FROM event_reservations");

            while (result.next()) {
                Event_reservations tempReservation = new Event_reservations(result.getInt("account_id"), result.getInt("account_id"), 
                        result.getInt("quantity"), result.getDouble("amount"), result.getString("status"), 
                        result.getDate("claim_date").toLocalDate(), result.getTimestamp("claimed_date"), 
                        result.getTimestamp("updated_at"), result.getTimestamp("created_at"));
                
                collections.add(tempReservation.getAccount_id() + "~" + tempReservation.getEvent_id() + "~" + tempReservation.quantity + "~" 
                        + tempReservation.amount + "~" + tempReservation.status + "~" + tempReservation.claim_date + "~" 
                        + tempReservation.claimed_date + "~" + tempReservation.updated_at + "~" + tempReservation.created_at);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        return collections;
    }
    
}
