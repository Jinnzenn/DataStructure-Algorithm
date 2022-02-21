package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Stratege;

public class Duck {
    
    private QuackBehavior quackBehavior;
    
    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }
    
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
