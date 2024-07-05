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
import java.util.ArrayList;

public class Parkings extends MyModel{
    private int id;
    private String parking_area;
    private Locations locations_id;
    private double price;
    private Timestamp updated_at;
    private Timestamp created_at;
    private String slot;

    public Parkings() {
        this.id = 0;
        this.parking_area = "";
        this.locations_id = new Locations();
        this.locations_id.setId(0);
        this.price = 0.0;
        this.updated_at = new java.sql.Timestamp(System.currentTimeMillis());
        this.created_at = new java.sql.Timestamp(System.currentTimeMillis());
        this.slot = "";
    }

    public Parkings(int id, String parking_area, int locations_id, double price, Timestamp updated_at, Timestamp created_at, String slot) {
        this.id = id;
        this.parking_area = parking_area;
        this.locations_id = new Locations();
        this.locations_id.setId(locations_id);
        this.price = price;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.slot = slot;
    }
    
    public Parkings(String parking_area, int locations_id, double price, Timestamp updated_at, Timestamp created_at, String slot) {
        this.parking_area = parking_area;
        this.locations_id = new Locations();
        this.locations_id.setId(locations_id);
        this.price = price;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.slot = slot;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParking_area() {
        return parking_area;
    }

    public void setParking_area(String parking_area) {
        this.parking_area = parking_area;
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
    
    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
    @Override
    public void insertData() {
        
    }

    @Override
    public void updateData() {
        
    }

    @Override
    public void deleteData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                    "DELETE FROM parkings WHERE id = ?");
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
            result = statement.executeQuery("SELECT * FROM parkings");

            while (result.next()) {
                Parkings tempParking = new Parkings(result.getInt("id"), 
                        result.getString("parking_area"), 
                        result.getInt("locations_id"), 
                        result.getDouble("price"), 
                        result.getTimestamp("updated_at"),
                        result.getTimestamp("created_at"),
                        result.getString("slot"));
                

                collections.add(tempParking.id + "~" + tempParking.parking_area + "~" + tempParking.getLocations_id() + "~" 
                        + tempParking.price + "~" + tempParking.updated_at + "~" + tempParking.created_at + "~" + tempParking.slot);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        return collections;
    }
}
