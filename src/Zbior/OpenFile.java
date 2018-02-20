package Zbior;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenFile {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(
                "/src/Zbior/File.txt");

        Scanner sc = new Scanner(file); //Scanner odczytuje z pliku

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
        }

    }
}
