package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static int minimum (int[] array) {
        if(array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }

        return minimumRekursiv(array, array[0], array[array.length - 1], array[0]);
    }

    private static int minimumRekursiv(int[] arr, int currPos, int lastPos, int actualElem) {
        if(arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        else if (arr.length == 1) {
            return actualElem;
        }
        else {
            if(currPos > lastPos) {
                arr[0] = lastPos;
                arr[arr.length - 1] = currPos;
            }
            var newArray = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                newArray[i] = arr[i];
            }

            return minimumRekursiv(newArray, newArray[0], newArray[newArray.length - 1], newArray[0]);
        }
    }



    public static void main(String[] args) {

        int[] array = {10, 20, 5, 6, 7, -5, -10, 20};
        System.out.println(minimum(array));


    }
}