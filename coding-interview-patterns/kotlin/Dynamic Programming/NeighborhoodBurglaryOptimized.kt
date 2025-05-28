fun neighborhoodBurglaryOptimized(houses: List<Int>): Int {
    if (houses.isEmpty()) {
        return 0
    }
    if (houses.size == 1) {
        return houses[0]
    }
    // Initialize the variables with the base cases.
    var prevMaxProfit = maxOf(houses[0], houses[1])
    var prevPrevMaxProfit = houses[0]
    for (i in 2 until houses.size) {
        val currMaxProfit = maxOf(prevMaxProfit, houses[i] + prevPrevMaxProfit)
        // Update the values for the next iteration.
        prevPrevMaxProfit = prevMaxProfit
        prevMaxProfit = currMaxProfit
    }
    return prevMaxProfit
}
