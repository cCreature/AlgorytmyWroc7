package Zajecia0302;

public class PrzeszukiwanieLidera {
    public static void main(String[] args) {
        int[] tab = {1, 1, 2, 1, 1, 4};

        int n = 0; //ustawiam sobie maxa na zero
        //nie znam jeszcze długości mojej tabloicy do zliczania
        //więc na ten moment szukam największego elementu, aby na jego podstawie
        //zbudować tablice
        for(int i = 0; i < tab.length; i++)
        {
            if(tab[i] > n)
                n = tab[i];
        }

        int tablicaDoZliczania[] = new int[n+1]; //teraz kiedy znam największy element mogę utworzyć tablice

        for(int i = 0; i < tab.length; i++) //przechodzę po tabie zliczając liczby
        {
            tablicaDoZliczania[tab[i]]++;
        }

        //teraz wyszukuje element najczęściej występujący
        int max = 0;
        for(int i = 0; i < tablicaDoZliczania.length; i++)
            if(tablicaDoZliczania[i] > tablicaDoZliczania[max])
                max = i;

        if(tablicaDoZliczania[max] >= Math.round(tablicaDoZliczania.length / 2d)) //sprawdzam czy wystąpił więcej niż połowę razy
            System.out.printf("Lider: %d\n", max);
        else
            System.out.println("Nie znaleziono lidera!");
    }
}
