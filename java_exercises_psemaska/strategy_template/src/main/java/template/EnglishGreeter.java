package template;

public class EnglishGreeter extends Greeter{
    @Override
    protected String getGreetingString(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
