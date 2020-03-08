package lesson2;

import javax.xml.soap.Node;

public class Advantage {

    private static final int NUM=10;

    private static void increment(){
        int COUNT=10_0000_0000;
        for(int i=0;i<COUNT;i++){
            COUNT++;
        }
    }
    //串行
    private static void serial(){
        long start=System.currentTimeMillis();//1970年一月一日开始，到当前拿的毫秒数
        for(int i=0;i<NUM;i++){
            increment();
        }
        long end=System.currentTimeMillis();
        System.out.printf("串行执行时间：%s毫秒\n",end-start);

    }
    //并发（有时候java语义里边，并发这个词即表达并发，也表示并行）
    private static void parallel(){
        long start=System.currentTimeMillis();

        for(int i=0;i<NUM;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }
        //等待new Thread所有的线程执行完毕，否则一直等待。
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        long end=System.currentTimeMillis();
        System.out.printf("并行执行时间：%s毫秒\n",end-start);
    }

    public static void main(String[] args) {
        parallel();
        serial();
    }

}





