package Zajecia2701;

import java.util.Scanner;

public class Bankomat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nominalyZl = new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1}; //Tablica z nominałami złotówek od największych do najmniejszych
        int[] nominalyZuzycie = new int[nominalyZl.length];  //Ilość wydanych złotych
        //Domyślnie świeżo utworzona tablica jest wyzerowana {0, 0 ... 0}
        int kwotaZlote = sc.nextInt(); //Wejściowa kwota złotych

        int aktualnyNominal = 0;
        while (kwotaZlote > 0){ //Dopóki można wydać jakieś pieniądze
            if(kwotaZlote >= nominalyZl[aktualnyNominal]){ //Jeżeli jesteś w stanie wydać kwotę tym nominałem
                kwotaZlote -= nominalyZl[aktualnyNominal]; //Odejmij od ogólnej kwoty złotówek właśnie wskazany w tablicy nominał
                nominalyZuzycie[aktualnyNominal]++; //Zwiększ ilość banknotów, które wydaliśmy o konkretnym nominale
            }
            else {
                aktualnyNominal++; //w przeciwnym wypadku przejdź do kolejnego nominału
            }
        }

        //Aby wydrukować konkretne wartości trzeba przejść przez pętle, która pozwoli na odczyt
        //ilości banknotów, które wydaliśmy
        for (int i = 0; i < nominalyZl.length; i++) {
            if(nominalyZuzycie[i] > 0)
                System.out.printf("%d zł x %d\n", nominalyZl[i],
                        nominalyZuzycie[i]);
            //%d oznacza odwołanie się do elementu, który jest typu int, \n oznacza przejście do nowej linii
            //każdemu %d odpowiadają kolejne argumenty po napisie w ""
        }

    }
}
