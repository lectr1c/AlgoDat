package me.lectr1c.F9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        run27();
    }

    public static void run27()  {
        try {
            String directory = System.getProperty("user.dir");
            BufferedReader in = new BufferedReader(new FileReader(directory + "/cars.txt"));
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
            saveToFile("carsA", cars);
            System.out.println(cars);
            cars.sort(new CompareCar());
            saveToFile("carsB", cars);
            System.out.println(cars);
        } catch (IOException e) {
                System.out.println(e.getMessage());
        }

    }

    public static void saveToFile(String filename, ArrayList<Car> cars){
        try {
            String directory = System.getProperty("user.dir");
            BufferedWriter out = new BufferedWriter(new FileWriter(directory + "/" + filename + ".txt"));
            for (Car car: cars) {
                String carStr = car.getModel() + " " + car.getYear() + " " + car.getMileage();
                out.write(carStr);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
