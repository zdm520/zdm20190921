package lesson2;

public class BreadOperator {
    //库存面包数量：上限100，下限0
    public static volatile int SUM;

    public static void main(String[] args) {
        //启动生产者线程。生产面包
        for(int i=0;i<5;i++){
            new Thread(new Producer(),"面包师傅"+i).start();
        }
        //启动消费者线程，消费面包
        for(int i=0;i<5;i++){
            new Thread(new Consumer(),"消费者"+i).start();
        }
    }
    //默认生产者：面包师傅生产面包，一次生产三个面包,一个师傅生产20次面包
    private static class  Producer implements Runnable{
        @Override
        public void run(){
            try {
                for (int i=0;i<20;i++){
                    synchronized (BreadOperator.class){
                        while (SUM+3>100){
                            //释放对象锁，需要让其他线程进入同步代码块，当前线程需要进入阻塞
                            BreadOperator.class.wait();
                        }
                        SUM+=3;//生产面包
                        Thread.sleep(10);
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName()+"生产了，库存为"+SUM);
                        Thread.sleep(10);
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //默认消费者：消费面包，一次消费一个面包
    private static class Consumer implements Runnable{

        @Override
        public void run(){
            try{
                while (true){
                    synchronized (BreadOperator.class){
                        while (SUM==0){
                            //释放对象锁，阻塞当前线程，因为没有调用notify()方法，
                            BreadOperator.class.wait();
                        }
                        SUM--;
                        Thread.sleep(10);
                        //notify()/notifyall()方法都是通知wait()被阻塞的线程
                        //notify()方法是随机选择一个wait()方法阻塞的线程唤醒
                        //唤醒的是wait()阻塞的线程和synchronized阻塞的线程
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName()+"，消费了，库存为"+SUM);
                        Thread.sleep(10);
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
