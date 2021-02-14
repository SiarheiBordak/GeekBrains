import ru.geekbrains.units.Cat;
import ru.geekbrains.units.Eating;
import ru.geekbrains.units.Plate;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 20),
                new Cat("Bobik", 25),
                new Cat("Knopka", 20),
                new Cat("Somik", 25),
                new Cat("Murzik", 15)
        };

        Plate plate = new Plate(100);

        Eating eating = new Eating(cats, plate);

        eating.feedCats(cats, plate);

        eating.infoCats(cats);
    }
}
