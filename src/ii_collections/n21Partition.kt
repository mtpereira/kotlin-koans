package ii_collections

import iii_conventions.iterateOverRange

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

//fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = customers.filter { customer -> customer.orders.filter { !it.isDelivered }.size > customer.orders.filter { it.isDelivered }.size }.toSet()
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    return customers.filter { customer ->
        val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
        undelivered.size> delivered.size
    }.toSet()
}
