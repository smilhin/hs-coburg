import java.util.Arrays;
import java.util.List;

public class Main {

public static void main(String[] srg) {

}
    public static void printIntValues(Integer[] values ) {

        List<Integer> list = Arrays.asList(values);

        // Ausgabe aller Werte von values mit forEach
        list.forEach(b -> System.out.print(b + " "));
    }

}
