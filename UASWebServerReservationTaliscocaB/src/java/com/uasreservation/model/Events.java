/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uasreservation.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Events extends MyModel{

    private int id;
    private String event_name;
    private Timestamp event_date;
    private String category;
    private String status;
    private int participant_slot;
    private int number_of_participant;
    private Timestamp open_reservation_date;
    private Timestamp close_reservation_date;
    private Locations locations_id;
    private double price;
    private String description;
    
    public Events(int id, String event_name, Timestamp event_date, String category, String status, 
            int participant_slot, int number_of_participant, Timestamp open_reservation_date, 
            Timestamp close_reservation_date, int locations_id, double price, String description) {
        this.id = id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.category = category;
        this.status = status;
        this.participant_slot = participant_slot;
        this.number_of_participant = number_of_participant;
        this.open_reservation_date = open_reservation_date;
        this.close_reservation_date = close_reservation_date;
        this.locations_id = new Locations();
        this.locations_id.setId(locations_id); 
        this.price = price;
        this.description = description;
    }
    
    public Events(int id, String status, int participant_slot, int number_of_participant) {
        this.id = id;
        this.status = status;
        this.participant_slot = participant_slot;
        this.number_of_participant = number_of_participant;
    }
    
    public Events() {
        this.id = 0;
        this.event_name = "";
        this.event_date =  new java.sql.Timestamp(System.currentTimeMillis());
        this.category = "";
        this.status = "";
        this.participant_slot = 0;
        this.number_of_participant = 0;
        this.open_reservation_date =  new java.sql.Timestamp(System.currentTimeMillis());
        this.close_reservation_date =  new java.sql.Timestamp(System.currentTimeMillis());
        this.locations_id = new Locations();
        this.locations_id.setId(0);
        this.price = 0f;
        this.description = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Timestamp getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Timestamp event_date) {
        this.event_date = event_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getParticipant_slot() {
        return participant_slot;
    }

    public void setParticipant_slot(int participant_slot) {
        this.participant_slot = participant_slot;
    }

    public int getNumber_of_participant() {
        return number_of_participant;
    }

    public void setNumber_of_participant(int number_of_participant) {
        this.number_of_participant = number_of_participant;
    }

    public Timestamp getOpen_reservation_date() {
        return open_reservation_date;
    }

    public void setOpen_reservation_date(Timestamp open_reservation_date) {
        this.open_reservation_date = open_reservation_date;
    }

    public Timestamp getClose_reservation_date() {
        return close_reservation_date;
    }

    public void setClose_reservation_date(Timestamp close_reservation_date) {
        this.close_reservation_date = close_reservation_date;
    }

    public int getLocations_id() {
        return locations_id.getId();
    }

    public void setLocations_id(int locations_id) {
        this.locations_id.setId(locations_id);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO events (event_name, event_date, category, status, participant_slot, number_of_participant, open_reservation_date, close_reservation_date, locations_id, price, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                sql.setString(1, this.event_name);
                sql.setTimestamp(2, this.event_date);
                sql.setString(3, this.category);
                sql.setString(4, this.status);
                sql.setInt(5, this.participant_slot);
                sql.setInt(6, this.number_of_participant);
                sql.setTimestamp(7, this.open_reservation_date);
                sql.setTimestamp(8, this.close_reservation_date);
                sql.setInt(9, this.locations_id.getId());
                sql.setDouble(10, this.price);
                sql.setString(11, this.description);
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
                        "UPDATE events SET status = ?, participant_slot = ?, number_of_participant = ? WHERE id = ?");
                sql.setString(1, this.status);
                sql.setInt(2, this.participant_slot);
                sql.setInt(3, this.number_of_participant);
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
                    "DELETE FROM events WHERE id = ?");
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
        ArrayList<String> collections = new ArrayList<String>();
        try {
            this.statement = (Statement)MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM events");

            while (this.result.next()) {
                Events e = new Events(result.getInt("id"), result.getString("event_name"),
                        result.getTimestamp("event_date"), result.getString("category"), 
                        result.getString("status"), result.getInt("participant_slot"), 
                        result.getInt("number_of_participant"), result.getTimestamp("open_reservation_date"), 
                        result.getTimestamp("close_reservation_date"), result.getInt("locations_id"), 
                        result.getDouble("price"),result.getString("description"));
                
                collections.add(e.id + "~" + e.event_name + "~" + e.event_date + "~" 
                        + e.category + "~" + e.status + "~" + e.participant_slot + "~" 
                        + e.number_of_participant + "~" + e.open_reservation_date + "~" 
                        + e.close_reservation_date + "~" + e.getLocations_id() + "~" + e.price + "~" 
                        + e.description);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        return collections;
    }
    
}
