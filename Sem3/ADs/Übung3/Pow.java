public class Pow {

    public static void main(String[] srg) {

        System.out.println(pow(2, 6));
        System.out.println(pow(3, 4));
        System.out.println(pow(10, 5));
        System.out.println(pow(4, 3));

    }

    public static long pow(long x, int n) {
        long result = 1;
        if(n % 2 == 0) {

            for(int i = 0; i < n / 2; i++) {
                result *= x;
            }

            result *= result;
        }

        else {
            for(int i = 0; i < (n - 1) / 2; i++) {
                result *= x;
            }
            result *= result * x;
        }

        return result;
    }

}







