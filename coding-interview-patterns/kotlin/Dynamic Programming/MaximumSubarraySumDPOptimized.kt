fun maximumSubarraySumDPOptimized(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) {
        return 0
    }
    var currentSum = nums[0]
    var maxSum = nums[0]
    for (i in 1 until n) {
        currentSum = maxOf(nums[i], currentSum + nums[i])
        maxSum = maxOf(maxSum, currentSum)
    }
    return maxSum
}
