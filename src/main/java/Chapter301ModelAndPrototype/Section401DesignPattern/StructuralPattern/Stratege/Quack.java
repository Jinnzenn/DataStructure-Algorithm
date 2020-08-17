package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Stratege;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
