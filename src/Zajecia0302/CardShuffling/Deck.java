package Zajecia0302.CardShuffling;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    public Deck() {
        for (int i = 0; i <= 12 ; i++) {
            for (int j = 0; j <= 3 ; j++) {
                deck.add(new Card(Colors.getValueBasedOnInt(j),
                        Figures.getValueBasedOnInt(i)));
            }
        }
    }

    public void printAll(){
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
}
