/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cdbk.bgb.QLSV.connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class MyConnection {

    private String dbURL = "jdbc:mysql://localhost:3306/fbu_java_04";
    private String userName = "root";
    private String password = "";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(dbURL, userName, password);
            }
        } catch (Exception e) {
        }
        return conn;
    }
}
