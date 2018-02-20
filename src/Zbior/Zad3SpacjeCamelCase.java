package Zbior;

public class Zad3SpacjeCamelCase {
    public static void main(String[] args) {
        String input = "Dzisiaj jest czwartek,\n A jutro bedzie piatek.\n";
        boolean toUpper = true;
        for (int i = 0; i < input.length(); i++){
            char letter = input.charAt(i); //odczytuje znak po znaku
            if(letter == ' ') //jeżeli spacja
                toUpper = true; //oznaczam specjalną zmienną, że następny znak ma być napisany
                                //z dużej i jednocześnie pomijam spacje
            else //jeżeli nie spacja
                if(toUpper){ //i mam napisać z dużej
                    System.out.print(Character.toUpperCase(letter)); //wypisuje
                    toUpper = false; //następny znak będzie napisany z małej
                }
                else //i nie mam napisać z dużej to przepisuje
                    System.out.print(letter);
        }

    }
}
