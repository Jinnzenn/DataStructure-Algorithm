package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter9;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Levin
 * @date 2017-10-09.
 */
public class CaptureService {

    private final static LinkedList<Control> CONTROLS = new LinkedList<>();
    private final static int MAX_WORKER = 5;

    public static void main(String[] args) {
        Stream.of("T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9").map(name -> {
            Thread thread = createCaptureThread(name);
            thread.start();
            return thread;
        }).collect(toList()).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("所有采集任务已经完成").ifPresent(System.out::println);
    }

    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            Optional.of("[ " + Thread.currentThread().getName() + " ] 开始工作...").ifPresent(System.out::println);
            synchronized (CONTROLS) {
                while (CONTROLS.size() >= MAX_WORKER) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }
            Optional.of("[ " + Thread.currentThread().getName() + " ] 正在采集...").ifPresent(System.out::println);
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CONTROLS) {
                Optional.of("[ " + Thread.currentThread().getName() + " ] 采集完毕...").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);
    }
    private static final class Control {}
}
