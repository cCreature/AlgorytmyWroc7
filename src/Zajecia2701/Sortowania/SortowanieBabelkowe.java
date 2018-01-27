package Zajecia2701.Sortowania;

public class SortowanieBabelkowe {
    public static void main(String[] args) {
        int sort[] = {5, 4, 3, 2, 1};

        for(int i=0; i<sort.length;i++) //idziemy po całej długości tablicy do posortowania
        {
            for(int j=0;j<sort.length-1; j++) //za każdym razem zaczynamy od początku, aby mieć
            //pewność, że zawsze uda nam się dobrze posortować
            {
                if(sort[j]>sort[j+1]) //Jeżeli elementy są w złej kolejności wykonaj SWAPa
                {
                    //SWAP - zamiana miejscami dwóch elementów w tablicy
                    int temp = sort[j]; //tworzymy zmienną tymczasową i od razu zapisujemy do niej pierwszą wartość
                    sort[j] = sort[j+1]; //zamieniamy miejscami wartości
                    sort[j+1] = temp; //odzyskujemy wartość z temp i zapisujemy na nowym, tym razem odpowiednim miejscu
                }
            }
        }
    }
}
