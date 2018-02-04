package Zajecia0302;

import java.util.Stack;

public class Stos {
    public static void main(String[] args) {
        int liczba = 22;
        int podstawa = 8;

        Stack<Integer> stos= new Stack<>();

        do{
            stos.push(liczba%podstawa);
            liczba = Math.floorDiv(liczba, podstawa);
        }while(liczba > 0);

        while(!stos.empty()){
            System.out.println(stos.pop());
        }
    }
}
