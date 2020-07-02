import java.util.*;

public class RealSimpleTheadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        RealSimpleThreadExecutor excutor = new RealSimpleThreadExecutor(3);

        for (int i = 0; i < 10; i++) {

            excutor.exec(new Runnable() {

                @Override

                public void run() {

                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");

                }

            });

        }

       excutor.shutdown();

    }

}