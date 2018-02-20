package Zajecia2701.PracaDomowa;

public class Warcaby {
    public static void main(String[] args) {
        //Użycie warcaby 3 4 B
        int m = 10; //rozmiar m
        int n = 7; //rozmiar n
        String color = "C"; //kolor B lub C
        int counter = 0; //licznik -- domyślnie dla koloru Czarnego parzysty licznik

        if(color.equals("B")) //jeżeli w polu A1 mamy mieć kolor Biały to zaburzamy zliczanie
        //zaczynając zliczanie od 1
        {
            counter = 1;
        }

        String[][] board = new String[m][n]; //tworzymy plansze

        for(int wiersz = 0; wiersz < m; wiersz++)//przechodzimy po wszystkich wierszach
        {
            for(int kolumna = 0; kolumna < n; kolumna++) //w tej pętli wrzechodzimy po wszystkich wierszach
            {
                //teraz musimy rozpatrzeć skrajne przypadki
                if (wiersz == 0 && kolumna == 0) //przypadek kiedy jesteśmy w polu A1
                    board[wiersz][kolumna] = color; //Po prostu przypisujemy kolor
                    //nie zaburzamy countera, ponieważ to zrobiliśmy wcześniej
                else if(kolumna==0) //przypadek kiedy jesteśmy w pierwszej kolumnie - nowy rząd
                {
                    if(board[wiersz-1][kolumna].equals("B")) //jeżeli rząd wyżej kolor był B
                    {
                        board[wiersz][kolumna] = "C"; //wstawiamy kolor C
                        counter = 0; //zaburzamy licznik, na podstawie którego ustalamy wartość kolejnych pól
                    }
                    else{
                        board[wiersz][kolumna] = "B"; //wstawiamy kolor B
                        counter = 1; //zaburzamy licznik i dzięki temu możemy ustalić wartości kolejnych pól
                    }
                }
                else{
                    if(counter % 2==0) //jeżeli licznik jest parzysty
                    {
                        board[wiersz][kolumna] = "C"; //ustawiamy kolor czarny
                    }
                    else{
                        board[wiersz][kolumna] = "B"; //ustawiamy kolor biały
                    }
                }

                counter++; //po każdym przejściu pętli zwiększamy licznik
            }
        }

        for(int i= 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(" %s ", board[i][j]);
            }
            System.out.printf("\n");

        }
    }
}
