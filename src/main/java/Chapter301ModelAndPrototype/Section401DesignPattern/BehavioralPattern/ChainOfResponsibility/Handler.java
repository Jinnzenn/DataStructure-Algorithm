package Chapter301ModelAndPrototype.Section401DesignPattern.BehavioralPattern.ChainOfResponsibility;

public abstract class Handler {
    
    protected Handler successor;
    
    
    public Handler(Handler successor) {
        this.successor = successor;
    }
    
    
    protected abstract void handleRequest(Request request);
}
