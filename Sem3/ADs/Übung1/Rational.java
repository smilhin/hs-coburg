
public class Rational {
    private int numerator;
    private int denominator;


    public Rational() {
        numerator = 0;
        denominator = 1;
    }


    public Rational(int n) {
        numerator = n;
        denominator = 1;
    }


    public Rational(int n, int d) {
        assert (d != 0);

        numerator = n;
        denominator = d;
        reduce();
    }


    public Rational sum(Rational right) {

        return new Rational(
                this.numerator*right.denominator + this.denominator*right.numerator,
                this.denominator*right.denominator
        );
    }


    public Rational subtract(Rational right) {
        return new Rational(
                this.numerator*right.denominator - this.denominator*right.numerator,
                this.denominator*right.denominator
        );
    }


    public Rational multiply(Rational right) {

        return new Rational(
                this.numerator*right.numerator,
                this.denominator* right.denominator
        );
    }


    public Rational divide(Rational right) {
        assert (right.numerator != 0);
        return new Rational(
                this.numerator*right.denominator,
                this.denominator* right.numerator
        );
    }


    private void reduce() {
        assert (denominator != 0);

        int ggT = ggT(this.numerator, this.denominator);

        this.numerator /= ggT;
        this.denominator /= ggT;

    }

    private int ggT(int A, int B) {
        int rest = A % B;

        while(rest > 0) {
            rest = A % B;
            A = B;
            B = rest;
        }
        return A;
    }
    public void toScreen() {
        System.out.println("Wert " + this.toString());
    }



    public String toString() {
        return numerator + "/" + denominator;
    }

}
