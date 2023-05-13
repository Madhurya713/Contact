package com.example.Contact.controller;

import com.example.Contact.entity.Contact;
import com.example.Contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("getAllContacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("getContactById/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PostMapping("createContact")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id,@RequestBody Contact newContact) {
        return contactService.updateContact(id, newContact);
    }

    @DeleteMapping("deleteContact/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @GetMapping("/search")
    public List<Contact> searchContacts(@RequestParam String query) {
        return contactService.searchContacts(query);
    }
}
