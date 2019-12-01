package coms.sofency;

import java.util.Arrays;

public class Test1 {
    public static void fun(int[] a, int[] b) {
        int[] sum = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length&&j < b.length) {
            if (a[i] < b[j]) {
                sum[k] = a[i];
                i++;
                k++;
            } else {
                sum[k] = b[j];
                j++;
                k++;
            }
        }
        while(i<a.length){
            sum[k]=a[i];
            i++;
            k++;
        }
        while (j<b.length){
            sum[k]=b[j];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(sum));
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 9};
        int[] array2 = {2, 4, 6, 8};
        fun(array1, array2);
    }
}