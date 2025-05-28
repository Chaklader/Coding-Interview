import kotlin.math.min
import kotlin.math.max

fun largestContainer(heights: List<Int>): Int {
    var maxWater = 0
    var left = 0
    var right = heights.size - 1
    while (left < right) {
        // Calculate the water contained between the current pair of
        // lines.
        val water = min(heights[left], heights[right]) * (right - left)
        maxWater = max(maxWater, water)
        // Move the pointers inward, always moving the pointer at the
        // shorter line. If both lines have the same height, move both
        // pointers inward.
        if (heights[left] < heights[right]) {
            left++
        } else if (heights[left] > heights[right]) {
            right--
        } else {
            left++
            right--
        }
    }
    return maxWater
}