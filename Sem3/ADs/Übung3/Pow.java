public class Pow {

    public static void main(String[] srg) {

        System.out.println(pow(10, 5));

    }

    public static long pow(long x, int n){
        long result = 1;
        if(n % 2 == 0) {
            result *= x;
            while(n / 2 > 0) {
                result *= x;
                n--;
            }
        }
        else {
            while((n - 1) / 2 > 0) {
                result *= x;
                n--;
            }
            result *= result;
            result *= x;
        }

        return result;
    }

}







