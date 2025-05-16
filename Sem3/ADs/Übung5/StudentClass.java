public class StudentClass implements Student{

    private final String name, surname;


    public StudentClass(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name + " " + surname;
    }

    public boolean equals(Student student) {
        return this.name.equals(student.name()) && this.surname.equals(student.surname());
    }
    public String name() {
        return name;
    }
    public String surname() {
        return surname;
    }

}
