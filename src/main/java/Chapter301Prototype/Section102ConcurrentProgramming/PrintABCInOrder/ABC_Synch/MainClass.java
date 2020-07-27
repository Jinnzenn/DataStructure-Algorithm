package Chapter301Prototype.Section102ConcurrentProgramming.PrintABCInOrder.ABC_Synch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static class Print_Aoo implements Runnable{

		@Override
		public void run() {
			System.out.print("Aoo\n");
		}
	}
    public static class Print_Boo implements Runnable{

		@Override
		public void run() {
			System.out.print("Boo\n");
		}
	}
    public static class Print_Coo implements Runnable{

		@Override
		public void run() {
			System.out.print("Coo\n");
		}
	}
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int count = Integer.parseInt(line);
            ABC_Synch p = new ABC_Synch(count);
            Thread t1 = new Thread(){
                public void run() {
                    try {
                        p.aoo(new Print_Aoo());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
	    		}
	    	};
            Thread t2 =new Thread( ){
                public void run() {
                    try {
                        p.boo(new Print_Boo());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t3 =new Thread( ){
                public void run() {
                    try {
                        p.coo(new Print_Coo());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
            t2.start();
            t3.start();
            //t1.join();
            //t2.join();
            //t3.join();
            System.out.println("Finish");
            //String out = String.valueOf(ret);
            
            //System.out.print(out);
        }
    }
}