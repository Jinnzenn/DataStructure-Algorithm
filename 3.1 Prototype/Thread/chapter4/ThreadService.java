package com.battcn.chapter4;

/**
 * @author Levin
 * @date 2017-09-18.
 */
public class ThreadService {

    public static void main(String[] args) {
        WorkerService service = new WorkerService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            try {
                Thread.sleep(3 * 1000);// TODO 模拟加载数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.listener(2 * 1000);
        System.out.println("一共耗时：" + (System.currentTimeMillis() - start));
    }

}

class WorkerService {
    private Thread executeService;
    private volatile boolean finished = false;

    public void execute(Runnable task) {
        executeService = new Thread(() -> {
            Thread runner = new Thread(task);
            runner.setDaemon(true);
            runner.start();
            try {
                runner.join();//前面已经说过join与守护线程了
                finished = true;
            } catch (InterruptedException e) {
                System.out.println("打断正在工作的线程......");
            }
        });
        executeService.start();
    }

    public void listener(long mills) {
        System.out.println("开启监听......");
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("工作耗时过长,开始打断...");
                executeService.interrupt();//打断线程
                break;
            }
            try {
                executeService.sleep(100L);//每隔100毫秒检测一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}