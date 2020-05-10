package com.battcn.chapter11;

/**
 * 捕获线程异常
 *
 * @author Levin
 * @date 2017-10-10.
 */
class ConnectionPool {
    static void create() {
        System.out.println("初始化连接池...");
    }

    static void close() {
        System.out.println("关闭连接池...");
    }
}

public class ThreadUncaughtException {

    public static void main(String[] args) {
        try {
            //有个任务需要异步执行
            Thread t2 = new Thread(() -> System.out.println(Integer.parseInt("ABC")), "T2");
            t2.start();
        } catch (Exception e) {
            ConnectionPool.close();
        }
        ///////////////////////////////////////////////分割线//////////////////////////////////////////////
        ConnectionPool.create();
        Thread t1 = new Thread(() -> System.out.println(Integer.parseInt("ABC")), "T1");
        t1.start();
        t1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("[线程] - [" + t.getName() + "] - [消息] - [" + e.getMessage() + "]");
            ConnectionPool.close();
        });
    }
}
