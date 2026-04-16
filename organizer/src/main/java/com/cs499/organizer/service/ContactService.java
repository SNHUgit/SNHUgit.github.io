package com.cs499.organizer.service;

import java.util.List;

import com.cs499.organizer.entity.Contact;

//Contact service defines contact operations.
//Includes:
//- CRUD work
//- search
//- sorting

public interface ContactService {
    List<Contact> findAll();
    Contact findById(int id);
    Contact save(Contact contact);
    void deleteById(int id);
    List<Contact> findByFirstNameContaining(String firstName);
    List<Contact> findByLastNameContaining(String lastName);
    List<Contact> findByAddressContaining(String address);
    List<Contact> findByNumberContaining(String number);
    List<Contact> findAllSorted(String sort);
    List<Contact> searchAndSortByName(String searchContact, String sort);    
}
