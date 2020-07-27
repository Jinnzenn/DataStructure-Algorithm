package Chapter301Prototype.Section401DesignPattern.CreationalPattern.FactoryMethod;

import Chapter301Prototype.Section401DesignPattern.CreationalPattern.SimpleFactory.ConcreteProduct;
import Chapter301Prototype.Section401DesignPattern.CreationalPattern.SimpleFactory.Product;

public class ConcreteFactory extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
