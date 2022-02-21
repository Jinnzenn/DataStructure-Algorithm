package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.ProducerConsumer;

/**
 * �����ߺ������ߣ�wait()��notify()��ʵ��
 * @author ZGJ
 * @date 2017��6��22��
 */
public class WaitAndNotifyImple{
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";
    
    public static void main(String[] args) {
        WaitAndNotifyImple test = new WaitAndNotifyImple();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "������������Ŀǰ�ܹ���" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "���������ѣ�Ŀǰ�ܹ���" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}