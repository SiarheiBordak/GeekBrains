import ru.geekbrains.gui.PhoneBook;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Bordak", "+375336808097");
        phoneBook.add("Putin", "+37296404033");
        phoneBook.add("Trump", "+375336808097");
        phoneBook.add("Putin", "+79245437813");
        phoneBook.add("Navalny", "+375449071897");

        phoneBook.info();

        System.out.println("Putin phone number : " + phoneBook.get("Putin"));
    }
}
