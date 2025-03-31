package example

class OrderItem {
    int quantity

    static belongsTo = [book: Book, order: CustomerOrder]

    static constraints = {
        quantity min: 1
    }
}