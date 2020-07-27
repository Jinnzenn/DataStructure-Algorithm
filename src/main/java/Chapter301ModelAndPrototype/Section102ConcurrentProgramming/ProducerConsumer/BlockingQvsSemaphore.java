package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.ProducerConsumer;

import java.util.concurrent.Semaphore;

public class BlockingQvsSemaphore {

    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Thread(new Producer()).start();  
		new Thread(new Producer()).start();  
		new Thread(new Producer()).start();  
        new Thread(new BConsumer()).start();
    }

}


class Signs{  
    static Semaphore empty=new Semaphore(10);
    static Semaphore full=new Semaphore(0);
    static Semaphore mutex=new Semaphore(1);
} 


class Producer implements Runnable{  
    @SuppressWarnings("static-access")
    public void run() {
        try {
            while (true) {
                Signs.empty.acquire(); // �ݼ��ֿ���ź����������Ѽ�������1
                Signs.mutex.acquire(); // �����ٽ���
                System.out.println("����һ����Ʒ����ֿ�");
                Signs.mutex.release(); // �뿪�ٽ���
                Signs.full.release(); // �����ֿ����ź�����������������1
                Thread.currentThread().sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class BConsumer implements Runnable{  
    @SuppressWarnings("static-access")
    public void run() {
        try {
            while (true) {
                Signs.full.acquire(); // �ݼ��ֿ����ź�����������������1
                Signs.mutex.acquire();
                System.out.println("===");
                Signs.mutex.release();
                Signs.empty.release(); // �����ֿ���ź����������Ѽ�������1
                Thread.currentThread().sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }  
   
}