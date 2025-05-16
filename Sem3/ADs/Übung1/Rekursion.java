public class Rekursion {
    public static void main(String[] args) {

        System.out.println(bad(5)); //Stackoverflow tritt auf

    }
    public static int bad (int n) {
        if (n == 0) return 0;
        else
            return bad(n/3 + 1) + n - 1;
        /*
        Mit n >= 0 ist der Ausdruck n/3 + 1 >= 0 (immer), also die Bedingung n == 0 wird niemals erfüllt sein
        d. h. unendlich lange Schleife
        */

    }
}