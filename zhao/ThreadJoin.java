package lesson2;

/**
 * t线程：线程引用对象
 * 当前线程进行阻塞（运行态-->阻塞态）等待（满足一定条件），
 * t线程（不做任何处理，让t执行运行）
 *
 * 一定条件：以下哪个条件先执行完，就满足
 *
 * 传入的时间：时间值+时间单位毫秒
 * 线程引用对象执行完毕
 */

public class ThreadJoin {

    //无睡眠join里面无参数
    private static void without() throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName());
    }

    //无睡眠join里面有参数
    public static void without_Sleep() throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        /**
         * t线程执行时间和2秒钟谁先到，
         * 就以这个时间点作为main线程等待的时间点,到了这个时间点就往下执行
         * 意思就是如果t执行时间比两秒钟更快的话，先把t执行完，
         * 接着立刻往下执行
         */

        t.start();
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }

//有睡眠join里面有参数

    private static void with_Sleep() throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //当前线程main线程等待2秒钟就往下执行
        //因为t线程执行时间大于2秒钟，因此先执行main线程
        t.start();
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args)
            throws InterruptedException {
        //without();
        //without_Sleep();
        with_Sleep();
    }
}
