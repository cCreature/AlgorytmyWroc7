package Zajecia0302.MyList;

public class MyList {
    private int counter = 0;
    private Element head;
    private Element tail;

    public int getCounter() {return counter;}
    public Element getHead() {return head;}
    public Element getTail() {return tail;}

    public Element findForward(int value){
        Element currentElement = head;
        if(currentElement.getData() == value)
            return currentElement;

        while (currentElement.getNext() != null){
            currentElement = currentElement.getNext();
            if(currentElement.getData() == value)
                return currentElement;
        }
        return null;
    }

    public Element findBackwards(int value){
        Element currentElement = tail;
        if(currentElement.getData() == value)
            return currentElement;

        while (currentElement.getPrev() != null){
            currentElement = currentElement.getPrev();
            if(currentElement.getData() == value)
                return currentElement;
        }
        return null;
    }

    private void setFirstElement(Element newElement){
        head = newElement;
        tail = newElement;
        newElement.setNext(null);
        newElement.setPrev(null);
        counter++;
    }

    public void addAtBeginning(int value){
        Element newElement = new Element();
        newElement.setData(value);

        if(counter > 0){
            newElement.setNext(head);
            newElement.setPrev(null);
            head = newElement;
            Element nextOfNewElement = newElement.getNext();
            nextOfNewElement.setPrev(newElement);
            counter++;
        }
        else {
            setFirstElement(newElement);
        }
    }

    public void addAtEnd(int value){
        Element newElement = new Element();
        newElement.setData(value);

        if(counter > 0){
            newElement.setNext(null);
            newElement.setPrev(tail);
            tail = newElement;
            Element prevOfNewElement = newElement.getPrev();
            prevOfNewElement.setNext(newElement);
            counter++;
        }
        else {
            setFirstElement(newElement);
        }
    }

    public void addElementAfterElement(int newValue, int valueInsertAfter)
            throws Exception {
        Element elementAfter = findForward(valueInsertAfter);

        if(elementAfter == null){
            throw new Exception("Nie ma wartości");
        }

        if(elementAfter == tail){
            addAtEnd(newValue);
        }
        else{
            Element newElement = new Element();
            newElement.setData(newValue);
            newElement.setNext(elementAfter.getNext());
            newElement.setPrev(elementAfter);

            elementAfter.setNext(newElement);
            Element oldAfterElement = newElement.getNext();
            oldAfterElement.setPrev(newElement);
            //równoważne newElement.getNext().setPrev(newElement);
            counter++;
        }
    }

    public void addElementBeforeElement(int newValue, int valueInsertBefore)
            throws Exception {
        Element elementBefore = findForward(valueInsertBefore);

        if(elementBefore == null){
            throw new Exception("Nie ma wartości");
        }

        if(elementBefore == head){
            addAtBeginning(newValue);
        }
        else{
            Element newElement = new Element();
            newElement.setData(newValue);
            newElement.setNext(elementBefore);
            newElement.setPrev(elementBefore.getPrev());

            elementBefore.setPrev(newElement);
            Element oldBeforeElement = newElement.getPrev();
            oldBeforeElement.setNext(newElement);
            //równoważne newElement.getPrev().setNext(newElement);
            counter++;
        }
    }

    public void deleteElement(int value) throws Exception {
        Element elementToDelete = findForward(value);

        if(elementToDelete == null){
            throw new Exception("Nie ma takiego elementu");
        }

        if(elementToDelete != head && elementToDelete != tail) {
            Element elementBeforeElementToDelete = elementToDelete.getPrev();
            elementBeforeElementToDelete.setNext(elementToDelete.getNext());

            Element elementAfterElementToDelete = elementToDelete.getNext();
            elementAfterElementToDelete.setPrev(elementToDelete.getPrev());
        }

        if(elementToDelete == head){
            head = head.getNext();
            head.setPrev(null);
        }
        if(elementToDelete == tail){
            tail = tail.getPrev();
            tail.setNext(null);
        }

        counter--;
    }


    //DEBUG
    public void printAll(){
        Element currentElement = head;
        while (true){
            System.out.println(currentElement.getData() + " ");
            if(currentElement.getNext() != null)
                currentElement = currentElement.getNext();
            else
                break;
        }
    }
}
