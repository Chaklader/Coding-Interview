import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAnIntegerStream {
    
    PriorityQueue<Integer> leftHalf;    
    PriorityQueue<Integer> rightHalf;

    public MedianOfAnIntegerStream() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        rightHalf = new PriorityQueue<>();                          // Min-heap
    }

    public void add(int num) {
        // If 'num' is less than or equal to the max of 'leftHalf', it 
        // belongs to the left half.
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.offer(num);
            // Rebalance the heaps if the size of the 'leftHalf' 
            // exceeds the size of the 'rightHalf' by more than one.
            if (leftHalf.size() > rightHalf.size() + 1) {
                rightHalf.offer(leftHalf.poll());
            }
        }
        // Otherwise, it belongs to the right half.
        else {
            rightHalf.offer(num);
            // Rebalance the heaps if 'rightHalf' is larger than 
            // 'leftHalf'.
            if (leftHalf.size() < rightHalf.size()) {
                leftHalf.offer(rightHalf.poll());
            }
        }
    }

    public float getMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0f;
        }
        return leftHalf.peek();
    }
}
