import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

public static void main(String[] srg) {
EmployeeAdminTest.applyPredicates();
}

}


class EmployeeAdministration {
    List<Employee> employees = new ArrayList<Employee>();

    public EmployeeAdministration(List<Employee> list) {
        employees.addAll(list);
    }

    public void add(Employee e) {
        employees.add(e);
    }

    public List<Employee> filter(Predicate<Employee> p) {
        List<Employee> newList = new ArrayList<>(employees);
        newList.removeIf(p);
        return newList;
    }
    public String toString() {
        return employees.toString();
    }
}

class EmployeeAdminTest {

    public static void applyPredicates () {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex David", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        EmployeeAdministration employees = new EmployeeAdministration(
                Arrays.asList(new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8,
                        e9, e10 }));


        // alle die älter als 18 sind
        Predicate<Employee> isAgeMoreThan18 = i -> (i.getAge() < 18);
        Predicate<Employee> isAgeMoreThan21 = i -> (i.getAge() < 21);
        Predicate<Employee> isAgeEqualsLessThan35 = i -> (i.getAge() >= 35);


        // alle die männlich sind
        Predicate<Employee> isMale = i -> (!i.getGender().equals("M")) ;

        // alle die weiblich sind
        Predicate<Employee> isFemale = i -> (!i.getGender().equals("F")) ;

        // alle die männlich und über 18 sind
        Predicate<Employee> isAdultMale = i -> {
            return !(i.getGender().equals("M")) || i.getAge() < 18;

        };

        // alle mit Vornamen David
        Predicate<Employee> firstNameDavid = i -> !(i.getFirstName().contains("David"));



        System.out.println("---- all employees > age 21----\n" + employees.filter(isAgeMoreThan21));

        System.out.println("\n---- all employees male----\n" + employees.filter(isMale));

        System.out.println("\n---- all employees female----\n" +employees.filter(isFemale));

        System.out.println("\n---- all employees AdultMale----\n" +employees.filter(isAdultMale));

        System.out.println("\n---- all employees David firstName----\n" +employees.filter(firstNameDavid));

        System.out.println("\n---- all employees <= age 35----\n" + employees.filter(isAgeEqualsLessThan35));

        System.out.println("\n---- all employees AdultMale or female----\n" +"[]");
    }
}



