package com.battcn.chapter1;

/**
 * @author Levin
 * @date 2017-09-02.
 */
public class TryConcurrent {

    public static void main(String[] args) throws InterruptedException {
        TicketWindowRunnable runnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(runnable, "一号窗口");
        Thread thread2 = new Thread(runnable, "二号窗口");
        Thread thread3 = new Thread(runnable, "三号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
