package com.zhao.user;

import com.zhao.operation.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name){
        this.name=name;
        this.operations=new IOperation[]{
                new EixtOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation(),
                new FindOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("hello"+this.name+"欢迎使用图书管理系统");
        System.out.println("1:新增图书");
        System.out.println("2:删除图书");
        System.out.println("3：显示所有图书");
        System.out.println("0:退出系统");
        System.out.println("请输入你的选择");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
