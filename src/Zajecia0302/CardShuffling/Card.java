package Zajecia0302.CardShuffling;

public class Card {
    //Każda karta składa się z koloru i figury
    Colors color;
    Figures figure;

    public Card(Colors color, Figures figure) {
        //do konstruktora przekazuje kolor i figure i to jedyne miejsca gdzie mogę ustawić wartości
        this.color = color;
        this.figure = figure;
    }

    public Colors getColor() {
        return color;
    }

    public Figures getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return color.name() + " " + figure.name();
    }
}
