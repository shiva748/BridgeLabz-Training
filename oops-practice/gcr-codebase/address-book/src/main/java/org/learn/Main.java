package org.learn;

import org.learn.service.AddressBookService;
import org.learn.utils.AddressBookUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBookService service = new AddressBookService();
        Scanner sc = new Scanner(System.in);
        System.out.println("// === === Welcome to address book === === //");
        System.out.println("Please select a option.");
        System.out.println("Add a contact:- ( 1 )");
        System.out.println("Exit address book:- ( -1 )");
        boolean run = true;
        while(run){
            String input = sc.nextLine();
            switch (input){
                case "1":
                    service.addContact(AddressBookUtils.readContact());
                    System.out.println("Contact added successfully.");
                    break;
                case "-1":
                    run = false;
                    System.out.println("Thank you for using this program.");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}