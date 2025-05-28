fun productArrayWithoutCurrentElement(nums: List<Int>): List<Int> {
    val n = nums.size
    val res = MutableList(n) { 1 }
    // Populate the output with the running left product.
    for (i in 1 until n) {
        res[i] = res[i - 1] * nums[i - 1]
    }
    // Multiply the output with the running right product, from right to 
    // left.
    var rightProduct = 1
    for (i in n - 1 downTo 0) {
        res[i] *= rightProduct
        rightProduct *= nums[i]
    }
    return res
}