import ru.geekbrains.animals.Animal;
import ru.geekbrains.animals.Cat;
import ru.geekbrains.animals.Dog;

public class Main {

    public static void main(String[] args) {
        Dog dogOne = new Dog("dogOne");
        dogOne.run(450);
        dogOne.swim(9);

        Dog dogTwo = new Dog("dogTwo");
        dogTwo.run(502);
        dogTwo.swim(7);

        Dog dogThree = new Dog("dogThree");
        dogThree.run(50);
        dogThree.swim(11);

        Cat catOne = new Cat("catOne");
        catOne.run(202);
        catOne.swim(0);

        Cat catTwo = new Cat("catTwo");
        catTwo.run(150);
        catTwo.swim(10);

        System.out.println("Number of animals: " + Animal.getCountAnimal());
        System.out.println("Number of dogs: " + Dog.getCountDog());
        System.out.println("Number of cats: " + Cat.getCountCat());
    }
}
