package Chapter301ModelAndPrototype.Section401DesignPattern.BehavioralPattern.ChainOfResponsibility;

public class Client {
    
    public static void main(String[] args) {
        
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);//关键代码，形成责任链条
        
        Request request1 = new Request(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);//注意，两次都是向handler2中传入请求，但最后处理request的handler不固定
        
        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }
}
