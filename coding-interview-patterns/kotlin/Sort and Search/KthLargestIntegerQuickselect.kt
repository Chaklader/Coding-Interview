fun kthLargestIntegerQuickselect(nums: List<Int>, k: Int): Int {
    return quickselect(nums.toMutableList(), 0, nums.size - 1, k)
}

fun quickselect(nums: MutableList<Int>, left: Int, right: Int, k: Int): Int {
    val n = nums.size
    if (left >= right) {
        return nums[left]
    }
    val randomIndex = (left..right).random()
    nums[randomIndex] = nums[right].also { nums[right] = nums[randomIndex] }
    val pivotIndex = partition(nums, left, right)
    // If the pivot comes before 'n - k', the ('n - k')th smallest
    // integer is somewhere to its right. Perform quickselect on the
    // right part.
    if (pivotIndex < n - k) {
        return quickselect(nums, pivotIndex + 1, right, k)
    // If the pivot comes after 'n - k', the ('n - k')th smallest integer
    // is somewhere to its left. Perform quickselect on the left part.
    } else if (pivotIndex > n - k) {
        return quickselect(nums, left, pivotIndex - 1, k)
    // If the pivot is at index 'n - k', it's the ('n - k')th smallest
    // integer.
    } else {
        return nums[pivotIndex]
    }
}

fun partition(nums: MutableList<Int>, left: Int, right: Int): Int {
    val pivot = nums[right]
    var lo = left
    for (i in left until right) {
        if (nums[i] < pivot) {
            nums[lo] = nums[i].also { nums[i] = nums[lo] }
            lo++
        }
    }
    nums[lo] = nums[right].also { nums[right] = nums[lo] }
    return lo
}
