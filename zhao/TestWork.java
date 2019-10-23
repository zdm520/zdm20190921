package coms.sofency.test;

import java.util.Scanner;

public class TestWork {
    public static int fac(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        else{
            return fac(n-1)+fac(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("输入一个数:");
        int a=in.nextInt();
        int x=fac(a);
        System.out.println(x);
    }
}
