
public class Uebung1 {
    public static void main(String[] args) {

        System.out.println("ggt von 1974 und 2022 (iterativ):" + ggTIter(1974, 2022));
        System.out.println("ggt von 1974 und 2022 (rekursiv):" + ggTRec(1974, 2022));

        System.out.println("Fakultät von 12 iterativ: " + facIter(12));
        System.out.println("Fakultät von 12 recursiv: " + facRec(12));
    }



    public static int ggTIter(int A, int B) {
        int rest = A % B;

        while(rest > 0) {
            rest = A % B;
            A = B;
            B = rest;
        }
        return A;
    }


    public static int ggTRec(int A, int B) {
        int rest;
        if(B > 0) {
            rest = A % B;
            return ggTRec(B, rest);
        }
        else {
            return A;
        }
    }


    public static int facIter(int n) {

        if(n >= 0) {
            int m = 1;
            for(int i = n; i > 0; i--) {
                m *= i;
            }
            return m;
        }
        
        return -1;
    }

    /**
     * Calculates the faculty recursively
     *
     * @param n the number to calculate the faculty for
     * @return the faculty of n
     */
    public static int facRec(int n) {

        if(n == 0 || n == 1) {
            return 1;
        }
        else if(n < 0) {
            return -1;
        }
        else {
            return n * facRec(n - 1);
        }
    }
}
