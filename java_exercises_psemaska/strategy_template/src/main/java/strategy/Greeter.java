package strategy;

public class Greeter {

    GreetingLanguageStrategy greetingLanguageStrategy;

    public Greeter(GreetingLanguageStrategy greetingLanguageStrategy) {
        this.greetingLanguageStrategy = greetingLanguageStrategy;
    }

    public String getGreetingString(String firstName, String lastName) {
        return greetingLanguageStrategy.getGreetingString() + " " + firstName + " " + lastName;
    }
}
