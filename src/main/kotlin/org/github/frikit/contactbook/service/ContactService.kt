package org.github.frikit.contactbook.service

import org.github.frikit.contactbook.model.Contact
import org.github.frikit.contactbook.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val contactRepository: ContactRepository
) {

    fun findAllContacts(): List<Contact> = contactRepository.findAll().filterNotNull()

    //TODO update postcode if decide to make it generic
    fun findContactByPostcode(postcode: String): List<Contact> = contactRepository
        .findContactsByAddress_Postcode(postcode)
        .filterNotNull()

    fun saveContact(contact: Contact): Contact {
        //TODO add try catch if address exist in database extract address and use it to save contact with existing address
        return contactRepository.save(contact)
    }
}
