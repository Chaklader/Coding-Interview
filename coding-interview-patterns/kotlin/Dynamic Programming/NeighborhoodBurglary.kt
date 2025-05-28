fun neighborhoodBurglary(houses: List<Int>): Int {
    // Handle the cases when the array is less than the size of 2 to
    // avoid out-of-bounds errors when assigning the base case values.
    if (houses.isEmpty()) {
        return 0
    }
    if (houses.size == 1) {
        return houses[0]
    }
    val dp = IntArray(houses.size)
    // Base case: when there's only one house, rob that house.
    dp[0] = houses[0]
    // Base case: when there are two houses, rob the one with the most
    // money.
    dp[1] = maxOf(houses[0], houses[1])
    // Fill in the rest of the DP array.
    for (i in 2 until houses.size) {
        // 'dp[i]' = max(profit if we skip house 'i', profit if we rob house 'i').
        dp[i] = maxOf(dp[i - 1], houses[i] + dp[i - 2])
    }
    return dp[houses.size - 1]
}
