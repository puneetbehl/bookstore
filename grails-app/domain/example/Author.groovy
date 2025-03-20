package example

import grails.rest.Resource

import java.time.LocalDate

@Resource(uri = '/authors')
class Author {
    String firstName
    String lastName
    LocalDate birthDate
    String nationality

    static hasMany = [books: Book]

    static constraints = {
        firstName blank: false, maxSize: 100
        lastName blank: false, maxSize: 100
        nationality nullable: true, maxSize: 50
        birthDate nullable: true
    }
}
