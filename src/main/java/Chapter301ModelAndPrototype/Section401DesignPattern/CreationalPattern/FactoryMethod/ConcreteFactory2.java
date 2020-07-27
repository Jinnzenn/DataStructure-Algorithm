package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.FactoryMethod;

import Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.SimpleFactory.ConcreteProduct2;
import Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.SimpleFactory.Product;

public class ConcreteFactory2 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}