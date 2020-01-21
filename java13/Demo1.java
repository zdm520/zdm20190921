package cn.zhao.Demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Demo1 demo1=new Demo1();
        //demo1.insert();
         List<Student> list= demo1.select();
         System.out.println(list);
    }


    public void insert(){
        Connection conn=null;
        Statement stml=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection
                    ("jdbc:mysql:///java13","root","root");
            stml=conn.createStatement();
            String sql="insert into student values(125,'赵代猛','男',20,'物理系')";
            int count=stml.executeUpdate(sql);
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(stml!=null){
                try {
                    stml.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public List<Student> select(){
        List<Student> list=new ArrayList<>();
        Connection conn=null;
        Statement stml=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection
                    ("jdbc:mysql:///java13","root","root");
            String sql="select * from student";
            stml=conn.createStatement();
            rs=stml.executeQuery(sql);
            Student student=null;
            while (rs.next()){
                int sno=rs.getInt("sno");
                String sname=rs.getString("sname");
                String ssex=rs.getString("ssex");
                int sage=rs.getInt("sage");
                String sdept=rs.getString("sdept");
                //创建学生对象，并赋值
                student=new Student();
                student.setSage(sage);
                student.setSdept(sdept);
                student.setSname(sname);
                student.setSno(sno);
                student.setSsex(ssex);
                //装载集合
                list.add(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stml!=null){
                try {
                    stml.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }



}
