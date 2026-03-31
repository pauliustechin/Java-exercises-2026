package template;

public class LithuanianGreeter extends Greeter{

    @Override
    protected String getGreetingString(String firstName, String lastName) {
        return "Labas " + firstName + " " + lastName;
    }
}
