public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    public Employee(Integer id, Integer age, String gender, String fName,
                    String lName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", age=" + age + ", gender=" + gender + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

}
