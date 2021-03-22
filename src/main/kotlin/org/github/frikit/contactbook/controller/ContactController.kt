package org.github.frikit.contactbook.controller

import org.github.frikit.contactbook.model.Contact
import org.github.frikit.contactbook.service.ContactService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class ContactController(
    private val contactService: ContactService
) {

    private val log = LoggerFactory.getLogger(ContactController::class.java)

    //TODO can add pagination if required very easy
    //TODO would be better to do with post search by postcode but it depends on business use case so will leave GET for now
    @GetMapping("/contacts")
    fun getContacts(
        @RequestParam postcode: String?
    ): List<Contact> {
        return if (postcode == null)
            contactService.findAllContacts()
        else
            contactService.findContactByPostcode(postcode)
    }


    @PostMapping("/add/contact")
    fun addContact(
        @RequestBody contactToAdd: Contact
    ) {
        log.info("Add contact=$contactToAdd...")
        val added = contactService.saveContact(contactToAdd)
        log.info("Add contact=$added...[OK]")
    }

}
