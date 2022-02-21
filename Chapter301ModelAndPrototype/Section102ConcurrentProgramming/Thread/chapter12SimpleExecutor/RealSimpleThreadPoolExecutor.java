package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.Thread.chapter12SimpleExecutor;
/**
 * 实现简单的线程池，体现线程复用
 * 
 * 1.   线程池里的核心线程数与最大线程数
 * 2.   线程池里真正工作的线程类worker
 * 3.   线程池里用来存取任务的队列
 * 4.   线程中的任务类task
 */
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RealSimpleThreadPoolExecutor {
    /**
     * 线程池的几个要素
     * */
    
    //最大工作线程数
    int poolSize = 10;
    //核心线程数（创建了多少个工作线程）
    int coreSize = 0;
    //存取任务的队列
    private static BlockingQueue<Runnable> queueTask = null;
    //池里的workers
    private final HashSet<Worker> workers = new HashSet<Worker>();
    //放置worker里的工作线程
    private final List<Thread> threadList = new ArrayList<Thread>();


    //标记线程池是否在运行
    private volatile boolean RUNNING = true;
    //标记线程是否被中断关闭
    boolean shutdown = false;

    /**
     * 创建线程池
     * @param poolSize
     */
    public RealSimpleThreadPoolExecutor(int poolSize){
        this.poolSize = poolSize;
        queueTask = new LinkedBlockingQueue<Runnable>(poolSize);//排队等待队列
    }



    /**
     * 任务提交和执行
     * @param runnable
     */

    public void exec(Runnable runnable) {
        //如果任务为空，抛空异常
        if (runnable == null) throw new NullPointerException();

        if(coreSize < poolSize){
            addThread(runnable);//如果线程池未满，任务加入线程池并执行
        }else{
            System.out.println("offer"+  runnable.toString() + "   " + queueTask.size());//如果线程池已满，任务加入等待队列
            try {
                queueTask.put(runnable);//采用put()，如果任务队列已满，会阻塞等待。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //增加线程并执行任务
    public void addThread(Runnable runnable){
        coreSize++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        try {
            t.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭线程池
     */
    public void shutdown() {
        RUNNING = false;
        if(!workers.isEmpty()){
            for (Worker worker : workers){
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    


    
    
    /**
     * 定义一个内部类Worker，这个内部类Worker是用来执行每个任务的，在创建线程池后，往线程里添加任务，每个任务都是由Worker一个一个来启动的。
     */
    
    public class Worker implements Runnable{
        //分配任务时，不是直接执行，而是先加入任务队列
        public Worker(Runnable runnable){
            queueTask.offer(runnable);
        }

        @Override
        public void run() {
           while (true && RUNNING){//确认线程池还在运行
                if(shutdown == true){
                    Thread.interrupted();//如果线程池执行关闭，采用interrupted()方法中断线程
                }
                Runnable task = null;
                try {
                    task = getTask();//如果线程池未关闭，从任务队列中取任务执行
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queueTask.take();
        }
        
        //能够关闭闲置的线程
        public void interruptIfIdle() {
            for (Thread thread : threadList ) {
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        
        RealSimpleThreadPoolExecutor excutor = new RealSimpleThreadPoolExecutor(3);
        
        for (int i = 0; i < 10; i++) {
            
            excutor.exec(new Runnable() {
                
                @Override
                
                public void run() {
                    
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");
                    
                }
                
            });
            
        }
        
        excutor.shutdown();
        
    }
 }



    