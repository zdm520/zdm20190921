package lesson3;

public class UnsafeThread {
    private static int SUM;//int数据类型，处于方法区的常量池中，超出范围到堆中
    public static void main(String[] args) {

        //同时启动20个线程，每个线程对同一个变量执行操作：循环10000次，每次循环++操作
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
                        SUM++;
                    }
                }
            }).start();
        }
        //如果所有线程没有执行完，便一直等待执行完
        while (Thread.activeCount()>1){
            Thread.yield();//线程让步
        }
        //不是预期的结果20_0000,
        //每次结果不一致
        System.out.println(SUM);
    }
}
