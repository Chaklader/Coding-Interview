fun minCoinCombinationTopDown(coins: List<Int>, target: Int): Int {
    val memo = hashMapOf<Int, Int>()
    val result = topDownDp(coins, target, memo)
    return if (result == Int.MAX_VALUE) -1 else result
}

fun topDownDp(coins: List<Int>, target: Int, memo: MutableMap<Int, Int>): Int {
    // Base case: if the target is 0, then 0 coins are needed to reach
    // it.
    if (target == 0) {
        return 0
    }
    if (target in memo) {
        return memo[target]!!
    }
    // Initialize 'minCoins' to a large number.
    var minCoins = Int.MAX_VALUE
    for (coin in coins) {
        // Avoid negative targets.
        if (coin <= target) {
            // Calculate the minimum number of coins needed if we use
            // the current coin.
            minCoins = minOf(minCoins, 1 + topDownDp(coins, target - coin, memo))
        }
    }
    memo[target] = minCoins
    return memo[target]!!
}
