package Zajecia0302.PracaDomowa.OneWayList;

public class OneWayList {
    private OneWayListElement _head;
    private int _counter;

    //SEKCJA DODAWAWANIA I USUWANIA ELEMENTÓW NA POCZĄTKU / KOŃCU LISTY
    public void addElementAtBeginning(int newElement) //dodajemy nowy element na początku listy
    {
        OneWayListElement p = new OneWayListElement(); //tworzymy nowy element
        p.data = newElement; //zapisujemy wartość, którą chcemy dodać do pola data
        p.next = _head; //następnikiem ustawiamy obecną głowę, ponieważ to był pierwszy dotychczasowy element
        _head = p; //nowo utworzony obiekt staje się głową
        _counter++; //zwiększamy licznik o 1
    }

    public void deleteElementAtBeginning(){
        OneWayListElement p = _head; //pobieramy wskaźnik na głowę
        if(p != null) //jeżeli jest on różny od null oznacza, że przechowuje wartość
        {
            _head = p.next; //głowa od tego momentu wskazuje na następnika
            p=null; //usuwamy element z pamięci
        }
        _counter--;
    }

    public void addElementAtEnd(int newElement) //dodajemy nowy element na końcu listy
    {
        OneWayListElement p = new OneWayListElement(); //tworzymy nowy element
        p.data = newElement; //zapisujemy wartość, którą chcemy dodać do pola data
        p.next = null; //od razu ustawiamy wartość na null, ponieważ ostatni element NIE może mieć poprzednika

        if(_counter == 0) //jeżeli lista jest pusta nie mamy wyjścia i od razu ustawiamy wskaźnik głowy na nas
        {
            _head = p;
        }
        else //w przeciwnym wypadku musimy dotrzeć do ostatniego elementu
        {
            OneWayListElement iterator = _head; //ustawiamy iterator na głowę
            while (iterator.next != null) //idziemy po kolejnych elememntach aż nie będziemy mieli następnika
            {
                iterator = iterator.next; //przeskakujemy do kolejnego elememntu
            }
            iterator.next = p; //jeżeli zakończyliśmy pętle bo nie mamy następnika to ustawiamy nowy element jako następnik ostatniego
            //teraz już przedostatniego
        }

        _counter++; //zwiększamy licznik o 1
    }

    public void deleteElementAtEnd(){
        OneWayListElement iterator = _head; //ustawiamy wskaźnik, który będzie przechodził po całej liście
        //na głowę
        if(_counter == 0 ) //jeżeli lista jest pusta
            return; //kończymy - nie mamy czego usuwać

        //w przeciwnym razie idziemy na koniec listy
        if(iterator.next !=null) //jeżeli mamy następnika
        {
            while(iterator.next.next !=null) //jeżeli następnik następnika nie jest ostatnim elementem
            //zatrzymujemy się w przedostatnim elemencie
            {
                iterator = iterator.next; //przechodzimy do następnego elementu
            }
            iterator.next = null; //skoro znaleźliśmy przedostatni element to one teraz staje się ostatnim
        }
        else //w przeciwnym razie jesteśmy smutną listą jednoelementową
        {
            _head = null; //Usuwamy jedyny element, więc głowa jest pusta
            iterator = null; //czyścimy iterator - sprzątamy po sobie
            _counter--;
        }

    }

    public void addElementBeforeElement(int elementToAdd, int beforeElement)
    {
        OneWayListElement elementBefore = getElementForward(beforeElement);
        //wyszukujemy nasz element

        if(elementBefore == _head) //jeżeli element przed który chcemy dodać jest głową
        {
            addElementAtBeginning(elementToAdd); //skorzystajmy z metody dodawania na początku listy
        }
        else //w przeciwnym razie musimy jeszcze raz wyszukać nasz element
        //tym razem musimy zatrzymać się na elemencie przed nim
        //żeby pozmieniać wskaźniki
        {
            OneWayListElement iterator = _head;
            while (iterator.next != elementBefore) //dopóki nie znajdziemy
            //elementu, któego następnikiem jest element przed który chcemy wstawić
            {
                iterator = iterator.next; //przechodzimy do następnego elementu
            }

            OneWayListElement newElement = new OneWayListElement();
            newElement.data = elementToAdd;
            newElement.next = iterator.next; //następnikiem nowego elementu staje się element przed który chcemy dodać
            iterator.next = newElement; //iteratorem zatrzymaliśmy się przed elementem przed którym chcemy dodać
            //więc następnikiem tego elementu staje się nasz element
        }
        _counter++;
    }

    public void addElementAfterElement(int elementToAdd, int afterElement){
        OneWayListElement elementAfter = getElementForward(afterElement); //wyszukujemy element za który chcemy dodać

        OneWayListElement newElement = new OneWayListElement();
        newElement.data = elementToAdd;
        newElement.next = elementAfter.next; //następnikiem naszego elementu jest następnik elelemntu za który chcemy wstawić

        elementAfter.next = newElement; //następnikiem elementu za który chcemy wstawić stajemy się my
        _counter++;
    }

    public void deleteElement(int elementToDelete)
    {
        OneWayListElement toDelete = getElementForward(elementToDelete); //wyszukujemy element do usunięcia

        if(_head == toDelete) //jeżeli okazało się, że w głowie
        //znajduje się element do usunięcia
        {
            deleteElementAtBeginning(); //korzystamy z metody do usunięcia na początku listy
        }
        else //w przeciwnym wypadku musimy znaleźć elementu przed elementem do usunięcia
        {
            OneWayListElement iterator = _head; //tworzymy iterator, którym będziemy wyszukiwać elememt
            //i od razu przypisujemy mu wskazanie na głowę
            while (iterator.next != toDelete)//przechodzimy aż zatrzymamy się w elemencie, który
            //znajduje się przed elementem do usunięcia
            {
                iterator = iterator.next; //przechodzimy do następnego elementu
            }
            iterator.next = toDelete.next; //przepisujemy następnik elementu usuwanego do następnika elementu
            //przed tym do usunięcia
            toDelete = null; //robimy porządek i usuwamy nasz element
        }
    }

    //SEKCJA POMOCNICZO - TECHNICZNA
    public OneWayListElement getElementForward(int data) //metoda zwraca pierwszy element, który przechowuje
    //zadeklarowaną przez nas wartość
    {
        OneWayListElement p = _head; //zaczynamy wyszukiwanie od głowy
        while (p.next != null) //przechodzimy dopóki mamy następnik
        {
            if(p.data == data){
                break; //jeżeli udało nam się znaleźć element to kończymy wykonywanie pętli
            }
            p = p.next;
        }

        return p; //jeżeli nie mamy następnika lub przerwaliśmy pętle zwracamy p (pierwszy element z wartością
        //którą chcemy uzyskać lub ogon z listy)
    }

    public void printAllElements() //metoda drukuje całą listę od pierwszego elementu (głowy) do ostatniego
    // - ogona
    {
        OneWayListElement p = _head; //zaczynamy wyszukiwanie od głowy
        while (p != null) //przechodzimy dopóki mamy jakąkolwiek wartość (łącznie z ostatnim elementem)
        {
            System.out.println(p.data);
            p = p.next;
        }
    }
}
