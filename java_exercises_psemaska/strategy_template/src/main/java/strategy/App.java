package strategy;

public class App {

    public static void main(String[] args) {

        Greeter greetLT = new Greeter(new LithuanianGreetingStrategy());
        Greeter greetEN = new Greeter(new EnglishGreetingStrategy());

        System.out.println(greetLT.getGreetingString("Jonas", "Jonauskas"));
        System.out.println(greetEN.getGreetingString("Egle", "Eglaite"));

    }
}
