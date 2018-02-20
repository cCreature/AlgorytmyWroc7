package Zajecia0302.PracaDomowa;

import java.util.ArrayList;
import java.util.Stack;

public class PalindromStos {
    public static void main(String[] args) {

        //Przykładowe wejście dla pojedynczej liczby
        char[] liczbaJakoChary = "1234321".toCharArray(); //liczbę do sprawdzania rozbijamy na poszczególne znaki

        ArrayList<Integer> lista = new ArrayList<>(); //tworzymy listę

        Stack<Integer> stos = new Stack<>(); //i tworzymy stok

        for (int i = 0; i < liczbaJakoChary.length; i++) {
            lista.add(Character.getNumericValue(liczbaJakoChary[i]));
            //parsujemy chary do wartości int
        }

        int i = 0;
        int halfElement = Math.floorDiv(lista.size(), 2);
        while (i < halfElement) //dopóki nie dojdziemy do pierwszego środkowego elementu
        {
            stos.add(lista.get(i)); //wrzucamy element na stos
            i++; //zwiększamy iterator
        }
        if (lista.size() % 2 == 1) //czy jest parzysta długość liczby jest nieparzysta
        //jak jest to warunkiem na sprawdzenie poprawności palindromu jest pominięcie analizowania tej liczby
        {
            i++;
        }
        while (i < lista.size()) //od drugiej połowy do końca listy
        {
            if (stos.pop() != lista.get(i)) //jeżeli udało się ściągnąć element ze stosu i różni się od
            //kolejnego elementu listy
            {
                System.out.printf("Podany ciąg liczb nie jest palindromem!");//wyświetlamy komunikat
                return;
            }
            i++; //inaczej zwiększamy iterator aż przejdziemy wszystkie elementy
        }
        System.out.printf("Podany ciąg liczb jest palindromem!");
    }

}
