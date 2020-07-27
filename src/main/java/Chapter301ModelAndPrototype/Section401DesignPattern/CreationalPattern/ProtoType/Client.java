package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.ProtoType;

public class Client {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(prototype.toString() + " " + prototype.hashCode());
        System.out.println(clone.toString() + " " + clone.hashCode());
        clone = prototype.myClone();
        System.out.println(clone.toString() + " " + clone.hashCode());
    }
}
