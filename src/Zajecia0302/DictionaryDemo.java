package Zajecia0302;

import java.util.Dictionary;
import java.util.HashMap;

public class DictionaryDemo {
    public static void main(String[] args) {

        HashMap<String, String> szyfrCezara = new HashMap<>();
        szyfrCezara.put("A", "D");
        szyfrCezara.put("B", "E");
        szyfrCezara.put("C", "F");
        szyfrCezara.put("D", "G");
        szyfrCezara.put("E", "H");
        szyfrCezara.put("F", "I");

        System.out.println(szyfrCezara.get("A"));
        szyfrCezara.remove("A");
        System.out.println();

    }
}
