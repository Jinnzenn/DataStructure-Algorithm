package Chapter301Prototype.Section401DesignPattern.CreationalPattern.Singleton;

public class SingletonHungerGuy {
    //没有延迟实例化，没有节约内存资源
    private static SingletonHungerGuy uniqueInstance = new SingletonHungerGuy("唯一实例名", 25);
    private String name;
    private int age;
    public static SingletonHungerGuy getUniqueInstance() {
        return uniqueInstance;
    }
    public SingletonHungerGuy(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args){
        SingletonHungerGuy theUniqueGuyA = SingletonHungerGuy.getUniqueInstance();
        System.out.println(theUniqueGuyA.name + " " + theUniqueGuyA.age);
        SingletonHungerGuy theUniqueGuyB = SingletonHungerGuy.getUniqueInstance();
        System.out.println(theUniqueGuyB.name + " " + theUniqueGuyB.age);
    }
}
