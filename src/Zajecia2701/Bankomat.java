package Zajecia2701;

import java.util.Scanner;

public class Bankomat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nominalyZl = new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] nominalyZuzycie = new int[nominalyZl.length];
        int kwotaZlote = sc.nextInt();

        int aktualnyNominal = 0;
        while (kwotaZlote > 0){
            if(kwotaZlote >= nominalyZl[aktualnyNominal]){
                kwotaZlote -= nominalyZl[aktualnyNominal];
                nominalyZuzycie[aktualnyNominal]++;
            }
            else {
                aktualnyNominal++;
            }
        }

        for (int i = 0; i < nominalyZl.length; i++) {
            if(nominalyZuzycie[i] > 0)
                System.out.printf("%d zł x %d\n", nominalyZl[i],
                        nominalyZuzycie[i]);
        }

    }
}
