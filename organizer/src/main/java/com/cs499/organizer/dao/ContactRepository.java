package com.cs499.organizer.dao;

import com.cs499.organizer.entity.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByFirstNameContaining(String firstName);
    List<Contact> findByLastNameContaining(String lastName);
    List<Contact> findByNumberContaining(String Number);
    List<Contact> findByAddressContaining(String address);
    
    List<Contact> findAllByOrderByLastNameAsc();
    List<Contact> findAllByOrderByLastNameDesc();

    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName);

    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrderByLastNameAsc(
            String firstName, String lastName);

    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrderByLastNameDesc(
            String firstName, String lastName);
}
