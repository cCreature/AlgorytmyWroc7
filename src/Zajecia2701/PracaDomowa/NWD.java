package Zajecia2701.PracaDomowa;

import java.util.Scanner;

public class NWD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        System.out.println(nwd(k, n));
    }

    private static int nwd(int k, int n){
        if(k == 0)
            return n;

        return nwd(n%k, k);
    }
}
