package example

import grails.rest.Resource

@Resource(uri = '/customers')
class Customer {
    String firstName
    String lastName
    String email

    static hasMany = [orders: CustomerOrder]

    static constraints = {
        firstName blank: false, maxSize: 100
        lastName blank: false, maxSize: 100
        email blank: false, email: true, unique: true
    }
}
