import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class Main {

public static void main(String[] srg) {

}
    public static void operators() {
        IntBinaryOperator addition 			= (int x, int y) -> {return x + y;};
        IntBinaryOperator subtraction 		= (int x, int y) -> {return x - y;};
        IntBinaryOperator division 			= (int x, int y) -> {return x / y;};
        IntBinaryOperator multiplication 	= (int x, int y) -> {return x * y;};

        IntUnaryOperator inc = (int x) -> {return x + 1;}; // increment
        IntUnaryOperator dec = (int x) -> {return x - 1;}; // decrement

        System.out.println("40 + 2 = " + addition.applyAsInt(40, 2));
        System.out.println("20 - 10 = " + subtraction.applyAsInt(20, 10));

        System.out.println("inc(20) = " + inc.applyAsInt(20) );
        System.out.println("dec(20) = " + dec.applyAsInt(20) );

        System.out.println("20 / 4 = " + division.applyAsInt(20, 4) );
        System.out.println("20 * 5 = " + multiplication.applyAsInt(20, 5));
    }
}