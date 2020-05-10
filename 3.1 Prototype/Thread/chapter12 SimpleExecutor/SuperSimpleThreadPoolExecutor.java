import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingDeque;


/**
    * 线程池类，管理线程worker，Worker其实是Thread
    */
public class SuperSimpleThreadPoolExecutor {
    private int workerNumber = 0;//线程池大小
    private BlockingDeque<Runnable> tasks;//阻塞队列，用来存放Runnable实例，所有向线程池添加的任务首先进入线程池

    public SuperSimpleThreadPoolExecutor  (int workerNumber) {
        this.workerNumber = workerNumber;
        tasks = new LinkedBlockingDeque<>(10); //最多10个任务
    }

    /**
     * 添加任务
     * @param task
     */
    public void addTask (Runnable task) {
        tasks.offer(task);
    }

    /**
     * 开始线程池
     */
    public void start () {
        for (int i = 0; i < workerNumber; i++) {
            new Worker(tasks).start();//所有Worker对象都拥有指向唯一阻塞队列的引用，从线程池中取出Runnable实例运行
        }
    }
    
    public static class Worker extends Thread {
	
        private BlockingDeque<Runnable> tasks;
    
        public Worker (BlockingDeque<Runnable> tasks) {
            this.tasks = tasks;
        }
    
        @Override
        public void run() {
			//无限取用，或者可以设置定时关闭
			int count = 0;
            while (count < 10) {
                try {
                    Runnable task = tasks.poll(2, TimeUnit.SECONDS);
                    if (task != null) {
                        System.out.println("worker : " + getName() + " 有新任务");
                        task.run(); //直接执行Runnable的run()，达到线程复用
						
                        Thread.sleep(1000);
                    } else {
                        System.out.println("worker : " + getName() + " 暂未有任务");
                        Thread.sleep(1000);
                    }
					count++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
    
            }
        }
    }
	
	
	public static void main (String[] args) {
        SuperSimpleThreadPoolExecutor  poolService = new SuperSimpleThreadPoolExecutor(3); //线程池里开启3个线程worker

        //添加任务
        for (int i = 0; i < 10; i++) {
            poolService.addTask(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务编号：" + System.currentTimeMillis());
                }
            });
        }
        //开始线程池
        poolService.start();
	}
}
