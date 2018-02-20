package Zajecia0302.PracaDomowa;

import java.util.Scanner;

public class Duplikat {
    public static void main(String[] args) {
        System.out.println("Podaj liczbę elementów");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] duplicateArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Podaj " + (i+1) + " liczbę:");
            duplicateArray[i] = sc.nextInt();
        }

        //Najbardziej naiwna wersja - przechodzę po kolei elementy, aż do tego, który w tym momencie wskazuje
        //i jednocześnie sprawdzam czy się powtórzył

        for(int i =0; i <duplicateArray.length; i++) //idę po każdym elemencie
        {
            for(int j = 0; j < i; j++) //idę od 0 elementu do o 1 mniejszego od aktualnie przetwarzanego w "i"
                if(duplicateArray[i] == duplicateArray[j]) //jeżeli się powtarzają znaczy, że duplikat
                {
                    System.out.printf("Pierwszy zduplikowany element: %d pod indeksami: %d i %d\n", duplicateArray[i], j, i);
                    return; //wyświetlam komunikat i przerywam działanie
                }
        }

        System.out.printf("Tablica nie przechowuje zdublowanych elementów\n");
    }
}
