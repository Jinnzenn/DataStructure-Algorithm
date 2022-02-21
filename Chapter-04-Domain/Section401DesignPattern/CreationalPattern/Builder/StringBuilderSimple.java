package Chapter301ModelAndPrototype.Section401DesignPattern.CreationalPattern.Builder;

public class StringBuilderSimple extends AbstractStringBuilderSimple {
    public StringBuilderSimple() {
        super(16);
    }
    
    @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }
}
