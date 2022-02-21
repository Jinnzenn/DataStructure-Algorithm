package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Decorator;

public class Milk extends CondimentDecorator {
    
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
