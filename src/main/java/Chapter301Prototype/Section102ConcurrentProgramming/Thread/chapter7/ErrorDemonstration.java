package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter7;

import java.util.Optional;

/**
 * 错误示范
 *
 * @author Levin
 * @create 2017/9/29 0029
 */
public class ErrorDemonstration {

    private final static byte[] LOCK = new byte[0];
    private static int i = 0;
    private static boolean isProduction = true;

    static void product() {//生产者
        if (isProduction) {
            System.out.println("P->" + (++i));
            isProduction = false;
        }
    }

    static void consumer() {//消费者
        if (!isProduction) {
            System.out.println("C->" + i);
            isProduction = true;
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                product();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                consumer();
            }
        }).start();
    }

}
