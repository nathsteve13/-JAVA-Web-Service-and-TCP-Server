/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasserverreservationtaliscocab;

/**
 *
 * @author natha
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class MyModel {
    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbreservation", "root", "");
        } catch(Exception ex) {
            System.out.println("Error di connection : " + ex);
        }
        return conn;
    }
    
    public abstract void insertData();
    public abstract void updateData();
    public abstract void deleteData();
    public abstract ArrayList<String> viewListData();
}
