fun geometricSequenceTriplets(nums: List<Int>, r: Int): Int {
    // leftMap and rightMap will use 'getOrDefault' to ensure the default value of 0 is returned when
    // accessing a key that doesn’t exist in the hash map. This effectively sets
    // the default frequency of all elements to 0.
    val leftMap = mutableMapOf<Int, Int>()
    val rightMap = mutableMapOf<Int, Int>()
    var count = 0
    // Populate 'rightMap' with the frequency of each element in the array.
    for (x in nums) {
        rightMap[x] = rightMap.getOrDefault(x, 0) + 1
    }
    // Search for geometric triplets that have x as the center.
    for (x in nums) {
        // Decrement the frequency of x in 'rightMap' since x is now being
        // processed and is no longer to the right.
        rightMap[x] = rightMap.getOrDefault(x, 0) - 1
        if (x % r == 0) {
            count += leftMap.getOrDefault(x / r, 0) * rightMap.getOrDefault(x * r, 0)
        }
        // Increment the frequency of x in 'leftMap' since it'll be a part of the
        // left side of the array once we iterate to the next value of x.
        leftMap[x] = leftMap.getOrDefault(x, 0) + 1
    }
    return count
}
