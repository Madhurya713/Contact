package com.example.Contact.service;

import com.example.Contact.entity.Contact;
import com.example.Contact.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).get();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact contactDetails) {
        Contact contact = getContactById(id);
        contact.setFirstName(contactDetails.getFirstName());
        contact.setLastName(contactDetails.getLastName());
        contact.setEmail(contactDetails.getEmail());
        contact.setPhoneNumber(contactDetails.getPhoneNumber());
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.delete(getContactById(id));
    }

    public List<Contact> searchContacts(String search) {

        List<Contact> searchResults = new ArrayList<>();
        searchResults.addAll(contactRepository.findByFirstNameContainingIgnoreCase(search));
        searchResults.addAll(contactRepository.findByLastNameContainingIgnoreCase(search));
        searchResults.addAll(contactRepository.findByEmailContainingIgnoreCase(search));
        return searchResults;
//        return null;
    }
}
