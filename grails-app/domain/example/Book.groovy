package example

import grails.rest.Resource

import java.time.LocalDate

@Resource(uri = '/books')
class Book {
    String title
    String isbn
    Author author
    Publisher publisher
    BigDecimal price
    LocalDate publishedDate

    static constraints = {
        title blank: false, maxSize: 255
        isbn blank: false, unique: true, maxSize: 20
        price min: 0.0
        publishedDate nullable: true
    }
}

