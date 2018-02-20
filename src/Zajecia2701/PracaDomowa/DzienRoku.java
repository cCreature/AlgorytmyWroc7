package Zajecia2701.PracaDomowa;

public class DzienRoku {
    public static void main(String[] args) {
        int[] _daysInMonth =         {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //liczba dni w miesiącu w zwykłaym roku
        int[] _daysInMonthLeapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //liczba dni w przestępnym roku

        //Jedno z wielu możliwych rozwiązań
        //Wykorzystam tablice z wyliczonymi wcześniej długościami miesięcy
        //jako elementowi 0 przypisuje wartość 0, aby indeksy w tablicy odpowiadały miesiącom

        int day = 8;
        int month = 11;
        int year = 2014;

        int[] daysInMonth; //żeby jak najbardziej uwspólnić kod i żeby był jak najczytelniejszy
        //tworzę dodatkową tablicę, do której przepisze wartości z wcześniej zdefiniowanych tablic
        //w ten sposób nie muszę się bawić w kobinowanie ze zmianami tablic i dodatkowymi ifami
        //mogę to zrobić, ponieważ mam pewność, że w obu przypadkach długość tablic będzie taka sama


        if(!IsLeapYear(year)) //sprawdzam czy rok jest przestępny (napisałem dodatkową prywatną metodę poniżej
        //jest ona dokładniej omówiona w RokPrzestepny)
        {
            daysInMonth = _daysInMonth; //jeżeli nie jest przestępny to będę korzystał z danych z tablicy _daysInMonth
        }
        else
        {
            daysInMonth = _daysInMonthLeapYear; //w p.p. korzystam z przygotowanej tablicy dla roku przestępnego
        }

        //Waliduje (sprawdzam) skrajne przypadki, które mogłby wyłożyć algorytm
        if(month > 12 || month < 1) //nie ma 13 i większego miesiąca - wyświetlam błąd i kończę działanie
        {
            System.out.println("Nie ma takiej daty!");
            return;
        }

        if(day > daysInMonth[month]) // każdy miesiąc ma określoną liczbę dni - jeżeli została ona przekroczona kończę działanie
        //i wyświetlam błąd
        {
            System.out.println("Nie ma takiej daty!");
            return;
        }

        int result = 0; //zmienna służy do przechowywania wyniku

        for(int i = 0; i < month; i++) //przechodzimy po miesiącach od stycznia (01) do miesiąca o 1 mniejszego od
        // miesiąca który podaliśmy na wejściu i pobieramy jego liczbę dni
        {
            result = daysInMonth[i] + result; //następnie tą liczbę dni dodajemy do wyniku
        }
        result = result + day; //na koniec dodajemy dni, które mamy w miesiącu który podaliśmy na wejściu

        //Przykład dla daty 11 07 2013
        //Ostatni dzień czerwca jest 181 dniem roku i dodajemy 11, więc 11 07 jest 192 dniem roku.

        System.out.printf("Dzień %d.%d.%d jest %d dniem roku", day, month, year, result);
    }

    private static Boolean IsLeapYear(int year) //metoda zwraca TRUE jeżeli rok jest przestępny, FALSE w p.p.
    {
        if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
            return true;
        }

        return false;
    }

}
