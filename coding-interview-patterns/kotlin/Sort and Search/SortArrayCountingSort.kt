fun sortArrayCountingSort(nums: List<Int>): List<Int> {
    if (nums.isEmpty()) return emptyList()
    val res = mutableListOf<Int>()
    // Count occurrences of each element in 'nums'.
    val counts = IntArray(nums.maxOrNull()!! + 1)
    for (num in nums) {
        counts[num]++
    }
    // Build the sorted array by appending each index 'i' to it a total
    // of 'counts[i]' times.
    for (i in counts.indices) {
        val count = counts[i]
        repeat(count) { res.add(i) }
    }
    return res
}
