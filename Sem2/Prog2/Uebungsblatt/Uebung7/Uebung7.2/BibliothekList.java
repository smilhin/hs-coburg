import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class BibliothekList {

    public Collection<Buch> bibliothek = new ArrayList<Buch>();
    public BibliothekList() {

    }

    public boolean einfuegen(Buch b) {
        if(b != null) {
            bibliothek.add(b);
            return true;
        }
        return false;
    }

    public Collection<Buch> sucheNachAutor(String author) {

        ArrayList<Buch> booksFound = new ArrayList<Buch>();
        for(Buch b : bibliothek) {
            if(b.getAutor().equals(author)) {
                booksFound.add(b);
            }
        }

            return booksFound;


    }

    public Buch sucheNachISBN(String isbn) {
        for(Buch b : bibliothek) {
            if(b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public Collection<Buch> bestandSortierenNach(Comparator<Buch> comp) {




        return null;
    }

    public String toString() {
        String result = "";
        result += "[\n";
        for(Buch b : bibliothek) {
            result = result + b.toString() + "\n";
        }
        result += "]";
        return result;
    }

}
