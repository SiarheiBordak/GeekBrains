package ru.geekbrains.animals;

public class Cat extends Animal {
    private static int countCat;

    public Cat(String name) {
        super(name, 200, 0);
        countCat++;
    }

    public static int getCountCat() {
        return countCat;
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
        System.out.println(getName() + " can't swim " + distance + " meters.");
    }
}
