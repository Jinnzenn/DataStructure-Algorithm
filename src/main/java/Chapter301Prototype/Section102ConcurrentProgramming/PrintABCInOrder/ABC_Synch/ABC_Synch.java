package Chapter301Prototype.Section102ConcurrentProgramming.PrintABCInOrder.ABC_Synch;

class ABC_Synch {
    private int n;
    private volatile int word = 0;
    private Object lock = new Object();
    public ABC_Synch(int n) {
        this.n = n;
    }

    public void aoo(Runnable printAoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            synchronized(lock) {
                while (word%3 != 0 ) lock.wait();//让出锁
                word++;
                System.out.println(word);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printAoo.run();
                lock.notifyAll();
            }
        }
    }

    public void boo(Runnable printBoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            synchronized(lock) {
                while (word%3 != 1) lock.wait();
                word++;
                System.out.println(word);
                // printBar.run() outputs "bar". Do not change or remove this line.
        	    printBoo.run();
                lock.notifyAll();
            }
        }
    }
    public void coo(Runnable printCoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            synchronized(lock) {
                while  (word%3 != 2) lock.wait();
                word++;
                System.out.println(word);
                // printBar.run() outputs "bar". Do not change or remove this line.
        	    printCoo.run();
                lock.notifyAll();
            }
        }
    }
}