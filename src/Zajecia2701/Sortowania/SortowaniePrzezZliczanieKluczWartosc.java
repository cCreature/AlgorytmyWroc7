package Zajecia2701.Sortowania;

import java.util.Scanner;

public class SortowaniePrzezZliczanieKluczWartosc {
    public static void main(String[] args) {
        //Część 1: generowanie kluczy i wartości

        char[] arr = {'A', 'B', 'C'};
        String[] keys = new String[27];

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    sb.append(arr[i]).append(arr[j]).append(arr[k]);
                    keys[counter] = sb.toString();
                    sb.setLength(0);
                    counter++;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ilość ciągów:");
        int n = Integer.parseInt(sc.nextLine());

        String[] inputUser = new String[n];
        for (int i = 0; i < n; i++) {
            inputUser[i] = sc.nextLine().toUpperCase();
        }

        int[] counterArray = new int[27];
        for (int i = 0; i < inputUser.length; i++) {
            for (int j = 0; j < keys.length; j++) {
                if(keys[j].equals(inputUser[i])){
                    counterArray[j]++;
                    break;
                }
            }
        }

        for (int i = 0; i < counterArray.length; i++) {
            while (counterArray[i] > 0){
                System.out.print(keys[i] + " ");
                counterArray[i]--;
            }
        }
    }
}
