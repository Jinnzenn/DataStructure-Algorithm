package Chapter301ModelAndPrototype.Section401DesignPattern.BehavioralPattern.Iterator;

public interface Iterator<Item> {
    
    Item next();
    
    boolean hasNext();
}
