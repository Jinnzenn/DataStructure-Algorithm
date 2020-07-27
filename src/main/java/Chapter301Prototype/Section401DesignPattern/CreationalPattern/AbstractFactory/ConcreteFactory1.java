package Chapter301Prototype.Section401DesignPattern.CreationalPattern.AbstractFactory;

public class ConcreteFactory1 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA1();
    }
    
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}