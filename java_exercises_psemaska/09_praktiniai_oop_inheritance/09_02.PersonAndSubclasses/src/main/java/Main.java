import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your test code here

        ArrayList<Person> persons = new ArrayList<>();

        System.out.println("*********** 1st PART ***************");
        System.out.println();
        Person person1 = new Person("Jonas", "Vilnius");
        persons.add(person1);
        Person person2 = new Person("Egle", "Kaunas");
        persons.add(person2);
        System.out.println(person1);
        System.out.println(person2);

        System.out.println();
        System.out.println("*********** 2nd PART ***************");
        System.out.println();

        Student student1 = new Student("Mantas", "Vilnius");
        persons.add(student1);
        System.out.println(student1);
        student1.study();
        System.out.println(student1);

        System.out.println();
        System.out.println("*********** 3rd PART ***************");
        System.out.println();

        Teacher teacher1 = new Teacher("Ada lovelace", "Vilnius", 1200);
        persons.add(teacher1);
        Teacher teacher2 = new Teacher("Esko ukkonen", "Kaunas", 5400);
        persons.add(teacher2);
        System.out.println(teacher1);
        System.out.println(teacher2);

        Student student2 = new Student("Ollie", "Kaunas");
        persons.add(student2);

        int i = 0;
        while(i < 25){
            student2.study();
            i++;
        }

        System.out.println(student2);

        System.out.println();
        System.out.println("*********** 4th PART ***************");
        System.out.println();

        printPersons(persons);

    }

    public static void printPersons(ArrayList<Person> persons){
        persons.forEach(person -> System.out.println(person));
    }
}
