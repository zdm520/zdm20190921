package lesson2;

public class DaemonThread {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置为守护线程
        t.setDaemon(true);
        //启动线程
        t.start();
    }
}
