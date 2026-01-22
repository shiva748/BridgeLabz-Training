package org.learn.dao;

import org.learn.model.Contact;

import java.util.HashMap;
import java.util.Map;

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
}
