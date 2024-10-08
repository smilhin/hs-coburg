package generics.tutorial.kartenspiel;

public class Person {
    private String name, vorname;
    private int age;
    public Person(String name, String vorname, int age) {
        this.name = name;
        this.vorname = vorname;
        this.age = age;
    }
    public String toString() {
        return "[Name = " + this.name + " Vorname = " + this.vorname + " Age = " + this.age
 + "]";
    }
}
