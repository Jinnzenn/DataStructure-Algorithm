package com.battcn.chapter2;

/**
 * @author Levin
 * @date 2017-09-02.
 */
public class ThreadDemo {

    private static int count = 0;

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("battcn-group");
        Thread t1 = new Thread(() -> System.out.println("hello my name's " + Thread.currentThread().getName() + "  group name's" + Thread.currentThread().getThreadGroup().getName()));
        Thread t2 = new Thread(() -> System.out.println("hello my name's " + Thread.currentThread().getName() + "  group name's" + Thread.currentThread().getThreadGroup().getName()), "thread-battcn2");
        Thread t3 = new Thread(() -> System.out.println("hello my name's " + Thread.currentThread().getName() + "  group name's" + Thread.currentThread().getThreadGroup().getName()), "thread-battcn3");
        t1.start();
        t2.start();
        t3.start();
        group.enumerate(new Thread[]{t2, t3});
        /*for (int i = 0; i < Integer.MAX_VALUE; i++) {
            new Thread(group, new Runnable() {
                @Override
                public void run() {
                    try {
                        add(1);
                    } catch (Error error) {
                        System.out.println(count);
                        error.printStackTrace();
                    }
                }

                private void add(int i) {
                    count++;
                    add(i + 1);
                }
            }, "thread-battcn-4", 1 << 24).start();
        }*/

        Thread thread = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    for (int i = 1; i < 10; i++) {
                        Thread.sleep(1_000);
                        System.out.println("守护线程 " + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                for (int i = 1; i < 6; i++) {
                    Thread.sleep(1_000);
                    System.out.println("常规线程 " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
