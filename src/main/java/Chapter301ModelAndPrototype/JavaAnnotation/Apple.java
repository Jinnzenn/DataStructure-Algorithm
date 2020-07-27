package Chapter301ModelAndPrototype.JavaAnnotation;

public class Apple {
    @FruitProvider(id = 1, name = "红富士", address = "陕西")
    private String appleProviderA;
    @FruitProvider(id = 2, name = "金克拉", address = "江西")
    private String appleProviderB;
    public Apple(){}

    public String getAppleProviderA() {
        return appleProviderA;
    }

    public void setAppleProviderA(String appleProviderA) {
        this.appleProviderA = appleProviderA;
    }

    public String getAppleProviderB() {
        return appleProviderB;
    }

    public void setAppleProviderB(String appleProviderB) {
        this.appleProviderB = appleProviderB;
    }
}
