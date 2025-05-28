#include <vector>
#include <optional>

class Queue {
public:
    Queue() {}

    void enqueue(int x) {
        enqueueStack.push_back(x);
    }

    void transferEnqueueToDequeue() {
        // If the dequeue stack is empty, push all elements from the enqueue stack
        // onto the dequeue stack. This ensures the top of the dequeue stack
        // contains the most recent value.
        if (dequeueStack.empty()) {
            while (!enqueueStack.empty()) {
                dequeueStack.push_back(enqueueStack.back());
                enqueueStack.pop_back();
            }
        }
    }

    std::optional<int> dequeue() {
        transferEnqueueToDequeue();
        // Pop and return the value at the top of the dequeue stack.
        if (!dequeueStack.empty()) {
            int val = dequeueStack.back();
            dequeueStack.pop_back();
            return val;
        }
        return std::nullopt;
    }

    std::optional<int> peek() {
        transferEnqueueToDequeue();
        // Return the value at the top of the dequeue stack without removing it.
        if (!dequeueStack.empty()) {
            return dequeueStack.back();
        }
        return std::nullopt; 
    }

private:
    std::vector<int> enqueueStack;
    std::vector<int> dequeueStack;

};