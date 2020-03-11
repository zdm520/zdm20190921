package lesson3;

/**
 * 学习线程中断
 *自定义的中断标志位满足不了线程处于阻塞状态的操作逻辑
 * 不建议使用自己定义的
 */
public class InterruptThread {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(2000);
                    //判断线程如果没有被中断，便中断
                    while (!Thread.currentThread().isInterrupted()){
                        System.out.println("1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName());
                    //判断线程的中断标志位 true 或者 false
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        //t线程启动，t线程标志中断位为false
        t.start();
        //中断启动，t线程中断标志位为true
        t.interrupt();
    }


}
