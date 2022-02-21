package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.FactoryMethod;

import Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.SimpleFactory.ConcreteProduct1;
import Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.SimpleFactory.Product;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory1();
        Product product = factory.factoryMethod();
        // do something with the product
        System.out.println(product.getClass() + ConcreteProduct1.id);
    }
}
