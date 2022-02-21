package Chapter301ModelAndPrototype.Section102ConcurrentProgramming.Thread.chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 具体观察者对象
 */
class ObserverListener implements Observer {
    /**
     * 避免多线程锁竞争
     */
    private static final Object LOCK = new Object();

    @Override
    public void update(Observable observable, Object runnableEvent) {
        synchronized (LOCK) {
            ObservableRunnable.RunnableEvent event = (ObservableRunnable.RunnableEvent) runnableEvent;
            if (event != null) {
                if (event.getCause() != null) {
                    System.out.println("The Runnable [" + event.getThread().getName() + "] process failed and state is " + event.getState().name());
                    event.getCause().printStackTrace();
                } else {
                    System.out.println("The Runnable [" + event.getThread().getName() + "] data changed and state is " + event.getState().name());
                }
            }
        }
    }
}


class ObservableRunnable extends Observable implements Runnable {

    /**
     * 线程名称
     */
    private String name;

    ObservableRunnable(String name, ObserverListener listener) {
        this.name = name;
        super.addObserver(listener);
    }

    /**
     * 发送通知
     *
     * @param event 通知的内容
     */
    private void notifyChange(final RunnableEvent event) {
        // 前面说过 JDK自带的 需要每次设置一次状态,代表当前内容更改了
        super.setChanged();
        super.notifyObservers(event);
    }

    @Override
    public void run() {
        try {
            notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
            System.out.printf("根据 [%s] 查询 \n", this.name);
            Thread.sleep(1000L);
            if (this.name.equals("T3")) {
                // 故意模拟报错
                throw new RuntimeException("故意抛出错误");
            }
            notifyChange(new RunnableEvent(RunnableState.DOWN, Thread.currentThread(), null));
        } catch (Exception e) {
            notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
        }
    }

    enum RunnableState {
        /**
         * RUNNING：运行
         * ERROR：异常
         * DOWN：正常结束
         */
        RUNNING, ERROR, DOWN
    }

    static class RunnableEvent {
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        Throwable getCause() {
            return cause;
        }
    }
}

/**
 * @author Levin
 * @date 2017-12-14.
 */
public class ObserverClient {

    public static void main(String[] args) {
        ObserverListener listener = new ObserverListener();
        List<String> names = Arrays.asList("T1", "T2", "T3");
        for (String name : names) {
            Thread thread = new Thread(new ObservableRunnable(name, listener));
            thread.start();
        }
    }
}
