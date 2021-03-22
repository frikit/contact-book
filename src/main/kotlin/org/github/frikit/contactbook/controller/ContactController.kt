package org.github.frikit.contactbook.controller

import org.github.frikit.contactbook.model.Contact
import org.github.frikit.contactbook.service.ContactService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactController(
    private val contactService: ContactService
) {

    @GetMapping("/contacts")
    fun getContacts(): List<Contact> {
        return contactService.findAllContacts()
    }

}
