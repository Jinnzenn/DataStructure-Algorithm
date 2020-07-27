package Chapter301ModelAndPrototype.Section401DesignPattern.BehavioralPattern.Observer;

public interface Subject {
    void registerObserver(Observer o);
    
    void removeObserver(Observer o);
    
    void notifyObserver();
}
