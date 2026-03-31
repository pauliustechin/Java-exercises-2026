package decoratorInheritance;

public class GreeterUpperCaseDecorator extends Greeter{

    private Greeter greeter;

    public GreeterUpperCaseDecorator(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    String greet(String firstName, String lastName) {
        return greeter.greet(firstName.toUpperCase(), lastName.toUpperCase());
    }
}
