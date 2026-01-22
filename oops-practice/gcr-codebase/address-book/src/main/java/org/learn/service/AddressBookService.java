package org.learn.service;

import org.learn.dao.AddressBook;
import org.learn.model.Contact;
import org.learn.utils.AddressBookUtils;

import java.util.Optional;

public class AddressBookService {
    AddressBook addressBook;
    public AddressBookService() {
        this.addressBook = new AddressBook();
    }

    private boolean checkNull(Object object) {
        return object == null;
    }
    public boolean addContact(Contact contact) {
        if (checkNull(contact)) {
            return false;
        }
        if(addressBook.existsContact(contact)){
            System.out.println("Contact already exists with same name.");
            return false;
        }
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
        return true;
    }
    public boolean updateContact(Contact contact) {
        if (checkNull(contact)) {
            return false;
        }
        Optional<Contact> toUpdate = Optional.ofNullable(addressBook.getContact(contact.getFirstName(), contact.getLastName()));
        if(toUpdate.isPresent()){
            addressBook.updateContact(contact);
            System.out.println("Contact updated successfully.");
            return true;
        }else{
            System.out.println("No contact found with same name to update.\nWould you like to save the contact? (yes/no): ");
            String decision = AddressBookUtils.sc.nextLine();
            if(decision.equals("yes")){
                return addressBook.addContact(contact);
            }else{
                return false;
            }
        }
    }
}
