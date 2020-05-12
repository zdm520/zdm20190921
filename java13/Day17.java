package lesson5;

import java.util.Scanner;

/**
 * 2的个数
 *
 */

public class Day17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int rs=fun(n);
            System.out.println(rs);
        }
    }


    public static int fun(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }






//    public static int fun1(int n){
//        int count=0;
//        for(int i=n;i>=0;i--){
//            int j=i;
//            while (j>0){
//                if(j%10==2){
//                    count++;
//                    j=j/10;
//                }else {
//                    j=j/10;
//                }
//            }
//        }
//        return count;
//    }
}
