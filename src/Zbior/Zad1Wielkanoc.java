package Zbior;

public class Zad1Wielkanoc {
    public static void main(String[] args) {
        int rok = 2018;

        int a = rok % 19;
        int b = rok / 100;
        int c = rok % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * k + 22 * l) / 451;
        int p = (h + l - 7 * m + 114) % 31;

        int day = p + 1;
        int month = (h + l - 7 * m + 114) / 31;

        System.out.print("W roku " + rok + " Wielkanoc wypada " + day);
        if(month == 4) System.out.print(" kwietnia.");
        else System.out.print(" marca.");
    }
}
