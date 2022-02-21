package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Stratege;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
