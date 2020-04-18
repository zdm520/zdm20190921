package offer;
/**
 * DNA序列
 *这种一边查找一边记录大小的，用一个max记录
 * 再用数组朝后走，保存了max的值，最后用字符串的api ：subString();
 */


import java.util.Scanner;

public class Dna {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            String str=in.nextLine();
            int n=in.nextInt();
            String rs=func(str,n);
            System.out.println(rs);
        }
    }
    public static String func(String str,int n){
        int max=0;
        int len=str.length();
        int[] arr=new int[len-n];
        for(int i=0;i<len-n;i++){
            String rs=str.substring(i,i+n);
            for(int j=0;j<n;j++){
                if(rs.charAt(j)=='C'||rs.charAt(j)=='G'){
                    arr[i]++;
                }
            }
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        String ret=str.substring(max,max+n);
        return ret;
    }


}
