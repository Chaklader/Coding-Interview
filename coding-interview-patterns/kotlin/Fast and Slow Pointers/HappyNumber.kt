fun happyNumber(n: Int): Boolean {
    var slow = n
    var fast = n
    while (true) {
        slow = getNextNum(slow)
        fast = getNextNum(getNextNum(fast))
        if (fast == 1) {
            return true
        // If the fast and slow pointers meet, a cycle is detected. 
        // Hence, 'n' is not a happy number.
        } else if (fast == slow) {
            return false
        }
    }
}

fun getNextNum(x: Int): Int {
    var nextNum = 0
    var num = x
    while (num > 0) {
        // Extract the last digit of 'x'.
        val digit = num % 10
        // Truncate (remove) the last digit from 'x' using floor 
        // division.
        num /= 10
        // Add the square of the extracted digit to the sum.
        nextNum += digit * digit
    }
    return nextNum
}