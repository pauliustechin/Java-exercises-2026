package decoratorInheritance;

public class GreeterImpl extends Greeter{

    @Override
    String greet(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
