/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasserverreservationtaliscocab;

/**
 *
 * @author natha
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Locations extends MyModel{
    private int id;
    private String location_name;
    private LocalDate updated_at;
    private LocalDate created_at;

    public Locations() {
        this.id = 0;
        this.location_name = "";
        this.updated_at = LocalDate.now();
        this.created_at = LocalDate.now();
    }

    public Locations(String location_name, LocalDate updated_at, LocalDate created_at) {
        this.location_name = location_name;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO locations (location_name, updated_at, created_at) VALUES (?, ?, ?)");
                sql.setString(1, this.location_name);
                sql.setDate(2, java.sql.Date.valueOf(this.updated_at));
                sql.setDate(3, java.sql.Date.valueOf(this.created_at));
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
                        "UPDATE locations SET location_name = ?, updated_at = ?, created_at = ? WHERE id = ?");
                sql.setString(1, this.location_name);
                sql.setDate(2, java.sql.Date.valueOf(this.updated_at));
                sql.setDate(3, java.sql.Date.valueOf(this.created_at));
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
                    "DELETE FROM locations WHERE id = ?");
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
            result = statement.executeQuery("SELECT * FROM locations");

            while (result.next()) {
                Locations tempLocation = new Locations();
                tempLocation.setId(result.getInt("id"));
                tempLocation.setLocation_name(result.getString("location_name"));
                tempLocation.setUpdated_at(result.getDate("updated_at").toLocalDate());
                tempLocation.setCreated_at(result.getDate("created_at").toLocalDate());

                collections.add(tempLocation.getId() + "-" + tempLocation.getLocation_name() + "-" + tempLocation.getUpdated_at() + "-" + tempLocation.getCreated_at());
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
