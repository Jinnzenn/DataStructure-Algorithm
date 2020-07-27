package Chapter301Prototype.Section102ConcurrentProgramming.ProducerConsumer;

import java.util.concurrent.*;
import java.util.*;
class DiningPhilosophers {

    private volatile Semaphore[] forks = new Semaphore[]{
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
    };

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftForkNo = philosopher;
        int rightForkNo = (philosopher + 1) % 5;

        if (philosopher % 2 == 0) {
            forks[leftForkNo].acquire();
            pickLeftFork.run();

            forks[rightForkNo].acquire();
            pickRightFork.run();
        } else {
            forks[rightForkNo].acquire();
            pickRightFork.run();

            forks[leftForkNo].acquire();
            pickLeftFork.run();
        }

        eat.run();

        putLeftFork.run();
        forks[leftForkNo].release();

        putRightFork.run();
        forks[rightForkNo].release();
    }
	public class DiningPhilosophersTest {

		//@Rule
		//public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

		//@Test
		public void main() throws InterruptedException {
			DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

			List<int[]> output = new CopyOnWriteArrayList<>();
			List<Thread> philosophers = new ArrayList<>();

			int peopleNum = 5;
			int eatTime = 1;

			for (int i = 0; i < peopleNum; i++) {
				int philosopherNum = i;
				Thread philosopher = new Thread(new Runnable() {
					//@SneakyThrows
					@Override
					public void run() {
						for (int j = 0; j < eatTime; j++) {
							try {
								diningPhilosophers.wantsToEat(
                                        philosopherNum,
                                        () -> output.add(new int[]{philosopherNum, 1, 1}),
                                        () -> output.add(new int[]{philosopherNum, 2, 1}),
                                        () -> output.add(new int[]{philosopherNum, 0, 3}),
                                        () -> output.add(new int[]{philosopherNum, 1, 2}),
                                        () -> output.add(new int[]{philosopherNum, 2, 2})
                                );
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
				philosophers.add(philosopher);
				philosopher.start();
			}

			for (Thread philosopher : philosophers) {
				philosopher.join();
			}

			HashMap<Integer, Boolean> forkMap = new HashMap<>();

			for (int[] action : output) {
				int id = action[0];
				int side = action[1];
				int move = action[2];

				// pick up
				if (move == 1) {
					int forkNo = id + side;
					if (forkNo == peopleNum + 1) {
						forkNo = 1;
					}
					Boolean occupied = forkMap.getOrDefault(forkNo, false);
					if (occupied) {
						//fail("the " + forkNo + "th fork is occupied !");
						System.out.println("the " + forkNo + "th fork is occupied !");
					}
					forkMap.put(forkNo, true);
				}

				// put down
				if (move == 2) {
					int forkNo = id + side;
					if (forkNo == peopleNum + 1) {
						forkNo = 1;
					}
					Boolean occupied = forkMap.getOrDefault(forkNo, false);
					if (!occupied) {
						//fail("the " + forkNo + "th fork is not yours !");
						System.out.println("the " + forkNo + "th fork is not yours !");
					}
					forkMap.put(forkNo, false);
				}
			}
		}

	}
}
