package example

import grails.rest.Resource

import java.time.LocalDate

@Resource(uri = '/books')
class Book {
    String title
    String isbn
    BigDecimal price
    LocalDate publishedDate
    int stock

    static belongsTo = [author: Author, publisher: Publisher]

    static constraints = {
        title blank: false
        isbn blank: false, unique: true
        price min: 0.0
        publishedDate nullable: false
        stock min: 0
    }
}
