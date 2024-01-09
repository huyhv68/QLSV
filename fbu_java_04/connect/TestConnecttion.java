/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cdbk.bgb.fbu_java_04.connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */

public class TestConnecttion {
    public static void main(String[] args) {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/fbu_java_03";
            String userName = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, userName, password);
            if (conn != null) {
                System.out.println("Ket Noi Thanh Cong");
            }else{
                System.out.println("Kết nối thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
