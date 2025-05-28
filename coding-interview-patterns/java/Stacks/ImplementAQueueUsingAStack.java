import java.util.Stack;

public class ImplementAQueueUsingAStack {
    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;

    public ImplementAQueueUsingAStack() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    public void enqueue(int x) {
        this.enqueueStack.push(x);
    }

    private void transferEnqueueToDequeue() {
        // If the dequeue stack is empty, push all elements from the enqueue stack
        // onto the dequeue stack. This ensures the top of the dequeue stack
        // contains the most recent value.
        if (this.dequeueStack.isEmpty()) {
            while (!this.enqueueStack.isEmpty()) {
                this.dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    public int dequeue() {
        transferEnqueueToDequeue();;
        // Pop and return the value at the top of the dequeue stack.
        return this.dequeueStack.isEmpty() ? null : this.dequeueStack.pop();
    }

    public int peek() {
        transferEnqueueToDequeue();;
        return this.dequeueStack.isEmpty() ? null : this.dequeueStack.peek();
    }
}
