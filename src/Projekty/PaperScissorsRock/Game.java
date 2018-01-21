package Projekty.PaperScissorsRock;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Choices computerChoice;
    private Choices userChoice;

    private int gamesNumber = 0;
    private int gamerWins=0;
    private int computerWins=0;

    public void startGame(){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("n - nożyczki, p - papier, " +
                    "k - kamień, q - wyjście");
            String userInput = sc.next();
            userInput = userInput.toLowerCase().trim();
            if (userInput.equals("q")) {
                break;
            }

            int computerInput = rand.nextInt(3);
            computerChoice = Choices.getEnumBasedOnInt(computerInput);

            if (userInput.equals("k") || userInput.equals("n")
                    || userInput.equals("p")) {
                userChoice = Choices.getEnumBasedOnString(userInput);
            } else {
                System.out.println("Błędny wybór");
                continue;
            }
            gamesNumber++;
            calculateResult();
        }

        System.out.println("Wygrałeś: " + gamerWins +
                " razy. Przegrałeś: " + computerWins +
                " Zagrałeś " + gamesNumber + " gier.");

    }

    private void calculateResult(){
        if(userChoice.equals(computerChoice)){
            System.out.println("Remis, obaj wybraliście: "
                    + userChoice.getFirstLetter());
        }
        else if(userChoice.equals(Choices.ROCK) &&
                computerChoice.equals(Choices.SCISSORS)){
            gamerWins++;
            System.out.println("Gratulacje wygrałeś!"
                    + " Wskazałeś kamień, a komputer nożyczki");
        }
        else if(userChoice.equals(Choices.ROCK) &&
                computerChoice.equals(Choices.PAPER)){
            computerWins++;
            System.out.println("Przegrałeś!"
                    + " Wskazałeś kamień, a komputer papier");
        }
        else if(userChoice.equals(Choices.SCISSORS) &&
                computerChoice.equals(Choices.ROCK)){
            computerWins++;
            System.out.println("Przegrałeś!"
                    + " Wskazałeś nożyczki, a komputer kamień");
        }
        else if(userChoice.equals(Choices.SCISSORS) &&
                computerChoice.equals(Choices.PAPER)) {
            gamerWins++;
            System.out.println("Wygrałeś!"
                    + " Wskazałeś nożyczki, a komputer papier");
        }
        else if(userChoice.equals(Choices.PAPER) &&
                computerChoice.equals(Choices.ROCK)){
            gamerWins++;
            System.out.println("Wygrałeś!"
                    + " Wskazałeś papier, a komputer kamień");
        }
        else if(userChoice.equals(Choices.PAPER) &&
                computerChoice.equals(Choices.SCISSORS)){
            computerWins++;
            System.out.println("Przegrałeś!"
                    + " Wskazałeś papier, a komputer nożyczki");
        }
    }
}
