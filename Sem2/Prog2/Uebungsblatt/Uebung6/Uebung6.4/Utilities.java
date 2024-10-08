import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("uncheked")
public class Utilities<T extends Comparable<T>> {


    public static <T> void print(T[] array) {

        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

    }
    public static <T extends Comparable<T>> void sortiere(T[] array) {
        T previousValue;
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1].compareTo(array[i]) > 0 ) {
                    previousValue = array[i-1];
                    array[i - 1] = array[i];
                    array[i] = previousValue;
                }

            }
        }
    }

    public static <T> T noNull(T... args) {

        for (T arg : args) {
            if(arg != null) {
                return arg;
            }
        }
        return null;

    }

}
