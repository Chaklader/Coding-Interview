fun minCoinCombinationBottomUp(coins: List<Int>, target: Int): Int {
    // The DP array will store the minimum number of coins needed for
    // each amount. Set each element to a large number initially.
    val dp = IntArray(target + 1) { Int.MAX_VALUE }
    // Base case: if the target is 0, then 0 coins are needed.
    dp[0] = 0
    // Update the DP array for all target amounts greater than 0.
    for (t in 1..target) {
        for (coin in coins) {
            if (coin <= t) {
                dp[t] = minOf(dp[t], 1 + dp[t - coin])
            }
        }
    }
    return if (dp[target] != Int.MAX_VALUE) dp[target] else -1
}
