fun maximumSubarraySumDP(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) {
        return 0
    }
    val dp = IntArray(n)
    // Base case: the maximum subarray sum of an array with just one
    // element is that element.
    dp[0] = nums[0]
    var maxSum = dp[0]
    // Populate the rest of the DP array.
    for (i in 1 until n) {
        // Determine the maximum subarray sum ending at the current
        // index.
        dp[i] = maxOf(dp[i - 1] + nums[i], nums[i])
        maxSum = maxOf(maxSum, dp[i])
    }
    return maxSum
}
