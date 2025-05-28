#include <queue>
#include <vector>

class MedianOfAnIntegerStream {
public:
    MedianOfAnIntegerStream() {}
    
    void add(int num) {
        // If 'num' is less than or equal to the max of 'leftHalf', it 
        // belongs to the left half.
        if (leftHalf.empty() || num <= leftHalf.top()) {
            leftHalf.push(num);
            // Rebalance the heaps if the size of 'leftHalf' 
            // exceeds the size of 'rightHalf' by more than one.
            if (leftHalf.size() > rightHalf.size() + 1) {
                rightHalf.push(leftHalf.top());
                leftHalf.pop();
            }
        } else {
            // Otherwise, it belongs to the right half.
            rightHalf.push(num);
            // Rebalance the heaps if 'rightHalf' is larger than 
            // 'leftHalf'.
            if (leftHalf.size() < rightHalf.size()) {
                leftHalf.push(rightHalf.top());
                rightHalf.pop();
            }
        }
    }

    double getMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.top() + rightHalf.top()) / 2.0;
        }
        return leftHalf.top();
    }

private:
    // Max-heap for the left half. 
    std::priority_queue<int> leftHalf;
    // Min-heap for the right half. 
    std::priority_queue<int, std::vector<int>, std::greater<int>> rightHalf;
};