package Zajecia0302.CardShuffling;

public enum Colors {
    //Mamy 4 możliwości kart:
    CLUBS(0), //żołądź - trefl
    DIAMONDS(1), //dzwonek - karo
    HEARTS(2), //serce, czerwień - kier
    SPADES(3); //wino - pik

    private int value; //pole przechowujące wartość (tą w nawiasie przy enumie)
    Colors(int value){ //konstruktor ustawiający wartości
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Colors getValueBasedOnInt(int value){
        for (Colors color : Colors.values()) { //przeszukuje wszystkie kolory
            if(color.getValue() == value){ //gdy wartosć z nawiasu zgadza się z wartością podaną jako argument
                return color; //zwracam tą wartość
            }
        }
        return CLUBS;
    }
}
