package Zajecia0302.PracaDomowa.OneWayList;

public class OneWayListDemo {
    public static void main(String[] args) {
        OneWayList lista = new OneWayList();
        System.out.printf("Testujemy dodawanie elementów\n");
        lista.addElementAtBeginning(23);
        lista.addElementAtBeginning(24);
        lista.addElementBeforeElement(25, 24);
        lista.addElementBeforeElement(20, 24);
        lista.addElementAtEnd(10);
        lista.addElementAtEnd(11);
        lista.addElementAfterElement(12, 11);
        lista.addElementAfterElement(88, 23);
        lista.printAllElements();
        System.out.printf("\n");

        System.out.printf("Zaczynamy testować usuwanie\n");
        System.out.printf("Usuwam element 25\n");
        lista.deleteElement(25);
        lista.printAllElements();
        System.out.printf("Usuwam element 10\n");
        lista.deleteElement(10);
        lista.printAllElements();
    }
}
