package Chapter301ModelAndPrototype.Section401DesignPattern.BehavioralPattern.Command;

public class LightOnCommand implements Command {
    Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.on();
    }
}
