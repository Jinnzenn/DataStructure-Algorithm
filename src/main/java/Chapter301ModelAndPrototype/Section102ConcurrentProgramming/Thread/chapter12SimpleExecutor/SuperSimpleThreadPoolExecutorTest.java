package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.Thread.chapter12SimpleExecutor;

public class SuperSimpleThreadPoolExecutorTest {

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