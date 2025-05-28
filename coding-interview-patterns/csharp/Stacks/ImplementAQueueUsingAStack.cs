public class Queue
{
    private Stack<int> _enqueueStack;
    private Stack<int> _dequeueStack;

    public Queue()
    {
        _enqueueStack = new Stack<int>();
        _dequeueStack = new Stack<int>();
    }

    public void Enqueue(int x)
    {
        _enqueueStack.Push(x);
    }

    private void TransferEnqueueToDequeue()
    {
        // If the dequeue stack is empty, push all elements from the enqueue stack
        // onto the dequeue stack. This ensures the top of the dequeue stack
        // contains the most recent value.
        if (_dequeueStack.Count == 0)
        {
            while (_enqueueStack.Count > 0)
                _dequeueStack.Push(_enqueueStack.Pop());
        }
    }

    public int? Dequeue()
    {
        TransferEnqueueToDequeue();

        // Pop and return the value at the top of the dequeue stack.
        return _dequeueStack.Count > 0 ? _dequeueStack.Pop() : null;
    }

    public int? Peek()
    {
        TransferEnqueueToDequeue();
        return _dequeueStack.Count > 0 ? _dequeueStack.Peek() : null;
    }
}
