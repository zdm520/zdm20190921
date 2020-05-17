package offer;

import java.util.Scanner;

public class Day20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            fun(str);
        }
    }

    public static void fun(String str){
        int[] arr = new int[26];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                arr[str.charAt(i)-'A']++;
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("%c:%d",('A'+i),arr[i]);
            System.out.println();
        }
    }
}
