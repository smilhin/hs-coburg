public class Pow {

    public static void main(String[] srg) {

        System.out.println(pow_log(2, 6));
        System.out.println(pow_log(3, 4));
        System.out.println(pow_log(10, 5));
        System.out.println(pow_log(4, 3));

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

    public static long pow_log(long x, int n) {

        if(n == 1) {
            return x;
        }
        if(n % 2 == 0) {
            return pow_log(x * x, n / 2);
        }
        else if(n % 2 == 1) {
            return pow_log(x*x, (n-1) / 2) * x;
        }
        return 0;
    }
}







