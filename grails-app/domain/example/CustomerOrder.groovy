package example

import grails.rest.Resource

import java.time.LocalDate

@Resource(uri = '/orders')
class CustomerOrder {
    LocalDate orderDate = LocalDate.now()
    BigDecimal totalPrice

    static hasMany = [orderItems: OrderItem]
    static belongsTo = [customer: Customer]

    static constraints = {
        customer nullable: false
        totalPrice min: 0.0
    }
}
