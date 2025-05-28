fun sortArray(nums: List<Int>): List<Int> {
    quicksortOptimized(nums.toMutableList(), 0, nums.size - 1)
    return nums
}

fun quicksortOptimized(nums: MutableList<Int>, left: Int, right: Int) {
    if (left >= right) {
        return
    }
    // Choose a pivot at a random index.
    val randomIndex = (left..right).random()
    // Swap the randomly chosen pivot with the rightmost element to
    // position the pivot at the rightmost index.
    nums[right] = nums[randomIndex].also { nums[randomIndex] = nums[right] }
    val pivotIndex = partition(nums, left, right)
    quicksortOptimized(nums, left, pivotIndex - 1)
    quicksortOptimized(nums, pivotIndex + 1, right)
}

fun partition(nums: MutableList<Int>, left: Int, right: Int): Int {
    val pivot = nums[right]
    var lo = left
    // Move all numbers less than the pivot to the left, which
    // consequently positions all numbers greater than or equal to the
    // pivot to the right.
    for (i in left until right) {
        if (nums[i] < pivot) {
            nums[lo] = nums[i].also { nums[i] = nums[lo] }
            lo++
        }
    }
    // After partitioning, 'lo' will be positioned where the pivot should
    // be. So, swap the pivot number with the number at the 'lo' pointer.
    nums[lo] = nums[right].also { nums[right] = nums[lo] }
    return lo
}
