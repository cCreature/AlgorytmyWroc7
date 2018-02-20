package Zajecia0302.PracaDomowa;

import java.util.ArrayList;

public class UsuwanieZListy {
    public static void main(String[] args) {
        String exampleImput = "4 [1,2,2,3,4,2,4]"; //syluluje pobieranie wejścia od użytkownika

        int toDelete = Integer.parseInt(exampleImput.substring(0, exampleImput.indexOf('[')).trim());
        //obcinam napis od początku do pierwszego wystąpienia [ - dla naszego przykładu to będzie 4

        String numbersCut = exampleImput.substring(exampleImput.indexOf('[') + 1, exampleImput.indexOf(']'));
        //wycinam wszystko poza liczbami w napisie zostaje 1,2,2,3,4,2,4
        String[] numbers = numbersCut.split(","); //rozdzielam liczby (, oddziela jedne od drugich)

        ArrayList<Integer> listNumbers = new ArrayList<>();

        for (String number : numbers) { //foreachem odczytuje po kolei wartości z tablicy
            listNumbers.add(Integer.parseInt(number)); //dopisuje do listy i zamieniam na inty
        }

        int iterator = 0;
        while (iterator < listNumbers.size()){ //dopóki iterator jest mniejszy od liczby elementów w liście
            //size() jest metodą i za każdym razem od nowa wylicza długość listy
            if(listNumbers.get(iterator) == toDelete) //jeżeli aktualnie przetwarzany element równa się elementowi usuwamy go
                listNumbers.remove(iterator);
            else //w przeciwnym razie zwiększamy iterator
                iterator++;
        }

        for (Integer number : listNumbers) {
            System.out.println(number); //drukowanie
        }

    }
}
