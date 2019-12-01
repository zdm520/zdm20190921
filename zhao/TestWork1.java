package coms.sofency.test;

public class TestWork1 {
    public static void print(int[]c){
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
    public static int[] method(int[]b){
        int i=0;
        for(i=0;i<b.length;i++){
            b[i]=2*b[i];
        }
        return b;
    }
    public static void main(String[] args) {
         int[]a={1,2,3,4,5};
         int[]s=method(a);
         print(s);
    }
}
