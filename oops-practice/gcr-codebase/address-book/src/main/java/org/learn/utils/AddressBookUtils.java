package org.learn.utils;

import java.lang.reflect.Field;
import java.util.Scanner;

import org.learn.model.Contact;

public class AddressBookUtils {
    public static  Scanner sc = new Scanner(System.in);
    public static Contact readContact(){
        try{
            Class<?> cls = Contact.class;
            Field[] fields = cls.getDeclaredFields();
            Scanner sc = new Scanner(System.in);
            Contact contact = new Contact();
            for(Field field : fields){
                System.out.printf("Please enter %s: ", field.getName());
                field.setAccessible(true);
                field.set(contact, sc.nextLine());
                field.setAccessible(false);
            }
            return contact;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
