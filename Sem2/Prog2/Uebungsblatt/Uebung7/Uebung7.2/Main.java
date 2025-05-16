import java.util.ArrayList;
import java.util.Collection;

public class Main {

public static void main(String[] srg) {
    BibliothekList b = new BibliothekList();
    BibliothekTest.init(b);
    System.out.println(b.sucheNachAutor("Reinhard Schiedermeier"));
}


}
