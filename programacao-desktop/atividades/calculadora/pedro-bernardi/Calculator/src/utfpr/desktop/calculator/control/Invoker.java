package utfpr.desktop.calculator.control;

public class Invoker {

    public void compute( Command command )
    {
        command.calculate();
    }
}