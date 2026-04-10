import java.util.ArrayList;
import java.util.List;

public class MainProgram {

    public static void main(String[] args) {
        Employees<Object> empl = new Employees();
        Person person1 = new Person("john", Education.BA);
        Person person2 = new Person("ana", Education.BA);
        Person person3 = new Person("mantas", Education.HS);
        List<Person> ppl = new ArrayList<>();
        ppl.add(person2);
        ppl.add(person3);
        empl.add(person1);
        empl.add(ppl);
        empl.print();
        empl.fire(Education.BA);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        empl.print(Education.HS);
    }
}
