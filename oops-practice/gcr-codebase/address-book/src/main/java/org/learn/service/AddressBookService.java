package org.learn.service;

import org.learn.dao.AddressBook;
import org.learn.model.Contact;
import org.learn.utils.AddressBookUtils;

import java.util.HashMap;
import java.util.Optional;

public class AddressBookService {
    HashMap<String, AddressBook> books;
    public AddressBookService() {
        this.books = new HashMap<>();
    }

    private boolean checkNull(Object object) {
        return object == null;
    }
    public boolean addAddressBook(String bookName){
        if(books.containsKey(bookName)){
            System.out.println(bookName + " already exists");
            return false;
        }
        books.put(bookName, new AddressBook());
        return true;
    }

    public boolean addContact(String bookName,Contact contact) {
        if (checkNull(contact)) {
            return false;
        }
        AddressBook addressBook = books.getOrDefault(bookName,null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
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
    public boolean updateContact(String bookName,Contact contact) {
        if (checkNull(contact)) {
            return false;
        }
        AddressBook addressBook = books.getOrDefault(bookName,null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
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
    public boolean deleteContact(String bookName,String firstName, String lastName) {
        AddressBook addressBook = books.getOrDefault(bookName,null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
            return false;
        }
        addressBook.deleteContact(firstName, lastName);
        System.out.println("Contact deleted successfully.");
        return true;
    }
}
