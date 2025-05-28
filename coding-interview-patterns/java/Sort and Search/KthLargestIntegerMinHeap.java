import java.util.PriorityQueue;

public class KthLargestIntegerMinHeap {
    public int kthLargestIntegerMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            // Ensure the heap has at least 'k' integers.
            if (minHeap.size() < k) {
                minHeap.offer(num);
            }
            // If 'num' is greater than the smallest integer in the heap, pop
            // off this smallest integer from the heap and push in 'num'.
            else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }    
}
