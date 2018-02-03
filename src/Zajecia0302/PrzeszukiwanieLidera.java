package Zajecia0302;

public class PrzeszukiwanieLidera {
    public static void main(String[] args) {
        int tab[] = {1, 1, 1, 4, 4, 1, 1, 1, 1, 4};
        int maxInTab = -1;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] > maxInTab)
                maxInTab = tab[i];
        }

        int countingTab[] = new int[maxInTab + 1];

        for (int i = 0; i < tab.length; i++) {
            countingTab[tab[i]]++;
        }

        int countingMaxIdx = 0;
        for (int i = 0; i < countingTab.length; i++) {
            if(countingTab[i] > countingTab[countingMaxIdx])
                countingMaxIdx = i;
        }

        if(countingTab[countingMaxIdx] / (double)tab.length >= 0.5)
            System.out.println(countingMaxIdx);
        else
            System.out.println(-1);
    }
}
