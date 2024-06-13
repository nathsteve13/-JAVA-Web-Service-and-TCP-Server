/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uasreservation.model;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Events extends MyModel{

    private int id;
    private String event_name;
    private LocalDate event_date;
    private String category;
    private String status;
    private int participant_slot;
    private int number_of_participant;
    private LocalDate open_reservation_date;
    private LocalDate close_reservation_date;
    private int locations_id;
    private double price;
    private String description;
    
    public Events(String event_name, LocalDate event_date, String category, String status, int participant_slot, int number_of_participant, LocalDate open_reservation_date, LocalDate close_reservation_date, int locations_id, double price, String description) {
        this.event_name = event_name;
        this.event_date = event_date;
        this.category = category;
        this.status = status;
        this.participant_slot = participant_slot;
        this.number_of_participant = number_of_participant;
        this.open_reservation_date = open_reservation_date;
        this.close_reservation_date = close_reservation_date;
        this.locations_id = locations_id;
        this.price = price;
        this.description = description;
    }

    public Events() {
        this.id = 0;
        this.event_name = "";
        this.event_date = LocalDate.now();
        this.category = category;
        this.status = status;
        this.participant_slot = participant_slot;
        this.number_of_participant = number_of_participant;
        this.open_reservation_date = open_reservation_date;
        this.close_reservation_date = close_reservation_date;
        this.locations_id = locations_id;
        this.price = price;
        this.description = description;
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

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
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

    public LocalDate getOpen_reservation_date() {
        return open_reservation_date;
    }

    public void setOpen_reservation_date(LocalDate open_reservation_date) {
        this.open_reservation_date = open_reservation_date;
    }

    public LocalDate getClose_reservation_date() {
        return close_reservation_date;
    }

    public void setClose_reservation_date(LocalDate close_reservation_date) {
        this.close_reservation_date = close_reservation_date;
    }

    public int getLocations_id() {
        return locations_id;
    }

    public void setLocations_id(int locations_id) {
        this.locations_id = locations_id;
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
                sql.setDate(2, java.sql.Date.valueOf(this.event_date));
                sql.setString(3, this.category);
                sql.setString(4, this.status);
                sql.setInt(5, this.participant_slot);
                sql.setInt(6, this.number_of_participant);
                sql.setDate(7, java.sql.Date.valueOf(this.open_reservation_date));
                sql.setDate(8, java.sql.Date.valueOf(this.close_reservation_date));
                sql.setInt(9, this.locations_id);
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
                        "UPDATE events SET event_name = ?, event_date = ?, category = ?, status = ?, participant_slot = ?, number_of_participant = ?, open_reservation_date = ?, close_reservation_date = ?, locations_id = ?, price = ?, description = ? WHERE id = ?");
                sql.setString(1, this.event_name);
                sql.setDate(2, java.sql.Date.valueOf(this.event_date));
                sql.setString(3, this.category);
                sql.setString(4, this.status);
                sql.setInt(5, this.participant_slot);
                sql.setInt(6, this.number_of_participant);
                sql.setDate(7, java.sql.Date.valueOf(this.open_reservation_date));
                sql.setDate(8, java.sql.Date.valueOf(this.close_reservation_date));
                sql.setInt(9, this.locations_id);
                sql.setDouble(10, this.price);
                sql.setString(11, this.description);
                sql.setInt(12, this.id);
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
        ArrayList<String> collections = new ArrayList<>();
        try {
            statement = MyModel.conn.createStatement();
            result = statement.executeQuery("SELECT * FROM events");

            while (result.next()) {
                Events tempEvent = new Events();
                tempEvent.setId(result.getInt("id"));
                tempEvent.setEvent_name(result.getString("event_name"));
                tempEvent.setEvent_date(result.getDate("event_date").toLocalDate());
                tempEvent.setCategory(result.getString("category"));
                tempEvent.setStatus(result.getString("status"));
                tempEvent.setParticipant_slot(result.getInt("participant_slot"));
                tempEvent.setNumber_of_participant(result.getInt("number_of_participant"));
                tempEvent.setOpen_reservation_date(result.getDate("open_reservation_date").toLocalDate());
                tempEvent.setClose_reservation_date(result.getDate("close_reservation_date").toLocalDate());
                tempEvent.setLocations_id(result.getInt("locations_id"));
                tempEvent.setPrice(result.getDouble("price"));
                tempEvent.setDescription(result.getString("description"));

                collections.add(tempEvent.getId() + "-" + tempEvent.getEvent_name() + "-" + tempEvent.getEvent_date() + "-" 
                        + tempEvent.getCategory() + "-" + tempEvent.getStatus() + "-" + tempEvent.getParticipant_slot() + "-" 
                        + tempEvent.getNumber_of_participant() + "-" + tempEvent.getOpen_reservation_date() + "-" 
                        + tempEvent.getClose_reservation_date() + "-" + tempEvent.getLocations_id() + "-" + tempEvent.getPrice() + "-" 
                        + tempEvent.getDescription());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (result != null) result.close();
                if (statement != null) statement.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return collections;
    }
    
}
