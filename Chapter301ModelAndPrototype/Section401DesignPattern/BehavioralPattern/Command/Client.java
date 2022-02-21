package Chapter301ModelAndPrototype.Section401DesignPattern.BehavioralPattern.Command;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        invoker.setOnCommand(lightOnCommand, 0);
        invoker.setOffCommand(lightOffCommand, 0);
        invoker.onButtonWasPushed(1);
        invoker.offButtonWasPushed(1);
    }
}
