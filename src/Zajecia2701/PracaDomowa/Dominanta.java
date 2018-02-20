package Zajecia2701.PracaDomowa;

public class Dominanta {
    public static void main(String[] args) {
        int[] T = {1, 3, 2, 2, 1, 1, 1, 1, 5};

        int max = 0;

        int amountOfElements = T.length;

        for(int i = 0; i < amountOfElements; i++) //Szukamy największego elementu
        {
            if(T[i] > max) //jeżeli obecnie przetwarzany element jest większy od maxa to stanie się on naszym nowym maxem
                max = T[i];
        }

        int L[] = new int[max+1]; //Tworzymy pomocniczą tablicę i od razu dajmey jej wartość max+1

        for(int i = 0; i < amountOfElements; i++) //Robimy zliczanie jak w sortowaniu przez zliczanie
        {
            int number = T[i];
            L[number]++;
        }

        int result = 0; //tutaj będziemy trzymać INDEKS elementu, którego wartość jest największa
        for(int i = 0; i < L.length; i++){
            if(L[i] > L[result]) //jeżeli wartość obecnie przetwarzanego elementu (L[i]) jest większa od elementu, który
            //do tej pory oznaczaliśmy największym (L[result]) to on będzie naszym nowym indeksem. Pamiętajmy, że przechowujemy indeksy
            //a nie wartości
            {
                result = i;
            }
        }


        System.out.printf("Najczęściej występująca wartość: %d wystąpiła %d razy.", result, L[result]);

    }
}
