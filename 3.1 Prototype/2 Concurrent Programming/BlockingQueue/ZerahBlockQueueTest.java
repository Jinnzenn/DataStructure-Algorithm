import java.util.*;
public class ZerahBlockQueueTest {
    public static void main(String[] args) {
        ZerahBlockQueue queue = new ZerahBlockQueue(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.add(i);
                System.out.println("拉个：" + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for(;;){
                System.out.println("屎壳郎开始工作，消费：" + queue.take());
                try {
                    Thread.sleep(800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
