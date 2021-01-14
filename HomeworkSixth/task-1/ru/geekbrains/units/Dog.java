package ru.geekbrains.units;

public class Dog extends Animal {
    private static int counter;

    public Dog(String name) {
        super(name);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500 && distance > 0) {
            System.out.println(getName() + " ran " + distance + " meters.");
        } else {
            System.out.println(getName() + " won't run this distance.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10 && distance > 0) {
            System.out.println(getName() + " swam " + distance + " meters.");
        } else {
            System.out.println(getName() + " will not swim this distance.");
        }
    }
}
