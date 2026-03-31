package org.learn.dao;

import org.learn.model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CityDictionary {

    private HashMap<String, List<String>> dictionary;

    public CityDictionary() {
        dictionary = new HashMap<>();
    }

    public void addPerson(String bookName, Contact contact) {
        List<String> lst = dictionary.getOrDefault(contact.getCity(), null);
        if (lst == null) {
            lst = new ArrayList<>();
            dictionary.put(contact.getCity(), lst);
        }
        lst.add(bookName + "_" + (contact.getFirstName() + "_" + contact.getLastName()).toLowerCase());
    }

    public void deletePerson(String bookName, Contact contact) {
        List<String> lst = dictionary.getOrDefault(contact.getCity(), null);
        if (lst == null) {
            return;
        }
        lst.remove(bookName + "_" + (contact.getFirstName() + "_" + contact.getLastName()).toLowerCase());
    }

    public List<String> getCity(String city) {
        return dictionary.getOrDefault(city, null);
    }
}
