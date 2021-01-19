package ru.geekbrains.units;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int appetite) {
        if (food - appetite >= 0) {
            food -= appetite;
            return true;
        }

        return false;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
