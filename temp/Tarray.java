package worker;

public class Tarray {
    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        int[] rs=muliply(A);
        dis(rs);
    }
    public static int[] muliply(int[] A){
        int[] b=new int[A.length];
        for (int i=0;i<A.length;i++){
            swap(A,0,i);
            b[i]=fun(A);
        }
        return b;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int fun(int[] A){
        int count=1;
        for (int i=1;i<A.length;i++){
            count*=A[i];
        }
        return count;
    }
    public static void dis(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
