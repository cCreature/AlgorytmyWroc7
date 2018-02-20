package Zajecia0302;

public class PrzeszukiwanieMinMax {
    public static void main(String[] args) {
        String input = "[1,4,78,3]"; //przykładowe wejście
        String values = input.substring(input.indexOf("[") + 1,input.indexOf("]")).trim(); //napis pozbawiony [ ]
        String[] val = values.split(","); //tablica napisów rozdzielona po ,

        int[] valuesInt = new int[val.length]; //
        for (int i = 0; i < val.length; i++) { //idę po kolei po tablicy
            valuesInt[i] = Integer.parseInt(val[i]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int indexMin = -1; //indeks najmniejszaej wartości
        int indexMax = -1; //indeks największej wartości
        for (int i = 0; i < valuesInt.length; i++) {
            if(min > valuesInt[i]){ //jeżeli wartość jest mniejsza od dotychczasowej
                min = valuesInt[i];
                indexMin = i;
            }
            if (max < valuesInt[i]){ //jeżeli wartość jest większa od dotychczasowej
                max = valuesInt[i];
                indexMax = i;
            }
        }
        System.out.printf("MIN: %d, (%d)\n", indexMin, min);
        System.out.printf("MAX: %d, (%d)\n", indexMax, max);
    }
}
