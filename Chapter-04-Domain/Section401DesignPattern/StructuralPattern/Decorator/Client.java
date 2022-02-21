package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Decorator;

public class Client {
    
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());//不禁止套娃？？？
    }
}
