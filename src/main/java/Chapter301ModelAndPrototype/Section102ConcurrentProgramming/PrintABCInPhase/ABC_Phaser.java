package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.PrintABCInPhase;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
 

public class ABC_Phaser extends Phaser {
 
	@Override
	protected boolean onAdvance(int phase, int registeredParties) {	//��ÿ���׶�ִ����ɺ�ص��ķ���
		
		switch (phase) {
		case 0:
			return studentArrived();
		case 1:
			return finishFirstExercise();
		case 2:
			return finishSecondExercise();
		case 3:
			return finishExam();
		default:
			return true;
		}
		
	}
	
	private boolean studentArrived(){
		System.out.println("ѧ��׼������,ѧ��������"+getRegisteredParties());
		return false;
	}
	
	private boolean finishFirstExercise(){
		System.out.println("��һ������ѧ������");
		return false;
	}
	
	private boolean finishSecondExercise(){
		System.out.println("�ڶ�������ѧ������");
		return false;
	}
	
	private boolean finishExam(){
		System.out.println("����������ѧ�����꣬��������");
		return true;
	}
	
 
	public static class StudentTask implements Runnable {
	 
		private Phaser phaser;
		
		public StudentTask(Phaser phaser) {
			this.phaser = phaser;
		}
	 
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"���￼��");
			phaser.arriveAndAwaitAdvance();
			
			System.out.println(Thread.currentThread().getName()+"����1��ʱ��...");
			doExercise1();
			System.out.println(Thread.currentThread().getName()+"����1�����...");
			phaser.arriveAndAwaitAdvance();
			
			System.out.println(Thread.currentThread().getName()+"����2��ʱ��...");
			doExercise2();
			System.out.println(Thread.currentThread().getName()+"����2�����...");
			phaser.arriveAndAwaitAdvance();
			
			System.out.println(Thread.currentThread().getName()+"����3��ʱ��...");
			doExercise3();
			System.out.println(Thread.currentThread().getName()+"����3�����...");
			phaser.arriveAndAwaitAdvance();
		}
	 
		private void doExercise1() {
			long duration = (long)(Math.random()*10);
			try {
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private void doExercise2() {
			long duration = (long)(Math.random()*10);
			try {
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private void doExercise3() {
			long duration = (long)(Math.random()*10);
			try {
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��Ŀ��5��ѧ���μӿ��ԣ�һ���������⣬Ҫ������ѧ��������ܿ�ʼ����
	 * ��ȫ�������һ�⣬���ܼ������ڶ��⣬�������ơ�
	 * 
	 * Phaser��phase��party������Ҫ״̬��
	 * phase��ʾ�׶Σ�party��ʾÿ���׶ε��̸߳�����
	 * ֻ��ÿ���̶߳�ִ����phaser.arriveAndAwaitAdvance();
	 * �Ż������һ���׶Σ����������ȴ���
	 * ������Ŀ��5��ѧ��(�߳�)������phaser.arriveAndAwaitAdvance();�ͽ�����һ��
	 * @author liujun
	 */
	public static void main(String[] args) {
		ABC_Phaser phaser = new ABC_Phaser();
		StudentTask[] studentTask = new StudentTask[5];
		
		//�½�5���߳�����Runnable����5��ѧ����Override run() ��ƶ������Ϊ������ͬһ��phaser��
		for (int i = 0; i < studentTask.length; i++) {
			studentTask[i] = new StudentTask(phaser);
			phaser.register();	//ע��һ�α�ʾphaserά�����̸߳���
		}
		
		//�����̣߳�5���߳�ͬʱ����ͬһ��phaser������
		//phaser����5���̵߳�run����
		Thread[] threads = new Thread[studentTask.length];
		for (int i = 0; i < studentTask.length; i++) {
			threads[i] = new Thread(studentTask[i], "Student "+i);
			threads[i].start();
		}
		
		//�ȴ������߳�ִ�н���
		for (int i = 0; i < studentTask.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Phaser has finished:"+phaser.isTerminated());
		
	}
}