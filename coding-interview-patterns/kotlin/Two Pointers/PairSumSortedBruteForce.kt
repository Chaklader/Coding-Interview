fun pairSumSortedBruteForce(nums: IntArray, target: Int): List<Int> {
    val n = nums.size
    for (i in 0 until n) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return listOf(i, j)
            }
        }
    }
    return emptyList()
}
