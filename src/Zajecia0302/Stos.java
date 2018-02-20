package Zajecia0302;

import java.util.Stack;

public class Stos {
    public static void main(String[] args) {
        int liczba = 22;
        int podstawa  = 8;

        Stack<Integer> stos = new Stack<>(); //Tworzę nowy stos
        //Zauważ, że przy deklaracji korzystam z klasy opakowującej!

        while(liczba > 0) //dopóki liczba jest większa od 0 oznacza to
        //że mogę jeszcze ją podzielić i dorzucić na stos wynik modulo
        {
            stos.push(liczba % podstawa);
            liczba = liczba / podstawa;
        }

        //Wypisywanie stosu
        while (!stos.empty()) {
            //TODO co w przypadku HEX?
            System.out.printf("%d", stos.pop());
        }
    }
}
