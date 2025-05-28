import java.util.Stack

fun repeatedRemovalOfAdjacentDuplicates(s: String): String {
    val stack = Stack<Char>()
    for (c in s) {
        // If the current character is the same as the top character on the stack,
        // a pair of adjacent duplicates has been formed. So, pop the top character
        // from the stack.
        if (stack.isNotEmpty() && c == stack.peek()) {
            stack.pop()
        }
        // Otherwise, push the current character onto the stack.
        else {
            stack.push(c)
        }
    }
    // Return the remaining characters as a string.
    return stack.joinToString("")
}
