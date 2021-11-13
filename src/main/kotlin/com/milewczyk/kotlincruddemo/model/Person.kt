package com.milewczyk.kotlincruddemo.model

import com.milewczyk.kotlincruddemo.model.enums.Gender
import javax.persistence.*

@Entity
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val personId: Long,
        val firstname: String,
        val lastname: String,
        val age: Int,
        @Enumerated(EnumType.STRING)
        val gender: Gender
)
