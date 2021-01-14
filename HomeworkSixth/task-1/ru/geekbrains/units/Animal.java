package ru.geekbrains.units;

public abstract class Animal {
    private String name;
    private static int counter;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public String getName() {
        return name;
    }

    public static int getCounter() {
        return counter;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
