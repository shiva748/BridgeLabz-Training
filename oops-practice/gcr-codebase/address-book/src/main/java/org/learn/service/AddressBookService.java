package org.learn.service;

import org.learn.dao.AddressBook;
import org.learn.model.Contact;

public class AddressBookService {
    AddressBook addressBook;
    public AddressBookService() {
        this.addressBook = new AddressBook();
    }
    public boolean addContact(Contact contact) {
        if(addressBook.existsContact(contact)){
            System.out.println("Contact already exists with same name.");
            return false;
        }
        return addressBook.addContact(contact);
    }
}
