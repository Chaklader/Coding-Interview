fun firstAndLastOccurrencesOfANumber(nums: List<Int>, target: Int): List<Int> {
    val lowerBound = lowerBoundBinarySearch(nums, target)
    val upperBound = upperBoundBinarySearch(nums, target)
    return listOf(lowerBound, upperBound)
}

fun lowerBoundBinarySearch(nums: List<Int>, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] > target -> right = mid - 1
            nums[mid] < target -> left = mid + 1
            else -> right = mid
        }
    }
    return if (nums.isNotEmpty() && nums[left] == target) left else -1
}

fun upperBoundBinarySearch(nums: List<Int>, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        // In upper-bound binary search, bias the midpoint to the right.
        val mid = (left + (right - left) / 2) + 1
        when {
            nums[mid] > target -> right = mid - 1
            nums[mid] < target -> left = mid + 1
            else -> left = mid
        }
    }
    // If the target doesn't exist in the array, then it's possible that
    // 'left = mid + 1' places the left pointer outside the array when
    // 'mid == n - 1'. So, we use the right pointer in the return
    // statement instead.
    return if (nums.isNotEmpty() && nums[right] == target) right else -1
}
