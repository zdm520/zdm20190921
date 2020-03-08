package lesson2;

public class Main {
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunable()).start();
        MyThread myThread=new MyThread();
        myThread.run();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}





