import java.util.Stack

fun validParenthesisExpression(s: String): Boolean {
    val parenthesesMap = mapOf('(' to ')', '{' to '}', '[' to ']')
    val stack = Stack<Char>()
    for (c in s) {
        // If the current character is an opening parenthesis, push it
        // onto the stack.
        if (parenthesesMap.containsKey(c)) {
            stack.push(c)
        } else {
            // If the current character is a closing parenthesis, check if
            // it closes the opening parenthesis at the top of the stack.
            if (stack.isNotEmpty() && parenthesesMap[stack.peek()] == c) {
                stack.pop()
            } else {
                return false
            }
        }
    }
    // If the stack is empty, all opening parentheses were successfully
    // closed.
    return stack.isEmpty()
}
