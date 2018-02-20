package Zajecia0302;

public class PrzeszukiwanieTablicy {
    public static void main(String[] args) {
        String input = "4 [1,4,78,3]"; //przykład wejścia
        int number = Integer.parseInt(
                input.substring(0, input.indexOf("[")).trim()
        ); //pobieram element do wyszukania
        String values = input.substring(input.indexOf("[") + 1,
                input.indexOf("]")).trim(); //wyciągamy tylko 1,4,78,3
        String[] val = values.split(","); //rozdzielamy po ,

        int[] valuesInt = new int[val.length]; //robimy tablice intów i zamieniamy napisy
        for (int i = 0; i < val.length; i++) {
            valuesInt[i] = Integer.parseInt(val[i]);
        }

        int index = -1;

        for (int i = 0; i < valuesInt.length; i++) {
            if(valuesInt[i] == number){ //jeżeli znaleźliśmy element przerywamy i zapisujemy jego pozycje
                index = i+1;
                break;
            }
        }
        System.out.println(index);
    }
}
