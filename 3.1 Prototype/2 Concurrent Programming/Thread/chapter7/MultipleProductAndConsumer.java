package com.battcn.chapter7;

import java.util.stream.Stream;

/**
 * 多生产多消费模式
 *
 * @author Levin
 * @create 2017/9/29 0029
 */
public class MultipleProductAndConsumer {

    private final static byte[] LOCK = new byte[0];
    private static boolean isProduction = true;
    private static int i = 0;

    static void product() {
        synchronized (LOCK) {
            try {
                if (isProduction) {//如果标示位为生产状态,则继续生产
                    System.out.println(Thread.currentThread().getName() + " -> " + (++i));
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
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                    isProduction = true;
                    LOCK.notifyAll();//通知我已经消费完毕了
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Stream.of("P1", "P2", "P3", "P4").forEach(name -> new Thread(() -> {
            while (true) {
                product();
            }
        }, name).start());
        Stream.of("C1", "C2").forEach(name -> new Thread(() -> {
            while (true) {
                consumer();
            }
        }, name).start());
    }
}
