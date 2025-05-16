
public class ggTOhneModulo {
    public static void main(String[] args) {

        System.out.println("ggT:  " + ggT(1974, 2022));

    }


    // ggT ohne Modulo
    public static int ggT(int A, int B) {
        int rest;
        int m = A;
        int n = B;
        while(m >= n) {
            m -= n;
        }
        rest = m;

        while(rest > 0) {
            int k = A;
            int l = B;
            while(k >= l) {
                k -= l;
            }
            rest = k;
            A = B;
            B = rest;
        }
        return A;
    }
}
