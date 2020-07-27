package Chapter301ModelAndPrototype.Section401DesignPattern.StructuralPattern.Adaptor;

public class Client {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();
    }
}
