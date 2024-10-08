import java.util.Arrays;
import java.util.*;

class Person {

    private final String firstName;
    private String lastName;
    private final int age;

    public Person(String f, String l, int a) {
        firstName = f;
        lastName = l;
        age = a;
    }
    public static int compareFirstNames(Person p1, Person p2) {
        return p1.firstName.compareTo(p2.firstName);
    }
    public String getFirstName() {
        return firstName;
    }

    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }
}


public class PersonTest {

    public static void testPerson() {
        Person[] people = new Person[] { new Person("Ted", "Neward", 41),
                new Person("Charlotte", "Neward", 41),
                new Person("Michael", "Neward", 19),
                new Person("Matthew", "Neward", 13),
                new Person("Adam", "Pfeiffer", 43) };

        Comparator<Person> comp = Person::compareFirstNames;
        Arrays.sort(people, comp);

        //v2
        Arrays.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

        //v3
        Arrays.sort(people, Comparator.comparing(Person::getFirstName));

        Arrays.asList(people).forEach(b -> System.out.println(b));

    }
}
