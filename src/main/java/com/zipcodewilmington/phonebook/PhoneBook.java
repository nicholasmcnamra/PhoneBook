package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>();
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        boolean entry = false;
        if (phonebook.containsKey(name) || phonebook.containsValue(phoneNumber)) {
            entry = true;
        }
        return entry;
    }
    public Boolean hasEntry(String name) {
        boolean entry = false;
        if (phonebook.containsKey(name)) {
            entry = true;
        }
        return entry;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String key = "";
        for (Map.Entry<String, List<String>> entry: phonebook.entrySet()) {
            String value = entry.getValue().toString();
            value = value.substring(1, value.length()-1);
            if(Objects.equals(value, phoneNumber)) {
                key = entry.getKey();
            }
        }
        return key;
    }

    public List<String> getAllContactNames() {
        List <String> keys = new ArrayList<String>();
        for (String key : phonebook.keySet()) {
            keys.add(key);
        }
        return keys;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
