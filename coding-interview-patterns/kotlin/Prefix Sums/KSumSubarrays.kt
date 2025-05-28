fun kSumSubarrays(nums: List<Int>, k: Int): Int {
    val n = nums.size
    var count = 0
    // Populate the prefix sum array, setting its first element to 0.
    val prefixSum = IntArray(n + 1)
    for (i in 0 until n) {
        prefixSum[i + 1] = prefixSum[i] + nums[i]
    }
    // Loop through all valid pairs of prefix sum values to find all 
    // subarrays that sum to 'k'.
    for (j in 1..n) {
        for (i in 1..j) {
            if (prefixSum[j] - prefixSum[i - 1] == k) {
                count++
            }
        }
    }
    return count
}