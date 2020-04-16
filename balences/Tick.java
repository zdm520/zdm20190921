package offer;
/**
 * 统计学生人数
 *
 */

import java.util.Scanner;

public class Tick {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            int grade=sc.nextInt();
            int rs=sum(n,arr,grade);
            System.out.println(rs);
        }
    }
    public static int sum(int n,int[] arr,int grade){
        int count=0;
        if(n>0&&n<=1000){
            if(grade>=0&&grade<=100){
                for (int i=0;i<arr.length;i++){
                    if(arr[i]>=0&&arr[i]<=100&&arr[i]==grade){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
