package org.github.frikit.contactbook.model

import javax.persistence.*

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uniq_address", columnNames = ["city", "postcode"])]
)
data class Address(
    @Id @GeneratedValue
    val id: Long? = null,
    //TODO to discuss what kind of generic is expected class level or anything like string
    //TODO make it generic
    val city: String,
    //TODO to discuss what kind of generic is expected class level or anything like string
    //TODO make it generic
    val postcode: String
)
