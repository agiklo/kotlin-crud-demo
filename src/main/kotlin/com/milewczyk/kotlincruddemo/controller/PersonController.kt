package com.milewczyk.kotlincruddemo.controller

import com.milewczyk.kotlincruddemo.model.Person
import com.milewczyk.kotlincruddemo.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/person"])
class PersonController(_personService: PersonService) {

    val personService: PersonService = _personService

    @GetMapping
    fun getPersons(): ResponseEntity<MutableList<Person>> =
            ResponseEntity.status(HttpStatus.OK).body(personService.getPersons())

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable("id") id: Long): ResponseEntity<Person?> =
            ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(id))

    @PostMapping
    fun addPerson(@RequestBody person: Person): ResponseEntity<Person> =
            ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(person))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(@PathVariable id: Long) = personService.deletePerson(id)
}
