package org.learn.service;

import org.learn.dao.AddressBook;
import org.learn.dao.StateDictionary;
import org.learn.dao.CityDictionary;
import org.learn.model.Contact;
import org.learn.utils.AddressBookUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class AddressBookService {

    HashMap<String, AddressBook> books;
    StateDictionary stateDictionary;
    CityDictionary cityDictionary;

    public AddressBookService() {
        this.books = new HashMap<>();
        this.stateDictionary = new StateDictionary();
        this.cityDictionary = new CityDictionary();
    }

    private boolean checkNull(Object object) {
        return object == null;
    }

    public boolean addAddressBook(String bookName) {
        if (books.containsKey(bookName)) {
            System.out.println(bookName + " already exists");
            return false;
        }
        books.put(bookName, new AddressBook());
        return true;
    }

    public boolean addContact(String bookName, Contact contact) {
        if (checkNull(contact)) {
            return false;
        }

        AddressBook addressBook = books.getOrDefault(bookName, null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
            return false;
        }

        if (addressBook.existsContact(contact)) {
            System.out.println("Contact already exists with same name.");
            return false;
        }

        addressBook.addContact(contact);
        stateDictionary.addPerson(bookName, contact);
        cityDictionary.addPerson(bookName, contact);

        System.out.println("Contact added successfully.");
        return true;
    }

    public boolean updateContact(String bookName, Contact contact) {
        if (checkNull(contact)) {
            return false;
        }

        AddressBook addressBook = books.getOrDefault(bookName, null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
            return false;
        }

        Optional<Contact> toUpdate =
                Optional.ofNullable(addressBook.getContact(contact.getFirstName(), contact.getLastName()));

        if (toUpdate.isPresent()) {

            if (!toUpdate.get().getState().equals(contact.getState())) {
                stateDictionary.deletePerson(bookName, toUpdate.get());
                stateDictionary.addPerson(bookName, contact);
            }

            if (!toUpdate.get().getCity().equals(contact.getCity())) {
                cityDictionary.deletePerson(bookName, toUpdate.get());
                cityDictionary.addPerson(bookName, contact);
            }

            addressBook.updateContact(contact);
            System.out.println("Contact updated successfully.");
            return true;

        } else {
            System.out.println("No contact found with same name to update.\nWould you like to save the contact? (yes/no): ");
            String decision = AddressBookUtils.sc.nextLine();
            if (decision.equals("yes")) {
                return addContact(bookName, contact);
            }
            return false;
        }
    }

    public Contact getContact(String bookName, String firstName, String lastName) {
        AddressBook addressBook = books.getOrDefault(bookName, null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
            return null;
        }
        return addressBook.getContact(firstName, lastName);
    }

    public boolean deleteContact(String bookName, String firstName, String lastName) {
        AddressBook addressBook = books.getOrDefault(bookName, null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
            return false;
        }

        Optional<Contact> toDelete =
                Optional.ofNullable(addressBook.getContact(firstName, lastName));

        if (toDelete.isPresent()) {
            stateDictionary.deletePerson(bookName, toDelete.get());
            cityDictionary.deletePerson(bookName, toDelete.get());
            addressBook.deleteContact(firstName, lastName);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("No Contact Found to delete.");
        }
        return true;
    }

    public void searchByState(String state) {
        Optional<List<String>> isState =
                Optional.ofNullable(stateDictionary.getState(state));

        if (!isState.isPresent()) {
            System.out.println("No State found.");
            return;
        }

        List<Contact> contacts = new ArrayList<>();
        for (String s : isState.get()) {
            String[] params = s.split("_");
            contacts.add(getContact(params[0], params[1], params[2]));
        }

        System.out.println(contacts);
    }

    public void searchByCity(String city) {
        Optional<List<String>> isCity =
                Optional.ofNullable(cityDictionary.getCity(city));

        if (!isCity.isPresent()) {
            System.out.println("No City found.");
            return;
        }

        List<Contact> contacts = new ArrayList<>();
        for (String s : isCity.get()) {
            String[] params = s.split("_");
            contacts.add(getContact(params[0], params[1], params[2]));
        }
        System.out.println(contacts);
    }

    public void countContactsByCity(String city) {
        List<String> persons = cityDictionary.getCity(city);
        System.out.print(persons == null ? "No contact's for this city." : persons.size()+" contacts found.");
    }

    public void countContactsByState(String state) {
        List<String> persons = stateDictionary.getState(state);
        System.out.print(persons == null ? "No contact's for this state." : persons.size()+" contacts found.");
    }

    public void getSortedByName(String bookName) {
        AddressBook addressBook = books.getOrDefault(bookName, null);
        if (addressBook == null) {
            System.out.println("No Address Book Found");
            return;
        }
        System.out.println(addressBook.getSortedByName());
    }

}
