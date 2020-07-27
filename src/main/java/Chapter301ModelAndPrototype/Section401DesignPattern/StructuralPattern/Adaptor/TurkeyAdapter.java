package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Adaptor;

/**
 * 可以用Turkey冒充Duck
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;
    
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    
    @Override
    public void quack() {
        turkey.gobble();
    }
}
