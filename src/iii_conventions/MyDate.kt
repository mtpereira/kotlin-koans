package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

operator fun MyDate.compareTo(date: MyDate): Int {
    val jdn = { y: Int, m: Int, d: Int ->
        1461 * (y + 4800 + (m - 14) / 12) / 4 + (367 * (m - 2 - 12 * ((m - 14) / 12))) / 12 - (3 * ((y + 4900 + (m - 14) / 12) / 100)) / 4 + d - 32075
    }
    return jdn(year, month, dayOfMonth) - jdn(date.year, date.month, date.dayOfMonth)
}
