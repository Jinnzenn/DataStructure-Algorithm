package Chapter301Prototype.Section401DesignPattern.CreationalPattern.AbstractFactory;

public class ConcreteFactory2 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA2();
    }
    
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}