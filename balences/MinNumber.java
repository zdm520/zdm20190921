package offer;

import java.util.Scanner;

/**
 * 组个最小数
 *
 */
public class MinNumber {
    public static void main(String[] args) {
        int count=0;
        int[] arr=new int[10];
        Scanner sc=new Scanner(System.in);
        //数组下标代表要输出的数字，数组里面的数字代表数字的个数
        //有点计数排序的意思
        while (sc.hasNext()){
            for (int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            for (int i=0;i<arr.length;i++){
                count+=arr[i];
            }
            if(count>0 && count<=50){
                //下面找到以第一个非0的数字输出
                for(int i=1;i<arr.length;i++){
                        if(arr[i]!=0){
                            System.out.print(i+" ");
                            arr[i]--;
                            break;
                        }
                }
                //现在按照从小到大输出
                for(int i=0;i<arr.length;i++){
                    while (arr[i]!=0){
                        System.out.print(i+" ");
                        arr[i]--;
                    }
                }
            }
        }
    }

}
