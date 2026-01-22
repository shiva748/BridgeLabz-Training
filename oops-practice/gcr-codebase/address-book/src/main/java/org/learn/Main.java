package org.learn;

import org.learn.service.AddressBookService;
import org.learn.utils.AddressBookUtils;
import java.util.Scanner;

public class Main {
    private static void printOptions() {
        System.out.println("Please select a option.");
        System.out.println("Add a contact:- ( 1 )");
        System.out.println("Update a contact:- ( 2 )");
        System.out.println("Delete a contact:- ( 3 )");
        System.out.println("Exit address book:- ( -1 )");
    }

    public static void main(String[] args) {
        AddressBookService service = new AddressBookService();
        Scanner sc = AddressBookUtils.sc;
        System.out.println("// === === Welcome to address book === === //");
        printOptions();
        boolean run = true;
        while(run){
            String input = sc.nextLine();
            switch (input){
                case "1":
                    service.addContact(AddressBookUtils.readContact());
                    break;
                case "2":
                    System.out.println("Please enter all details of contact you want to update.");
                    service.updateContact(AddressBookUtils.readContact());
                    break;
                case "3":
                    System.out.println("Please enter first and last name of contact you want to delete.");
                    String firstName = sc.nextLine();
                    String lastName = sc.nextLine();
                    service.deleteContact(firstName, lastName);
                case "-1":
                    run = false;
                    System.out.println("Thank you for using this program.");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
            printOptions();
        }
    }
}