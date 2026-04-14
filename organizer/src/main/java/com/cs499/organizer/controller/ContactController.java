package com.cs499.organizer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs499.organizer.entity.Contact;
import com.cs499.organizer.service.ContactService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Initialize contact page
    @GetMapping
    public String contactPage(@RequestParam(required = false) String searchContact,
            @RequestParam(required = false) String sort,
            Model model) {

        loadContactPageModel(model, searchContact, sort, "showContact");
        return "contact";
    }

    // Add Contact
    @PostMapping("/add")
    public String addContact(@Valid @ModelAttribute("newContact") Contact newContact,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            loadContactPageModel(model, null, "asc", "addContact");
            return "contact";
        }

        contactService.save(newContact);
        return "redirect:/contact";
    }

    // Edit Contact
    @PostMapping("/edit")
    public String updateContact(@RequestParam int id,
            @Valid @ModelAttribute("editContact") Contact editContact,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            loadContactPageModel(model, null, "asc", "editContact");
            return "contact";
        }

        Contact contact = contactService.findById(id);
        contact.setFirstName(editContact.getFirstName());
        contact.setLastName(editContact.getLastName());
        contact.setNumber(editContact.getNumber());
        contact.setAddress(editContact.getAddress());
        contactService.save(contact);

        return "redirect:/contact";
    }

    // Delete Contact
    @PostMapping("/delete")
    public String deleteContact(@RequestParam int id) {
        contactService.deleteById(id);
        return "redirect:/contact";
    }

    // Loads common model data needed for the contact page
    private void loadContactPageModel(Model model, String searchContact, String sort, String activeTab) {

        if (sort == null || sort.isBlank()) {
            sort = "asc";
        }

        List<Contact> contacts;

        if (searchContact != null && !searchContact.isBlank()) {
            contacts = contactService.searchAndSortByName(searchContact, sort);
        } else {
            contacts = contactService.findAllSorted(sort);
        }

        model.addAttribute("contacts", contacts);
        model.addAttribute("searchContactValue", searchContact);
        model.addAttribute("sort", sort);
        model.addAttribute("activeTab", activeTab);

        if (!model.containsAttribute("newContact")) {
            model.addAttribute("newContact", new Contact());
        }

        if (!model.containsAttribute("editContact")) {
            model.addAttribute("editContact", new Contact());
        }
    }
}