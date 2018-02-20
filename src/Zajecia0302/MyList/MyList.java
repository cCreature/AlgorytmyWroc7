package Zajecia0302.MyList;

public class MyList {
    private int counter = 0; //pole, które przechowuje licznik zliczający elementy
    private Element head; //pole, które przechowuje głowę listy
    private Element tail; //pole, które przechowuje ogon listy

    public int getCounter() {return counter;}
    public Element getHead() {return head;}
    public Element getTail() {return tail;}

    public Element findForward(int value){ //metoda, która przechodzi po wszystkich elementach listy
        Element currentElement = head; //jako element pierwszy pobieramy sobie głowę listy
        if(currentElement.getData() == value) //jeżeli już pierwszy element spełnia nasz warunek kończymy działanie
            //i go zwracamy
            return currentElement;

        while (currentElement.getNext() != null){ //przechodzimy po każdym elemencie dopóki następnik wskazuje na inny element
            currentElement = currentElement.getNext(); //naszym nowym przetwarzanym elementem staje się następnik
            if(currentElement.getData() == value) //jeżeli wartości się zgadzają
                return currentElement; //zwracamy element
        }
        return null; //jeżeli nie udało się znaleźć zwracamy nulla
    }

    public Element findBackwards(int value){
        Element currentElement = tail; //zaczynamy przeszukiwanie od ogona
        if(currentElement.getData() == value) //sprawdzamy czy tym elemencie jest wyszukiwany przez nas element
            return currentElement; //zwracamy go

        while (currentElement.getPrev() != null){ //przechodzimy po każdym elemencie dopóki poprzednik wskazuje na inny element
            currentElement = currentElement.getPrev(); //naszym nowym przetwarzanym elementem staje się poprzednik
            if(currentElement.getData() == value) //jeżeli wartości się zgadzają
                return currentElement; //zwracamy element
        }
        return null; //jeżeli nie udało się znaleźć zwracamy nulla
    }

    private void setFirstElement(Element newElement){
        head = newElement; //nowy element staje się jednocześnie głową i ogonem
        tail = newElement;
        newElement.setNext(null); // ten element nie ma poprzednika i następnika
        newElement.setPrev(null);
        counter++; //zwiększam licznik
    }

    public void addAtBeginning(int value){
        Element newElement = new Element();  //tworzymy nowy element
        newElement.setData(value); //zapisujemy wartość, którą chcemy dodać do pola data

        if(counter > 0){
            newElement.setNext(head); //następnikiem pierwszego elementu staje się dotychczasowa głowa
            newElement.setPrev(null); //pierwszy element nie ma poprzednika
            head = newElement; //nowy element staje się głową
            Element nextOfNewElement = newElement.getNext(); //pobieramy wcześniejszą głowę
            nextOfNewElement.setPrev(newElement); //żeby jako poprzednik ustawić nowy element
            counter++; //zwiększam licznik
        }
        else {
            //jeżeli nasz nowo dodany element jest jedyny (np. całkowicie nowa lista
            // i dodajemy pierwszy element to wykonujemy specjalną logikę dodania pierwszego elementu
            setFirstElement(newElement);
        }
    }

    public void addAtEnd(int value){ //dodaje element na końcu
        Element newElement = new Element(); //tworzymy nowy element
        newElement.setData(value); //zapisujemy wartość, którą chcemy dodać do pola data

        if(counter > 0){
            newElement.setNext(null); //następnikiem ostatniego elementu jest null
            newElement.setPrev(tail); //poprzednikiem ostatniego elementu staje się dotyczasowy ogon
            tail = newElement; //nowy element staje się ogonem
            Element prevOfNewElement = newElement.getPrev(); //pobieram poprzednik nowego elementu (dot ogon)
            prevOfNewElement.setNext(newElement); //następnikiem tego elementu ustawiamy nowy element
            counter++; //zwiększam licznik
        }
        else {
            //jeżeli nasz nowo dodany element jest jedyny (np. całkowicie nowa lista
            // i dodajemy pierwszy element to wykonujemy specjalną logikę dodania pierwszego elementu
            setFirstElement(newElement);
        }
    }

