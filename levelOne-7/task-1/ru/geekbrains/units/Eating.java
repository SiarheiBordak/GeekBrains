package ru.geekbrains.units;

public class Eating {
    private Cat[] cats;
    private Plate plate;

    public Eating(Cat[] cats, Plate plate) {
        this.cats = cats;
        this.plate = plate;
    }

    public void feedCats(Cat[] cats, Plate plate) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }

    public void infoCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].isSatiety()) {
                System.out.println(cats[i].getName() + " ate.");
            } else {
                System.out.println(cats[i].getName() + " is hungry.");
            }
        }
    }
}
