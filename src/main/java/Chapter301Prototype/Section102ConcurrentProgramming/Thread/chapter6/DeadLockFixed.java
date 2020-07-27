package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter6;

/**
 * @author Levin
 * @date 2017-09-24.
 */
public class DeadLockFixed {
    void method1() {
        while (true) {
            synchronized (String.class) {
                System.out.println("获得 Integer.class 对象锁");
                synchronized (Integer.class) {
                    System.out.println("获得 String.class 对象锁");
                }
            }
        }
    }
    void method2() {
        while (true) {
            synchronized (String.class) {
                System.out.println("获得 String.class 对象锁");
                synchronized (Integer.class) {
                    System.out.println("获得 Integer.class 对象锁");
                }
            }
        }
    }
    public static void main(String[] args) {
        DeadLockFixed fixed = new DeadLockFixed();
        new Thread(fixed::method1, "method1").start();
        new Thread(fixed::method2, "method2").start();
    }
}
