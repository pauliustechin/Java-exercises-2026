import java.util.ArrayList;

public class Room {

    ArrayList<Person> persons;

    public Room() {
        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public boolean isEmpty() {
        return persons.isEmpty();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Person shortest() {
        if(isEmpty()){
            return null;
        } else {
            Person shortestPerson = persons.get(0);
            for(int i = 1; i < persons.size(); i++) {
                if(shortestPerson.getHeight() > persons.get(i).getHeight()){
                    shortestPerson = persons.get(i);
                }
            }
            return shortestPerson;
        }
    }

    public Person take() {
        if(isEmpty()){
            return null;
        } else {
            Person shortestPerson = shortest();
            persons.remove(shortestPerson);
            return shortestPerson;
        }
    }
}
