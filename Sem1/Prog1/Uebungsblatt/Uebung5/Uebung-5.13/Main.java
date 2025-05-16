package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static long ggtRek(int a, int b) {

        if (b > 0) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
            return ggtRek(a, b);
        }
        else {
            return a;
        }

    }


    public static void main(String[] args) {

        System.out.println(ggtRek(184, 184));

    }
}