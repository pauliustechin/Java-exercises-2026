package decoratorInheritance;

public class GreeterExclamationMarkDecorator extends Greeter{

    Greeter greeter;

    public GreeterExclamationMarkDecorator(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    String greet(String firstName, String lastName) {
        return greeter.greet(firstName, lastName) + "!";
    }
}
