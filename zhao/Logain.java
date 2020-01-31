package com.com.bitedu.db;

import java.sql.*;
import java.util.Scanner;

public class Logain {
    public boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement pstml=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection
                    ("jdbc:mysql:///java13","root","root");
            String sql="select * from user where username=? and password= ? ";
            pstml=conn.prepareStatement(sql);
            pstml.setString(1,username);
            pstml.setString(2,password);
            rs=pstml.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstml!=null){
                try {
                    pstml.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.next();
        System.out.println("请输入你的密码：");
        String password=sc.next();
        Logain logain=new Logain();
        boolean flag=logain.login(username,password);
        if(flag){
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
}
