import java.util.Arrays;


public class Main {



    public static void main(String[] s) {

        Star a = new Star(2);
        Star b = new Star(4);
        Star c = new Star(9);
        Wire ab = new Wire(a, b, 9);
        Wire abc = new Wire(ab, c, 10);

        System.out.println(abc);
    }
} // 