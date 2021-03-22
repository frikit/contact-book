package org.github.frikit.contactbook.service

import org.github.frikit.contactbook.BaseTest
import org.github.frikit.contactbook.model.Address
import org.github.frikit.contactbook.model.Contact
import org.github.frikit.contactbook.repository.ContactRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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

    fun saveRandomUserInDatabase(
        contactID: Long? = null,
        fullName: String = "Victor O",
        dateOfBirth: LocalDate = LocalDate.of(2019, 1, 19),
        addressID: Long? = null,
        addressCity: String = "Kiv",
        addressPostCode: String = "No postcode"
    ): Contact {
        val input = Contact(
            id = contactID,
            fullName = fullName,
            dateOfBirth = dateOfBirth,
            address = Address(id = addressID, city = addressCity, postcode = addressPostCode)
        )

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

    @Test
    fun testFindUsersByPostcode() {
        saveRandomUserInDatabase(fullName = "Vik", addressPostCode = "POSTCODE1")
        saveRandomUserInDatabase(fullName = "Vik2", addressPostCode = "POSTCODE2")
        saveRandomUserInDatabase(fullName = "Vik3", addressPostCode = "POSTCODE3")
        saveRandomUserInDatabase(fullName = "Vik4", addressPostCode = "POSTCODE4")
        saveRandomUserInDatabase(fullName = "Vik5", addressPostCode = "POSTCODE5")

        assertEquals(1, contactService.findContactByPostcode("POSTCODE1").size)
        assertEquals("Vik", contactService.findContactByPostcode("POSTCODE1").first().fullName)
    }
}
