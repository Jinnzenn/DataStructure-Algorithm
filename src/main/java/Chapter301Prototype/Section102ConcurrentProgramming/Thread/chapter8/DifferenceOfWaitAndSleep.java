package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter8;

import java.util.stream.Stream;

/**
 * @author Levin
 * @date 2017-09-28.
 */
public class DifferenceOfWaitAndSleep {

    private final static Object LOCK = new Object();

    static void method1() {
        synchronized (LOCK) {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] begin sleep ...");
                Thread.sleep(5_000);
                System.out.println("[" + Thread.currentThread().getName() + "] end sleep ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void method2() {
        synchronized (LOCK) {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] begin wait ...");
                LOCK.wait();
                System.out.println("[" + Thread.currentThread().getName() + "] end wait ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Stream.of("T1", "T2").forEach(name -> new Thread(DifferenceOfWaitAndSleep::method2, name).start());
    }


}
