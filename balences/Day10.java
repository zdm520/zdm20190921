package worker;

import java.util.Scanner;

/**
 * 尼科彻斯定理
 *主要就是要找到规律，求出第一个数
 */
public class Day10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String str=fun(n);
            System.out.println(str);
        }
    }
    public static String fun(int n){
        String ret="";
        int first=0;
        //当n为偶数时候，第一个数与n的数学表达式
        if(n%2==0){
            first=n*n-2*(n/2)+1;
        }else{
            //当n为奇数时，第一个数与n的数学表达式
            first=n*n-2*(n/2);
        }
        //将第一个数先连接起来，不然后面不好连接
        ret+=first;
        for(int i=1;i<n;i++){
            ret+="+"+(first+2*i);
        }
        return ret;
    }
}
