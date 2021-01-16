package ru.geekbrains.animals;

public abstract class Animal {
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    private static int countAnimal;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        countAnimal++;
    }

    public String getName() {
        return name;
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
