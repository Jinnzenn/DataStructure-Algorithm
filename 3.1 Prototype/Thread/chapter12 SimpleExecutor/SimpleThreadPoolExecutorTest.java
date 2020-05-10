package com.battcn.chapter12;


import java.util.stream.IntStream;

/**
 * @author Levin
 * @create 2017/10/12 0012
 */
public class SimpleExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        SimpleThreadPoolExecutor executor = new SimpleThreadPoolExecutor();
        IntStream.range(0, 50).forEach(i ->
                executor.submit(() -> {
                    System.out.printf("[线程] - [%s] 开始工作...\n", Thread.currentThread().getName());
                    try {
                        Thread.sleep(2_000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("[线程] - [%s] 工作完毕...\n", Thread.currentThread().getName());
                })
        );
        executor.shutdown();
    }

}
