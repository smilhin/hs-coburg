package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {


    /** Berechnet die Potenz a^k mod b mittels "Quadrieren und Multiplizieren".
     * @param a Basis
     * @param k Exponent, ganze Zahl >= 0
     * @param b Modulus
     * @return die Potenz
     */
    public static int pow(final int a, int k, final int b) {
        long x = a;
        long z = 1;
        while(k > 0)
            if(k%2 == 0) {
                k /= 2;
                x = x*x%b;
            } else {
                k--;
                z = z*x%b;
            }
        return (int) z;
    }


    /**
     * Fermat-Test prüft, ob a^(n-1) mod n = 1 ist.
     * @param n Modulus
     * @param a Basis
     * @return true, wenn n den Fermat-Test übersteht, sonst false
     */
    public static boolean fermatTest(final int n, final int a) {

        return pow(a, n - 1, n) == 1;

    }

    /**
     * Prüft, ob eine natürliche Zahl n eine "Pseudo"-Primzahl ist.
     * Wendet den Fermat-Test mit 100 Zufallszahlen a auf n an.
     * Die Wahrscheinlichkeit, dass eine zusammengesetzte Zahl n den Test übersteht,
     * ist klein, meist kleiner als 2^-100.
     * Allerdings gibt es Ausnahmen, sog. Charmichael-Zahlen, z.B. n = 561 = 3*11*17.
     * @param n die zu testende Zahl
     * @return
     */
    public static boolean isPrime(final int n) {

        boolean myBool = true;
        for (int i = 1; (i < n) && (i < 100); i++) {
            if (!fermatTest(n, i)) {
                myBool = false;
                break;
            }
        }
        return myBool;

    }


    public static void main(String[] args) {

        System.out.println(isPrime(563));

    }
}