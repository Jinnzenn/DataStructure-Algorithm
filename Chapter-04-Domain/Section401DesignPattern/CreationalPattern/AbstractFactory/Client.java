package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.AbstractFactory;

public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
        System.out.println(productA.getClass() + "  " + productB.getClass());
        // do something with productA and productB
        abstractFactory = new ConcreteFactory2();
        productA = abstractFactory.createProductA();
        productB = abstractFactory.createProductB();
        System.out.println(productA.getClass() + "  " + productB.getClass());
        
    }
}
