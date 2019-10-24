package coms.sofency.test;

/**
 * 如何求解0---999999之间的水仙花数
 */

public class TestWork4 {
    public static void print(){
        int count=0;
        for(int i=0;i<=999999;i++){
            int sum=0;
            int tmp=i;
            while(tmp!=0){
                count++;
                tmp=tmp/10;
            }
            tmp=i;
            while(tmp!=0){
                sum=sum+(int)Math.pow((tmp%10),count);
                tmp=tmp/10;
            }
            if(sum==i){
                System.out.println(i);
            }
            count=0;
        }
    }
    public static void main(String[] args) {
     print();
    }
}
