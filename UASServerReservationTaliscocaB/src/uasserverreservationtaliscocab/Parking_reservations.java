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

public class Parking_reservations extends MyModel {
    private Account account_id;
    private Parkings parking_id;
    private int quantity;
    private double amount;
    private String status;
    private LocalDate claim_date;
    private LocalDate claimed_date;
    private LocalDate updated_at;
    private LocalDate created_at;

    public Parking_reservations() {
        this.account_id.setId(0);
        this.parking_id.setId(0);
        this.quantity = 0;
        this.amount = 0.0;
        this.status = "";
        this.claim_date = LocalDate.now();
        this.claimed_date = LocalDate.now();
        this.updated_at = LocalDate.now();
        this.created_at = LocalDate.now();
    }

    public Parking_reservations(int accounts_id, int parkings_id, int quantity, double amount, String status, LocalDate claim_date, LocalDate claimed_date, LocalDate updated_at, LocalDate created_at) {
        this.account_id.setId(accounts_id);
        this.parking_id.setId(parkings_id);
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.claim_date = claim_date;
        this.claimed_date = claimed_date;
        this.updated_at = updated_at;
        this.created_at = created_at;
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

    public LocalDate getClaimed_date() {
        return claimed_date;
    }

    public void setClaimed_date(LocalDate claimed_date) {
        this.claimed_date = claimed_date;
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
                        "INSERT INTO parking_reservations (accounts_id, parkings_id, quantity, amount, status, claim_date, claimed_date, updated_at, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                sql.setInt(1, this.account_id.getId());
                sql.setInt(2, this.parking_id.getId());
                sql.setInt(3, this.quantity);
                sql.setDouble(4, this.amount);
                sql.setString(5, this.status);
                sql.setDate(6, java.sql.Date.valueOf(this.claim_date));
                sql.setDate(7, java.sql.Date.valueOf(this.claimed_date));
                sql.setDate(8, java.sql.Date.valueOf(this.updated_at));
                sql.setDate(9, java.sql.Date.valueOf(this.created_at));
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
                        "UPDATE parking_reservations SET quantity = ?, amount = ?, status = ?, claim_date = ?, claimed_date = ?, updated_at = ?, created_at = ? WHERE accounts_id = ? AND parkings_id = ?");
                sql.setInt(3, this.quantity);
                sql.setDouble(4, this.amount);
                sql.setString(5, this.status);
                sql.setDate(6, java.sql.Date.valueOf(this.claim_date));
                sql.setDate(7, java.sql.Date.valueOf(this.claimed_date));
                sql.setDate(8, java.sql.Date.valueOf(this.updated_at));
                sql.setDate(9, java.sql.Date.valueOf(this.created_at));
                sql.setInt(10, this.account_id.getId());
                sql.setInt(11, this.parking_id.getId());
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
                        "DELETE FROM parking_reservations WHERE accounts_id = ? AND parkings_id = ?");
                sql.setInt(1, this.account_id.getId());
                sql.setInt(2, this.parking_id.getId());
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
            result = statement.executeQuery("SELECT * FROM parking_reservations");

            while (result.next()) {
                Parking_reservations tempReservation = new Parking_reservations();
                tempReservation.setAccount_id(result.getInt("accounts_id"));
                tempReservation.setParking_id(result.getInt("parkings_id"));
                tempReservation.setQuantity(result.getInt("quantity"));
                tempReservation.setAmount(result.getDouble("amount"));
                tempReservation.setStatus(result.getString("status"));
                tempReservation.setClaim_date(result.getDate("claim_date").toLocalDate());
                tempReservation.setClaimed_date(result.getDate("claimed_date").toLocalDate());
                tempReservation.setUpdated_at(result.getDate("updated_at").toLocalDate());
                tempReservation.setCreated_at(result.getDate("created_at").toLocalDate());

                collections.add(tempReservation.getAccount_id() + "-" + tempReservation.getParking_id() + "-" + tempReservation.getQuantity() + "-" + tempReservation.getAmount() + "-" + tempReservation.getStatus() + "-" + tempReservation.getClaim_date() + "-" + tempReservation.getClaimed_date() + "-" + tempReservation.getUpdated_at() + "-" + tempReservation.getCreated_at());
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
