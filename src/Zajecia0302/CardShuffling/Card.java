package Zajecia0302.CardShuffling;

public class Card {
    Colors color;
    Figures figure;

    public Card(Colors color, Figures figure) {
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
