package Zajecia2701;

import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        try {
            n = sc.nextInt(); //pobieramy ilość liczb, które które chcemy zsumować
            //jeżeli ktoś podał coś innego niż int, wówczas zostanie przechwycony wyjątek i wejdziemy do catch
        }
        catch (Exception ex){
            System.out.println("Podełeś błędne dane"); //jeżeli zostanie rzucony wyjątek wtedy wyświetlamy komunikat
            //o błędnych danych
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            try{
                sum += sc.nextInt(); //pobieramy liczbę i dodajemy do sumy
                System.out.println(sum); //za każdym razem drukujemy sumę
            }
            catch (Exception ex){ //jeżeli zostanie wprowadzone cokolwiek innego niż int
                sc.next(); //obejście błędu wewnętrznewgo w klasie Scanner
                System.out.println(sum); //drukujemy sumę mimo błędu
            }
        }
    }
}
