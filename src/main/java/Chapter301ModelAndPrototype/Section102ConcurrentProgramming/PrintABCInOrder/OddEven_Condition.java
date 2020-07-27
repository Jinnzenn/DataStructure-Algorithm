package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.PrintABCInOrder;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven_Condition {
    private static Lock lock = new ReentrantLock();
    private static Condition odd = lock.newCondition();
    private static Condition even = lock.newCondition();
    private static int count = 0;
    static class ThreadOdd extends Thread{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try {
                    lock.lock();
                    while((count%2)!=1){
                        odd.await();
                    }
                    System.out.println("odd: " + count);
                    count++;
                    even.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class  ThreadEven extends Thread{
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try {
                    lock.lock();
                    while((count%2)!=0){
                        even.await();
                    }
                    System.out.println("Even: " + count);
                    count++;
                    odd.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        new ThreadOdd().start();
        new ThreadEven().start();
    }
}
