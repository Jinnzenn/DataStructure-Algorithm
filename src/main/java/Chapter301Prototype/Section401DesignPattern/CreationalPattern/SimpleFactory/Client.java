package Chapter301Prototype.Section401DesignPattern.CreationalPattern.SimpleFactory;

public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        // do something with the product
        System.out.println(product.toString() + " " + product.name);
    }
}
