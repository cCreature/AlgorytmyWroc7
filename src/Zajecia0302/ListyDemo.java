package Zajecia0302;

import java.util.ArrayList;

public class ListyDemo {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Mercedes");
        cars.add("Audi");
        cars.add("Skoda");

        for (String car : cars) {
            System.out.println(car);
        }

    }
}
