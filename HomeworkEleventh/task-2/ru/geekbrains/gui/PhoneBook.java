package ru.geekbrains.gui;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        ArrayList<String> phoneList = phoneBook.get(name);

        if (phoneList == null) {
            phoneList = new ArrayList<>();
        }

        phoneList.add(phone);
        phoneBook.put(name, phoneList);
    }

    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }

    public void info() {
        System.out.println(phoneBook);
    }
}
