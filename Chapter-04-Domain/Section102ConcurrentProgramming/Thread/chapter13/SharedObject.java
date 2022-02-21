package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.Thread.chapter13;

/**
 * @author Levin
 * @date 2017-10-17.
 */
public class SharedObject {

    private static volatile int COUNTER = 0;
    private static final int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = COUNTER;
            while (localValue < MAX_LIMIT) {
                if (localValue != COUNTER) {
                    System.out.printf("[线程] - [%s] - [%d]\n", Thread.currentThread().getName(), COUNTER);
                    localValue = COUNTER;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = COUNTER;
            while (COUNTER < MAX_LIMIT) {
                System.out.printf("[线程] - [%s] - [%d]\n", Thread.currentThread().getName(), ++localValue);
                COUNTER = localValue;
            }
        }, "UPDATER").start();
    }
}
