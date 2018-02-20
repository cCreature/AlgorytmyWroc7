package Zajecia2701;

import java.util.Scanner;

public class SitoErystotelesa {
    public static void main(String[] args) {
        //https://pl.wikipedia.org/wiki/Sito_Eratostenesa
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //pobieramy liczbę, do której będziemy generować sito

        boolean[] arr = new boolean[n + 1]; //tablica sita

        for (int i = 0; i < arr.length; i++) {
            arr[i] = true; //na starcie wszystkie liczby oznaczamy jako pierwsze
        }

        for (int i = 2; i < arr.length; i++) { //lecimy po kolei po liczbach
            if(arr[i]) //jeżeli liczba była oznaczona jako pierwsza zostawiamy ją oznaczoną
                for (int j = i + i; j < arr.length; j+=i) { //jej wielokrotności oznaczamy jako złożone
                    arr[j] = false;
                }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]) //drukujemy liczby pierwsze
                System.out.printf("%d ", i);
        }
    }
}
