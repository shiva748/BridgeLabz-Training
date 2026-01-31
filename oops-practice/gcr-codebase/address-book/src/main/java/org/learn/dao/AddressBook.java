package org.learn.dao;

import org.learn.model.Contact;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBook {
    Map<String, Contact> map;
    public AddressBook() {
        map = new HashMap<>();
    }

    public boolean existsContact(Contact contact) {
        return map.containsKey((contact.getFirstName()+contact.getLastName()).toLowerCase());
    }

    public boolean addContact(Contact contact) {
        map.put((contact.getFirstName()+contact.getLastName()).toLowerCase(), contact);
        return true;
    }

    public Contact getContact(String firstName, String lastName) {
        return map.getOrDefault(firstName.toLowerCase()+lastName.toLowerCase(), null);
    }

    public boolean deleteContact(String firstName, String lastName) {
        map.remove(firstName.toLowerCase()+lastName.toLowerCase());
        return true;
    }

    public boolean updateContact(Contact contact) {
        deleteContact(contact.getFirstName(), contact.getLastName());
        addContact(contact);
        return true;
    }

    public List<Contact> getSortedByName() {
        return map.values().stream().sorted(Comparator.comparing((c)-> c.getFirstName()+" "+c.getLastName())).collect(Collectors.toList());
    }
}
