package Zajecia2701;

import java.util.Scanner;

public class SzyfrCezara {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Scanner sc = new Scanner(System.in); //pobieramy słowo do zakodowania
        char[] toCode = sc.next().toLowerCase().toCharArray(); //zamieniamy na tablicę charów
        int key = sc.nextInt(); //pobieramy klucz - ile przestawiamy

        for (int i = 0; i < toCode.length; i++) { //lecimy po każdej literce
            int letter = 0; //tutaj zapiszemy jaki jest indeks litery ze słowa
            for (int j = 0; j < letters.length; j++) {
                if(letters[j] == toCode[i]){ //wyszukujemy literę jeżeli się zgadza to przepisujemy
                    letter = j;
                    break;
                }
            }
            System.out.print(letters[(letter + key)%26]); //wypisujemy literę przestawioną o klucz
            //modulo wynika z tego że przestawienie może wyjść poza tablicę
            //wtedy od początku
        }
    }
}