    public void addElementAfterElement(int newValue, int valueInsertAfter) throws Exception {
        Element elementAfter = findForward(valueInsertAfter); //wyszukuje element po którym będzie wstawiany element

        if(elementAfter == null){ //jeżeli nie udało się odnaleźć rzucany jest wyjątek
            throw new Exception("Nie ma wartości");
        }

        if(elementAfter == tail){ //jeżeli element po którym wstawiamy jest ogon
            addAtEnd(newValue); //wołamy dodanie na końcu
        }
        else{
            Element newElement = new Element(); //w p.p tworzymy nowy element
            newElement.setData(newValue);
            newElement.setNext(elementAfter.getNext()); //przepisujemy element po elemencie, za którym chcemy wstawić
            newElement.setPrev(elementAfter); //poprzednikiem staje się element za którym chcemy wstawić

            elementAfter.setNext(newElement); //następnikiem elementu za którym wstawiamy staje się nowy element
            Element oldAfterElement = newElement.getNext(); //pobieram następnika nowego elementu
            oldAfterElement.setPrev(newElement); //i ustawiam mu nowy element za porzednika
            //równoważne newElement.getNext().setPrev(newElement);
            counter++; //zwiększam licznik
        }
    }

    public void addElementBeforeElement(int newValue, int valueInsertBefore) throws Exception {
        Element elementBefore = findForward(valueInsertBefore); //wyszukuje element po którym będzie wstawiany element

        if(elementBefore == null){  //jeżeli nie udało się odnaleźć rzucany jest wyjątek
            throw new Exception("Nie ma wartości");
        }

        if(elementBefore == head){ //jeżeli element po którym wstawiamy jest głowa
            addAtBeginning(newValue); //wołamy dodanie na początku
        }
        else{
            Element newElement = new Element(); //w p.p tworzymy nowy element
            newElement.setData(newValue);
            newElement.setNext(elementBefore); //następnikiem nowego elementu jest element przed który wstawiamy
            newElement.setPrev(elementBefore.getPrev()); //poprzednikiem staje się element przed elementem przed którym wstawiamy

            elementBefore.setPrev(newElement); //ustawiam elementowi przed którym chce wstawić element jako poprzednika nowy element
            Element oldBeforeElement = newElement.getPrev(); //pobieram element przed poprzednikiem nowego elementu
            oldBeforeElement.setNext(newElement); //ustawiamy mu następnika - nowy element
            //równoważne newElement.getPrev().setNext(newElement);
            counter++; //zwiększam licznik
        }
    }

    public void deleteElement(int value) throws Exception {
        Element elementToDelete = findForward(value); //wyszukuje element do usunięcia

        if(elementToDelete == null){  //jeżeli nie udało się odnaleźć rzucany jest wyjątek
            throw new Exception("Nie ma takiego elementu");
        }

        if(elementToDelete != head && elementToDelete != tail) { //jeżeli nie jest ani głową ani ogonem
            Element elementBeforeElementToDelete = elementToDelete.getPrev(); //pobieram poprzednika tego elementu
            elementBeforeElementToDelete.setNext(elementToDelete.getNext()); //ustawiam my następnika następnika elemementu, który usuwam

            Element elementAfterElementToDelete = elementToDelete.getNext(); //pobieram następnika tego elementu
            elementAfterElementToDelete.setPrev(elementToDelete.getPrev()); //ustawiam mu poprzednika poprzednika elementu, który usuwam
        }

        if(elementToDelete == head){ //jeżeli jest głową
            head = head.getNext(); //nową głową staje się następnik
            head.setPrev(null); //nowej głowie ustawiamy poprzednika na null
        }
        if(elementToDelete == tail){ //jeżeli jest ogonem
            tail = tail.getPrev(); //nowym ogonem staje się poprzednik
            tail.setNext(null); //nowemu ogonowi ustawiamy następnika na null
        }

        counter--; //zmniejszam licznik
    }


    //DEBUG
    public void printAll(){
        Element currentElement = head;
        while (true){
            System.out.println(currentElement.getData() + " "); //wydrukuj wartość elementu
            if(currentElement.getNext() != null) //jeżeli jest następnik
                currentElement = currentElement.getNext(); //pobierz nowy element
            else //w p.p przerwij działanie
                break;
        }
    }
}
