package Zajecia2701.Sortowania;

public class SortowaniePrzezZliczanie {
    public static void main(String[] args) {
        int[] toSort = {5, 5, 3, 8, 1, 2, 4, 4, 3};

        int max = -1;
        //Wyszukanie maxa
        for (int i = 0; i < toSort.length; i++) {
            if(max < toSort[i])
                max = toSort[i];
        }

        int[] countingTable = new int[max+1];
        // zliczanie
        for (int i = 0; i < toSort.length; i++)
            countingTable[toSort[i]]++;

        for (int i = 0; i < countingTable.length; i++) {
            while (countingTable[i] > 0) {
                System.out.print(i + " ");
                countingTable[i]--;
            }
        }

    }
}
