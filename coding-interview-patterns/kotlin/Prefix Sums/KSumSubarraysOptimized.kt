fun kSumSubarraysOptimized(nums: IntArray, k: Int): Int {
    var count = 0
    // Initialize the map with 0 to handle subarrays that sum to 'k'
    // from the start of the array.
    val prefixSumMap = mutableMapOf(0 to 1)
    var currPrefixSum = 0
    for (num in nums) {
        // Update the running prefix sum by adding the current number.
        currPrefixSum += num
        // If a subarray with sum 'k' exists, increment 'count' by the
        // number of times it has been found.
        if (currPrefixSum - k in prefixSumMap) {
            count += prefixSumMap[currPrefixSum - k]!!
        }
        // Update the frequency of 'currPrefixSum' in the hash map.
        val freq = prefixSumMap.getOrDefault(currPrefixSum, 0)
        prefixSumMap[currPrefixSum] = freq + 1
    }
    return count
}
