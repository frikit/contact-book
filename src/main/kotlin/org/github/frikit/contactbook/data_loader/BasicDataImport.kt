package org.github.frikit.contactbook.data_loader

import org.github.frikit.contactbook.model.Address
import org.github.frikit.contactbook.model.Contact
import org.github.frikit.contactbook.repository.ContactRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class BasicDataImport(
    val contactRepository: ContactRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        contactRepository.save(Contact(id = null, fullName = "Victor O", dateOfBirth = LocalDate.of(2019,1,19), address = Address(id = null, "Kiv", "No postcode")))
        contactRepository.save(Contact(id = null, fullName = "Victor O", dateOfBirth = LocalDate.of(2019,1,19), address = Address(id = null, "Kiv2", "No postcode")))
    }
}
