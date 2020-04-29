package offer;

import java.util.Scanner;

public class SearchX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            if(n>=1 && n<=200){
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=in.nextInt();
                }
                int x=in.nextInt();
                int rs=searchx(n,arr,x);
                System.out.println(rs);
            }
        }
    }
    public static int searchx(int n,int[] arr,int x){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }
}
