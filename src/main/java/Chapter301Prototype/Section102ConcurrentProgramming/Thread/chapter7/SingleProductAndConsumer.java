package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter7;

/**
 * 单实例：wait与notify详解
 *
 * @author Levin
 * @create 2017/9/29 0029
 */
public class SingleProductAndConsumer {

    private final static byte[] LOCK = new byte[0];
    private static boolean isProduction = true;
    private static int i = 0;

    static void product() {
        synchronized (LOCK) {
            try {
                if (isProduction) {//如果标示位为生产状态,则继续生产
                    System.out.println("P->" + (++i));
                    isProduction = false;
                    LOCK.notify();//消费者可以消费了
                } else {
                    LOCK.wait();//说明生产出来的数据还未被消费掉
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void consumer() {
        try {
            synchronized (LOCK) {
                if (isProduction) {//如果当前还在生产,那么就暂停消费者线程
                    LOCK.wait();
                } else {
                    System.out.println("C->" + i);
                    isProduction = true;
                    LOCK.notify();//通知我已经消费完毕了
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                SingleProductAndConsumer.product();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                SingleProductAndConsumer.consumer();
            }
        }).start();
    }


}
