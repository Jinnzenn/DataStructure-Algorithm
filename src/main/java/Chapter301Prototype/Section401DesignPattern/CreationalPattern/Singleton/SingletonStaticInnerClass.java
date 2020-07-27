package Chapter301Prototype.Section401DesignPattern.CreationalPattern.Singleton;

/**
 * 当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。
 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时
 * SingletonHolder 才会被加载，此时初始化 INSTANCE 实例，
 * 并且 JVM 能确保 INSTANCE 只被实例化一次。
 */
public class SingletonStaticInnerClass {
    private String name;
    private int age;
    private SingletonStaticInnerClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    private static class SingletonHolder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass("唯一实例名", 25);
    }
    
    public static SingletonStaticInnerClass getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
    public static void main(String[] args){
        SingletonStaticInnerClass theUniqueGuyA = SingletonStaticInnerClass.getUniqueInstance();
        
        System.out.println(theUniqueGuyA.name + " " + theUniqueGuyA.age);
        
        SingletonStaticInnerClass theUniqueGuyB = SingletonStaticInnerClass.getUniqueInstance();
        
        System.out.println(theUniqueGuyB.name + " " + theUniqueGuyB.age);
    }
}
