package org.github.frikit.contactbook.repository

import org.github.frikit.contactbook.BaseTest
import org.github.frikit.contactbook.model.Address
import org.github.frikit.contactbook.model.Contact
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

internal class ContactRepositoryTest(
    @Autowired val contactRepository: ContactRepository
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

        val dbValue = contactRepository.save(input)
        return dbValue
    }

    @Test
    fun testSaveUser() {
        val input = Contact(id = null, fullName = "Victor O", dateOfBirth = LocalDate.of(2019,1,19), address = Address(id = null, "Kiv", "No postcode"))

        val dbValue = contactRepository.save(input)

        val expected = input.copy(id = dbValue.id, address = input.address.copy(id = dbValue.address.id))

        assertEquals(expected, dbValue)
    }

    @Test
    fun testDeleteUser() {
        //save
        saveRandomUserInDatabase()
        val expected = 1L
        val actual = contactRepository.count()

        assertEquals(expected, actual)

        //delete
        contactRepository.deleteAll()

        assertEquals(0, contactRepository.count())
    }

    @Test
    fun testFindAllUsers() {
        //save
        saveRandomUserInDatabase()
        val expected = 1
        val actual = contactRepository.findAll().size

        assertEquals(expected, actual)
    }

    @Test
    fun testInsertDuplicateAddressAsNew() {
        //save
        saveRandomUserInDatabase()
        try {
            saveRandomUserInDatabase()
            fail("Should not allow duplicate insert for address")
        } catch (ex: Exception) {
            //success
        }
    }
}
