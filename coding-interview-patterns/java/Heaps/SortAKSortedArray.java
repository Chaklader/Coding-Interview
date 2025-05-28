import java.util.PriorityQueue;

public class SortAKSortedArray {
    public int[] sortAKSortedArray(int[] nums, int k) {
        // Populate a min-heap with the first k + 1 values in 'nums'.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k + 1; i++) {
            minHeap.offer(nums[i]);
        }
        // Replace elements in the array with the minimum from the heap at each 
        // iteration.
        int insertIndex = 0;
        for (int i = k + 1; i < nums.length; i++) {
            nums[insertIndex] = minHeap.poll();
            insertIndex++;
            minHeap.offer(nums[i]);
        }
        // Pop the remaining elements from the heap to finish sorting the array.
        while (!minHeap.isEmpty()) {
            nums[insertIndex] = minHeap.poll();
            insertIndex++;
        }
        return nums;
    }
}
