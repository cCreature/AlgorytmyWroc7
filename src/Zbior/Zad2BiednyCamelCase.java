package Zbior;

public class Zad2BiednyCamelCase {
    public static void main(String[] args) {
        String word = "Lorem ipsum";
        for(int j = 0; j < word.length(); j++){
            String letter = Character.toString(word.charAt(j));
            if(j%2==0)
                letter = letter.toUpperCase();
            System.out.print(letter);
        }
    }
}
