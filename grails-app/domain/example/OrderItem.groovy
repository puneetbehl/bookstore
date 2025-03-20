package example

class OrderItem {
    Book book
    CustomerOrder customerOrder
    Integer quantity

    static constraints = {
        book nullable: false
        customerOrder nullable: false
        quantity min: 1
    }
}
