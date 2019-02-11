package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy{ it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
            .flatMap { customer -> customer.orders }
            .sumBy { order -> order.products.count { it == product } }
}
