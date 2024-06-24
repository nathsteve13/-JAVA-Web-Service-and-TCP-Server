/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uasreservation.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Account extends MyModel {
    private int id;
    private String name;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
    private double balance;
    private Timestamp updated_at;
    private Timestamp created_at;

    public Account() {
        id = 0;
        name = "";
        dob = LocalDate.now();
        email = "";
        username = "";
        password = "";
        balance = 0f;
        updated_at = new java.sql.Timestamp(System.currentTimeMillis());
        created_at = new java.sql.Timestamp(System.currentTimeMillis());
    }
    
    public Account(double _balance, Timestamp _updated_at, Timestamp _created_at) {
        this.balance = _balance;
        this.updated_at = _updated_at;
        this.created_at = _created_at; 
    }
     
    public Account(String _name, LocalDate _dob, String _email, String _username, String _password, double _balance, Timestamp _updated_at, Timestamp _created_at) { 
        this.name = _name;
        this.dob = _dob;
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.balance = _balance;
        this.updated_at = _updated_at;
        this.created_at = _created_at;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "insert into accounts (name, dob, email, username, password, balance, updated_at, created_at) values (?,?,?,?,?,?,?,?)");
                sql.setString(1, this.name);
                sql.setDate(2, java.sql.Date.valueOf(this.dob));
                sql.setString(3, this.email);
                sql.setString(4, this.username);
                sql.setString(5, this.password);
                sql.setDouble(6, this.balance);
                sql.setTimestamp(7, this.updated_at);
                sql.setTimestamp(8, this.created_at);
                sql.executeUpdate();
                sql.close();
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "UPDATE accounts SET balance = ?, updated_at = ?, created_at = ? WHERE id = ?");
                sql.setDouble(1, this.balance);
                sql.setTimestamp(2, this.updated_at);
                sql.setTimestamp(3, this.created_at);
                sql.setInt(4, id);

                sql.executeUpdate();
                sql.close();
            } 
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                    "DELETE FROM accounts WHERE id = ?");
                sql.setInt(1, id);
                sql.executeUpdate();
                sql.close();
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ArrayList<String> viewListData() {
        ArrayList<String> collections = new ArrayList<String>();
        try {
            statement = MyModel.conn.createStatement();
            result = statement.executeQuery("SELECT * FROM accounts where id = " + this.getId());
            
            while (result.next()) {
                Account tempv = new Account();
                tempv.setName(result.getString("name"));
                tempv.setDob(result.getDate("dob").toLocalDate());
                tempv.setEmail(result.getString("email"));
                tempv.setUsername(result.getString("username"));
                tempv.setBalance(result.getDouble("balance"));
                tempv.setUpdated_at(result.getTimestamp("updated_at"));
                tempv.setCreated_at(result.getTimestamp("created_at"));

                collections.add(tempv.getId() + "-" + tempv.getName() + "~" + tempv.getDob() + "~" + tempv.getEmail() + "~" + tempv.getUsername() + "~" + tempv.getBalance() + "~" + tempv.getUpdated_at() + "~" + tempv.getCreated_at());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return collections;
    }
    public String checkLogin() {
        String dataUser = "";
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "SELECT * FROM accounts WHERE email = ? and password = ?"
                );
                sql.setString(1, this.email);
                sql.setString(2, this.password);
                this.result = sql.executeQuery();
                if (this.result.next()) {
                    this.setId(this.result.getInt("id"));
                    this.setName(this.result.getString("name"));
                    this.setDob(this.result.getDate("dob").toLocalDate());
                    this.setEmail(this.result.getString("email"));
                    this.setUsername(this.result.getString("username"));
                    this.setPassword(this.result.getString("password"));
                    this.setBalance(this.result.getDouble("balance"));
                    this.setUpdated_at(this.result.getTimestamp("updated_at"));
                    this.setCreated_at(this.result.getTimestamp("created_at"));
                    sql.close();
                    dataUser = "TRUE~" + id + "~" + name + "~" + dob + "~" + email + "~" + username 
                    + "~" + balance + "~" + updated_at + "~" + created_at + "\n";
                    
                }
                else {
                    dataUser = "FALSE~" + "\n";
                }
            }
        } catch (Exception e) {
            System.out.println("Error di checklogin " + e);
        }

        return dataUser;
    }
    
    public boolean checkEmail() {
        try {
            PreparedStatement emailCheck = MyModel.conn.prepareStatement(
                    "SELECT email FROM accounts WHERE email = ?");
            emailCheck.setString(1, this.email);
            this.result = emailCheck.executeQuery();
            if (this.result.next()) {
                emailCheck.close();
                return false; 
            }
            emailCheck.close();

            PreparedStatement passwordCheck = MyModel.conn.prepareStatement(
                    "SELECT password FROM accounts WHERE password = ?");
            passwordCheck.setString(1, this.password);
            this.result = passwordCheck.executeQuery();
            if (this.result.next()) {
                passwordCheck.close();
                return false; 
            }
            passwordCheck.close();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
    
}
