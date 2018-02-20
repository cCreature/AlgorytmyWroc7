package Zajecia0302.CardShuffling;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>(); //lista kart
    public Deck() {
        //konstruktor ma za zadanie wygenerować wszystkie możliwe karty
        for (int i = 0; i <= 12 ; i++) {
            for (int j = 0; j <= 3 ; j++) {
                deck.add(new Card(Colors.getValueBasedOnInt(j),
                        Figures.getValueBasedOnInt(i)));
            }
        }
    }

    public void printAll(){
        for (Card card : deck) { //drukowanie wszystkich kart z decka
            System.out.println(card);
        }
    }

    public void shuffle(){
        Collections.shuffle(deck); //losowe ułożenie wartości na liście
    }
}
