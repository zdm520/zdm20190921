package worker;


import java.util.Scanner;

public class TCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String string=sc.nextLine();
        fun(string);
    }
    public static void fun(String string){
        //确定范围
        int[] num=new int[10];
        //计数
        for(int i=0;i<string.length();i++){
            num[string.charAt(i)-'0']++;
        }
        //输出
        for(int i=0;i<num.length;i++){
            if(num[i]!=0){
                System.out.println(i+":"+num[i]);
            }
        }
    }
}
