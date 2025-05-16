package Uebungsblatt1;


class Employee {
    public String employeeName;
    public String employeeSurname;

    int numberOfEmployees = 0;
    static int count = 0;

    public Employee(String employeeName, String employeeSurname) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        numberOfEmployees = getCount();

    }

    public void setFirstName(String name) {
        this.employeeName = name;
    }
    public void setLastName(String surname) {
        this.employeeSurname = surname;
    }
    public String getFirstName() {
        return this.employeeName;
    }
    public String getLastName() {
        return this.employeeSurname;
    }

    public String toString() {
        return "Employee [Vorname = " + employeeName + ", Nachname = " + employeeSurname + "] Gesamtanzahl an Employees: " + numberOfEmployees;
    }

    public int getCount() {
        return ++count;
    }


    public static void main(String[] args) {

        Employee e1 = new Employee("Hans", "Maier");
        System.out.println( e1.toString() );
        Employee e2 = new Employee("Thomas", "Müller");
        System.out.println( e2.toString() );

    }
}