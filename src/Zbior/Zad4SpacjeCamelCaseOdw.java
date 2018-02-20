package Zbior;

public class Zad4SpacjeCamelCaseOdw {
    public static void main(String[] args) {
        String input = "DzisiajJestCzwartek,\nAJutroBedziePiatek.";

        for (int i = 0; i < input.length(); i++) { //idę po znaku
            if(Character.isUpperCase(input.charAt(i)) && i != 0){ //jeżeli to nie jest pierwszy znak wejścia i jest napisany wielką
                System.out.print(" " + Character.toLowerCase(input.charAt(i))); //dopisuje spację i znak z małej
            }
            else{ //w p.p. przepisuje
                System.out.print(input.charAt(i));
            }
        }
    }
}
