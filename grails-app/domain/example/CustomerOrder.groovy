package example

import grails.rest.Resource

import java.time.LocalDate

@Resource(uri = '/orders')
class CustomerOrder {
    BigDecimal totalPrice
    BigDecimal finalPrice
    LocalDate orderDate = LocalDate.now()
    String status
    String shippingMethod // Added field to match ComplexService logic

    static belongsTo = [customer: Customer]
    static hasMany = [orderItems: OrderItem]

    static constraints = {
        totalPrice min: 0.0
        finalPrice nullable: true
        status blank: false, inList: ["PENDING", "PROCESSED", "SHIPPED"]
        shippingMethod blank: false, inList: ["EXPRESS", "STANDARD", "ECONOMY"]
    }
}