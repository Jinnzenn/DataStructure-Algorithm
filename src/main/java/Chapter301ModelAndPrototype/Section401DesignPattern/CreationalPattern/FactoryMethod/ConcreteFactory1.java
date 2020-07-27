package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.FactoryMethod;

import Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.SimpleFactory.ConcreteProduct1;
import Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.SimpleFactory.Product;

public class ConcreteFactory1 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
