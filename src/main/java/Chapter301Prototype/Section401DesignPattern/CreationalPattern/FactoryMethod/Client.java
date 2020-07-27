package Chapter301Prototype.Section401DesignPattern.CreationalPattern.FactoryMethod;

import Chapter301Prototype.Section401DesignPattern.CreationalPattern.SimpleFactory.ConcreteProduct1;
import Chapter301Prototype.Section401DesignPattern.CreationalPattern.SimpleFactory.Product;
import Chapter301Prototype.Section401DesignPattern.CreationalPattern.SimpleFactory.SimpleFactory;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory1();
        Product product = factory.factoryMethod();
        // do something with the product
        System.out.println(product.getClass() + ConcreteProduct1.id);
    }
}
