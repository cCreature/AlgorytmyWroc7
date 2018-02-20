package Zajecia0302.Kopiec;

public class Kopiec {
    private int tab[] = new int[15];
    private int n = 0; //rozmiar bieżący kopca

    void addElementToKopiec(int element){
        int i = n;//ustawiamy indeks i na pozycję wstawianego elementu
        n++; //zwiększamy liczbę elementów
        int j = Math.floorDiv(i-1, 2); //indeks rodzica
        while (i > 0 && tab[j] < element){
            tab[i] = tab[j]; //umieszczamy rodzica na miejscu syna
            i = j;  //przenosimy się na pozycję ojca
            j = Math.floorDiv(i - 1, 2); //obliczamy indeks ojca
        }
        tab[i] = element; //wstawiamy element kopca
    }

    int deleteElement(){
        if(n > 0){
            int root = tab[0];
            n--;
            int element = tab[n]; //zapamiętujemy ostatni element kopca
            int i = 0; //przeszukiwanie drzewa rozpoczynamy od korzenia
            int j = 1; //j wskazuje lewego syna
            while (j < n){ //dopóki uda nam się odnaleźć lewego syna idziemy w dół kopca
                if(j+1 < n && tab[j+1] > tab[j]){//szukamy większego syna
                    j = j+1;
                }
                if(element > tab[j]) //jeśli warunek kopca spełniony, wychodzimy z pętli
                    break;
                tab[i] = tab[j]; //inaczej kopiujemy większego syna do ojca
                i = j; //przechodzimy na pozycję większego syna
                j = 2*j + 1;//j wskazuje lewego syna
            }
            tab[i] = element; //w odpowiednim miejscu umieszczamy ostatni element, aby zachowany był
            //warunek kopca
            return root;
        }
        return -1;
    }

    public void rozbierzKopiec(){
        int sortedTab[] = new int[n]; //tworzę tablice, która posłuży mi do sortowania
        for (int i = n-1; i >= 0 ; i--) {
            sortedTab[i] = deleteElement();//kasuje korzeń i jednocześnie zapisuje sobie jego wartość na ostatnim wolnym
            //miejscu tablicy
        }

        for (int i = 0; i < sortedTab.length; i++) {
            System.out.println(sortedTab[i]);
        }
    }

    void printAllElements(){
        for (int i = 0; i < n; i++) {
            System.out.printf("%d: %d\n", i, tab[i]);
        }
    }
}
