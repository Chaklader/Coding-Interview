fun swapOddAndEvenBits(n: Long): Long {
    val evenMask: Long = 0x55555555   // 01010101010101010101010101010101
    val oddMask: Long = 0xAAAAAAAA  // 10101010101010101010101010101010
    val evenBits = n.toLong() and evenMask
    val oddBits = n.toLong() and oddMask
    // Shift the even bits to the left, the odd bits to the right, and 
    // merge these shifted values together.
    // shl - signed shift left
    // ushr - unsigned shift right
    return (evenBits shl 1) or (oddBits ushr 1)
}