package Zbior;

import java.io.*;

public class Zad6BajtockieSwietoTrojkata {
    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir");
            File f = new File("src/Zbior/Files/TriangleHoliday.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            //Odczytanie ilości przypadków
            readLine = b.readLine();
            int testNumber = Integer.parseInt(readLine);

            //Odczytanie liczby uczestników n i zużycie kredy k
            for(int i = 0; i < testNumber; i++) {
                readLine = b.readLine();
                String[] parsedLine = new String[3];
                parsedLine = readLine.split(" ");
                int numberOfChildren = Integer.parseInt(parsedLine[0]);
                chalkUsing = Float.parseFloat(parsedLine[1])*1000; //użycie kredy w gramach

                for(int j=0; j < numberOfChildren; j++){
                    readLine = b.readLine();
                    parsedLine = readLine.split(" ");
                    CalculateUsing(parsedLine);

                }
                System.out.println(tempResult);
                tempResult = 0;
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double tempResult;
    public static double chalkUsing;

    private static void CalculateUsing(String[] test){
        int a = Integer.parseInt(test[0]);
        int b = Integer.parseInt(test[1]);
        int c = Integer.parseInt(test[2]);

        double result = 0.0;
        if(CheckIfTriangleExist(a, b, c)){
            result = Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c))/4.0;
            result = result / 10000.0; //wynik w metrach kwadratowych
            tempResult += Math.round(result * chalkUsing);
        }

    }

    private static boolean CheckIfTriangleExist(int a, int b, int c){
        boolean canI = false;
        if(a + b >= c){
            return true;
        }
        else if(a + c >= b){
            return true;
        }
        else if(b + c >= a){
            return true;
        }
        else{
            return false;
        }
    }
}
