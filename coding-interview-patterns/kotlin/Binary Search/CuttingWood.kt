fun cuttingWood(heights: List<Int>, k: Int): Int {
    var left = 0
    var right = heights.maxOrNull()!!
    while (left < right) {
        // Bias the midpoint to the right during the upper-bound binary
        // search.
        val mid = (left + (right - left) / 2) + 1
        if (cutsEnoughWood(mid, k, heights)) {
            left = mid
        } else {
            right = mid - 1
        }
    }
    return right
}

// Determine if the current value of 'H' cuts at least 'k' meters of
// wood.
fun cutsEnoughWood(H: Int, k: Int, heights: List<Int>): Boolean {
    var woodCollected = 0
    for (height in heights) {
        if (height > H) {
            woodCollected += height - H
        }
    }
    return woodCollected >= k
}
