package Projekty.PaperScissorsRock;

public enum Choices {
    ROCK(0, "k"),
    SCISSORS(1, "n"),
    PAPER(2, "p");

    private int values;
    private String firstLetter;
    Choices(int values, String firstLetter) {
        this.values = values;
        this.firstLetter = firstLetter;
    }
    public int getValues() { return values; }

    public String getFirstLetter() {return firstLetter;}

    public static Choices getEnumBasedOnInt(int e){
        for (Choices choice : Choices.values()) {
            if(choice.getValues() == e)
                return choice;
        }
        return ROCK;
    }
    public static Choices getEnumBasedOnString(String e){
        for (Choices choice : Choices.values()) {
            if(choice.getFirstLetter().equals(e))
                return choice;
        }
        return ROCK;
    }

}
