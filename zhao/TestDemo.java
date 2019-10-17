package coms.sofency.test;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class TestDemo {
   int n;
   char start;
   char middle;
   char end;
   public void hannuo(int n,char start,char middle,char end){
       this.n=n;
       this.start=start;
       this.middle=middle;
       this.end=end;
       if(n==1){
           move(start,end);
       }
       else{
           hannuo(n-1,start,end,middle);
           move(start,end);
           hannuo(n-1,middle,start,end);
       }
   }
public void move(char start,char end){
    System.out.println(start+"->"+end);
}
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("你有几个盘子:");
        int n=in.nextInt();
        TestDemo test=new TestDemo();
        test.hannuo(n,'a','b','c');
    }
}
