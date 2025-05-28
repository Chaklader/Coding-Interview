fun sortArray(nums: List<Int>): List<Int> {
    quicksort(nums.toMutableList(), 0, nums.size - 1)
    return nums
}

fun quicksort(nums: MutableList<Int>, left: Int, right: Int) {
    // Base case: if the subarray has 0 or 1 element, it's already
    // sorted.
    if (left >= right) {
        return
    }
    // Partition the array and retrieve the pivot index.
    val pivotIndex = partition(nums, left, right)
    // Call quicksort on the left and right parts to recursively sort
    // them.
    quicksort(nums, left, pivotIndex - 1)
    quicksort(nums, pivotIndex + 1, right)
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
