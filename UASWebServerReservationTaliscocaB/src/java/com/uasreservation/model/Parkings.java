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
    private String status;
    private Timestamp available_date;
    private Locations locations_id;
    private double price;
    private Timestamp updated_at;
    private Timestamp created_at;

    public Parkings() {
        this.id = 0;
        this.parking_area = "";
        this.status = "";
        this.available_date = new java.sql.Timestamp(System.currentTimeMillis());
        this.locations_id.setId(0);
        this.price = 0.0;
        this.updated_at = new java.sql.Timestamp(System.currentTimeMillis());
        this.created_at = new java.sql.Timestamp(System.currentTimeMillis());
    }

    public Parkings(String parking_area, String status, Timestamp available_date, int locations_id, double price, Timestamp updated_at, Timestamp created_at) {
        this.parking_area = parking_area;
        this.status = status;
        this.available_date = available_date;
        this.locations_id.setId(locations_id);
        this.price = price;
        this.updated_at = updated_at;
        this.created_at = created_at;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getAvailable_date() {
        return available_date;
    }

    public void setAvailable_date(Timestamp available_date) {
        this.available_date = available_date;
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

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO parkings (parking_area, status, available_date, locations_id, price, updated_at, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)");
                sql.setString(1, this.parking_area);
                sql.setString(2, this.status);
                sql.setTimestamp(3, this.available_date);
                sql.setInt(4, this.locations_id.getId());
                sql.setDouble(5, this.price);
                sql.setTimestamp(6, this.updated_at);
                sql.setTimestamp(7, this.created_at);
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
                        "UPDATE parkings SET parking_area = ?, status = ?, available_date = ?, locations_id = ?, price = ?, updated_at = ?, created_at = ? WHERE id = ?");
                sql.setString(1, this.parking_area);
                sql.setString(2, this.status);
                sql.setTimestamp(3, this.available_date);
                sql.setInt(4, this.locations_id.getId());
                sql.setDouble(5, this.price);
                sql.setTimestamp(6, this.updated_at);
                sql.setTimestamp(7, this.created_at);
                sql.setInt(8, this.id);
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
                Parkings tempParking = new Parkings();
                tempParking.setId(result.getInt("id"));
                tempParking.setParking_area(result.getString("parking_area"));
                tempParking.setStatus(result.getString("status"));
                tempParking.setAvailable_date(result.getTimestamp("available_date"));
                tempParking.setLocations_id(result.getInt("locations_id"));
                tempParking.setPrice(result.getDouble("price"));
                tempParking.setUpdated_at(result.getTimestamp("updated_at"));
                tempParking.setCreated_at(result.getTimestamp("created_at"));

                collections.add(tempParking.getId() + "-" + tempParking.getParking_area() + "-" + tempParking.getStatus() + "-" + tempParking.getAvailable_date() + "-" + tempParking.getLocations_id() + "-" + tempParking.getPrice() + "-" + tempParking.getUpdated_at() + "-" + tempParking.getCreated_at());
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
