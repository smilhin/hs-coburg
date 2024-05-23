import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

public static void main(String[] srg) {

}
}
class Buch  {

    protected final String isbn, autor, titel;
    private float price;

    public Buch(String isbn, String autor, String titel, float price) {
        super();
        this.isbn = isbn;
        this.autor = autor;
        this.titel = titel;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // .. übrigen getter weggelassen

    public String toString() {
        return "\n" + String.format("%-22s", autor) + " "
                + String.format("\"%-15s\"", titel) + " "
                + String.format("%13s", isbn) + " "
                + String.format("%.1f" , price);
    }
}

class BuchTest {

    public static void testPrice() {
        LinkedList<Buch> bib = new LinkedList<Buch>();
        bib.add(new Buch("9784898645133","Reinhard Schiedermeier", "Java Praktikum",                                                           34.0f));
        bib.add(new Buch("01303451517",  "Harvey Deitel",          "How to program Java",                                                      110.0f));
        bib.add(new Buch("9783897214484",  "Kathy Sierra",          "Software Engineering Basics",                                             87.0f));
        bib.add(new Buch("0136290310",   "Bertrand Meyer",         "Object Oriented Software Construction",                                    56.0f));
        bib.add(new Buch("9783897214484","Bertrand Meyer",         "Software Engineering Approaches for Offshore and Outsourced Development",  89.0f));
        bib.add(new Buch("9783642018558","Kathy Sierra",           "Java von Kopf bis Fuss",                                                   65.0f));


        bib.forEach(b -> b.setPrice(b.getPrice() + 10.0f));
        System.out.println(bib);

    }

}