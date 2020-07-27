package Chapter301Prototype.Section102ConcurrentProgramming.Thread.chapter5;

/**
 * @author Levin
 * @date 2017-09-23.
 */
class Bank1 {
    synchronized static void transferAccount() {
        System.out.println("开始转账：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("转账完毕");
    }

    synchronized static void debit() {
        System.out.println("开始扣款：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("扣款完毕");
    }
}


class Bank2 implements Runnable {

    @Override
    public synchronized void run() {
        System.out.println("查询数据：" + Thread.currentThread().getName());
        System.out.println("开始转账：" + Thread.currentThread().getName());
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("转账完毕");
    }
}


class Bank3 implements Runnable {
    private final byte[] LOCK = new byte[0]; // 特殊的实例化变量

    @Override
    public void run() {
        System.out.println("查询数据：" + Thread.currentThread().getName());
        synchronized (LOCK) {//该种方式只能锁
            System.out.println("开始转账：" + Thread.currentThread().getName());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("转账完毕");
        }
    }
}

class Bank4 implements Runnable {

    @Override
    public void run() {
        System.out.println("查询数据：" + Thread.currentThread().getName());
        synchronized (Bank4.class) {
            System.out.println("开始转账：" + Thread.currentThread().getName());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("转账完毕");
        }
    }
}


class Bank5 {
    synchronized static void add() {
        System.out.println("添加数据：" + Thread.currentThread().getName());
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("添加完毕");
    }

    void transferAccount() {
        synchronized (this) {
            System.out.println("开始转账：" + Thread.currentThread().getName());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("转账完毕");
        }
    }
}


public class BankMain {

    public static void main(String[] args) {
//        new Thread(Bank1::transferAccount, "北京银行").start();
//        new Thread(Bank1::debit, "上海银行").start();

//        Bank2 bank2 = new Bank2();
//        new Thread(bank2, "北京银行").start();
//        new Thread(bank2, "上海银行").start();

//        Bank3 bank3 = new Bank3();
//        new Thread(bank3, "北京银行").start();
//        new Thread(bank3, "上海银行").start();
//
//        new Thread(new Bank4(), "北京银行").start();
//        new Thread(new Bank4(), "上海银行").start();


//        Bank5 bank5 = new Bank5();
//        new Thread(bank5::transferAccount, "北京银行").start();
//        new Thread(() -> bank5.add(), "上海银行").start();
    }

}
