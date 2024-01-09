/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cdbk.bgb.QLSV.controller;

import com.cdbk.bgb.QLSV.connect.MyConnection;
import com.cdbk.bgb.QLSV.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class UserController {

    MyConnection myConnection = new MyConnection();

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            Connection conn = myConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_user");
            while(rs.next()){
                list.add(new User(rs.getInt("id"), 
                        rs.getString("username"), 
                        rs.getString("password"), 
                rs.getString("email")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean insert(User user) {
        try {
            Connection conn = myConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "insert into tbl_user values(null, '"+user.getUsername()+"', "
                    + " '"+user.getPassword()+"', "
                    + "'"+user.getEmail()+"')";
            if (stmt.executeUpdate(sql) > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public boolean delete(int id) {
        try {
            Connection conn = myConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "delete from tbl_user where id ="+id;
            if (stmt.executeUpdate(sql) > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public boolean update(User user) {
        try {
            Connection conn = myConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "update tbl_user set username = '"+user.getUsername()+"', "
                    + "password = '"+user.getPassword()+"', "
                    + "email = '"+user.getEmail()+"' where id ="+user.getId();
            if (stmt.executeUpdate(sql) > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public static void main(String[] args) {
        UserController uc = new UserController();
        List<User> list = uc.getAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
