fun findTheInsertionIndex(nums: List<Int>, target: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
        val mid = left + (right - left) / 2
        // If the midpoint value is greater than or equal to the target,
        // the lower bound is either at the midpoint, or to its left.
        if (nums[mid] >= target) {
            right = mid
        // The midpoint value is less than the target, indicating the
        // lower bound is somewhere to the right.
        } else {
            left = mid + 1
        }
    }
    return left
}
