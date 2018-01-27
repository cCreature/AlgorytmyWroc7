package Projekty.OneHundredCounting;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void play(){
        int game = 100;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        while(game > 1){
            int userChoice = 0;
            System.out.println("Na grze: " + game);
            System.out.println("Podaj [1-10]");
            try {
                userChoice = sc.nextInt();
            }
            catch (Exception e){
                sc.next(); continue;
            }
            if(userChoice > 10 || userChoice < 1){
                System.out.println("Błędna liczba");
                continue;
            }
            game -=userChoice;
            int computerChoice = (game < 11) ? game : rand.nextInt(10) + 1;
            System.out.println("Komputer wybrał " + computerChoice);
            game -= computerChoice;

        }
    }
}
