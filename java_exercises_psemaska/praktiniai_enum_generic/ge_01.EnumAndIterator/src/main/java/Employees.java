import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees<T>{

    List<T> employees = new ArrayList<>();

    public void add(Person personToAdd) {
        employees.add((T) personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        employees.add((T) peopleToAdd);
    }

    public void print() {
        for(T obj : employees) {
            if(obj instanceof List) {
                Iterator<Person> it = ((List) obj).iterator();
                while(it.hasNext()) {
                    System.out.println(it.next());
                }
            } else {
                System.out.println(obj);
            }
        }
    }

    public void print(Education education) {
        for(T obj : employees) {
            if(obj instanceof List) {
                Iterator<Person> it = ((List<Person>) obj).iterator();
                while(it.hasNext()) {
                    Person person = it.next();
                    if(person.getEducation() == education) {
                        System.out.println(person);
                    }
                }
            } else {
                Person person = (Person) obj;
                if(person.getEducation() == education) {
                    System.out.println(person);
                }
            }
        }
    }

    public void fire(Education education) {

        List<Person> tempList = new ArrayList<>();

        for(T obj : employees) {
            if(obj instanceof List) {
                Iterator<Person> it = ((List<Person>) obj).iterator();
                while (it.hasNext()) {
                    Person person = it.next();
                    if (person.getEducation() == education) {
                        it.remove();
                    }
                }
            }
            else {
                Person person = (Person) obj;
                if(person.getEducation() == education) {
                    tempList.add(person);
                }
            }
        }

        if(!tempList.isEmpty()) {
            for(Person person : tempList) {
                employees.remove(person);
            }
        }
    }

}
