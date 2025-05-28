import java.util.Stack

class Queue {

    private val enqueueStack = Stack<Int>()
    private val dequeueStack = Stack<Int>()

    fun enqueue(x: Int) {
        enqueueStack.push(x)
    }

    private fun transferEnqueueToDequeue() {
        // If the dequeue stack is empty, push all elements from the enqueue stack
        // onto the dequeue stack. This ensures the top of the dequeue stack
        // contains the most recent value.
        if (dequeueStack.isEmpty()) {
            while (enqueueStack.isNotEmpty()) {
                dequeueStack.push(enqueueStack.pop())
            }
        }
    }

    fun dequeue(): Int {
        transferEnqueueToDequeue()
        // Pop and return the value at the top of the dequeue stack.
        return if (dequeueStack.isNotEmpty()) {
            dequeueStack.pop()
        } else {
            -1
        }
    }

    fun peek(): Int {
        transferEnqueueToDequeue()
        return if (dequeueStack.isNotEmpty()) {
            dequeueStack.peek()
        } else {
            -1
        }
    }
}
