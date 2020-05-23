package offer;

import java.util.Scanner;

/**
 * 坐标移动
 *
 */


public class Move {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            display(str);
        }
    }
    public static void display(String str){
        String[] s = str.split(";");
        int[] arr = new int[2];

        for(int i=0;i<s.length;i++){
            try {
                String s1 = s[i];
                if(s1==null || s1.length()<2 || s1.length()>3){
                    continue;
                }
                if(s1.charAt(0)=='A'){
                    arr[0]=arr[0]-Integer.parseInt(s1.substring(1));
                }
                else if(s1.charAt(0)=='S'){
                    arr[1]=arr[1]-Integer.parseInt(s1.substring(1));
                }
                else if(s1.charAt(0)=='W'){
                    arr[1]=arr[1]+Integer.parseInt(s1.substring(1));
                }
                else if(s1.charAt(0)=='D'){
                    arr[0]=arr[0]+Integer.parseInt(s1.substring(1));
                }
            }catch (Exception e){
                continue;
            }
        }
        System.out.println(arr[0]+","+arr[1]);
    }
}
