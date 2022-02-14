package me.lectr1c.F9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        run27();
    }

    public static void run27()  {
        try {
            String directory = System.getProperty("user.dir");
            BufferedReader in = new BufferedReader(new FileReader(directory + "\\cars.txt"));
            ArrayList<Car> cars = new ArrayList<>();
            while (true){
                String line = in.readLine();
                if (line == null) break;

                var data = line.split(" ");
                String model = data[0];
                int year = Integer.parseInt(data[1]);
                int mileage = Integer.parseInt(data[2]);

                cars.add(new Car(model, year, mileage));
            }
            System.out.println(cars);
            Collections.sort(cars);
            System.out.println(cars);
            cars.sort(new CompareCar());
            System.out.println(cars);
        } catch (IOException e) {
                System.out.println(e.getMessage());
        }

    }
}
