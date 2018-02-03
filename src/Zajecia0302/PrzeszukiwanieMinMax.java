package Zajecia0302;

public class PrzeszukiwanieMinMax {
    public static void main(String[] args) {
        String input = "[1,4,78,3]";
        String values = input.substring(input.indexOf("[") + 1,
                input.indexOf("]")).trim();
        String[] val = values.split(",");

        int[] valuesInt = new int[val.length];
        for (int i = 0; i < val.length; i++) {
            valuesInt[i] = Integer.parseInt(val[i]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        int indexMax = -1;
        for (int i = 0; i < valuesInt.length; i++) {
            if(min > valuesInt[i]){
                min = valuesInt[i];
                indexMin = i;
            }
            if (max < valuesInt[i]){
                max = valuesInt[i];
                indexMax = i;
            }
        }
        System.out.printf("MIN: %d, (%d)\n", indexMin, min);
        System.out.printf("MAX: %d, (%d)\n", indexMax, max);
    }
}
