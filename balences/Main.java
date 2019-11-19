package com.zhao;

import com.zhao.book.BookList;
import com.zhao.user.Admin;
import com.zhao.user.NormalUser;
import com.zhao.user.User;
/**
 * main方法，程序的入口
 */

import java.util.Scanner;

public class Main {
    //写一个用户登录的方法，返回的是一个用户
    public static User login(){
        System.out.println("请输入你的名字");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入你的身份（1是管理员，0是普通用户）");
        int who=scanner.nextInt();
        if(who==1){
            return new Admin(name);
        }
        else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList=new BookList(); //先生成书这个对象
        User user=login();      //接收这个用户
        while (true){
            int choice=user.menu();   //调用用户的菜单方法，返回的是选项
            user.doOperation(choice,bookList); //用户可以调用父类User的方法
        }
    }
}
