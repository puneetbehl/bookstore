package example

import grails.rest.Resource

@Resource(uri = '/customers')
class Customer {
    String firstName
    String lastName
    String email
    Boolean premiumMember = false // Added this field to match service logic

    static hasMany = [orders: CustomerOrder]

    static constraints = {
        firstName blank: false
        lastName blank: false
        email email: true, blank: false
    }
}