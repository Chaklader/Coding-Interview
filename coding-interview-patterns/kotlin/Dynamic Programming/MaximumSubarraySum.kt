fun maximumSubarraySum(nums: List<Int>): Int {
    if (nums.isEmpty()) {
        return 0
    }
    // Set the sum variables to negative infinity to ensure negative
    // sums can be considered.
    var maxSum = Int.MIN_VALUE
    var currentSum = Int.MIN_VALUE
    // Iterate through the array to find the maximum subarray sum.
    for (num in nums) {
        // Either add the current number to the existing running sum, or
        // start a new subarray at the current number.
        currentSum = maxOf(currentSum + num, num)
        maxSum = maxOf(maxSum, currentSum)
    }
    return maxSum
}
