package lesson3;

import java.util.Scanner;

/**
 * 错排算法
 * D(n)=(n-1)*(D(n-1)+D(n-2))
 */
public class MyThread1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            double a=fenmu(n);
            double b=fenzi(n);
            double rs=(b/a)*100;
            System.out.println(String.format("%.2f",rs)+"%");
        }
    }
    //求分母
    public static double fenmu(int n){
        if(n==1){
            return 1;
        }
        return n*fenmu(n-1);
    }
    //求分子
    public static double fenzi(int n){
        if(n==1){
            return 0;
        }
        else if(n==2){
            return 1;
        }
        return (n-1)*(fenzi(n-1)+fenmu(n-2));
    }

}
