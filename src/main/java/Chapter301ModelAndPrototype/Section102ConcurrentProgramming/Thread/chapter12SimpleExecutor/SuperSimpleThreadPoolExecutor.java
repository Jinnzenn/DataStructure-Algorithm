package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.Thread.chapter12SimpleExecutor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingDeque;


/**
    * �̳߳��࣬�����߳�worker��Worker��ʵ��Thread
    */
public class SuperSimpleThreadPoolExecutor {
    private int workerNumber = 0;//�̳߳ش�С
	//�̳߳ص��̴߳����������ȡ����
    private BlockingDeque<Runnable> tasks;//�������У��������Runnableʵ�����������̳߳���ӵ��������Ƚ���������С�
	

    public SuperSimpleThreadPoolExecutor  (int workerNumber) {
        this.workerNumber = workerNumber;
        tasks = new LinkedBlockingDeque<>(10); //���10������
    }

    /**
     * �������
     * @param task
     */
    public void addTask (Runnable task) {
        tasks.offer(task);
    }

    /**
     * ��ʼ�̳߳�
     */
    public void start () {
        for (int i = 0; i < workerNumber; i++) {
            new Worker(tasks).start();//����Worker����ӵ��ָ��Ψһ�������е����ã����̳߳���ȡ��Runnableʵ������
        }
    }
    
    public static class Worker extends Thread {
	
        private BlockingDeque<Runnable> tasks;
    
        public Worker (BlockingDeque<Runnable> tasks) {
            this.tasks = tasks;
        }
    
        @Override
        public void run() {
			//����ȡ�ã����߿������ö�ʱ�رգ�count < 10������10��
			int count = 0;
            while (count < 10) {
                try {
                    Runnable task = tasks.poll(2, TimeUnit.SECONDS);
                    if (task != null) {
                        System.out.println("worker : " + getName() + " ��������");
                        task.run(); //ֱ��ִ��Runnable��run()���ﵽ�̸߳���
						
                        Thread.sleep(1000);
                    } else {
                        System.out.println("worker : " + getName() + " ��δ������");
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
        SuperSimpleThreadPoolExecutor  poolService = new SuperSimpleThreadPoolExecutor(3); //�̳߳��￪��3���߳�worker

        //�������
        for (int i = 0; i < 10; i++) {
            poolService.addTask(new Runnable() {
                @Override
                public void run() {
                    System.out.println("�����ţ�" + System.currentTimeMillis());
                }
            });
        }
        //��ʼ�̳߳�
        poolService.start();
	}
}
