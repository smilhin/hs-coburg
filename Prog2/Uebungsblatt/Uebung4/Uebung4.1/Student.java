public class Student extends Person {


    int matrikelNum;
    public Student(String name, String surname, String street, String houseNum, String city, int plz, int matrikelNum) {
        super(name, surname, street, houseNum, city, plz);
        this.matrikelNum = matrikelNum;
    }
    public int getMatrikelnummer() {return this.matrikelNum;}
    public void setMatrikelnummer(int matrikelNum) {this.matrikelNum = matrikelNum;}

    public String toString() {
        return "Student [matrikelNummer=" +this.matrikelNum + ", nachname=" + this.surname + ", vorname=" + this.name + ", strassenname=" + this.street + ", hausnummer=" + this.houseNum + ", ort=" + this.city + ", postleitzahl=" + this.plz + "]";
    }
}
