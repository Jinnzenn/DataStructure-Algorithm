import java.util.*;

public class ZerahBlockQueue {
    //队列容器
    private List<Integer> container = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    //Condition
    //  队列为空
    private Condition isNull = lock.newCondition();
    // 队列已满
    private Condition isFull = lock.newCondition();
    private volatile int size;
    private volatile int capacity;

    ZerahBlockQueue(int cap) {
        this.capacity = cap;
    }
        
    public void add(int data) {
        try {
            lock.lock();
            try {
                while (size >= capacity) {
                    System.out.println("队列已满，释放锁，等待消费者消费数据");
                    isFull.await();
                }
            } catch (InterruptedException e) {
                isFull.signal();
                e.printStackTrace();
            }
            ++size;
            container.add(data);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    public int take(){
        try {
            lock.lock();
            try {
                while (size == 0){
                    System.out.println("阻塞队列空了，释放锁，等待生产者生产数据");
                    isNull.await();
                }
            }catch (InterruptedException e){
                isFull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res ;
        }finally {
            lock.unlock();
        }
    }


}
