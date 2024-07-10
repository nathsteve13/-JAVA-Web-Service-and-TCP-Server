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

public class Parking_reservations extends MyModel {
    private int id;
    private Parkings parking_id;
    private Account account_id;
    private LocalDate parking_date;
    private double amount;
    private String status;
    private Timestamp claimed_date;
    private Timestamp updated_at;
    private Timestamp created_at;

    public Parking_reservations() {
        this.id = 0;
        this.account_id = new Account();
        this.account_id.setId(0);
        this.parking_id = new Parkings();
        this.parking_id.setId(0);
        this.amount = 0.0;
        this.status = "";
        this.claimed_date =  new java.sql.Timestamp(System.currentTimeMillis());
        this.updated_at =  new java.sql.Timestamp(System.currentTimeMillis());
        this.created_at =  new java.sql.Timestamp(System.currentTimeMillis());
    }

    public Parking_reservations(int accounts_id, int parkings_id, double amount) {
        this.account_id = new Account();
        this.account_id.setId(accounts_id);
        this.parking_id = new Parkings();
        this.parking_id.setId(parkings_id);
        this.amount = amount;
    }
    
    public Parking_reservations(int id, int accounts_id, int parkings_id, LocalDate parking_date, double amount, 
            String status, Timestamp claimed_date, Timestamp updated_at, Timestamp created_at) {
        this.id = id;
        this.account_id = new Account();
        this.account_id.setId(accounts_id);
        this.parking_id = new Parkings();
        this.parking_id.setId(parkings_id);
        this.parking_date = parking_date;
        this.amount = amount;
        this.status = status;
        this.claimed_date = claimed_date;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }
    
    public Parking_reservations(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.setId(id);
    }
    
    public int getAccount_id() {
        return account_id.getId();
    }

    public void setAccount_id(int account_id) {
        this.account_id.setId(account_id);
    }
    
    
    public int getParking_id() {
        return parking_id.getId();
    }

    public void setParking_id(int event_id) {
        this.parking_id.setId(event_id);
    }
    
    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
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

    public Timestamp getClaimed_date() {
        return claimed_date;
    }

    public void setClaimed_date(Timestamp claimed_date) {
        this.claimed_date = claimed_date;
    }

    public LocalDate getParking_date() {
        return parking_date;
    }

    public void setParking_date(LocalDate parking_date) {
        this.parking_date = parking_date;
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
                        "INSERT INTO parking_reservations (parkings_id, accounts_id, parking_date, amount, status, updated_at, created_at) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?)");
                sql.setInt(1, this.parking_id.getId());
                sql.setInt(2, this.account_id.getId());
                sql.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                sql.setDouble(4, this.amount);
                sql.setString(5, "not claimed");
                sql.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
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
                        "UPDATE parking_reservations SET status = ?, claimed_date = ?, updated_at = ? WHERE id = ?");
                sql.setString(1, "claimed");
                sql.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.setInt(4, this.id);
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
                        "DELETE FROM parking_reservations WHERE id = ?");
                sql.setInt(1, this.id);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ArrayList<String> viewListData() {
        ArrayList<String> collections = new ArrayList<>();
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "SELECT * FROM parking_reservations where accounts_id = ?");
                sql.setInt(1, this.account_id.getId());
                ResultSet result = sql.executeQuery();
                
                while (result.next()) {
                    Parking_reservations tempReservation = new Parking_reservations(
                            result.getInt("id"),    
                            result.getInt("accounts_id"),
                            result.getInt("parkings_id"),
                            result.getDate("parking_date").toLocalDate(),
                            result.getDouble("amount"),
                            result.getString("status"),
                            result.getTimestamp("claimed_date"),
                            result.getTimestamp("updated_at"),
                            result.getTimestamp("created_at"));

                    collections.add(tempReservation.id + "~" 
                            + tempReservation.getAccount_id() + "~" 
                            + tempReservation.getParking_id() + "~" 
                            + tempReservation.parking_date + "~" 
                            + tempReservation.amount + "~" 
                            + tempReservation.status + "~" 
                            + tempReservation.claimed_date + "~" 
                            + tempReservation.updated_at + "~" 
                            + tempReservation.created_at);
                }
            }

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        return collections;
    }
}
