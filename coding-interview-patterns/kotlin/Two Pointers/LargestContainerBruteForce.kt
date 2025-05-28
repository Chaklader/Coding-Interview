import kotlin.math.max
import kotlin.math.min

fun largestContainerBruteForce(heights: List<Int>): Int {
    val n = heights.size
    var maxWater = 0
    // Find the maximum amount of water stored between all pairs of lines.
    for (i in 0 until n) {
        for (j in i + 1 until heights.size) {
            val water = min(heights[i], heights[j]) * (j - i)
            maxWater = max(maxWater, water)
        }
    }
    return maxWater
}
