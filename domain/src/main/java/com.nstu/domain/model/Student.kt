package com.nstu.domain.model

class Student(
    id: Int,
    email: String,
    password: String,
    firstName: String,
    secondName: String,
    middleName: String
) : User(id, email, password, firstName, secondName, middleName) {
}