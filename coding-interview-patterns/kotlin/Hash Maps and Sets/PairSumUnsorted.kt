fun pairSumUnsorted(nums: List<Int>, target: Int): List<Int> {
    val hashmap = mutableMapOf<Int, Int>()
    for ((i, x) in nums.withIndex()) {
        if (target - x in hashmap) {
            return listOf(hashmap[target - x]!!, i)
        }
        hashmap[x] = i
    }
    return emptyList()
}
