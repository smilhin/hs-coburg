package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static boolean vertausche(char[] s, char [] t) {

        if (s.length != t.length) {
            return false;
        }
        else {

            var newArray = new char[s.length];
            for (int i = 0; i < s.length; i++) {
               newArray[i] = s[i];
                s[i] = t[i];
                t[i] = newArray[i];
            }
        return true;
        }

    }

    public static boolean vertausche2(char[] s, char [] t) {

        char[] newArray = s;
        s = t;
        t = newArray;

        return true;

    }

    public static void main(String[] args) {

        char[] s = { 'S', 'O', 'R', 'T', 'B' , 'Y'};
        char[] t = { 'B', 'U', 'B', 'B', 'L' , 'E'};

        vertausche(s, t);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(t));

    }
}