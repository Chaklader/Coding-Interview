fun reverse32BitInteger(n: Int): Int {
    // shadow n to make it mutable
    var n = n
    val intMax = Int.MAX_VALUE
    val intMin = Int.MIN_VALUE
    var reversedN = 0
    // Keep looping until we've added all digits of 'n' to 'reversedN'
    // in reverse order.
    while (n != 0) {
        // digit = n % 10
        val digit = n % 10
        // n = n / 10
        n /= 10
        // Check for integer overflow or underflow.
        if (reversedN > (intMax / 10) || reversedN < (intMin / 10)) {
            return 0
        }
        // Add the current digit to 'reversedN'.
        reversedN = reversedN * 10 + digit
    }
    return reversedN
}
