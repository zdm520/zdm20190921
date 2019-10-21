package coms.sofency.test;
import java.util.Arrays;

public class TestWork6 {
    public static void print(int[]a,int n){
        int left=0;
        int right=a.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(n>a[mid]){
                left=mid+1;
            }
           else if(n<a[mid]){
                right=mid-1;
            }
            else{
                System.out.println(mid);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[]b=new int[]{1,4,6,7,15,67,56,34};
         print(b,67);
    }
}
