package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void sortieren(int[] array) {


        int previousValue = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    previousValue = array[i-1];
                    array[i - 1] = array[i];
                    array[i] = previousValue;
                }

            }
        }

    }


    public static void main(String[] args) {
        int[] a = {1, 10, 3, 2, 5, 0, 700, -12, 100};
        sortieren(a);
        System.out.println(Arrays.toString(a));
    }
}