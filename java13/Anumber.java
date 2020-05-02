package worker;

import java.util.Scanner;

/**
 * 内行数
 *
 */
public class Anumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            String rs=func(n);
            System.out.println(rs);
        }
    }
    public static String func(int n){
        StringBuffer sb=new StringBuffer();
        if(n>=2 && n<=100){
            int n1=(int) Math.pow(n,2);
            while (n1/10!=0){
                sb.append(n1%10);
                n1=n1/10;
            }
        }
        if(sb.length()==0){
            return "No!";
        }
        sb.reverse();
        String str1=new String(sb);
        int rs=Integer.parseInt(str1);
        if(rs==n){
            return "Yes!";
        }
        return "No!";
    }
}
