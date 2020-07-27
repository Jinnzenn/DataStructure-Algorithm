package Chapter301Prototype.Section102ConcurrentProgramming.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用BlockingQueue实现生产者消费者模型
 * @author ChenJinzhen
 * @date 2020.07.24
 */
public class BlockingQueueImple {
    private static AtomicInteger count = new AtomicInteger();//使用count计数
    final BlockingQueue blockingQueue = new LinkedBlockingQueue(10);//与ArrayBlockingQueue相比有较大的吞吐量
    public static void main(String[] args) {
        BlockingQueueImple test = new BlockingQueueImple();
        test.new Producer().start();
        test.new Consumer().start();
        test.new Producer().start();
        test.new Consumer().start();
        test.new Producer().start();
        test.new Consumer().start();
        test.new Producer().start();
        test.new Consumer().start();
    }
    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count.getAndIncrement();
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count.getAndDecrement();
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}