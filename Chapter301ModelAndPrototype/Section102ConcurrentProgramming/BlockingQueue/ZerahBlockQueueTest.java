package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.BlockingQueue;

public class ZerahBlockQueueTest {
    public static void main(String[] args) {
        ZerahBlockQueue queue = new ZerahBlockQueue(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.add(i);
                System.out.println("������" + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for(;;){
                System.out.println("ʺ���ɿ�ʼ���������ѣ�" + queue.take());
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
