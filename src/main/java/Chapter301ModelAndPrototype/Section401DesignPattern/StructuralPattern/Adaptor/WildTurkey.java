package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Adaptor;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble!");
    }
}
