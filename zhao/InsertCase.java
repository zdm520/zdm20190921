package com.bitedu.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCase {
    public static void createTable(){
        Connection connection=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/my_jdbc_db","root","root");
             stmt=connection.createStatement();
            String str="create table "+"student(sno int,sname varchar(20))";
            stmt.execute(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



//    public static void insertIntoTable(){
//
//    }


    public static void main(String[] args) {
        createTable();
//        insertIntoTable();
    }
}
