package org.github.frikit.contactbook.repository

import org.github.frikit.contactbook.model.Contact
import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository: JpaRepository<Contact, Long>
