package example

import grails.rest.Resource

@Resource(uri = '/publishers')
class Publisher {
    String name
    String address
    String website

    static hasMany = [books: Book]

    static constraints = {
        name blank: false, unique: true, maxSize: 255
        address nullable: true, maxSize: 500
        website nullable: true, url: true
    }
}
