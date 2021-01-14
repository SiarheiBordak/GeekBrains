package ru.geekbrains.units;

public class Cat extends Animal {
    private static int counter;

    public Cat(String name) {
        super(name);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200 && distance > 0) {
            System.out.println(getName() + " ran " + distance + " meters.");
        } else {
            System.out.println(getName() + " won't run this distance.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " can't swim " + distance + " meters.");
    }
}
