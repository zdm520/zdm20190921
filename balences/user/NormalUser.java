package com.zhao.user;

import com.zhao.operation.*;

import java.util.Scanner;

/**
 * 普通用户继承了User，重写里面的方法
 */

public class NormalUser extends User{
    public NormalUser(String nmae){
        this.name=nmae;
        this.operations=new IOperation[]{
                new EixtOperation(),
                new BorrowOperatioin(),
                new DisplayOperation(),
                new FindOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("hello"+this.name+"欢迎使用图书管理系统");
        System.out.println("1:借阅图书");
        System.out.println("2:展示所有图书");
        System.out.println("3:查找图示");
        System.out.println("0:退出系统");
        System.out.println("请输入你得选择");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
