package Zajecia0302.CardShuffling;

public enum Colors {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int value;
    Colors(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Colors getValueBasedOnInt(int value){
        for (Colors color : Colors.values()) {
            if(color.getValue() == value){
                return color;
            }
        }
        return CLUBS;
    }
}
