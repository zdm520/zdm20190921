package com.zhao.thread;

/**
 * 同步保证线程安全，确保线程原子性
 * 用synchronized上锁
 */


public class ThreadDemo2 {
    public static void main(String[] args) {
        //创建对象
        ThreadTrain1 train1=new ThreadTrain1();
        //创建线程对象
        Thread t1=new Thread(train1,"窗口1");
        Thread t2=new Thread(train1,"窗口2");
        //启动线程
        t1.start();
        t2.start();
    }
}
//用实现接口来实现一种方法
class ThreadTrain1 implements Runnable{
    private int trickCount=100;
    @Override
    public void run() {
        while (trickCount>0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    //出售票
    public synchronized void sale(){
            if(trickCount>0){
                System.out.println(Thread.currentThread().getName()+"出售第"+(100-trickCount+1)+"张票");
                trickCount--;
            }
    }
}