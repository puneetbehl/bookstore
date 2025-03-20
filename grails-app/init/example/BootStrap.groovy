package example

import java.time.LocalDate

class BootStrap {
    def init = { servletContext ->
        def author1 = new Author(
                firstName: "George",
                lastName: "Orwell",
                birthDate: LocalDate.of(1903, 6, 25),
                nationality: "British"
        ).save(failOnError: true)

        def author2 = new Author(
                firstName: "J.K.",
                lastName: "Rowling",
                birthDate: LocalDate.of(1965, 7, 31),
                nationality: "British"
        ).save(failOnError: true)

        def publisher1 = new Publisher(
                name: "Penguin Books",
                address: "London, UK",
                website: "https://www.penguin.co.uk"
        ).save(failOnError: true)

        def publisher2 = new Publisher(
                name: "Bloomsbury",
                address: "London, UK",
                website: "https://www.bloomsbury.com"
        ).save(failOnError: true)

        def book1 = new Book(
                title: "1984",
                isbn: "9780451524935",
                author: author1,
                publisher: publisher1,
                price: 499.99,
                publishedDate: LocalDate.of(1949, 6, 8)
        ).save(failOnError: true)

        def book2 = new Book(
                title: "Animal Farm",
                isbn: "9780451526342",
                author: author1,
                publisher: publisher1,
                price: 299.99,
                publishedDate: LocalDate.of(1945, 8, 17)
        ).save(failOnError: true)

        def book3 = new Book(
                title: "Harry Potter and the Sorcerer’s Stone",
                isbn: "9780439708180",
                author: author2,
                publisher: publisher2,
                price: 799.99,
                publishedDate: LocalDate.of(1997, 6, 26)
        ).save(failOnError: true)

        def customer = new Customer(
                firstName: "John",
                lastName: "Doe",
                email: "johndoe@example.com"
        ).save(failOnError: true)

        def order = new CustomerOrder(
                customer: customer,
                totalPrice: book1.price + book2.price
        ).save(failOnError: true)

        new OrderItem(book: book1, customerOrder: order, quantity: 1).save(failOnError: true)
        new OrderItem(book: book2, customerOrder: order, quantity: 1).save(failOnError: true)
    }
}
