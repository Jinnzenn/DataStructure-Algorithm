package Chapter301Prototype.Section102ConcurrentProgramming.BlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreBlockingQueue{
	/**ʹ��semaphore�ź���ʵ�ּ򵥵���������*/
	
	//��ƾ����������ܵĶ���
	static class SemaphoreQueue{
		private List<Integer> valueList;
		private Semaphore putSema;//����put�������������
		private Semaphore getSema;//
		private Semaphore mutexPut;//�����ٽ�������ֹ�����̲߳���ȫ����
		private Semaphore mutexGet;//�����ٽ�������ֹ�����̲߳���ȫ����
		
		public SemaphoreQueue(int capacity){
			putSema = new Semaphore(capacity);
			getSema = new Semaphore(0);
			mutexPut = new Semaphore(1);
			mutexGet = new Semaphore(1);
			valueList = new ArrayList<Integer>(capacity);
		}
		
		public void put(Integer message){
			try{
				putSema.acquire();
				mutexPut.acquire();
				valueList.add(message);
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				mutexPut.release();
				getSema.release();
			}
		}
		public Integer take(){
			Integer message = null;
			try{
				getSema.acquire();
				mutexGet.acquire();
				//���ܳ��ֿն��У�����
				message = valueList.get(0);
				valueList.remove(0);
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				mutexGet.release();
				putSema.release();
			}
			return message;
		}
	}
	
	static class Producer extends Thread{
		SemaphoreQueue queue;
		int[] num;
		public Producer(SemaphoreQueue queue, int[] num){
			this.queue = queue;
			this.num = num;
		}
		
		public void run(){
			int produceCount = 0;
			try{
				while(num[0]<200){
					produceCount++;
					num[0]++;
					Integer message = new Integer(produceCount);
					queue.put(message);
					System.out.println(Thread.currentThread().getName() + "���������ۼ�������" + produceCount +"����Ϣ");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	static class Consumer extends Thread{
		SemaphoreQueue queue;
		int[] num;
		public Consumer(SemaphoreQueue queue, int[] num){
			this.queue = queue;
			this.num = num;
		}
		
		public void run(){
			int consumerCount = 0;
			try{
				while(num[0]<200){
					consumerCount++;
					num[0]++;
					Integer message = queue.take();
					System.out.println(Thread.currentThread().getName() + "���������ۼ�������" + consumerCount +"����Ϣ");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		SemaphoreQueue queue = new SemaphoreQueue(20);
		int num = 200;
		int[] pro = new int[] {0};
		int[] com = new int[] {0};
		Producer p1 = new Producer(queue, pro);
		Producer p2 = new Producer(queue, pro);
		Consumer c1 = new Consumer(queue, com);
		Consumer c2 = new Consumer(queue, com);
		p1.setName("p1"); p1.start();
		c1.setName("c1"); c1.start();
		
		p2.setName("p2");
		try {
			p2.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p2.start();
		c2.setName("c2");
		try {
			c2.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c2.start();
	}
	
	
}

