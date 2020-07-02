/**
choice4
2019-03-01 19:11:56 +08:00
为了提升性能，线程里面有工作内存，这样访问数据不用去主存读取，可以快一些。共享变量被线程修改后，该线程的工作内存中的值就会和其他线程不一致，也和主存的值不一致，所以需要将工作内存的值刷入主存，但是这个刷入可能其他线程并没有看到。使用 volatile 后可以通过 cpu 指令屏障强制要求读操作发生在写操作之后，并且其他线程在读取该共享变量时，需要先清理自己的工作内存的该值，转而重新从主存读取，volatile 保证一定会刷新，但是不写也不一定其他线程看不见。
就是上面大哥说的巧合（即这种不一定每次都会有正确的保障）
https://www.v2ex.com/amp/t/539969/2
**/
public class ThreadTest1 {
	
    private int flag = 0;
    public void first(Runnable printFirst) throws InterruptedException {
            //如果flag不为0则让first线程等待，while循环控制first线程如果不满住条件就一直在while代码块中，防止出现中途跳入，执行下面的代码，其余线程while循环同理
            while( flag != 0){
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            //定义成员变量为 1
            flag = 1;
            //唤醒其余所有的线程
    }
    public void second(Runnable printSecond) throws InterruptedException {
            //如果成员变量不为1则让二号等待
            while (flag != 1){
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            //如果成员变量为 1 ，则代表first线程刚执行完，所以执行second，并且改变成员变量为 2
            flag = 2;
            //唤醒其余所有的线程
    }
    public void third(Runnable printThird) throws InterruptedException {
            //如果flag不等于2 则一直处于等待的状态
            while (flag != 2){
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            //如果成员变量为 2 ，则代表second线程刚执行完，所以执行third，并且改变成员变量为 0
            printThird.run();
            flag = 0;
    }

    public static void main(String[] args) {
        ThreadTest1 threadTest = new ThreadTest1();
        Thread thread1 = new Thread(()->{
            try {
				for(int i = 1; i < 100; i++){
					
					threadTest.first(()->{
						System.out.println("one");
					});
				}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
				for(int i = 1; i < 100; i++){
					threadTest.second(()->{
						System.out.println("two");
					});
				}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()->{
            try {
				for(int i = 1; i < 100; i++){
					threadTest.third(()->{
						System.out.println("three");
					});
				}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        thread1.start();
        thread2.start();
    }
}