package com.bitedu.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Statement stmt=null;
        Connection connection=null;
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

             connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/",
                            "root",
                            "root");

             stmt = connection.createStatement();

            stmt.execute("create database my_jdbc_db");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }

                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
