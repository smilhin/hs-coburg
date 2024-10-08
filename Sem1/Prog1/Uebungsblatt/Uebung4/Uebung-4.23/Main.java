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

    public static void dreiDimSortieren(int[][][] array){

        int previousValue = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sortieren(array[i][j]);
                System.out.println("Array Dim: " + (j + 1));
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.println(array[i][j][k]);
                }
            }
        }

    }




    public static void main(String[] args) {
        int[][][] einArray = {{{5,4,3,2,11}, {10,9,8,7,6}, {15,14,13,12,111}}};
        dreiDimSortieren(einArray);

    }
}