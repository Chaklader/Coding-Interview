fun pairSumUnsortedTwoPass(nums: List<Int>, target: Int): List<Int> {
    val numMap = mutableMapOf<Int, Int>()
    // First pass: Populate the hash map with each number and its 
    // index.
    for ((i, num) in nums.withIndex()) {
        numMap[num] = i
    }
    // Second pass: Check for each number's complement in the hash map.
    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        if (complement in numMap && numMap[complement] != i) {
            return listOf(i, numMap[complement]!!)
        }
    }
    return emptyList()
}