package me.lectr1c.F9;

public class Car implements Comparable<Car> {

    private String model;
    private int year;
    private int mileage;

    public Car(String model, int year, int mileage) {
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public int compareTo(Car o) {
        return -(o.model.compareTo(this.model));
    }

    @Override
    public String toString(){
        return "Model: " + model + " Year: " + year + " Mileage: " + mileage;
    }
}
