package template;

public class App {

    public static void main(String[] args) {
        Greeter greeter1 = new EnglishGreeter();
        Greeter greeter2 = new LithuanianGreeter();

        System.out.println(greeter1.getGreetingString("Jonas", "Jonaitis"));
        System.out.println(greeter2.getGreetingString("Egle", "Eglaite"));

    }
}
