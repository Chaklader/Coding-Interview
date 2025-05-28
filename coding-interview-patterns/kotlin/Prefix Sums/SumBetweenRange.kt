class SumBetweenRange(nums: IntArray) {

    private val prefixSum: IntArray = IntArray(nums.size)

    init {
        prefixSum[0] = nums[0]
        for (i in 1 until nums.size) {
            prefixSum[i] = prefixSum[i - 1] + nums[i]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        if (i == 0) {
            prefixSum[j]
        }
        return prefixSum[j] - prefixSum[i - 1]
    }
}
