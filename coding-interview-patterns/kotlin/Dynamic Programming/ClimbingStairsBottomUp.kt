fun climbingStairsBottomUp(n: Int): Int {
    if (n <= 2) {
        return n
    }
    val dp = IntArray(n + 1)
    // Base cases.
    dp[1] = 1
    dp[2] = 2
    // Starting from step 3, calculate the number of ways to reach each
    // step until the n-th step.
    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}
