package Chapter301Prototype.Section102ConcurrentProgramming.ProducerConsumer;

import java.util.concurrent.Semaphore;
/**
 * 使用semaphore信号量实现 生产者消费者模型
 * @author Chenjinzhen
 * @date 2020.07.24
 */
public class SemaphoreImple {
    //创建三个信号量
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);//互斥锁，保证对count这个共享资源的访问不冲突，可去除
    private static Integer count = 0;//输出状态，可去除
    public static void main(String[] args) {
        SemaphoreImple test = new SemaphoreImple();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();
    }
    class Producer implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();//一次只能有一个生产者或消费者修改 count，
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前count：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }
    class Consumer implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前count：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}