package decorator;

public class GreeterUpperCaseDecorator implements Greeter{

    private Greeter greeter;

    public GreeterUpperCaseDecorator(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public String greet(String firstName, String lastName) {
        return greeter.greet(firstName.toUpperCase(), lastName.toUpperCase());
    }
}
