package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static int[][] calculateTable(int[][] array, char cmd) {
        switch (cmd) {
            case 's' -> {
                var newArray = new int[array.length+1][array[0].length+1];

                // Copy the array and calculate the row sums
                for (int i = 0; i < array.length; i++) {
                    int rowSum = 0;
                    for (int j = 0; j < array[0].length; j++) {
                        newArray[i][j] = array[i][j];
                        rowSum += array[i][j];
                    }
                    newArray[i][newArray[0].length-1] = rowSum;
                }

                // Calculate the column sums
                for (int i = 0; i < array[0].length; i++) {
                    int columnSum = 0;

                    for (int[] ints : array) {
                        columnSum += ints[i];
                    }

                    newArray[newArray.length-1][i] = columnSum;
                }

                return newArray;
            }

            case 'i' -> {
                var newArray = new int[array.length][array[0].length];
                int value = 10;

                for (int i = 0; i < newArray.length; i++) {
                    for (int j = 0; j < newArray[0].length; j++) {
                        newArray[i][j] = value++;
                    }
                }

                return newArray;
            }

            case 'r' -> {
                var newArray = new int[array.length][array[0].length];

                for (int i = 0; i < newArray.length; i++) {
                    for (int j = 0; j < newArray[i].length; j++) {
                        if (j == 0) {
                            newArray[i][j] = 0;
                        }
                        else {
                            newArray[i][j] = array[i][j-1];
                        }
                    }
                }

                return newArray;
            }


            default -> {
                int[][] newArray = {{-40}, {10}};
                return newArray;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {10,  11,  12,  13,  14},
                {15,  16,  17,  18,  19},
                {20,  21,  22,  23,  24},
                {25,  26,  27,  28,  29}
        };
        int[][] k = calculateTable(a, 'r');
        for (int i = 0; i < k.length; i++) {
            System.out.println(Arrays.toString(k[i]));
        }
    }
}