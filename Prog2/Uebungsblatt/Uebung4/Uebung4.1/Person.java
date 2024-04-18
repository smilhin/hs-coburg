public class Person {

    String surname, name, street, houseNum, city;
    int plz;

    public Person(String name, String surname, String street, String houseNum, String city, int plz) {
        this.surname = surname;
        this.name = name;
        this.street = street;
        this.houseNum = houseNum;
        this.city = city;
        this.plz = plz;

    }

    public String getSurname() {return this.surname;}
    public String getName() {return this.name;}
    public String getStreet() {return this.street;}
    public String getHouseNum() {return this.houseNum;}
    public String getCity() {return this.city;}
    public int getPlz() {return this.plz;}


    public void setNachname(String surname) {this.surname = surname;}
    public void setVorname(String name) {this.name = name;}
    public void setStrassenname(String street) {this.street = street;}
    public void setHausnummer(String houseNum) {this.houseNum = houseNum;}
    public void setOrt(String city) {this.city = city;}
    public void setPostleitzahl(int plz) {this.plz = plz;}



    public static void Main() {
        Student s1 = new Student("Peter", "Müller", "Hauptstrasse", "4a", "Coburg", 96450, 455555);
        Dozent d1 = new Dozent("Dieter", "Landes", "Am Ring", "12", "Coburg", 96450, "Software Engineering");
        Person p1 = new Person( "Tim", "Schmitt", "Ayinger Str.", "4a", "München", 89006);
        Student s2 = new Student("Yvonne", "Hinz", "Bahnhofstr", "30", "Nürnberg", 91000, 41622);
        Dozent d2 = new Dozent("Claudia", "Ehrlicher", "Am Baum", "12", "Berlin", 30323, "Ethik");

        System.out.println(s1);
        System.out.println(d1);
        System.out.println(p1);
        System.out.println(s2);
        System.out.println(d2);


    }
    public String toString() {
        return "Person [nachname=" + this.surname + ", vorname=" + this.name + ", strassenname=" + this.street + ", hausnummer=" + this.houseNum + ", ort=" + this.city + ", postleitzahl=" + this.plz + "]";
    }
}

