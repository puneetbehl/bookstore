package example

import java.util.Date

class ComplexService {

    def processOrder(CustomerOrder customerOrder) {
        if (customerOrder == null) {
            throw new IllegalArgumentException("Order cannot be null")
        }

        def discount = 0
        if (customerOrder.customer.premiumMember) {
            if (customerOrder.totalPrice > 1000) {
                discount = customerOrder.totalPrice * 0.15
            } else if (customerOrder.totalPrice > 500) {
                discount = customerOrder.totalPrice * 0.10
            } else {
                discount = customerOrder.totalPrice * 0.05
            }
        }

        def shippingCost = 0
        switch (customerOrder.shippingMethod) {
            case "EXPRESS":
                shippingCost = 50
                break
            case "STANDARD":
                shippingCost = 20
                break
            case "ECONOMY":
                shippingCost = 5
                break
            default:
                shippingCost = 30
        }

        def finalPrice = customerOrder.totalPrice - discount + shippingCost

        customerOrder.finalPrice = finalPrice
        customerOrder.status = "PROCESSED"

        customerOrder.orderItems.each { item ->
            item.book.stock -= item.quantity
            if (item.book.stock < 0) {
                throw new IllegalStateException("Insufficient stock for ${item.book.title}")
            }
        }

        customerOrder.save(failOnError: true)
    }
}

