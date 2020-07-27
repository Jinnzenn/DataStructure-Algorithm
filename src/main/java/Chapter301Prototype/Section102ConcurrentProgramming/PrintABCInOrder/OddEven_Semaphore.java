package Chapter301Prototype.Section102ConcurrentProgramming.PrintABCInOrder;

import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class OddEven_Semaphore {
    private Semaphore semaOdd = new Semaphore(1);
    private Semaphore semaEven = new Semaphore(0);
    private volatile int count = 0;
    public class printOdd implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                try {
                    Thread.sleep(100);
                    semaOdd.acquire();
                    System.out.println("odd: " + count);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaEven.release();
                }
            }
        }
    }
    public class printEven implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                try {
                    Thread.sleep(100);
                    semaEven.acquire();
                    System.out.println("even: " + count);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaOdd.release();
                }
            }
        }
    }
    public static void main(String[] args){
        OddEven_Semaphore printer = new OddEven_Semaphore();
        new Thread(printer.new printOdd()).start();
        new Thread(printer.new printEven()).start();
        
        System.out.println("更简洁写法");
        OddEven_Semaphore printor = new OddEven_Semaphore();
        int cnt;
        Semaphore odd = new Semaphore(1);
        Semaphore even = new Semaphore(0);
        new Thread(()->{
            for(int i = 0; i < 100; i++){
                try {
                    Thread.sleep(100);
                    odd.acquire();
                    System.out.println("odd2: " + printor.count);
                    printor.count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    even.release();
                }
            }
        }).start();
        new Thread(()->{
            for(int i = 0; i < 100; i++){
                try {
                    Thread.sleep(100);
                    even.acquire();
                    System.out.println("even2: " + printor.count);
                    printor.count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    odd.release();
                }
            }
        }).start();
    }
}
