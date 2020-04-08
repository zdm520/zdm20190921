package worker;

import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String str=reverse(n);
            System.out.println(str);
        }
    }
    public static String reverse(int n){
        StringBuffer sb=new StringBuffer();
        if(n>=0&&n<=9){
            sb.append(n);
        }else {
            for (int i=n;i>0;i/=10){
                sb.append(i%10);
            }
        }
        String str=new String(sb);
        return str;
    }
}
