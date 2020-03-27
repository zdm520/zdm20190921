package lesson2;

/**
 * 实现阻塞队列：1：满足线程安全的生产，消费的功能
 * 2：达到上限时不能添加元素，达到下限时不能够消费
 */


    public class MyBlockingQueue<E> {
    private Object[]arr;
    private int putIndex;
    private int takeIndex;
    private volatile int size;
    public MyBlockingQueue(int capacity){
        arr=new Object[capacity];
    }
    public synchronized  E take()throws InterruptedException{
        while (size==0){
            wait();
        }
        size--;
        notifyAll();
        E rs=(E)arr[takeIndex];
        takeIndex=(takeIndex+1)%arr.length;
        return rs;
    }

    public synchronized void put(E e)throws InterruptedException{
        while (size==arr.length){
            wait();
        }
        arr[putIndex]=e;
        putIndex=(putIndex+1)%arr.length;
        size++;
        notifyAll();
    }

    public static void main(String[] args)throws InterruptedException {
        MyBlockingQueue<Integer> queue=new MyBlockingQueue<>(100);
        for(int i=0;i<5;i++){
            final int k=i;
            new Thread(new Runnable() {
                @Override
                public void run() {   //五个线程一共500个元素入队列
                    try {
                        for(int j=0;j<100;j++){
                            queue.put(k*100+j);
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //出队列
        while (true){
            int num=queue.take();
            System.out.println(num);
        }
    }
}
