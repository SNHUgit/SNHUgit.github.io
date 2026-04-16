package com.cs499.organizer.service;

import java.util.List;
import java.util.Optional;

import com.cs499.organizer.dao.ContactRepository;
import com.cs499.organizer.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Contact service implementation handles contact logic.
//Includes:
//- saving contacts
//- searching contacts
//- sorting contacts

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
	this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
	return contactRepository.findAll();
    }

    @Override
    public Contact findById(int id) {
	Optional<Contact> contactCheck = contactRepository.findById(id);
	Contact contact = null;
	if (contactCheck.isPresent()) {
	    contact = contactCheck.get();
	} else {
	    throw new RuntimeException("Did not find contact id - " + id);
	}
	return contact;
    }

    @Override
    public Contact save(Contact contact) {
	return contactRepository.save(contact);
    }

    @Override
    public void deleteById(int id) {
	contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> findByFirstNameContaining(String firstName) {
	return contactRepository.findByFirstNameContaining(firstName);
    }

    @Override
    public List<Contact> findByLastNameContaining(String lastName) {
	return contactRepository.findByLastNameContaining(lastName);
    }

    @Override
    public List<Contact> findByAddressContaining(String address) {
	return contactRepository.findByAddressContaining(address);
    }

    @Override
    public List<Contact> findByNumberContaining(String number) {
	return contactRepository.findByNumberContaining(number);
    }

    // Returns all contacts in the selected sort order.
    @Override
    public List<Contact> findAllSorted(String sort) {
        if ("asc".equals(sort)) {
            return contactRepository.findAllByOrderByLastNameAsc();
        } else if ("desc".equals(sort)) {
            return contactRepository.findAllByOrderByLastNameDesc();
        } else {
            return contactRepository.findAll();
        }
    }
    
    // Searches contacts and keeps the selected sort order.
    @Override
    public List<Contact> searchAndSortByName(String searchContact, String sort) {
        if ("asc".equals(sort)) {
            return contactRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrderByLastNameAsc(
                            searchContact, searchContact);
        } else if ("desc".equals(sort)) {
            return contactRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrderByLastNameDesc(
                            searchContact, searchContact);
        } else {
            return contactRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                            searchContact, searchContact);
        }
    }
}
