import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.System.out;

public class LeetCode1114 {
	private AtomicInteger firstJobDone = new AtomicInteger(0);
	private AtomicInteger secondJobDone = new AtomicInteger(0);

	public LeetCode1114() {
	}

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first".
		printFirst.run();
		// mark the first job as done, by increasing its count.
		firstJobDone.incrementAndGet();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (firstJobDone.get() != 1) {
			// waiting for the first job to be done.
		}
		// printSecond.run() outputs "second".
		printSecond.run();
		// mark the second as done, by increasing its count.
		secondJobDone.incrementAndGet();
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (secondJobDone.get() != 1) {
			// waiting for the second job to be done.
		}
		// printThird.run() outputs "third".
		printThird.run();
	}
	public static void main(String[] args) {
		LeetCode1114 foo = new LeetCode1114();
		Runnable printer1 = new Runnable() {
			@Override
			public void run() {
				out.print("one");
			}
		};
		Runnable printer2 = new Runnable() {
			@Override
			public void run() {
				out.print("two");
			}
		};
		Runnable printer3 = new Runnable() {
			@Override
			public void run() {
				out.print("three");
			}
		};
		try {
			foo.first(printer1);
			foo.second(printer2);
			foo.third(printer3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}