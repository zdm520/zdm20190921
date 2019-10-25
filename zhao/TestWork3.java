package coms.sofency.test;

import java.util.Arrays;

public class TestWork3 {
    public static int print(int[]b,int n){
        int left=0;
        int right=b.length-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(n<b[middle]){
                right=middle-1;
            }
            else if(n>b[middle]){
                left=middle+1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]a=new int[]{1,4,6,7,15,67,56,34};
        int s= print(a,4);
        System.out.println(s);
    }






//    public static void print(int[]a){
//        int left=0;
//        int right=a.length-1;
//        while (left < right) {
//            while (left < right && a[left] % 2 == 0) {
//                left++;
//            }
//            while (left < right && a[right] % 2 != 0) {
//                right--;
//            }
//            int tmp=a[left];
//            a[left]=a[right];
//            a[right]=tmp;
//        }
//    }
//    public static void main(String[] args) {
//        int[]b=new int[]{1,2,3,4,5,6};
//        print(b);
//        System.out.println(Arrays.toString(b));
//    }





//    public static void print(int[]a){
//        for(int i=a.length-1;i>=0;i--){
//            System.out.println(a[i]);
//        }
//    }
//    public static void main(String[] args) {
//     int[]b=new int[]{1,2,3,4,5,6};
//     print(b);
//    }




//    public static void print(int[]a){
//        double avg=0;
//        double sum=0;
//        for(int i=0;i<=a.length-1;i++){
//            sum=sum+a[i];
//            avg=(sum/a.length);
//        }
//        System.out.println(avg);
//    }
//    public static void main(String[] args) {
//        int[]b=new int[]{1,2,3,4,5,6};
//        print(b);
//    }




//    public static void print(int[]a){
//        int min=a[0];
//        for(int x:a){
//            if(min>x){
//                min=x;
//            }
//        }
//        System.out.println(min);
//    }
//    public static void main(String[] args) {
//         int[]b=new int[]{1,2,3,5,8,46,8};
//         print(b);
//    }





//    public static void print(int[]a){
//        int max=a[0];
//        for(int x:a){
//            if(x>max){
//                max=x;
//            }
//        }
//        System.out.println(max);
//    }
//    public static void main(String[] args) {
//          int[]b=new int[]{1,2,3,5,8,46,8};
//           print(b);
//    }
}
