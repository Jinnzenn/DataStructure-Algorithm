import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreBlockingQueue{
	/**使用semaphore信号量实现简单的阻塞队列*/
	
	//设计具有阻塞功能的队列
	static class SemaphoreQueue{
		private List<Integer> valueList;
		private Semaphore putSema;//允许put操作的最大数量
		private Semaphore getSema;//
		private Semaphore mutexPut;//生成临界区，防止其他线程不安全操作
		private Semaphore mutexGet;//生成临界区，防止其他线程不安全操作
		
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
				//可能出现空队列？？？
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
					System.out.println(Thread.currentThread().getName() + "改生产者累计生产了" + produceCount +"条消息");
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
					System.out.println(Thread.currentThread().getName() + "该消费者累计消费了" + consumerCount +"条消息");
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
		
		p2.setName("p2"); p2.sleep(2000);p2.start();
		c2.setName("c2"); c2.sleep(20000);c2.start();
	}
	
	
}

