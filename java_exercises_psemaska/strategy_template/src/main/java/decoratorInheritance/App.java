package decoratorInheritance;

public class App {

    public static void main(String[] args) {
        Greeter greeter = new GreeterImpl();
        System.out.println(greeter.greet("Jonas", "Jonauskas"));

        greeter = new GreeterExclamationMarkDecorator(greeter);
        System.out.println(greeter.greet("Jonas", "Jonauskas"));

        greeter = new GreeterUpperCaseDecorator(greeter);
        System.out.println(greeter.greet("Jonas", "Jonauskas"));

    }
}