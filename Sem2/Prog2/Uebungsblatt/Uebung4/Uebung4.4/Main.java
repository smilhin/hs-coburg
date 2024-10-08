import java.util.Arrays;


public class Main {



    public static void main(String[] s) {

        Star a = new Star(2);
        Star b = new Star(9);
        GlitterStar a1 = new GlitterStar(4);

        a1.decorate();
        a1.decorate();
        a1.decorate();
        Wire ab = new Wire(a, a1, 9);
        ab.balance();

        Wire abc = new Wire(ab, b, 10);
        abc.balance();
        System.out.println(abc);

    }
} // 