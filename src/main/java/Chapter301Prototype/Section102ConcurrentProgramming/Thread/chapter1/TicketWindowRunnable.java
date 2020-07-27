package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter1;

/**
 * @author Levin
 * @date 2017-09-02.
 */
public class TicketWindowRunnable implements Runnable {
    private volatile int index = 1;
    private final static int max = 50;

    @Override
    public void run() {
        while (index <= max) {
            System.out.println(Thread.currentThread().getName() + "接收:" + (index++));
        }
    }
}
