package Zajecia2502;

import java.util.Stack;

public class ONP {
    public static void main(String[] args) {
        String input = "3 5 2 * +"; //wejście
        String[] inputArray = input.split(" ");
        //tablica znaków rozdzielona spacjami

        Stack<Integer> S = new Stack<>(); //tworzymy nowy stos

        int helper = 0; //zmienna pomocnicza

        for (String s : inputArray) {
            try{ //stawiamy pułapkę
                int element = Integer.parseInt(s);
                //jeżeli uda nam się sparsować,
                //czyli nie poleciał wyjątek
                //to wrzucamy na stos
                S.push(element);
            }
            catch (Exception e){ //jeżeli wyjątek to nie dostaliśmy na wejściu liczby
                switch (s){ //w zależoności od operatora
                    case "+": //wykonujemy dodawanie
                        helper = S.pop() + S.pop(); //na dwóch liczbach ze szczytu stosu
                        S.push(helper);
                        break;
                    case "-":
                        helper = S.pop() - S.pop();
                        S.push(helper);
                        break;
                    case "*":
                        helper = S.pop() * S.pop();
                        S.push(helper);
                        break;
                    case "/":
                        helper = S.pop() / S.pop();
                        S.push(helper);
                        break;
                }
            }
        }

        System.out.println(S.pop());

    }
}
