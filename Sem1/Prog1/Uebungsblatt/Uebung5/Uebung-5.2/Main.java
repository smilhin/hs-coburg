package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static float getDecimal(float value, int decimalPoints) {

        int k = (int)(value * (float)Math.pow(10, decimalPoints));
        value = (float)k / (float)Math.pow(10, decimalPoints);
        return value;

    }

    public static float toCelsius( float fahrenheit) {

        float celsius = 5.0f / 9.0f * (fahrenheit - 32);
        return getDecimal(celsius, 2);

    }


    public static float toFahrenheit( float celsius ) {

        float fahrenheit = 9.0f / 5.0f * celsius + 32;
        return getDecimal(fahrenheit, 2);
    }


    public static void main(String[] args) {

        System.out.println(toFahrenheit(0.0f));
        System.out.println(toCelsius(120.0f));

    }
}