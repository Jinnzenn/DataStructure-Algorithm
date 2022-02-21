package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.Singleton;

/**
 *
 为 uniqueInstance 分配内存空间
 初始化 uniqueInstance
 将 uniqueInstance 指向分配的内存地址
 
 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
 
 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 */
public class SingletonDoubleCheckLock {
    private volatile static SingletonDoubleCheckLock uniqueInstance;
    private String name;
    private int age;
    private SingletonDoubleCheckLock(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public static SingletonDoubleCheckLock getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDoubleCheckLock("唯一实例名", 25);
                }
            }
        }
        return uniqueInstance;
    }
    public static void main(String[] args){
        SingletonDoubleCheckLock theUniqueGuyA = SingletonDoubleCheckLock.getUniqueInstance();
        
        System.out.println(theUniqueGuyA.name + " " + theUniqueGuyA.age);
        
        SingletonDoubleCheckLock theUniqueGuyB = SingletonDoubleCheckLock.getUniqueInstance();
        
        System.out.println(theUniqueGuyB.name + " " + theUniqueGuyB.age);
    }
}
