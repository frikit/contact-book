package org.github.frikit.contactbook.service

import org.github.frikit.contactbook.BaseTest
import org.github.frikit.contactbook.model.Address
import org.github.frikit.contactbook.model.Contact
import org.github.frikit.contactbook.repository.ContactRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

internal class ContactServiceTest(
    @Autowired val contactRepository: ContactRepository,
    @Autowired val contactService: ContactService
) : BaseTest() {

    @BeforeEach
    fun setUp() {
        contactRepository.deleteAll()
    }

    @AfterEach
    fun tearDown() {
        contactRepository.deleteAll()
    }

    fun saveRandomUserInDatabase(): Contact {
        val input = Contact(id = null, fullName = "Victor O", dateOfBirth = LocalDate.of(2019,1,19), address = Address(id = null, "Kiv", "No postcode"))

        val dbValue = contactService.saveContact(input)
        return dbValue
    }

    @Test
    fun findAllContactsWhenIsEmpty() {
        assertEquals(0, contactService.findAllContacts().size)
    }

    @Test
    fun findAllContacts() {
        saveRandomUserInDatabase()
        assertEquals(1, contactService.findAllContacts().size)
    }

    @Test
    fun saveContact() {
        try {
            saveRandomUserInDatabase()
            //success
        } catch (ex: Exception) {
            fail("Should not fail as it is first entry in db")
        }
    }

    @Test
    fun saveContactTwice() {
        saveRandomUserInDatabase()

        try {
            saveRandomUserInDatabase()
            //TODO to find out
            fail("Should not allow duplicate insert for address OR maybe should allow :)?!")
        } catch (ex: Exception) {
            //success
        }
    }
}
