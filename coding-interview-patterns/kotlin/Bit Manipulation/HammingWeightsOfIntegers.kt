fun hammingWeightsOfIntegers(n: Int): List<Int> {
    return (1..n).map { countSetBits(it) }
}

fun countSetBits(n: Int): Int {
    var x = n
    var count = 0
    // Count each set bit of 'x' until 'x' equals 0.
    while (x > 0) {
        // Increment the count if the LSB is 1.
        count += x.and(1)
        // Right shift 'x' to shift the next bit to the LSB position.
        x = x.shr(1)
    }
    return count
}
