class WeightedRandomSelection(private val weights: IntArray) {
    private val prefixSums = IntArray(weights.size)

    init {
        prefixSums[0] = weights[0]
        for (i in 1 until weights.size) {
            prefixSums[i] = prefixSums[i - 1] + weights[i]
        }
    }

    fun select(): Int {
        // Pick a random target between 1 and the largest endpoint on the number
        // line.
        val target = (1..prefixSums.last()).random()
        var left = 0
        var right = prefixSums.size - 1
        // Perform lower-bound binary search to find which endpoint (i.e., prefix
        // sum value) corresponds to the target.
        while (left < right) {
            val mid = left + (right - left) / 2
            if (prefixSums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
