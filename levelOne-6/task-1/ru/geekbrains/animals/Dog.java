package ru.geekbrains.animals;

public class Dog extends Animal {
    private static int countDog;

    public Dog(String name) {
        super(name,500, 10);
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    @Override
    public void run(int distance) {
        if (distance <= getMaxRunDistance() && distance > 0) {
            System.out.println(getName() + " ran " + distance + " meters.");
        } else {
            System.out.println(getName() + " won't run this distance.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= getMaxSwimDistance() && distance > 0) {
            System.out.println(getName() + " swam " + distance + " meters.");
        } else {
            System.out.println(getName() + " will not swim this distance.");
        }
    }
}
