package org.learn.dao;

import org.learn.model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StateDictionary {
    private HashMap<String, List<String>> dictionary;
    public StateDictionary(){
        dictionary = new HashMap<>();
    }
    public void addPerson(String bookName, Contact contact){
        List<String> lst = dictionary.getOrDefault(contact.getState(), null);
        if (lst == null){
            lst = new ArrayList<>();
            dictionary.put(contact.getState(), lst);
        }
        lst.add(bookName+"_"+(contact.getFirstName()+"_"+contact.getLastName()).toLowerCase());
    }
    public void deletePerson(String bookName, Contact contact){
        List<String> lst = dictionary.getOrDefault(contact.getState(), null);
        if (lst == null){
            return;
        }
        lst.remove(bookName+"_"+(contact.getFirstName()+"_"+contact.getLastName()).toLowerCase());
    }
    public List<String> getState(String state){
        return dictionary.getOrDefault(state, null);
    }
}
