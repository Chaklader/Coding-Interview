fun hammingWeightsOfIntegersDp(n: Int): List<Int> {
    // Base case: the number of set bits in 0 is just 0. We set dp[0] to
    // 0 by initializing the entire DP array to 0.
    val dp = IntArray(n + 1)
    for (x in 1..n) {
        // 'dp[x]' is obtained using the result of 'dp[x >> 1]', plus
        // the LSB of 'x'.
        dp[x] = dp[x ushr 1] + (x and 1)
    }
    return dp.toList()
}
