import java.util.Stack

fun nextLargestNumberToTheRight(nums: List<Int>): List<Int> {
    val res = MutableList(nums.size) { 0 }
    val stack = Stack<Int>()
    // Find the next largest number of each element, starting with the
    // rightmost element.
    for (i in nums.size - 1 downTo 0) {
        // Pop values from the top of the stack until the current
        // value's next largest number is at the top.
        while (stack.isNotEmpty() && stack.peek() <= nums[i]) {
            stack.pop()
        }
        // Record the current value's next largest number, which is at
        // the top of the stack. If the stack is empty, record -1.
        res[i] = if (stack.isNotEmpty()) stack.peek() else -1
        stack.push(nums[i])
    }
    return res
}
