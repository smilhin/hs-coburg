package Uebungsblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {


    


    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Bitte n eingeben (n ungerade, 2 < n < 10):");
            n = sc.nextInt();
        } while(n < 2 || n > 10 || n % 2 == 0);

        int[][] quad = new int[n][n];
        int zeile = n / 2;
        int spalte = n / 2 + 1;
        int m = 0;

        do {

            m++;
            quad[zeile][spalte] = m;
            zeile--;
            spalte++;

            if(zeile == -1) zeile = n - 1;
            if (spalte == n) spalte = 0;

            if(quad[zeile][spalte] != 0) {
                zeile++;
                spalte++;

                if (zeile == n) zeile = 0;
                if (spalte == n) spalte = 0;
            }

        } while( m < n*n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                m = quad[i][j];

                if(m < 10) System.out.print(" ");
                if(m < 100) System.out.print(" ");

                System.out.print(" " + m);

            }
            System.out.println();
        }

    }
}