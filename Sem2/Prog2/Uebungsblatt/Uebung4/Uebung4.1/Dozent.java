public class Dozent extends Person {

    String subject;
    public Dozent(String name, String surname, String street, String houseNum, String city, int plz, String subject) {
        super(name, surname, street, houseNum, city, plz);
        this.subject = subject;
    }
    public String getLehrgebiet() { return this.subject; }
    public void setLehrgebiet(String subject) {this.subject = subject;}

    public String toString() {
        return "Dozent [lehrgebiet=" + this.subject + ", nachname=" + this.surname + ", vorname=" + this.name + ", strassenname=" + this.street + ", hausnummer=" + this.houseNum + ", ort=" + this.city + ", postleitzahl=" + this.plz + "]";
    }
}
