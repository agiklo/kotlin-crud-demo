package com.milewczyk.kotlincruddemo.service

import com.milewczyk.kotlincruddemo.model.Person
import com.milewczyk.kotlincruddemo.repository.PersonRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PersonService(_personRepository: PersonRepository) {

    val personRepository: PersonRepository = _personRepository

    fun getPersons(): MutableList<Person> = personRepository.findAll()

    fun getPersonById(id: Long): Person? = personRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    fun addPerson(person: Person): Person = personRepository.save(person)

    fun deletePerson(id: Long) = personRepository.deleteById(id)
}
