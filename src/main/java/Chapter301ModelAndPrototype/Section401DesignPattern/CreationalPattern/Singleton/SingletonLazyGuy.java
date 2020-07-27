package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.Singleton;

/**
 * 线程不安全
 */
public class SingletonLazyGuy {
    private static SingletonLazyGuy uniqueInstance;
    private String name;
    private int age;
    
    private SingletonLazyGuy(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public static SingletonLazyGuy getUniqueInstance() {
        //此处线程不安全
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazyGuy("唯一实例名", 25);
        }
        return uniqueInstance;
    }
    public static void main(String[] args){
        SingletonLazyGuy theUniqueGuyA = SingletonLazyGuy.getUniqueInstance();
        
        System.out.println(theUniqueGuyA.name + " " + theUniqueGuyA.age);
        
        SingletonLazyGuy theUniqueGuyB = SingletonLazyGuy.getUniqueInstance();
    
        System.out.println(theUniqueGuyB.name + " " + theUniqueGuyB.age);
    }
}
