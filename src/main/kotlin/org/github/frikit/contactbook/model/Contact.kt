package org.github.frikit.contactbook.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Contact(
    @Id @GeneratedValue
    val id: Long? = null,
    val fullName: String,
    val dateOfBirth: LocalDate,
    @ManyToOne(cascade = [CascadeType.ALL])
    val address: Address
)
